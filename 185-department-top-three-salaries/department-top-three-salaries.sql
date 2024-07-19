# Write your MySQL query statement below

WITH CTE AS (SELECT 
    d.name as Department,
    e.name as Employee,
    e.salary as Salary,
    DENSE_RANK() OVER(PARTITION BY d.name ORDER BY e.salary DESC) as rnk
FROM 
    Employee e
LEFT JOIN 
    Department d
ON e.departmentId = d.id)


SELECT 
    Department,
    Employee,
    Salary
FROM
    CTE
WHERE rnk <= 3




