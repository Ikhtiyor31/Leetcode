# Write your MySQL query statement below
SELECT 
    q1.query_name, ROUND(SUM(q1.rating / q1.position) / COUNT(q1.query_name),2) as quality,
     ROUND((SELECT 
        COUNT(*) 
     FROM 
        Queries q2 
     WHERE 
        q2.query_name = q1.query_name AND q2.rating < 3) / COUNT(q1.query_name) * 100,2) AS poor_query_percentage
FROM 
    Queries q1
WHERE 
    q1.query_name IS NOT NULL
GROUP BY
    q1.query_name