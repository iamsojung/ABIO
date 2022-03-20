select
    EMPNO
    , ENAME
    , LEVEL as LV
    , MGR
    , prior ename as MGR_ENAME
    , SUBSTRB (SYS_CONNECT_BY_PATH(ENAME, '-'), 2)
from
    emp
start with mgr is null
connect by prior empno = mgr
;