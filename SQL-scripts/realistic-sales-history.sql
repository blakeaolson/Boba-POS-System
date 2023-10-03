-- Create a table to hold the realistic sales history
CREATE TABLE realistic_sales_history (
    order_hour INT PRIMARY KEY,
    order_count INT,
    total_order_amount NUMERIC(10, 2)
);

-- Populate the realistic_sales_history table with data
INSERT INTO realistic_sales_history (order_hour, order_count, total_order_amount)
SELECT
    o.orderhour AS order_hour,
    COUNT(o.id) AS order_count,
    SUM(o.totalamount::NUMERIC) AS total_order_amount -- Cast to numeric
FROM
    orders o
GROUP BY
    o.orderhour
ORDER BY
    o.orderhour;

-- Display the contents of the realistic_sales_history table
SELECT * FROM realistic_sales_history;
