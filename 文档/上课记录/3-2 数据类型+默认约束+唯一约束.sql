-- 复习 数据类型 
-- 数字类型
-- 整数类型 tinyint smallint int MEDIUMint bigint
-- 无符号 unsigned 不包含复数
-- 浮点型 float double 尽量避免使用，精度 存放数据时会引起一些人为无法控制的
-- 实际数据与存储数据不一样
-- 定点型 decimal(m,d) m:位数（数字总位数，不包含小数点） d:小数点后的位数
-- bit 二进制数

-- 日期和时间
-- year  date time datetime timestamp
-- 当前系统时间 now() current_date
create database my_db;
use my_db;
create table d(
d1 date,
d2 datetime);
insert into d values(current_date,current_date);
select * from d;
insert into d values(current_date,now());

-- 字符串类型
-- char()
-- varchar()
create table my_char(
c1 char(3),
c2 varchar(3)
);
insert into my_char values('a','b');
insert into my_char values('a','c');
insert into my_char values('c','b');
insert into my_char values('c','b');
select * from my_char;

select * from my_char where c1='a'; 
select * from my_Char where c1='A';   -- 默认情况下，不区分大小写

create table my_binary(
b1 BINARY);
insert into my_binary values('a');
select * from my_binary;
select * from my_binary where b1='A';  -- a A 区分大小写
CREATE TABLE my_varchar1 (c VARCHAR(65533) NOT NULL) charset latin1;
insert into my_varchar1 values('你好');
-- > 1366 - Incorrect string value: '\xE4\xBD\xA0\xE5\xA5\xBD' for column 'c' at row 1
insert into my_varchar1 values('hello');

-- > 1074 - Column length too big for column 'c' (max = 21845); use BLOB or TEXT instead  21844
CREATE TABLE my_varchar2 (c VARCHAR(21844) CHARSET utf8);
insert into my_varchar2 values('你好');  -- > Affected rows: 1

CREATE TABLE my_char1 (
  c1 CHAR(2) CHARACTER SET latin1 COLLATE latin1_bin,
  c2 CHAR(2) CHARACTER SET gbk COLLATE gbk_bin,
  c3 CHAR(2) CHARACTER SET utf8 COLLATE utf8_bin
);
insert into my_char1 values('a','b','c');
insert into my_char1 values('A','B','C');
select * from my_char1;
select * from my_char1 where c1='a';
select * from my_char1 where c2='b';   -- 区分大小写
select * from my_char1 where c3='c';

CREATE TABLE my_char2 (
  c1 CHAR(2) CHARACTER SET latin1,
  c2 CHAR(2) CHARACTER SET gbk,
  c3 CHAR(2) CHARACTER SET utf8
);
insert into my_char2 values('a','b','c');
insert into my_char2 values('A','B','C');  -- 不区分大小写
select * from my_char2 where c3='c';

create table x1(
sno char(3),
xb char(2));  -- 性别 男/女  male/female
insert into x1 values('100','h');
insert into x1 values('101','男');
insert into x1 values('102','女');
select * from x1;

create table x2(
sno char(3),
xb char(2) check(xb='男' or xb='女'));
insert into x2 values('100','h');  
-- > 3819 - Check constraint 'x2_chk_1' is violated.
insert into x2 values('101','男');   -- > Affected rows: 1
insert into x2 values('102','女');
insert into x2 values('102','nv');
-- > 3819 - Check constraint 'x2_chk_1' is violated

create table x3(
sno char(3),
xb enum('男','女'));  -- 枚举类型  单选题
insert into x3 values('102','女');
insert into x3 values('102','nv');
-- > 1265 - Data truncated for column 'xb' at row 1

create table x4(
sno char(3),
xb enum('男','女'),
hobby SET('sing','dance','code','read'));  -- 多选
insert into x4 values('101','女','');
insert into x4 values('103','女','sing,dance');
select * from x4;
insert into x4 values('104','男','sing,dance,read,code');
insert into x4 values('105','男','ball');
-- > 1265 - Data truncated for column 'hobby' at row 1
insert into x4 values('106','男','sing','dance','read','code');
-- > 1136 - Column count doesn't match value count at row 1

CREATE TABLE my_json (j1 JSON, j2 JSON);
INSERT INTO my_json VALUES
('{"k1": "value", "k2": 10}', '["run", "sing"]');
select * from my_json;

create table my_default(
id int,
yhm char(4),
mima varchar(16) default '123456'  -- 默认约束 
);

insert into my_default values(1,'asdf','0000');
select * from my_default;

desc my_default;
insert into my_default values(2,'qadf','123456');

insert into my_default values(3,'qadf',default)
,(4,'qadf',default),(5,'qadf',default);   -- default代替默认值

create table my_d
(id int,
d1 datetime comment'办理日期',
t char(11)); 
insert into my_d values(1,now(),'12345678977');
select * from my_d;

create table my_d1
(id int,
d1 date comment'办理日期' default current_date,
t char(11)); 
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'current_date, t char(11))' at line 3

create table my_d1
(id int,
d1 date comment'办理日期' default '20220901',
t char(11));

desc my_d1;

create table s(
sno char(3),
sname varchar(10),
tel char(11),
qq char(11));

insert into s(sname,tel) values('张三','12345678977');
insert into s(tel) values('12345677777');  -- > Affected rows: 1
select * from s;
insert into s(sname,tel) values('张三','12345688888');

create table s1(
sno char(3) not null,
sname varchar(10) not null,
tel char(11) not null,
qq char(11));
desc s1;
insert into s1(sname,tel) values('张三','12345688888');
-- > 1364 - Field 'sno' doesn't have a default value
insert into s1(sno,sname,tel) values('101','张三','12345688888');
insert into s1 values('102','李斯','12345688887','789774456');
select * from s1;
insert into s1(sno,sname,qq) values('102','李斯','12345688887');
-- > 1364 - Field 'tel' doesn't have a default value

create table s2(
sno char(3) not null,
sname varchar(10) not null,
tel char(11) not null,
xb char(2) not null default '男',
qq char(11));

insert into s2(sno,sname,tel) values('101','张三','12345688888');
--  Affected rows: 1
select * from s2;
insert into s2(sno,sname,tel) values('101','张三','12345666688');
insert into s2(sno,sname,tel) values('101','wuwu','12345666688');

create table s3(
sno char(3) not null unique,
sname varchar(10) not null,
tel char(11) not null,
xb char(2) not null default '男',
qq char(11));
insert into s3(sno,sname,tel) values('101','张三','12345688888');
insert into s3(sno,sname,tel) values('101','wuwu','12345666688');
-- > 1062 - Duplicate entry '101' for key 's3.sno'
insert into s3(sno,sname,tel) values('102','wuwu','12345666688');
insert into s3(sno,sname,tel) values('103','lili','12345666688');
insert into s3(sno,sname,tel) values('104','jj','12345666688');
select * from s3;
insert into s3(sno,sname,tel) values(NULL,'Yuyu','12345666688');
-- > 1048 - Column 'sno' cannot be null

create table my_d1
(id int,
d1 date comment'办理日期' default '20220901',
t char(11));
desc my_d1;

alter table my_d1 add unique(id);
select * from my_d1;
insert into my_d1(id) values(1),(2);