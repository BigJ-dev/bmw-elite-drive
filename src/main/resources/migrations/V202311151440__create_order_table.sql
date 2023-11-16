-- Create the schema
CREATE SCHEMA IF NOT EXISTS elite_drive;
-- Create the table
CREATE TABLE IF NOT EXISTS elite_drive.order
(
    order_id                SERIAL PRIMARY KEY,
    order_date              TIMESTAMP WITHOUT TIME ZONE,
    estimated_delivery_date TIMESTAMP WITHOUT TIME ZONE,
    status                  VARCHAR(255),
    total_price             DECIMAL,
    client_id               BIGINT,
    vehicle_id              BIGINT

);
