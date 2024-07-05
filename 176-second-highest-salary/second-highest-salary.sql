# Write your MySQL query statement below

SELECT 
    MAX(salary) as 'SecondHighestSalary'
FROM 
    Employee e
WHERE 
    salary < (SELECT MAX(salary) FROM employee);