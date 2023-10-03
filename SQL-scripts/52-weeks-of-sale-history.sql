-- Create a table to hold the weekly sales data
CREATE TABLE weekly_sales (
    week_start_date DATE PRIMARY KEY,
    week_end_date DATE,
    items_sold_count INT
);

-- Generate a series of 52 weeks starting from January 1, 2023
WITH week_series AS (
    SELECT generate_series(
        '2023-01-01'::DATE,
        '2023-12-31'::DATE,
        interval '1 week'
    ) AS week_start_date
)
INSERT INTO weekly_sales (week_start_date, week_end_date, items_sold_count)
SELECT
    ws.week_start_date,
    ws.week_start_date + interval '6 days' AS week_end_date,
    COUNT(o.id) AS items_sold_count
FROM
    week_series ws
LEFT JOIN
    orders o ON o.orderdate::DATE BETWEEN ws.week_start_date AND ws.week_start_date + interval '6 days'
GROUP BY
    ws.week_start_date
ORDER BY
    ws.week_start_date;

-- Uncomment if want to display the contents of the weekly_sales table
-- SELECT * FROM weekly_sales;
