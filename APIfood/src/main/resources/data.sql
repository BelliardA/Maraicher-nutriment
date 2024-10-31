DROP TABLE IF EXISTS aliment;

CREATE TABLE aliment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    calories DOUBLE NOT NULL,
    proteins DOUBLE NOT NULL,
    carbohydrates DOUBLE NOT NULL,
    lipids DOUBLE NOT NULL
);

INSERT INTO aliment (name, quantity, price, calories,carbohydrates ,lipids , proteins) 
VALUES ('Apple', 10, 1.5, 94.64,25.12 ,0.31 ,0.47 ), 
       ('Mango', 3, 2.5, 124.2,31.05 ,0.79,1.7 ), 
       ('Orange', 8, 3.5, 61.57,15.46 ,0.16 ,1.23 );