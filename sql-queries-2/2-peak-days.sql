SELECT
    DATE(orderdate), --Select the columns by date
    SUM(CAST(totalamount AS NUMERIC)), --Select the sum of the order totals by date
FROM orders
GROUP BY DATE(orderdate) --Group the orders by date
ORDER BY SUM(totalamount) DESC LIMIT 2; --Order the top 2 dates by their order total in descending order