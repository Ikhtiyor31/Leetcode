# Write your MySQL query statement below
SELECT 
    st.student_id as student_id,
    st.student_name as student_name,
    sb.subject_name as subject_name,
    COUNT(ex.student_id) as attended_exams
FROM 
    Students st
JOIN 
    Subjects sb
LEFT JOIN 
    Examinations ex
ON 
    ex.student_id = st.student_id AND ex.subject_name = sb.subject_name
GROUP BY 
    student_id,
    subject_name
ORDER BY 
    student_id,
    subject_name
