# Write your MySQL query statement below


with cte as (select *, sum(weight) over (order by turn asc) as running_sum from Queue) 
select person_name from cte where running_sum <= 1000 order by running_sum DESC limit 1