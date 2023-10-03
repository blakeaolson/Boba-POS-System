SELECT 
    paymentmethod,
    COUNT(paymentmethod) AS paymentUse /*get payment use totals*/
FROM orders /*Order 3 most used payment methods*/
GROUP BY paymentmethod
ORDER BY paymentUse DESC
LIMIT 3;