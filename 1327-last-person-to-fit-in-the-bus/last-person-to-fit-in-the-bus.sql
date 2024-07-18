# Write your MySQL query statement below




WITH CTE AS (
    SELECT 
        person_name,
        rollingSum,
        ROW_NUMBER() OVER (ORDER BY turn DESC) AS rn
    FROM (
        SELECT 
            person_name,
            SUM(weight) OVER (ORDER BY turn ASC) as rollingSum,
            turn
        FROM 
            Queue
    ) subquery
    WHERE rollingSum <= 1000
)

SELECT person_name FROM CTE WHERE rn = 1


