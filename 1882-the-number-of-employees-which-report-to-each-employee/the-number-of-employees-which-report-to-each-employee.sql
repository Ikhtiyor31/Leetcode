# Write your MySQL query statement below
SELECT 
    e2.employee_id,
    e2.name,
    COUNT(e1.employee_id) reports_count,
    ROUND(AVG(e1.age)) average_age
FROM
    Employees e1
JOIN 
    Employees e2
WHERE
    e1.reports_to = e2.employee_id
GROUP BY
    employee_id
ORDER BY
    employee_id