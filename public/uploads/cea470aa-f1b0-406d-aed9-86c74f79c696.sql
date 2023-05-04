create or replace Procedure FN_NB IS
BEGIN

CURSOR C is(Select p.FIRST_NAME,p.LAST_NAME,m.FIRST_NAME,m.LAST_NAME into num  from  EMPLOYEES p,EMPLOYEES m where m.EMPLOYEE_ID = p.MANAGER_ID);

return num;

END;
/

Select FN_NB from dual;

