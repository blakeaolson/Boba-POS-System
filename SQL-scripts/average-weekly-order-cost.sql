-- Create a table to hold the average weekly order cost
CREATE TABLE average_weekly_order_cost (
    week_start_date DATE PRIMARY KEY,
    week_end_date DATE,
    average_order_cost NUMERIC(10, 2)
);

-- Populate the average_weekly_order_cost table with data
INSERT INTO average_weekly_order_cost (week_start_date, week_end_date, average_order_cost)
SELECT
    ws.week_start_date,
    ws.week_start_date + interval '6 days' AS week_end_date,
    AVG(o.totalamount::NUMERIC) AS average_order_cost -- Cast to numeric
FROM
    generate_series(
        '2023-01-01'::DATE,
        '2023-12-31'::DATE,
        interval '1 week'
    ) AS ws(week_start_date)
LEFT JOIN
    orders o ON o.orderdate::DATE BETWEEN ws.week_start_date AND ws.week_start_date + interval '6 days'
GROUP BY
    ws.week_start_date
ORDER BY
    ws.week_start_date;

-- Display the contents of the average_weekly_order_cost table
SELECT * FROM average_weekly_order_cost;

DROP TABLE average_weekly_order_cost;