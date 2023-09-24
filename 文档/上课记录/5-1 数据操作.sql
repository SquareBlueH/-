-- 复习
-- 自动增长
-- 约束 默认 非空 唯一 主键  外键
show databases;
use xsgl;
show tables;
select * from sy;

create table c(
cno char(2) primary key,
cname varchar(20) not null,
xf int);

insert into c values('01','数据库',3),('02','大学英语',2);

create table sc(
sno char(4),
cno char(2),
score int);

insert into sc values('1010','02',90);
select * from sc;
alter table sc add primary key(sno,cno);
insert into sc values('1010','02',89);
-- > 1062 - Duplicate entry '1010-02' for key 'PRIMARY'
insert into sc values('1010','01',89);
insert into sc values('1010','03',89);

-- c cname 添加唯一约束
alter table c add unique(cname);
insert into c values('03','数据库',3);
-- > 1062 - Duplicate entry '数据库' for key 'cname'
insert into c values('03','数据库设计',2);
select * from c;
create table x(
id int unique,
iname char(10));
insert into x values(null,'hgjk');

alter table sc add id int auto_increment;
-- > 1075 - Incorrect table definition; there can be only one auto column and it must be defined as a key
alter table sc add id int unique auto_increment;
desc sc;
select * from sc;

insert into sc values('1018','01',60,5);

insert into sc(sno,cno,score) 
values(1018,02,80); --  id=6;

-- 删除 id=6的数据
delete from sc where id=6;

insert into sc(sno,cno,score) 
values(1018,02,80);   -- id=7
select * from sc;

alter table c modify cno char(2) primary key auto_increment;

alter table sc add id2 int unique auto_increment;
-- 自动增长：
/* 1.数据类型必须是整数类型
2. 同一个数据表 自动增长只能是一个字段（一列)
3.该列必须是键（主键、唯一约束的键）
4.插入数据的，可以插入符合条件的值，也可以省略该列的值
如果省略的话，值是最大值（曾经出现）加1
there can be only one auto column and it must be defined as a key
*/
insert into sc values('1011','01',90,7);
-- > 1062 - Duplicate entry '7' for key 'id'
insert into sc values('1011','01',90,8);
-- > Affected rows: 1
insert into sc values('1011','01',9,9);
-- > 1062 - Duplicate entry '1011-01' for key 'PRIMARY'
-- 主键冲突更新:以更新方式
-- 语法是 insert into 数据表名[(字段列表)] values(值列表) 
-- on duplicate key update 字段名1=值1[,字段名2=值2]
insert into sc values(1011,01,9,9)
on duplicate key update score=90;

-- > Affected rows: 1
select * from sc;
update c set xf=3 where cname='大学英语';

-- 主键冲突替换:如果发生冲突，先删除表中的数据，再插入
-- 语法 replace into tablename(字段列表) values(值列表)[,(值列表)]
insert into sc values('1011','01',90,10);
-- > 1062 - Duplicate entry '1011-01' for key 'PRIMARY'
replace into sc values('1011','01',90,10);
-- > Affected rows: 2
select * from sc;
replace into sc(sno,cno,score) values('1011','01',90),('1018','01',70);
-- > Affected rows: 4
select * from sc;
-- 插入数据 数量比较大 解决主键冲突 推荐主键冲突替换

insert into sc values('1011','01',90,11)
on duplicate key update score=90

replace into sc(sno,cno,score) values('1011','03',90);
-- > Affected rows: 1

-- 复制表结构
desc sc;

-- 复制一张表sc1和sc表的结构一样
create table sc1(    -- 再创建一个
sno char(4),
cno char(2),
score int,
id int unique auto_increment,
primary key(sno,cno)
);

-- 复制已有的表结构
/*create table if not exists 新表名 like 旧表名
create table 新表名 (like 旧表名)*/
-- 复制一张表sc2和sc表的结构一样
create table sc2 like sc;

desc sc1;
desc sc2;

create table sc4 like sc3;
-- > 1146 - Table 'xsgl.sc3' doesn't exist

create TEMPORARY table sc4 like sc;
-- 临时表：一种仅存在当前会话可以见的表，当前会话关闭，自动删除。
select * from sc2;

-- 复制已存在表中的数据
/*语法：insert into 目标数据表名[(字段列表)] 
select [(字段列表)] from 数据源表名*/

/*正确语法：insert into 目标数据表名[(字段列表)] 
select *|部分字段列表 from 数据源表名*/

insert into sc2 select from sc;   -- 错误
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'from sc' at line 1
select * from sc;
insert into sc2 select * from sc;   -- 正确语句
-- > Affected rows: 8
select * from sc2;

select (*) from sc;
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '*) from sc' at line 1

select (sno,cno,score) from sc;
-- > 1241 - Operand should contain 1 column(s)
select sno,cno,score from sc;

create table t(
t1 int,
t2 varchar(20));
insert into t values(1,'水杯'),(2,'文具'),(3,'课本');
select * from t;

insert into t select * from t;


-- 课堂练习
/* 1.创建一个商品信息表
2.给商品信息表里插入数据
3.复制刚创建的商品信息表结构
4.复制商品信息表的数据到题3的表中*/

create table users(
gender enum('男','女'))charset latin1;
-- > 1291 - Column 'gender' has duplicated value '?' in ENUM

create table users(
gender enum('男','女'))charset utf8;
-- > OK