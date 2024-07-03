# Write your MySQL query statement below
SELECT 
    query_name, ROUND(SUM(rating / position) / COUNT(query_name),2) as quality,
    ROUND(SUM(if(rating < 3, 1, 0)) / COUNT(query_name) * 100,2) AS poor_query_percentage
FROM 
    Queries
WHERE 
    query_name IS NOT NULL
GROUP BY
    query_name