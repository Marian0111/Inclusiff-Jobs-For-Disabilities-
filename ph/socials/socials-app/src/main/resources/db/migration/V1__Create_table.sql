CREATE TABLE EVENT
(
    event_id          SERIAL PRIMARY KEY,
    event_name        VARCHAR(255) NOT NULL,
    event_date        DATE         NOT NULL,
    event_address     VARCHAR(255) NOT NULL,
    event_organizer   UUID         NOT NULL,
    event_external_id UUID         NOT NULL UNIQUE
);

CREATE TABLE DISABILITY
(
    disability_id          SERIAL PRIMARY KEY,
    disability_name        VARCHAR(255) NOT NULL,
    disability_external_id UUID         NOT NULL UNIQUE
);

CREATE TABLE EVENT_INTEREST
(
    event_interest_id      SERIAL PRIMARY KEY,
    event_external_id      UUID NOT NULL,
    disability_external_id UUID NOT NULL
);

INSERT INTO DISABILITY(disability_id, disability_name, disability_external_id)
VALUES (1, 'fizic', 'c705a204-5ff2-4ec8-b4f4-75a3e710a47d'),
       (2, 'vizual', '27fcdf79-cd50-471a-a370-1607548cdb9f'),
       (3, 'auditiv', '08af82d7-eb1a-4759-87b1-bdc35b8b633e'),
       (4, 'neuropsihic', '8589c2a0-e309-4730-b8ef-972974f24373'),
       (5, 'boli cronice', 'bb4d5346-3739-4ce0-af58-922f895d79e3');
