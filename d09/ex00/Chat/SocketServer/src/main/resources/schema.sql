DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
  id INTEGER PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
    password VARCHAR(200) NOT NULL
);