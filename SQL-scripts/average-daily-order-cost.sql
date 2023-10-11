-- Create a table to hold the average daily order cost
CREATE TABLE average_daily_order_cost (
    order_date DATE PRIMARY KEY,
    average_order_amount NUMERIC(10, 2)
);

-- Populate the average_daily_order_cost table with data
INSERT INTO average_daily_order_cost (order_date, average_order_amount)
SELECT
    o.orderdate::DATE AS order_date,
    AVG(o.totalamount::NUMERIC) AS average_order_amount -- Cast to numeric
FROM
    orders o
GROUP BY
    o.orderdate::DATE
ORDER BY
    o.orderdate::DATE;

-- Display the contents of the average_daily_order_cost table
SELECT * FROM average_daily_order_cost;
