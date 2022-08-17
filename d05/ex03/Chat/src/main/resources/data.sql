INSERT INTO chat.users (login, password) VALUES ('user', 'user');
INSERT INTO chat.users (login, password) VALUES ('user1', 'user1');
INSERT INTO chat.users (login, password) VALUES ('user2', 'user2');

INSERT INTO chat.rooms (name, owner) VALUES ('room', 1);
INSERT INTO chat.rooms (name, owner) VALUES ('room2', 2);
INSERT INTO chat.rooms (name, owner) VALUES ('room3', 3);

INSERT INTO chat.msgs (room, author, text, time) VALUES (1, 1, 'Hello!', NOW());
INSERT INTO chat.msgs (room, author, text, time) VALUES (2, 2, 'Hi!', NOW());
INSERT INTO chat.msgs (room, author, text, time) VALUES (3, 3, 'Bye!', NOW());