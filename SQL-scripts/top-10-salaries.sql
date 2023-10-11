SELECT * FROM employees
ORDER BY CAST(Salary AS NUMERIC) DESC /*Order casheirs by salary for top 10*/
LIMIT 10;