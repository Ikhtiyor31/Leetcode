# Write your MySQL query statement below

SELECT 
    MAX(e1.salary) SecondHighestSalary
FROM
    employee e1 
JOIN 
    employee e2 
ON e1.salary < e2.salary