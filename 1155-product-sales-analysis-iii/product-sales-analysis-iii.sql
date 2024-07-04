# Write your MySQL query statement below
SELECT 
    p.product_id, s.year first_year, s.quantity, s.price
FROM 
    Sales s
JOIN 
    Product p
ON 
    p.product_id = s.product_id
WHERE
    (p.product_id, s.year)
IN 
    (SELECT s1.product_id, MIN(s1.year) FROM Sales s1 GROUP BY s1.product_id)