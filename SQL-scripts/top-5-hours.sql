SELECT 
    CAST(orderhour AS NUMERIC) AS numHour,
    COUNT(*) AS order_count /*Count number of orders*/
FROM orders /*Get top 5 hours for orders*/
GROUP BY numHour
ORDER BY order_count DESC
LIMIT 5;