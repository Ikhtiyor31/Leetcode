# Write your MySQL query statement below

WITH 
    MaxRatingUser AS (
        SELECT 
            u.name
        FROM Users u
        LEFT JOIN 
            MovieRating mr
        ON 
            u.user_id = mr.user_id
        GROUP BY
            u.user_id
        ORDER BY 
            COUNT(*) DESC,
            u.name
        LIMIT 1
    ),
    HightestAverageOne AS (
        SELECT 
            mo.title name
        FROM 
            Movies mo
        LEFT JOIN 
            MovieRating mr2
        ON 
            mo.movie_id = mr2.movie_id
        WHERE 
            SUBSTR(mr2.created_at, 1, 7) = "2020-02"
        GROUP BY 
            mo.title
        ORDER BY 
            AVG(mr2.rating) DESC, 
            mo.title
        LIMIT 1
    )

SELECT name results FROM MaxRatingUser
UNION ALL
SELECT name results FROM HightestAverageOne;
    
    




