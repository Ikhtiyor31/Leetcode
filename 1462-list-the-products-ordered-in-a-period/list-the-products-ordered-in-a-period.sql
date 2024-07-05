# Write your MySQL query statement below

SELECT 
    product_name, 
    SUM(o.unit) unit
FROM 
    Products p
LEFT JOIN 
    Orders o
ON
    p.product_id = o.product_id
WHERE 
    SUBSTR(o.order_date, 1, 7) = "2020-02"
GROUP BY 
    p.product_name
HAVING SUM(o.unit) >= 100