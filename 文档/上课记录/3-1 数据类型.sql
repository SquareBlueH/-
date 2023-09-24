-- 复习 插入、查询、修改、删除数据
use xsgl;
show tables;
desc sy;
insert into sy(sname,sno,nation)
values('xixi','1015','苗族');
 
insert into sy values('1010','lily','女','苗族',18);
select * from sy;
insert into sy values('1011','lily','女','苗族',18),
('1012','lily','女','苗族',18),
('1013','lily','女','苗族',18),
('1014','lily','女','苗族',18);
select * from sy;
-- 修改学号1011 姓名为 hehe
update sy set sname='hehe' where sno='1011';
select * from sy;
update sy set sname='xiaoming',sxb='男' where sno='1012'; 
select * from sy;
-- 同时删除1013和1014的学生
delete from sy where sno='1013' and sno='1014';
-- > Affected rows: 0
delete from sy where sno='1013' or sno='1014';
-- > Affected rows: 2
select * from sy;

-- 数据类型
create database mydb;
use mydb;
create table my_int(
i1 int,
i2 int unsigned,
i3 tinyint,
i4 tinyint unsigned);

desc my_int;
insert into my_int values(1000,1000,100,100);
select * from my_int;
insert into my_int values(1000,1000,1000,1000);
-- > 1264 - Out of range value for column 'i3' at row 1
insert into my_int values(1000,-1000,100,-100);
-- > 1264 - Out of range value for column 'i2' at row 1
insert into my_int values(-1000,1000,-100,100);
-- > Affected rows: 1
select * from my_int;

create table my_int2(
i1 int(3) zerofill,
i2 tinyint(4) zerofill);
insert into my_int2 values(1234,2);
select * from my_int2;

create table my_int3(
i1 int(3),
i2 tinyint(4));
insert into my_int3 values(1234,2);
select * from my_int3;
insert into my_int3 values('123','2');
-- > Affected rows: 1
select * from my_int3;
insert into my_int3 values('小米','2');
-- > 1366 - Incorrect integer value: '小米' for column 'i1' at row 1
insert into my_int3 values('123.32','2');
-- > Affected rows: 1
insert into my_int3 values('123.499999','2');   
-- 小数插入到整数字段，四舍五入
select * from my_int3;

-- alter table 表名 modify 字段名 字段类型

create table my_float(
f1 float,
f2 float unsigned);

insert into my_float values(123.455,123.455);
select * from my_float;
insert into my_float values(-123.455,-123.455);
insert into my_float values(123.4554444,123.4554444);
insert into my_float values(123.45555555,123.45555555);
insert into my_float values(123.4555,123.4555);
-- > Affected rows: 1
INSERT INTO my_float VALUES(11111149, 11111159);
-- 整数部分和小数部分加起来达到7位时，第7位就会四舍五入。

create table my_decimal(   -- 定点数类型
d1 decimal(7,4),   -- 取值范围-999.9999~999.9999
d2 decimal(5,2));
insert into my_decimal values(123.4555,123.4555);
select * from my_decimal;
-- 123.4555 123.46

/*
insert into my_decimal values(123.4555,123.4555);
Query OK, 1 row affected, 1 warning (0.01 sec)

mysql> show wranings;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'wranings' at line 1
*/
create table my_bit(
b1 bit(4),
b2 bit(6));
insert into my_bit values(2,2);
select * from my_bit;
-- 0010	000010
alter table my_bit modify b1 bit(10);  -- > OK
alter table my_bit modify b2 bit(10);  -- > OK
insert into my_bit values('a','b');   -- > Affected rows: 1
select * from my_bit;
SELECT ASCII('A');    -- 65
SELECT ASCII('a');   -- 97
select bin(97);      -- 1100001
select length(bin(97));
select b'1100001';   -- a
select x'41';    -- A
select 0x41;

update xsgl.sy set sname='xiaoming\'',sxb='男' where sno='1012';
-- > Affected rows: 1
select * from xsgl.sy;  -- xiaoming'

update xsgl.sy set sname='xiao"ming',sxb='男' where sno='1012';

update xsgl.sy set sname="xiao\"ming",sxb='男' where sno='1012';

show tables;

insert into xsgl.sy(sname,sno,nation)
values('LL','1017','苗族');

-- 把性别为null值改为女
update xsgl.sy set sxb='女' where sxb = 'NULL';
--  > Affected rows: 0
update xsgl.sy set sxb='女' where sxb = 'Null';
-- > Affected rows: 0
update xsgl.sy set sxb='女' where sxb is Null;  --  -> Affected rows: 2
select * from xsgl.sy; 
update xsgl.sy set age='19' where age is NULL;   --  > Affected rows: 2
select * from xsgl.sy; 

-- 修改 更新所有除了NULL值之外学生年龄加1
update xsgl.sy set age=age+1 where age is not null;  -- > Affected rows: 5

create table my_date(
y year,    -- 年份  入学年份
x date,    -- 日期  年月日   出生日期
d DATETIME);   -- 年月日 时分秒   订单下单时间、车次时间、借书日期、还书日期

insert into my_date values(2021,20030606,20210901090000);
select * from my_date;

insert into my_date values(2021,'2003-07-06','20210901090000');
insert into my_date values(2022,current_date,now());
-- > Affected rows: 1
select * from my_date;
insert into my_date values(2022,current_date,now());

insert into my_date values(2021,'2003.07.07','20210901090011');
insert into my_date values(2021,'2003/07/07','20210901090022');