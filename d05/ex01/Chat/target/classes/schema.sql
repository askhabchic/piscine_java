DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS chat;

DROP TABLE IF EXISTS chat.users, chat.rooms, chat.msgs, chat.users_rooms;

CREATE TABLE IF NOT EXISTS chat.users
(
    id       SERIAL PRIMARY KEY,
    login    TEXT NOT NULL,
    password TEXT
);

CREATE TABLE IF NOT EXISTS chat.rooms
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    owner INTEGER NOT NULL REFERENCES chat.users(id)
);

CREATE TABLE IF NOT EXISTS chat.msgs
(
    id     SERIAL PRIMARY KEY,
    author INTEGER NOT NULL REFERENCES chat.users (id),
    room   INTEGER NOT NULL REFERENCES chat.rooms (id),
    text   TEXT    NOT NULL,
    time   timestamp
);

CREATE TABLE IF NOT EXISTS chat.users_rooms (
    user_id INTEGER NOT NULL REFERENCES chat.users (id),
    room_id INTEGER NOT NULL REFERENCES chat.rooms (id)
)