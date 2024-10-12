create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT IGNORE INTO `users` VALUES ('user', '{noop}codemakerbank@0641', '1');
INSERT IGNORE INTO `authorities` VALUES ('user', 'read');

-- codemakerbank@0641

INSERT IGNORE INTO `users` VALUES ('admin', '{bcrypt}$2a$12$FwJWBlvEtYOnwQDXzs5fXuRPvNLgi2H/yz8Fwwlr9EGBMxKLK/izK', '1');
INSERT IGNORE INTO `authorities` VALUES ('admin', 'admin');

--*************************************** Section 5 *************************************

INSERT  INTO `user_login` (`email`, `pwd`, `role`) VALUES ('happy@example.com', '{noop}codemakerbank@0641', 'read');
INSERT  INTO `user_login` (`email`, `pwd`, `role`) VALUES ('admin@example.com', '{bcrypt}$2a$12$FwJWBlvEtYOnwQDXzs5fXuRPvNLgi2H/yz8Fwwlr9EGBMxKLK/izK', 'admin');