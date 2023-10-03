-- Create a table to hold the busiest cashiers
CREATE TABLE busiest_cashiers (
    cashier_name VARCHAR(255) PRIMARY KEY,
    total_orders INT
);

-- Find the cashier with the most orders
INSERT INTO busiest_cashiers (cashier_name, total_orders)
SELECT
    cashiername,
    COUNT(id) AS total_orders
FROM
    orders
GROUP BY
    cashiername
ORDER BY
    COUNT(id) DESC
LIMIT 3; -- Store the cashier with the most orders

-- Display the contents of the busiest_cashiers table
SELECT * FROM busiest_cashiers;

DROP TABLE busiest_cashiers;