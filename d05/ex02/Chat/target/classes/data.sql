INSERT INTO chat.users (login, password) VALUES ('user', 'user');

INSERT INTO chat.rooms (name, owner) VALUES ('room', 1);

INSERT INTO chat.msgs (room, author, text, time) VALUES (1, 1, 'Hello!', NOW());