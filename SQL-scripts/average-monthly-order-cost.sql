-- Create a table to hold the average monthly order cost
CREATE TABLE average_monthly_order_cost (
    month_year DATE PRIMARY KEY,
    average_order_amount NUMERIC(10, 2)
);

-- Calculate the average monthly order cost and populate the table
INSERT INTO average_monthly_order_cost (month_year, average_order_amount)
SELECT
    DATE_TRUNC('month', o.orderdate::DATE) AS month_year,
    AVG(o.totalamount::NUMERIC) AS average_order_amount
FROM
    orders o
GROUP BY
    month_year
ORDER BY
    month_year;

-- Display the contents of the average_monthly_order_cost table
SELECT * FROM average_monthly_order_cost;
