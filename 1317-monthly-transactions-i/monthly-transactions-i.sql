# Write your MySQL query statement below

SELECT 
    SUBSTR(trans_date,1,7) AS month,
    country,
    COUNT(id) as trans_count ,
    SUM(if(state = 'approved', 1, 0)) as approved_count,
    SUM(amount) as trans_total_amount,
    SUM(if(state = 'approved', amount, 0)) as approved_total_amount
FROM 
    Transactions
GROUP BY
    month, country