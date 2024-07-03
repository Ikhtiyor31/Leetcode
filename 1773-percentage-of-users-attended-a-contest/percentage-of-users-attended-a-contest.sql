# Write your MySQL query statement below

SELECT 
    r.contest_id, ROUND((COUNT(r.user_id) / (select count(*) from Users)) * 100,2) as percentage
FROM 
    Users u
JOIN 
    Register r
ON
    u.user_id = r.user_id
GROUP BY 
    r.contest_id
ORDER BY
    percentage DESC, r.contest_id ASC;