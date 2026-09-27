# Write your MySQL query statement below

select s2.unique_id, s1.name
from  Employees s1
LEFT JOIN EmployeeUNI s2
on s1.id=s2.id