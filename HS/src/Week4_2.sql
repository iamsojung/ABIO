SELECT
    DT as ddt,
    count(dt) as a,
    count(distinct(id)) as b,
    sum(count(dt)) over(order by DT) as c,
    (select count(distinct(id)) from t where dt <= ddt) as d
FROM t group by dt ;
