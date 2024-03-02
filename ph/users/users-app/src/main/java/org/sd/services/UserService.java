package org.sd.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.sd.dtos.*;
import org.sd.entities.AddressEntity;
import org.sd.entities.UserEntity;
import org.sd.exceptions.AccountNotCreatedException;
import org.sd.exceptions.EntityNotFoundException;
import org.sd.repositories.AddressRepository;
import org.sd.repositories.UserRepository;
import org.sd.services.mappers.AddressMapper;
import org.sd.services.mappers.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    private final String USER_NOT_FOUND_MESSAGE = "User with id = %s not found!";
    private final String USER_DELETE_MESSAGE = "User with cnp = %s not found!";
    private final String ADDRESS_NOT_FOUND_MESSAGE = "Address not found!";

    @Transactional
    public UserDto createUser(UserRegistrationRequest userRegistrationRequest) {
        validateCnpAndEmail(userRegistrationRequest);

        UserEntity savedUser = saveUser(userRegistrationRequest);

        AddressEntity savedAddress = getSavedAddress(userRegistrationRequest, savedUser);

        return toDto(savedUser, savedAddress);
    }

    private void validateCnpAndEmail(UserRegistrationRequest userRegistrationRequest) {
        Optional<UserEntity> user = userRepository.findByCnp(userRegistrationRequest.getCnp());

        if (user.isPresent()) {
            throw new AccountNotCreatedException("User with this cnp already exists!");
        }

        if (userRepository.findAll().stream()
                .anyMatch(existentUser -> existentUser.getEmail().equals(userRegistrationRequest.getEmail()))) {
            throw new AccountNotCreatedException("User with this email already exists!");
        }
    }

    private UserDto toDto(UserEntity user, AddressEntity address) {
        UserDto userDto = userMapper.toDto(user);
        userDto.setAddressDto(addressMapper.toDto(address));

        return userDto;
    }

    private AddressEntity getSavedAddress(UserRegistrationRequest userRegistrationRequest, UserEntity savedUser) {
        return addressRepository.save(AddressEntity.builder()
                .user(savedUser)
                .country(userRegistrationRequest.getCountry())
                .county(userRegistrationRequest.getCounty())
                .city(userRegistrationRequest.getCity())
                .number(userRegistrationRequest.getNumber())
                .build());
    }

    private UserEntity saveUser(UserRegistrationRequest userRegistrationRequest) {
        return userRepository.save(UserEntity.builder()
                .firstname(userRegistrationRequest.getFirstname())
                .lastname(userRegistrationRequest.getLastname())
                .cnp(userRegistrationRequest.getCnp())
                .phoneNumber(userRegistrationRequest.getPhoneNumber())
                .email(userRegistrationRequest.getEmail())
                .password(userRegistrationRequest.getPassword())
                .role(userRegistrationRequest.getRole())
                .build());
    }

    public UserDto getUser(UUID userExternalId) {
        UserEntity user = userRepository.findUserEntityByUserExternalId(userExternalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, userExternalId)));

        AddressEntity address = getUserAddress(user.getId());

        return toDto(user, address);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(
                u -> {
                    AddressEntity address = getUserAddress(u.getId());

                    return toDto(u, address);
                }
        ).collect(Collectors.toList());
    }

    @Transactional
    public UserDto updateUser(UpdateUserRequest updateUserRequest) {
        UserEntity user = updateUserDetails(updateUserRequest);

        AddressEntity address = updateAddressDetails(updateUserRequest, user);

        return saveUpdatedUser(user, address);
    }

    private UserDto saveUpdatedUser(UserEntity user, AddressEntity address) {
        userRepository.save(user);
        addressRepository.save(address);

        return toDto(user, address);
    }

    private AddressEntity updateAddressDetails(UpdateUserRequest updateUserRequest, UserEntity user) {
        AddressEntity address = getUserAddress(user.getId());

        address.setCountry(updateUserRequest.getCountry());
        address.setCounty(updateUserRequest.getCounty());
        address.setCity(updateUserRequest.getCity());
        address.setNumber(updateUserRequest.getNumber());
        return address;
    }

    private UserEntity updateUserDetails(UpdateUserRequest updateUserRequest) {
        UserEntity user = userRepository.findUserEntityByUserExternalId(updateUserRequest.getUserExternalId())
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, updateUserRequest.getUserExternalId()))
                );

        user.setFirstname(updateUserRequest.getFirstname());
        user.setLastname(updateUserRequest.getLastname());
        user.setPhoneNumber(updateUserRequest.getPhoneNumber());
        return user;
    }

    @Transactional
    public ResponseMessage deleteUser(String cnp) {
        UserEntity userToBeDeleted = userRepository.findByCnp(cnp)
                .orElseThrow(() -> new EntityNotFoundException(String.format(USER_DELETE_MESSAGE, cnp)));

        AddressEntity addressToBeDeleted = getUserAddress(userToBeDeleted.getId());

        addressRepository.delete(addressToBeDeleted);
        userRepository.deleteById(userToBeDeleted.getId());

        return ResponseMessage.builder()
                .response("User deleted!")
                .build();
    }

    private AddressEntity getUserAddress(int id) {
        return addressRepository.findByUser_Id(id)
                .orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND_MESSAGE));
    }

    public UserDto login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Invalid credentials!"));

        AddressEntity address = getUserAddress(user.getId());

        return toDto(user, address);
    }
}
