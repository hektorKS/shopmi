ALTER DATABASE shopmi CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE USERS(
    ID INTEGER AUTO_INCREMENT,
    FIRST_NAME VARCHAR(33),
    LAST_NAME VARCHAR(33),
    USERNAME VARCHAR(33),
    PASSWORD BINARY(16), -- AES 256 gives 16 byte password
    SALT BINARY(16), -- AES 256 gives 16 byte salt
    EMAIL VARCHAR(51),
    PHONE_NUMBER VARCHAR(25) NULL,
    COUNTRY_CODE CHAR(3) NULL,
    PRIMARY KEY (ID),
    UNIQUE (USERNAME),
    UNIQUE (EMAIL)
);

ALTER TABLE USERS AUTO_INCREMENT=10001;