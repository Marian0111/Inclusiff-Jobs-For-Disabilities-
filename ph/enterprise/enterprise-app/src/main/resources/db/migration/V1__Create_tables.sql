CREATE TABLE JOB
(
    job_id          SERIAL PRIMARY KEY,
    job_description VARCHAR(300) NOT NULL,
    job_external_id UUID         NOT NULL UNIQUE,
    enterprise_id   UUID         NOT NULL
);

INSERT INTO JOB (job_description, job_external_id, enterprise_id)
VALUES ('Front-Desk person wanted! Administrative attributions, no experience needed, 2-week training offered',
        '0af479ee-cac4-41fc-85df-756e1581dbf1', '52205b39-793e-4863-99c5-6279fe0addf5'),
       ('Emergency line operator', '69909ae7-f796-4137-a41d-5efdf666af33', '52205b39-793e-4863-99c5-6279fe0addf5'),
       ('Self-check assistant', 'd0202e44-0fee-4320-b4d7-e063e8584c16',
        '52205b39-793e-4863-99c5-6279fe0addf5');
