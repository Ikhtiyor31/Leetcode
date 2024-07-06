SELECT 
    'Low Salary' category,
    COUNT(account_id) accounts_count
FROM 
    Accounts
WHERE
    income < 20000
UNION ALL
SELECT 
    'Average Salary' category,
    COUNT(account_id) accounts_count
FROM 
    Accounts
WHERE
    income >= 20000 AND income <= 50000
UNION ALL
SELECT 
    'High Salary' category, 
    COUNT(account_id) accounts_count
FROM
    Accounts
WHERE
    income > 50000
