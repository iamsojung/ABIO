CREATE TABLE t
AS
SELECT '20150801' dt, 1 id FROM dual
UNION ALL SELECT '20150801', 2 FROM dual
UNION ALL SELECT '20150801', 1 FROM dual
UNION ALL SELECT '20150802', 1 FROM dual
UNION ALL SELECT '20150802', 2 FROM dual
UNION ALL SELECT '20150802', 2 FROM dual
UNION ALL SELECT '20150803', 3 FROM dual
UNION ALL SELECT '20150804', 4 FROM dual
UNION ALL SELECT '20150804', 1 FROM dual
UNION ALL SELECT '20150805', 1 FROM dual;
 
SELECT * FROM t;


DT                 접속건수   접속자수 누적접속건수 누적접속자수
---------------- ---------- ---------- ------------ ------------
20150801                  3          2            3            2
20150802                  3          2            6            2
20150803                  1          1            7            3
20150804                  2          2            9            4
20150805                  1          1           10            4

 
SELECT * FROM t;

select dt, count(dt) from t group by dt;
select dt, id, count(id) from t group by dt,id;
select dt, id, count(DISTINCT id) as cnt from t group by dt,id;
