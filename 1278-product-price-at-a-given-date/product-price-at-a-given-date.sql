# Write your MySQL query statement below
WITH cte AS (
SELECT 
    *,
    RANK() OVER(PARTITION BY product_id ORDER BY change_date DESC) as rk
 FROM 
    Products
WHERE
    change_date <= '2019-08-16'
)

SELECT 
    product_id,
    new_price as price
FROM 
    cte
GROUP BY
    product_id
HAVING MAX(rk)
UNION ALL
SELECT 
    product_id,
    10 as 'price'
FROM 
    Products
GROUP BY 
    product_id
HAVING MIN(change_date) > '2019-08-16'