SELECT
    EXTRACT(YEAR FROM orderdate) AS ordYear, --Get year from date
    EXTRACT(MONTH FROM orderdate) AS ordMonth, -- Get month from date
    SUM(totalamount) AS salesTotal
FROM orders
GROUP BY
    ordYear,
    ordMonth
ORDER BY
    ordYear,
    ordMonth;