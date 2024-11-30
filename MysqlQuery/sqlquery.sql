CREATE DATABASE event_mgmt CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE event_mgmt;

CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  address varchar(45) DEFAULT NULL,
  mobile bigint DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE organizer (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  mobile bigint DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE event (
  event_id int NOT NULL AUTO_INCREMENT,
  event_title varchar(45) DEFAULT NULL,
  description varchar(45) DEFAULT NULL,
  event_date varchar(45) DEFAULT NULL,
  event_time varchar(45) DEFAULT NULL,
  location varchar(45) DEFAULT NULL,
  ticket_price int DEFAULT NULL,
  tickets_available int DEFAULT NULL,
  privacy varchar(45) DEFAULT NULL,
  ticket_type varchar(45) DEFAULT NULL,
  PRIMARY KEY (event_id)
);

CREATE TABLE ticket (
  id int NOT NULL AUTO_INCREMENT,
  user_id int DEFAULT NULL,
  user_name varchar(45) DEFAULT NULL,
  user_email varchar(45) DEFAULT NULL,
  user_mobile bigint DEFAULT NULL,
  event_date varchar(45) DEFAULT NULL,
  event_time varchar(45) DEFAULT NULL,
  ticket_type varchar(45) DEFAULT NULL,
  ticket_price int DEFAULT NULL,
  ticket_count int DEFAULT NULL,
  total_price int DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE feedback (
  id int NOT NULL AUTO_INCREMENT,
  user_id int DEFAULT NULL,
  user_name varchar(45) DEFAULT NULL,
  description varchar(45) DEFAULT NULL,
  event_date varchar(45) DEFAULT NULL,
  event_time varchar(45) DEFAULT NULL,
  feedback varchar(80) DEFAULT NULL,
  PRIMARY KEY (id)
);
