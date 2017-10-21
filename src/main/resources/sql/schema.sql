CREATE TABLE cart (
  ID INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (ID)
);

CREATE TABLE food (
  ID INT NOT NULL AUTO_INCREMENT,
  CART_ID INT,
  NAME VARCHAR(255) NOT NULL ,
  COST FLOAT NOT NULL,
  FOREIGN KEY (CART_ID) REFERENCES CART(ID),
  PRIMARY KEY (ID)
);

CREATE TABLE user (
  ID INT NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(40) NOT NULL,
  PASSWORD VARCHAR(40) NOT NULL,
  FIRST_NAME VARCHAR(40) NOT NULL,
  LAST_NAME VARCHAR(40),
  ENABLED TINYINT NOT NULL DEFAULT 1,
  ROLE VARCHAR(15) NOT NULL DEFAULT 'ROLE_USER',
  PHONE_NUMBER LONG,
  ADDRESS VARCHAR(250),
  PRIMARY KEY (ID)
);


CREATE TABLE orders (
  ID INT NOT NULL AUTO_INCREMENT,
  USER_ID INT,
  CART_ID INT,
  DELIVERY_ADDRESS VARCHAR(255),
  FOREIGN KEY (USER_ID) REFERENCES USER(ID),
  FOREIGN KEY (CART_ID) REFERENCES CART(ID),
  PRIMARY KEY (ID)
);
