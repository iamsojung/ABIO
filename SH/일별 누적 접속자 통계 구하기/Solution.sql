SELECT
    DT,
    COUNT(*) AS 접속건수,
    COUNT(DISTINCT id) AS 접속자수,
    SUM(COUNT(*)) OVER(ORDER BY DT) AS 누적접속건수,
    SUM(COUNT(DISTINCT id)) OVER(ORDER BY DT) AS 누적접속자수
FROM
    t
GROUP BY
    DT
ORDER BY
    DT ASC
;