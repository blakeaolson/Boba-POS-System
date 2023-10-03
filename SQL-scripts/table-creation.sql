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
  PaymentMethod varchar(255)
);

CREATE TABLE Inventory (
  ItemId varchar(255),
  Quantity int,
  ItemCategory varchar(255)
);

CREATE TABLE Suppliers (
  SupplierID int,
  SupplierName varchar(255),
  Item varchar(255),
  Quantity int,
  Cost int,
  SupplierDate varchar(255),
  Contact varchar(255)
);

CREATE TABLE Customer (
  ID int,
  CustomerName varchar(255),
  PaymentMethod varchar(255)
);