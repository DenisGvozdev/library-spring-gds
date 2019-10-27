DROP TABLE IF EXISTS STATUSES;
CREATE TABLE STATUSES(
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255),
  PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(
  ID INT NOT NULL AUTO_INCREMENT,
  FIRSTNAME VARCHAR(255),
  SECONDNAME VARCHAR(255),
  THIRDNAME VARCHAR(255),
  BIRTH_DATE TIMESTAMP,
  STATUS INT,
  PRIMARY KEY (ID),
  FOREIGN KEY (STATUS) REFERENCES STATUSES (ID)
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255),
  PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255),
  CREATE_DATE TIMESTAMP,
  DESCRIPTION VARCHAR(255),
  IMAGE VARBINARY(MAX),
  GENRE INT,
  STATUS INT,
  AUTHOR INT,
  PRIMARY KEY (ID),
  FOREIGN KEY (GENRE) REFERENCES GENRES (ID),
  FOREIGN KEY (STATUS) REFERENCES STATUSES (ID),
  FOREIGN KEY (AUTHOR) REFERENCES AUTHORS (ID)
);