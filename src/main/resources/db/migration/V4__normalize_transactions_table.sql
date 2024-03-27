-- Создание таблицы для валюты
CREATE TABLE currencies
(
    id        SERIAL PRIMARY KEY,
    shortname VARCHAR(10) UNIQUE NOT NULL
);

-- Создание таблицы для категорий расходов
CREATE TABLE expense_categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Обновление таблицы transactions
ALTER TABLE transactions
    ADD COLUMN currency_id INT,
    ADD COLUMN category_id INT,
    ADD CONSTRAINT fk_currency FOREIGN KEY (currency_id) REFERENCES currencies (id),
    ADD CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES expense_categories (id);

-- Удаление ненужных колонок
ALTER TABLE transactions
    DROP COLUMN currency_shortname,
    DROP COLUMN expense_category;
