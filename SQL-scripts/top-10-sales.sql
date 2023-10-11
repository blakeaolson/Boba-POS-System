SELECT
    id,
    orderdate,
    CAST(totalamount AS NUMERIC) as numAmount /*Make amount numeric*/
FROM orders 
ORDER BY numAmount DESC /*order by ordertotal*/
LIMIT 10; /*10 highest*/
