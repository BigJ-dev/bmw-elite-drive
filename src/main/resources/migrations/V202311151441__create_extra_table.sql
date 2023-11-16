CREATE TABLE elite_drive.extra
(
    extra_id          SERIAL PRIMARY KEY,
    name              VARCHAR(255),
    description       VARCHAR(255),
    price             DECIMAL,
    additional_cost   DECIMAL,
    unit_quantity     INTEGER NOT NULL,
    compatible_models VARCHAR(255)
);