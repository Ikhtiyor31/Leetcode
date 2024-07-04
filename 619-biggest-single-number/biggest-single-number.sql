# Write your MySQL query statement below
SELECT
    MAX(num) as num
FROM 
    MyNumbers
WHERE num IN (SELECT 
    MAX(num) as num
FROM
    MyNumbers
GROUP BY
    num
HAVING COUNT(*) = 1)