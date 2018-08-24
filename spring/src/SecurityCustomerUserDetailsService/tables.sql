CREATE database user_center;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(120) NOT NULL,
  password varchar(120) NOT NULL,
  exprie_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_locked tinyint(4) DEFAULT '0',
  is_credential tinyint(4) DEFAULT '1',
  is_enable tinyint(4) DEFAULT '1',
  name varchar(120) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
);

CREATE TABLE role (
  id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(30) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE groups (
  id int(11) NOT NULL AUTO_INCREMENT,
  groups_name varchar(30) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_group (
  id int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
  groups_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  FOREIGN KEY (groups_id) REFERENCES groups(id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE role_group (
  id int(11) NOT NULL AUTO_INCREMENT,
  role_id int(11) NOT NULL,
  group_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES role (id),
  FOREIGN KEY (group_id) REFERENCES groups (id)
);

//add little data
INSERT INTO `role` VALUES (1, 'ROLE_LIST');
INSERT INTO `role` VALUES (2, 'ROLE_CHART');
INSERT INTO `role` VALUES (3, 'ROLE_TABLE');

INSERT INTO `groups` VALUES (1, 'USER');
INSERT INTO `groups` VALUES (2, 'ADMIN');

INSERT INTO `role_group` VALUES (1, 1, 1);
INSERT INTO `role_group` VALUES (2, 2, 1);
INSERT INTO `role_group` VALUES (3, 3, 2);

INSERT INTO `user` VALUES (1, 'root', '123', '2019-3-10 05:04:20', 0, 1, 1, 'hu');

INSERT INTO `user_group` VALUES (1, 1, 1);