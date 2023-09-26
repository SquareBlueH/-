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
INSERT INTO stu VALUES (Null,'王大锤', '男', '20');
INSERT INTO stu VALUES (Null,'王小丫', '女', '19');
select * from stu  where sex='女';
select * from admin where aname='pry' and apass='123';
delete from stu where name='王大锤';
update admin set apass=666 where aname='peter';