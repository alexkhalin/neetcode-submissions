-- Write your query below
select c.customer_id
from customers c
where
c.year = 2020
and 
c.revenue > 0