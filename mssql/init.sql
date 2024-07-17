CREATE DATABASE test
GO

USE test
GO

ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = OFF
GO

-- Create Items Table
CREATE TABLE Products (
    ProductId INT PRIMARY KEY IDENTITY(1,1),
    ProductName NVARCHAR(100) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    Amount INT NOT NULL
);
GO
-- Create Customers Table
CREATE TABLE Customers (
    CustomerId INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    Address NVARCHAR(255),
    PhoneNumber NVARCHAR(15),
    Balance DECIMAL(10, 2) DEFAULT 0
);
GO
-- Create Orders Table
CREATE TABLE Orders (
    OrderId INT PRIMARY KEY IDENTITY(1,1),
    CustomerId INT NOT NULL,
    OrderDate DATETIME DEFAULT GETDATE(),
    CONSTRAINT FK_CustomerOrder FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
GO
-- Create OrderItems Table
CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY IDENTITY(1,1),
    OrderId INT NOT NULL,
    ProductId INT NOT NULL,
    Quantity INT NOT NULL,
    CONSTRAINT FK_OrderItemOrder FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    CONSTRAINT FK_OrderItemItem FOREIGN KEY (ProductId) REFERENCES Products(ProductId)
);
GO
-- Insert Sample Data for Items
INSERT INTO Products (ProductName, Price, Amount) VALUES
('T-shirt', 19.99, 50),
('Jeans', 39.99, 30),
('Sneakers', 59.99, 20),
('Watch', 99.99, 10);
GO
-- Insert Sample Data for Customers
INSERT INTO Customers (Name, Address, PhoneNumber, Balance) VALUES
('John Doe', '123 Main St, Anytown, USA', '+1234567890', 500.00),
('Jane Smith', '456 Elm St, Othertown, USA', '+1987654321', 750.00);
GO
-- Insert Sample Data for Orders
INSERT INTO Orders (CustomerId, OrderDate) VALUES
(1, GETDATE()),
(2, GETDATE());
GO
-- Insert Sample Data for OrderItems
INSERT INTO OrderItems (OrderId, ProductId, Quantity) VALUES
(1, 1, 2),
(1, 3, 1),
(2, 2, 1),
(2, 4, 2);
GO