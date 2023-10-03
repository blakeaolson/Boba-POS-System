CREATE TABLE Employees (
  ID int,
  Name varchar(255),
  Salary int,
  Role int
);

CREATE TABLE Orders (
  ID int,
  TotalAmount int,
  Date varchar(255),
  CashierName varchar(255),
  PaymentMethod varchar(255)
);

CREATE TABLE Inventory (
  ItemId int,
  Quantity int,
  ItemCategory varchar(255)
);

CREATE TABLE Suppliers (
  SupplierID int,
  Name varchar(255),
  Item varchar(255),
  Quantity int,
  Cost int,
  Date varchar(255),
  Contact varchar(255)
);

CREATE TABLE Customer (
  ID int,
  Name varchar(255),
  PaymentMethod varchar(255),
  OrderId int
);