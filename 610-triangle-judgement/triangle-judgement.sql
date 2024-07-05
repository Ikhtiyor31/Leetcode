# Write your MySQL query statement below

SELECT
    x, y, z, IF (x + y <= z or x + z <= y or z + y <= x, 'No', 'Yes') triangle
FROM
    Triangle