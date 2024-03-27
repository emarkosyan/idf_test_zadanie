CREATE TABLE currency_exchange_rates
(
    id            SERIAL PRIMARY KEY,
    currency_pair VARCHAR(255)   NOT NULL,
    exchange_rate DECIMAL(19, 6) NOT NULL,
    exchange_date DATE           NOT NULL
);
