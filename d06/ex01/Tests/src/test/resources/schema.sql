DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE products (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    price INTEGER
    );