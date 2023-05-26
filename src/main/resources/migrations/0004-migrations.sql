CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    emri VARCHAR(50) NOT NULL,
    mbiemri VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    salted_password VARCHAR(256) NOT NULL,
    salt VARCHAR(64) NOT NULL,
    is_active boolean,
    PRIMARY KEY (id)
);