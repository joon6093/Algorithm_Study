select temp.ID,
    case 
        when temp.per <= 0.25 then 'CRITICAL'
        when temp.per <= 0.50 then 'HIGH'
        when temp.per <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from (
    select ID,
    PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY desc) AS per
    FROM ECOLI_DATA
) as temp
order by temp.ID