# Write your MySQL query statement below

 WITH CTE AS (SELECT 
    person_name,
    SUM(weight) OVER (ORDER BY turn ASC) as rollingSum,
    turn
FROM 
    Queue)

SELECT
    person_name
FROM 
    CTE
WHERE
    rollingSum <= 1000
ORDER BY
    rollingSum DESC
LIMIT 1


