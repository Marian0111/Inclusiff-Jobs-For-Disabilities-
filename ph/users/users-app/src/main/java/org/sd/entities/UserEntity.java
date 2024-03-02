package org.sd.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sd.dtos.RoleDto;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "APP_USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleDto role;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "cnp", nullable = false, unique = true)
    private String cnp;

    @Column(name = "user_external_id", nullable = false, unique = true)
    private UUID userExternalId;

    @PrePersist
    void prePersist() {
        if (userExternalId == null) {
            userExternalId = UUID.randomUUID();
        }
    }
}
