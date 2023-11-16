CREATE TABLE IF NOT EXISTS elite_drive.client
(
    client_id         SERIAL PRIMARY KEY,
    name              VARCHAR(255),
    surname           VARCHAR(255),
    id_number         VARCHAR(255),
    contact_info      VARCHAR(255),
    address           VARCHAR(255),
    registration_date TIMESTAMP WITHOUT TIME ZONE
    );
