# Write your MySQL query statement below
SELECT 
    s.user_id, ROUND(AVG(CASE WHEN c.action = 'confirmed' then 1 else 0 end), 2) as confirmation_rate
FROM 
    Signups s
LEFT JOIN 
    Confirmations c 
ON s.user_id = c.user_id
GROUP BY
    user_id