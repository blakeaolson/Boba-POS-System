-- Create a table to hold the busiest days
CREATE TABLE busiest_days (
    sale_date DATE PRIMARY KEY,
    items_sold_count INT
);

-- Find the dates with the most number of sales
INSERT INTO busiest_days (sale_date, items_sold_count)
SELECT
    o.orderdate::DATE AS sale_date,
    COUNT(o.id) AS items_sold_count
FROM
    orders o
GROUP BY
    o.orderdate::DATE
ORDER BY
    COUNT(o.id) DESC
LIMIT 5; -- Adjust to change the number of busiest days

-- Display the contents of the busiest_days table
SELECT * FROM busiest_days;

DROP TABLE busiest_days;