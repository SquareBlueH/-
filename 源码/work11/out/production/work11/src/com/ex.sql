CREATE DATABASE ex��
use ex��

CREATE TABLE admin (
	aid int primary key,
	aname varchar(20) NOT NULL,
	apass varchar(20) NOT NULL
);

CREATE TABLE stu (
	sid int  primary key Auto_Increment,
	sname varchar(20) NULL,
	sex varchar(2) NULL,
	age int  NULL
);

INSERT INTO admin VALUES (1,'pry', '123');
INSERT INTO admin VALUES (2,'peter','456');

INSERT INTO stu VALUES (Null,'����', '��', '20');
INSERT INTO stu VALUES (Null,'��СѾ', 'Ů', '19');

select * from stu  where sex='Ů';

select * from admin where aname='pry' and apass='123';

delete from stu where name='����';

update stu set age=18 where name='��СѾ';


