CREATE TABLE TRAINING
(
    training_id          SERIAL PRIMARY KEY,
    description          VARCHAR(600) NOT NULL,
    training_external_id UUID         NOT NULL UNIQUE
);

CREATE TABLE TRAINING_REGISTRATION
(
    id                   SERIAL PRIMARY KEY,
    training_external_id UUID NOT NULL,
    user_external_id     UUID NOT NULL
);

INSERT INTO TRAINING (description, training_external_id)
VALUES ('Cashier training: basics and mobility training', '7dfa1fe2-c393-4887-9bc5-c83e53b934c5'),
       ('How to coffee? Full barista course', '7eea63b7-ec9b-4437-9dae-37269226e226'),
       ('Call center operator - from beginner to pro', '68142762-c230-4509-bbc9-ec150bd723a2'),
       ('Manufacturing 101 - airbags and car components', '853d4e3d-08d1-4116-9936-53b5d1f32d0a'),
       ('I bet I can sell you this marketing course', '48b8550b-f0b4-47f7-8f01-bea0bac70918'),
       ('Goods handling - safe and secure: we teach responsibility', 'f6da55a8-bdd6-4138-94d7-73631333aa8e');

INSERT INTO TRAINING_REGISTRATION (training_external_id, user_external_id)
VALUES ('7dfa1fe2-c393-4887-9bc5-c83e53b934c5', 'fa8b9f71-9d38-4fd7-9bdd-223f05f36672'),
       ('7eea63b7-ec9b-4437-9dae-37269226e226', 'e80de3ac-b80d-45d1-ba81-08bd6148ac1e');