SELECT
    EXTRACT(YEAR FROM Date) AS ordYear, --Get year from date
    EXTRACT(MONTH FROM Date) AS ordMonth, -- Get month from date
    SUM(Order Total) AS salesTotal
FROM orders
GROUP BY
    ordYear,
    ordMonth,
ORDER BY,
    ordYear,
    ordMonth;