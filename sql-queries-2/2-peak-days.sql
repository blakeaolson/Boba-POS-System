SELECT
    DATE(Date), --Select the columns by date
    SUM(Order Total), --Select the sum of the order totals by date
FROM order
GROUP BY DATE(Date) --Group the orders by date
ORDER BY SUM(Order Total) DESC LIMIT 2; --Order the top 2 dates by their order total in descending order