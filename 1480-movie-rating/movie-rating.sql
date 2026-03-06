# Write your MySQL query statement below

(select u.name as results 
from Users u 
join MovieRating mr on u.user_id = mr.user_id 
group by u.user_id
order BY COUNT(*) DESC, u.name ASC limit 1)
union all
(select m.title as results from Movies m
join MovieRating mr on mr.movie_id = m.movie_id
where mr.created_at between '2020-02-01' and '2020-02-29'
group by m.movie_id 
order by avg(mr.rating) desc, m.title asc
limit 1)