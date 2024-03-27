CREATE TABLE limits
(
    id           SERIAL PRIMARY KEY,
    category     VARCHAR(255)   NOT NULL,
    limit_amount DECIMAL(19, 2) NOT NULL,
    set_date     DATE           NOT NULL
);
