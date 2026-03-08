# Write your MySQL query statement below


with cte as (select d.name as "Department", salary as "Salary", e.name as "Employee",
dense_rank() over (partition by d.id order by salary desc) as "rnk" from Department d
join Employee e on d.id = e.departmentId)
select Department, Employee, Salary from cte where rnk <= 3