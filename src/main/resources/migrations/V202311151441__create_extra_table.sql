CREATE SEQUENCE IF NOT EXISTS elite_drive.hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE elite_drive.extra
(
    extra_id          BIGINT NOT NULL,
    name              VARCHAR(255),
    description       VARCHAR(255),
    additional_cost   DECIMAL,
    compatible_models VARCHAR(255),
    CONSTRAINT pk_extra PRIMARY KEY (extra_id)
);