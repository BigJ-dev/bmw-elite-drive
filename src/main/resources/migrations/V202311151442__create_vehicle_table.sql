CREATE SEQUENCE IF NOT EXISTS elite_drive.hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE elite_drive.vehicle
(
    vehicle_id        BIGINT NOT NULL,
    model             VARCHAR(255),
    base_price        DECIMAL,
    manufacturer      VARCHAR(255),
    standard_features VARCHAR(255),
    CONSTRAINT pk_vehicle PRIMARY KEY (vehicle_id)
);