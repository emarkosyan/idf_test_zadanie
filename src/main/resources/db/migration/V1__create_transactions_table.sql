CREATE TABLE transactions
(
    id                   SERIAL PRIMARY KEY,
    account_from         BIGINT         NOT NULL,
    account_to           BIGINT         NOT NULL,
    currency_shortname   VARCHAR(255)   NOT NULL,
    amount               DECIMAL(19, 2) NOT NULL,
    expense_category     VARCHAR(255)   NOT NULL,
    transaction_datetime TIMESTAMP      NOT NULL
);
