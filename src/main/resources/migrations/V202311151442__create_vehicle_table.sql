CREATE TABLE IF NOT EXISTS elite_drive.vehicle
(
    vehicle_id        SERIAL PRIMARY KEY,
    model             VARCHAR(255),
    year              INTEGER NOT NULL,
    base_price        DECIMAL,
    manufacturer      VARCHAR(255),
    standard_features VARCHAR(255)
);