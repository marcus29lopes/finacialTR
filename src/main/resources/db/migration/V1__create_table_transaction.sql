CREATE TABLE transaction (
                             id SERIAL PRIMARY KEY,
                             amount NUMERIC(15,2) NOT NULL,
                             date TIMESTAMP NOT NULL,
                             description TEXT,
                             type VARCHAR(10) NOT NULL);