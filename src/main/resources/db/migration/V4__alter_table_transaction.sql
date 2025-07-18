ALTER TABLE transaction
    ADD COLUMN cd_category INT4;

ALTER TABLE transaction
    ADD CONSTRAINT fk_category
        FOREIGN KEY (cd_category)
            REFERENCES category(cd_category);
