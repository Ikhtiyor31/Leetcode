# Write your MySQL query statement below

SELECT 
    DISTINCT (teacher_id) teacher_id, COUNT(DISTINCT subject_id) cnt
FROM 
    Teacher 
GROUP BY teacher_id;