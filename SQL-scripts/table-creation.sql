CREATE TABLE Employees (
  ID int,
  EmployeeName varchar(255),
  Salary varchar(255),
  EmployeeRole varchar(255)
);

CREATE TABLE Orders (
  ID int,
  TotalAmount varchar(255),
  OrderDate varchar(255),
  CashierName varchar(255),
  PaymentMethod varchar(255),
  OrderHour int
);

CREATE TABLE Inventory (
  ItemId varchar(255),
  Quantity int,
  ItemCategory varchar(255)
);

CREATE TABLE Suppliers (
  Item varchar(255),
  Quantity int
);

CREATE TABLE Customer (
  ID int,
  CustomerName varchar(255),
  PaymentMethod varchar(255)
);