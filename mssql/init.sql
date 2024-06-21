CREATE DATABASE test
GO

USE test
GO

ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = OFF
GO

CREATE TABLE dbo.Items
    (Productid int IDENTITY(1, 1) PRIMARY KEY,
    ProductName varchar(25) NOT NULL,
    Price float NOT NULL,
    Amount int NOT NULL)
GO

INSERT INTO dbo.Items (ProductName, Price, Amount) VALUES ('Laptop', 123.56, 2), ('Iphone', 93.2, 6);
GO