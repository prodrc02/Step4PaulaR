CREATE DATABASE interesdb;


USE interesdb;

CREATE TABLE accounts (
  id INTEGER PRIMARY KEY,
  accountDescription varchar(255),
  movementBalance1 decimal(15,2),
  movementBalance2 decimal(15,2),
  movementBalance3 decimal(15,2),
  movementBalance4 decimal(15,2),
  movementBalance5 decimal(15,2),
  amountToIncrease decimal(15,2),
  movementWithIncrease decimal (15,2),
  dateMov1 DATE,
  dateMov2 DATE,
  dateMov3 DATE,
  dateMov4 DATE,
  dateMov5 DATE
  
);
CREATE INDEX accounts_accountDescription ON accounts(accountDescription);