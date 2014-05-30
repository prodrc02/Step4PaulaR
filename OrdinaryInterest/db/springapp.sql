CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;

CREATE TABLE account (
  id INTEGER PRIMARY KEY,
  accountDescription varchar(255),
  movementBalance1 decimal(15,2),
  movementBalance2 decimal(15,2),
  movementBalance3 decimal(15,2),
  movementBalance4 decimal(15,2),
  movementBalance5 decimal(15,2),
  movementWithIncrease decimal(15,2),
  amountToIncrease decimal(15,2),
  dateMov1 date,
  dateMov2 date,
  dateMov3 date,
  dateMov4 date,
  dateMov5 date,
  
);
CREATE INDEX account_description ON account(accountDescription);