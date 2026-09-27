# Write your MySQL query statement below
select distinct s1.customer_id, Count(s1.customer_id) as count_no_trans
from Visits s1
left join Transactions s2
on s1.visit_id = s2.visit_id
where s2.transaction_id is  null
group by customer_id