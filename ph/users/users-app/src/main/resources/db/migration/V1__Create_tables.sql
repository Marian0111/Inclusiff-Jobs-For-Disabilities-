CREATE TABLE APP_USER
(
    user_id          SERIAL PRIMARY KEY,
    firstname        VARCHAR(20)  NOT NULL,
    lastname         VARCHAR(20)  NOT NULL,
    email            VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    role             VARCHAR(20)  NOT NULL,
    phone_number     VARCHAR(20)  NOT NULL,
    cnp              VARCHAR(13)  NOT NULL UNIQUE,
    user_external_id UUID         NOT NULL UNIQUE
);

CREATE TABLE ADDRESS
(
    address_id SERIAL PRIMARY KEY,
    country    VARCHAR(100) NOT NULL,
    county     VARCHAR(100) NOT NULL,
    city       VARCHAR(100) NOT NULL,
    number     VARCHAR(100) NOT NULL,
    user_id    SERIAL       NOT NULL,
    CONSTRAINT FK_address_user FOREIGN KEY (user_id) REFERENCES APP_USER (user_id)
);

INSERT INTO APP_USER (firstname, lastname, email, password, role, phone_number, cnp, user_external_id)
VALUES ('Raul', 'Marinescu', 'raulmarinescu@gmail.com', 'Parola1@', 'PEOPLE', '0751682223', '5010101012233',
        'fa8b9f71-9d38-4fd7-9bdd-223f05f36672'),
       ('Maria', 'Dragomir', 'mariadragomir@gmail.com', 'Parola1@', 'PEOPLE', '0751682229', '6010101012233',
        'e80de3ac-b80d-45d1-ba81-08bd6148ac1e'),
       ('Alexandru', 'Enache', 'alexandruenache@vision.com', 'Parola1@', 'COMPANY', '0751232229', '5010101019233',
        '52205b39-793e-4863-99c5-6279fe0addf5'),
       ('Adrian', 'Mihailescu', 'adrianmihailescu@yahoo.com', 'Parola1@', 'COMPANY', '0748288016', '5010101012267',
        '3be3d71c-ce39-4af8-8ce6-e8dbfc8acaff');

INSERT INTO ADDRESS (country, county, city, number, user_id)
VALUES ('Romania', 'Cluj', 'Cluj-Napoca', 'Iasomiei 14', 1),
       ('Romania', 'Cluj', 'Cluj-Napoca', 'Sora 15', 2),
       ('Romania', 'Cluj', 'Cluj-Napoca', 'Henri Barbusse 16', 3),
       ('Romania', 'Cluj', 'Cluj-Napoca', 'Observatorului 32', 4);
