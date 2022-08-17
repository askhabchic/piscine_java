INSERT INTO chat.users (login, password) VALUES ('rama', 'pass');
INSERT INTO chat.users (login, password) VALUES ('dina', 'nonpass');
INSERT INTO chat.users (login, password) VALUES ('lampa', 'mypass');
INSERT INTO chat.users (login, password) VALUES ('guzya', 'password');
INSERT INTO chat.users (login, password) VALUES ('ilmya', 'ownpass');

INSERT INTO chat.rooms (name, owner) VALUES (1, '1');
INSERT INTO chat.rooms (name, owner) VALUES (2, '2');
INSERT INTO chat.rooms (name, owner) VALUES (3, '3');
INSERT INTO chat.rooms (name, owner) VALUES (4, '4');
INSERT INTO chat.rooms (name, owner) VALUES (5, '5');

INSERT INTO chat.msgs (room, author, text, time) VALUES (1, 1, 'hello', 'Sun Jul 24 21:55:50 MSK 2022');
INSERT INTO chat.msgs (room, author, text, time) VALUES (2, 2, 'hello', 'Sun Jul 24 21:56:20 MSK 2022');
INSERT INTO chat.msgs (room, author, text, time) VALUES (1, 3, 'hi', 'Sun Jul 24 21:56:50 MSK 2022');
INSERT INTO chat.msgs (room, author, text, time) VALUES (2, 4, 'hi', 'Sun Jul 24 21:57:20 MSK 2022');
INSERT INTO chat.msgs (room, author, text, time) VALUES (1, 5, 'bb', 'Sun Jul 24 21:57:50 MSK 2022');
INSERT INTO chat.msgs (room, author, text, time) VALUES (2, 2, 'bb', 'Sun Jul 24 21:58:20 MSK 2022');