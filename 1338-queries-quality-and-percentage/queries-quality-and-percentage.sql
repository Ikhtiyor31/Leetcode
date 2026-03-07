# Write your MySQL query statement below

select q1.query_name, round(sum(q1.rating / q1.position) / count(q1.query_name), 2) as quality,
round(sum(if(rating < 3, 1, 0)) / count(q1.query_name) * 100, 2) as poor_query_percentage
from Queries q1
where q1.query_name is not null
group by q1.query_name