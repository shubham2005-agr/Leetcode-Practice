# Write your MySQL query statement below
select s2.product_name, s1.year, s1.price
from Sales s1
join Product s2
on s1.product_id = s2.product_id