CREATE TABLE IF NOT EXISTS category
(
    category_id   SERIAL PRIMARY KEY,
    category_name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS currency
(
    currency_id   SERIAL PRIMARY KEY,
    currency_name VARCHAR NOT NULL,
    currency_code VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS currency_exchange_rates
(
    exchange_rate_id SERIAL PRIMARY KEY,
    from_currency_id INTEGER NOT NULL,
    to_currency_id   INTEGER NOT NULL,
    rate             DECIMAL NOT NULL,
    exchange_date    DATE    NOT NULL,
    source           VARCHAR,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (from_currency_id) REFERENCES currency (currency_id),
    FOREIGN KEY (to_currency_id) REFERENCES currency (currency_id)
);

CREATE TABLE IF NOT EXISTS transactions
(
    transaction_id   SERIAL PRIMARY KEY,
    amount           DECIMAL   NOT NULL,
    currency_id      INTEGER   NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    limit_exceeded   BOOLEAN   DEFAULT FALSE,
    category_id      INTEGER,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (currency_id) REFERENCES currency (currency_id),
    FOREIGN KEY (category_id) REFERENCES category (category_id)
);
