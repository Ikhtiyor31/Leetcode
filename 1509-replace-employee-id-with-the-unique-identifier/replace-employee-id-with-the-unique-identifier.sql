# Write your MySQL query statement below

SELECT 
    EU.unique_id unique_id,
    E.name name
FROM
    Employees E
LEFT JOIN
    EmployeeUNI EU
ON E.id = EU.id 

   