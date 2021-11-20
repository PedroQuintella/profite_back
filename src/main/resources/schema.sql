CREATE TABLE installments (
                              id INT NOT NULL,
                              count INT NOT NULL,
                              value FLOAT NOT NULL
);

CREATE TABLE product (
                         id INT NOT NULL,
                         name VARCHAR(150) NOT NULL,
                         image VARCHAR(600) NOT NULL,
                         oldPrice FLOAT NOT NULL,
                         price FLOAT NOT NULL,
                         description VARCHAR(200),
                         installments_id INT NOT NULL
);