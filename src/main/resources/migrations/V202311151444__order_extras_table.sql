CREATE TABLE IF NOT EXISTS elite_drive.order_extras
(
    order_extra_id SERIAL PRIMARY KEY,
    order_id       BIGINT,
    extra_id       BIGINT
);