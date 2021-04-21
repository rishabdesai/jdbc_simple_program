create table emp99 (empno varchar(30), ename varchar(30), sal float, deptno integer, job varchar(30), mgr varchar(30));
insert into emp99 values("a_name","a_surname", 100.10,1,"job1","manager1");
insert into emp99 values("b_name","b_surname", 200.20,2,"job2","manager2");
insert into emp99 values("c_name","c_surname", 300.30,1,"job3","manager3");


DELIMITER $$

CREATE PROCEDURE SP_ADD_EMP99(p_empid varchar(30), p_ename varchar(30), p_sal float, p_deptno int, p_job varchar(30), p_mgr varchar(30)) 
BEGIN
INSERT INTO emp99 VALUES (p_empid,p_ename,p_sal,p_deptno,p_job,p_mgr);
END;
$$
DELIMITER ;
