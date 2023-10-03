SELECT
    EXTRACT(YEAR FROM DATE(orderdate)) AS ordYear, /*Get year after changing type to date*/
    EXTRACT(MONTH FROM DATE(orderdate)) AS ordMonth, /*Get month after changing type to date*/
    SUM(CAST(totalamount AS NUMERIC)) AS salesTotal /*Get total per month after changing type to numeric*/
FROM orders
GROUP BY /*Group and order by date (year and month)*/
    ordYear,
    ordMonth
ORDER BY
    ordYear,
    ordMonth;