SELECT * 
FROM inventory
ORDER BY CAST(quantity AS NUMERIC) ASC /*Order lowest inventory item*/
LIMIT 5; /*Bottom 5*/