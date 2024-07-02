# Write your MySQL query statement below

SELECT 
v.author_id AS id
FROM 
Views v 
WHERE 
v.viewer_id = v.author_id 
group by 
v.author_id 
ORDER BY id ASC