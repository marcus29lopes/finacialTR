
ALTER TABLE transaction
    ADD COLUMN cd_user integer;

ALTER TABLE transaction
    ADD CONSTRAINT fk_transaction_user
        FOREIGN KEY (cd_user)
            REFERENCES users(cd_user);
