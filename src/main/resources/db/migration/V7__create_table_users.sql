CREATE TABLE users (
                       cd_user SERIAL PRIMARY KEY,
                       ds_email VARCHAR(255) NOT NULL UNIQUE,
                       ds_password VARCHAR(255) NOT NULL,
                       nm_user VARCHAR(255),
                       vl_balance NUMERIC(15, 2) DEFAULT 0.00,
                       cd_role INTEGER NOT NULL,
                       CONSTRAINT fk_role FOREIGN KEY (cd_role) REFERENCES roles(id)
);
