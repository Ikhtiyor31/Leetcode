# Write your MySQL query statement below


select ROUND(count(*) / (select count(distinct player_id) from Activity), 2) as fraction from Activity a1 
where (a1.player_id, DATE_SUB(a1.event_date, interval 1 day)) in (
    select player_id, min(event_date) from Activity group by player_id
)