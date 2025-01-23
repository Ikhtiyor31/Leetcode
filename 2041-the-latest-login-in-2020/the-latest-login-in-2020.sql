# Write your MySQL query statement below
SELECT 
    user_id, time_stamp as last_stamp
FROM
    Logins l1
WHERE 
    time_stamp = (SELECT MAX(time_stamp) FROM Logins l2 where l2.user_id = l1.user_id AND SUBSTR(time_stamp, 1, 4) = "2020");