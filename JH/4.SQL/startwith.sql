
// http://www.gurubee.net/lecture/2223



사원번호(empno), 성명(ename), 상사의 사원번호(mgr) 를 가진 테이블 emp가 있습니다.
이 원본테이블([표 1] 참조)을 이용하여 [표 2]의 계층구조 결과테이블을 완성하는 쿼리를 작성하세요.
scott 사용자의 emp 테이블을 사용하여 문제를 해결하면 됩니다.

EMPNO ENAME        MGR
------ -------- -------
  7369 SMITH       7902
  7499 ALLEN       7698
  7521 WARD        7698
  7566 JONES       7839
  7654 MARTIN      7698
  7698 BLAKE       7839
  7782 CLARK       7839
  7788 SCOTT       7566
  7839 KING
  7844 TURNER      7698
  7876 ADAMS       7788
  7900 JAMES       7698
  7902 FORD        7566
  7934 MILLER      7782


  EMPNO ENAME        LV        MGR MGR_ENAME  ENAMES
------ ---------- ---- ---------- ---------- -------------------------
  7839 KING          1                       KING
  7566 JONES         2       7839 KING       KING-JONES
  7788 SCOTT         3       7566 JONES      KING-JONES-SCOTT
  7876 ADAMS         4       7788 SCOTT      KING-JONES-SCOTT-ADAMS
  7902 FORD          3       7566 JONES      KING-JONES-FORD
  7369 SMITH         4       7902 FORD       KING-JONES-FORD-SMITH
  7698 BLAKE         2       7839 KING       KING-BLAKE
  7499 ALLEN         3       7698 BLAKE      KING-BLAKE-ALLEN
  7521 WARD          3       7698 BLAKE      KING-BLAKE-WARD
  7654 MARTIN        3       7698 BLAKE      KING-BLAKE-MARTIN
  7844 TURNER        3       7698 BLAKE      KING-BLAKE-TURNER
  7900 JAMES         3       7698 BLAKE      KING-BLAKE-JAMES
  7782 CLARK         2       7839 KING       KING-CLARK
  7934 MILLER        3       7782 CLARK      KING-CLARK-MILLER




  SELECT EMPNO
        , ENAME
        , LEVEL LV
        , MGR
        , PRIOR ENAME AS MGR_ENAME
        , ENAMES
    FROM EMP
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO = MGR
    

//정답 
SELECT empno
     , ename
     , LEVEL lv
     , mgr
     , PRIOR ename mgr_ename
     , SUBSTR(SYS_CONNECT_BY_PATH(ename, '-'), 2) enames
  FROM emp
 START WITH mgr IS NULL
CONNECT BY PRIOR empno = mgr
 ORDER SIBLINGS BY empno
;