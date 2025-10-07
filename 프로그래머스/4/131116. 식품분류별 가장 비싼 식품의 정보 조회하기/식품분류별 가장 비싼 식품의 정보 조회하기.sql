select CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where (CATEGORY, PRICE) in (
    select CATEGORY, max(PRICE)
    from FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유') 
    group by  CATEGORY
)
order by MAX_PRICE desc
