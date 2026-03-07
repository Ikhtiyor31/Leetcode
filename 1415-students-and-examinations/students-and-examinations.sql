# Write your MySQL query statement below


select st.student_id, st.student_name, s.subject_name, count(ex.student_id) as attended_exams from Students st
join Subjects s
left join Examinations ex on ex.student_id = st.student_id AND ex.subject_name = s.subject_name
group by st.student_id, s.subject_name
order by st.student_id, s.subject_name