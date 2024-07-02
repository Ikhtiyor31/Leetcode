# Write your MySQL query statement below

SELECT 
    emp_uni.unique_id, emp.name
FROM 
    Employees emp
LEFT JOIN 
    EmployeeUNI emp_uni
ON emp.id = emp_uni.id