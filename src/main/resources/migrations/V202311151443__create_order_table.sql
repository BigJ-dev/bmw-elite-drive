CREATE SEQUENCE IF NOT EXISTS elite_drive.hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE elite_drive."order"
(
    order_id                BIGINT NOT NULL,
    order_date              TIMESTAMP WITHOUT TIME ZONE,
    estimated_delivery_date TIMESTAMP WITHOUT TIME ZONE,
    status                  VARCHAR(255),
    total_price             DECIMAL,
    client_id               BIGINT,
    vehicle_id              BIGINT,
    CONSTRAINT pk_order PRIMARY KEY (order_id)
);

ALTER TABLE elite_drive."order"
    ADD CONSTRAINT FK_ORDER_ON_CLIENTID FOREIGN KEY (client_id) REFERENCES elite_drive.client (client_id);

ALTER TABLE elite_drive."order"
    ADD CONSTRAINT FK_ORDER_ON_VEHICLEID FOREIGN KEY (vehicle_id) REFERENCES elite_drive.vehicle (vehicle_id);