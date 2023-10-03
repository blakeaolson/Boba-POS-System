SELECT
    EXTRACT(YEAR FROM DATE(orderdate)) AS ordYear,
    EXTRACT(MONTH FROM DATE(orderdate)) AS ordMonth,
    SUM(CAST(totalamount AS NUMERIC)) AS salesTotal
FROM orders
GROUP BY
    ordYear,
    ordMonth
ORDER BY
    ordYear,
    ordMonth;