-- 复习 约束 唯一 非空 默认
use my_db;
create table my_default1(
d date default 20221107,   -- 默认约束
id int);
insert into my_default1 values(20221106,1);
insert into my_default1 values(default,2);
insert into my_default1(id) values(3);
insert into my_default1(d) values(default);
select * from my_default1;


create table my_notnull(
id int not null,
d date default 20221107);
insert into my_notnull(d) values(default);
-- > 1364 - Field 'id' doesn't have a default value
select * from my_notnull;

create table my_notnull1(
id int,
d date not null default 20221107);

create table my_unique1(
d date default 20221107,   -- 默认约束
id int unique);
insert into my_unique1(id) values(3);
select * from my_unique1;
insert into my_unique1(id) values(3);
-- > 1062 - Duplicate entry '3' for key 'my_unique1.id'
desc my_unique1;
insert into my_unique1(d) values(20221108);

create table my_unique2(
d date default 20221107,   -- 默认约束
id int unique not null);
insert into my_unique2(d) values(20221108);
-- > 1364 - Field 'id' doesn't have a default value
desc my_unique2;

-- 主键约束
create table my_pri(
sno char(4) primary key,  -- 主键约束 列级约束
sname varchar(10),
xb char(2) default '女');
desc my_pri;  -- not null 
insert into my_pri values('1001','小一','男');
select * from my_pri;
insert into my_pri(sname,xb) values('小二','男');
-- > 1364 - Field 'sno' doesn't have a default value
insert into my_pri(sno) values('1002');
insert into my_pri values(null,'小一','男');
-- > 1048 - Column 'sno' cannot be null 
insert into my_pri values('1001','小一','男');
-- > 1062 - Duplicate entry '1001' for key 'my_pri.PRIMARY'

create table my_class(
classno char(4),
classname varchar(10),
sdept varchar(10));
desc my_class;

alter table my_class add primary key(classno);  -- 添加主键约束
desc my_class;
alter table my_class modify sdept varchar(10) default '计算机学院';
alter table my_class add unique(classname);

alter table my_class modify classno char(4);
ALTER TABLE my_class DROP PRIMARY KEY;   -- 一般不会使用删除主键约束 
-- 主键唯一识别实体 

-- 选课信息表 id无做为主键 （int 1-2-3-……）
sno cno grade 
create table sc(
sno char(4) primary key,
cno char(4) primary key,
grade int);
-- 失败

-- > 1068 - Multiple primary key defined
create table sc(
sno char(4),
cno char(4),
grade int,
primary key(sno)
);
desc sc;
insert into sc values('1001','2001',90);
insert into sc values('1001','2002',90);
create table sc1(
sno char(4),
cno char(4),
grade int,
primary key(cno)
);
insert into sc1 values('1001','2001',90);
insert into sc1 values('1001','2002',90);
insert into sc1 values('1002','2001',95);
insert into sc1 values('1002','2002',95);

create table sc2(
sno char(4),
cno char(4),
grade int,
primary key(sno,cno)   -- 表级约束
);
-- > OK
desc sc2;
insert into sc2 values('1001','2001',90);
insert into sc2 values('1001','2002',90);
insert into sc2 values('1002','2001',95);
insert into sc2 values('1002','2002',95);

insert into sc2 values('1002','2002',59);
-- > 1062 - Duplicate entry '1002-2002' for key 'sc2.PRIMARY'
select * from sc2;

create table sc3(
id int not null unique,  -- 序号
sno char(4),
cno char(4),
grade int,
primary key(sno,cno)   -- 表级约束
);
insert into sc3 values(4,'1002','2001',90);
insert into sc3 values(3,'1001','2001',60);
select * from sc3;

create table sc4(
id int primary key AUTO_INCREMENT,  -- 序号
sno char(4),
cno char(4),
grade int
);
insert into sc4 values(1,1001,2002,90);


select * from sc4;

insert into sc4(sno,cno,grade) 
values(1003,2002,70),(1004,2002,70),(1005,2002,70),(1006,2002,70);

create table sc5(
sno char(4) primary key auto_increment,
cno char(4),
grade int);
-- > 1063 - Incorrect column specifier for column 'sno'

create table sc6(
id1 int primary key AUTO_INCREMENT,  -- 序号
id2 int unique AUTO_INCREMENT,  -- 序号
sno char(4),
cno char(4),
grade int
);
--  1075 - Incorrect table definition; there can be only one auto column and it must be defined as a key


create table sc6(
id1 int AUTO_INCREMENT,  -- 序号
sno char(4),
cno char(4),
grade int
);

-- > 1075 - Incorrect table definition; there can be only one auto column and it must be defined as a key

insert into sc4 values(8,1008,2002,90);
insert into sc4(sno,cno,grade) 
values(1009,2002,70),(1014,2002,70),(1015,2002,70),(1016,2002,70);
select * from sc4;
insert into sc4 values(7,1018,2002,90);

insert into sc4(sno,cno,grade) 
values(1009,2003,70),(1014,2003,70),(1015,2003,70),(1016,2003,70);
-- 删除id为13
delete from sc4 where id =13;



insert into sc4(sno,cno,grade) 
values(1009,2004,70),(1014,2004,70),(1015,2004,70),(1016,2004,70);

create table t(
-- 字段列表 charater set 
) charset utf8;  -- 设置字符集