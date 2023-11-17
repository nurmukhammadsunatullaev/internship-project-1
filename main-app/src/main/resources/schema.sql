drop table if exists transactions;

CREATE TABLE IF NOT EXISTS transactions
(
    id                 BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    amount             BIGINT,
    transaction_time   TIMESTAMP,
    transaction_status VARCHAR(20),
    billing_system     VARCHAR
);