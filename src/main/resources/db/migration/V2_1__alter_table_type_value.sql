ALTER TABLE transaction
    ADD COLUMN transaction_type_id BIGINT;

ALTER TABLE transaction
    ADD CONSTRAINT fk_transaction_type
        FOREIGN KEY (transaction_type_id)
            REFERENCES type_value(cd_type_value);
