DROP TABLE IF EXISTS authorities;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS group_members;

DROP TABLE IF EXISTS group_authorities;

DROP TABLE IF EXISTS groups;

CREATE TABLE users(
	username VARCHAR(255) NOT NULL PRIMARY KEY,
	password VARCHAR(255) NOT NULL,
	firstname VARCHAR(255),
	lastname VARCHAR(255),
	enabled boolean NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(255) NOT NULL,
	authority VARCHAR(255) NOT NULL,
	CONSTRAINT FK_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX UQ_authorities_username_authority ON authorities (username,authority);

CREATE TABLE groups (
  id BIGINT PRIMARY KEY,
  group_name VARCHAR(255) NOT NULL);

CREATE TABLE group_authorities (
  group_id BIGINT NOT NULL,
  authority VARCHAR(255) NOT NULL,
  CONSTRAINT FK_group_authorities_group FOREIGN KEY(group_id) REFERENCES groups(id));

CREATE TABLE group_members (
  id BIGINT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  group_id bigint NOT NULL,
  CONSTRAINT FK_group_members_group FOREIGN KEY(group_id) REFERENCES groups(id));