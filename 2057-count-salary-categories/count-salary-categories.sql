# Write your MySQL query statement below
WITH low_salary AS (
    SELECT 
        'Low Salary' AS category,
        COUNT(*) AS accounts_count
    FROM 
        Accounts
    WHERE income < 20000
),

average_salary AS (
    SELECT 
        'Average Salary' AS category,
        COUNT(*) AS accounts_count
    FROM 
        Accounts
    WHERE income BETWEEN 20000 AND 50000
),

high_salary AS (
    SELECT 
        'High Salary' AS category,
        COUNT(*) AS accounts_count
    FROM 
        Accounts
    WHERE income > 50000
)

SELECT * FROM high_salary
UNION ALL
SELECT * FROM low_salary
UNION ALL
SELECT * FROM average_salary
