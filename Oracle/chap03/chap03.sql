sqlplus sys/oracle as sysdba


ALTER SESSION SET "_oracle_script"=true;

create user scott
identified by tiger
default tablespace users quota unlimited on users;

grant create session, create table to scott;

conn scott/tiger

show user

ALTER SESSION SET "_oracle_script"=true;

ALTER SESSION SET nls_date_language='american';

ALTER SESSION SET nls_date_format='dd-MON-rr';


@C:\doitoracle\doitoracle_scott.sql


desc emp;
desc dept;
desc salgrade;

select * from emp;


