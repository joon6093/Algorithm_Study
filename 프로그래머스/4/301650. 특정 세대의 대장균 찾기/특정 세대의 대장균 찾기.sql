select g3.ID
from ECOLI_DATA as g1
join ECOLI_DATA as g2
on g2.PARENT_ID = g1.ID
join ECOLI_DATA as g3
on g3.PARENT_ID = g2.ID
where g1.PARENT_ID is null
order by g3.ID ASC