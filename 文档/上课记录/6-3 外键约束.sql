# 外键约束
# 主键约束  主键：具有唯一性和非空 primary key 
# 外键：在一个表中引用另一个表的一列或多列，被引用的列应该具有主键约束
# 或唯一性约束，从而保证数据的一致性和完整性。
# 某一表中某一些字段取值参照另一个表的某些字段 foreign key
# 被引用的表称为主表（父表） 引用外键的表称为从表（子表）
# 选课信息表里，学号应该参照学生信息表的学号
# 在选课信息表的学号不能是学生信息表没有的学号
use xsgl;
select * from sc;
select * from s;
desc s;
# 建立外键约束 在建立数据表
create table xs1(
sno char(4) primary key,
sname varchar(20) not null,
gender enum('男','女') default '女',
sdept varchar(10));
desc c;
create table sc1(
id int unique auto_increment,
sno char(4) foreign key,
cno char(2) foreign key,
score int);
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key, cno char(2) foreign key, score int)' at line 3
create table sc1(
id int unique auto_increment,
sno char(4) foreign key references s1(sno),
cno char(2) foreign key references c(cno),
score int);
-- 语法错误
/*
create  table s(
字段名 字段类型 primary key,
……);

create table s(
字段名 字段类型,
……,
primary key (sno,cno));*/

create table xk(
id int unique auto_increment,
sno char(4) ,
cno char(2) ,
score int,
foreign key (sno) references s1(sno),
foreign key (cno) references c(cno));
desc s1;
> 3734 - Failed to add the foreign key constraint. Missing column 'sno' for constraint 'xk_ibfk_1' in the referenced table 's1'

create table xk(
id int unique auto_increment,
sno char(4) ,
cno char(2) ,
score int,
foreign key (sno) references xs1(sno),
foreign key (cno) references c(cno));
-- OK
desc xk;
select * from xs1;
select * from c;
insert into xk(sno,cno,score) values('1010','01',90);
-- > 1452 - Cannot add or update a child row: a foreign key constraint fails (`xsgl`.`xk`, CONSTRAINT `xk_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `xs1` (`sno`))
insert into xs1 values('1010','一一',default,'计算机');
insert into xk(sno,cno,score) values('1010','01',90);
-- > Affected rows: 1
insert into xk(sno,cno,score) values('1010','04',90);
-- > 1452 - Cannot add or update a child row: a foreign key constraint fails (`xsgl`.`xk`, CONSTRAINT `xk_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `c` (`cno`))
-- readers(主键 rno)  books(主键 bno) 
-- bbi (rno 参照readers rno bno 参照 books bno 外键约束)
-- innodb 存储引擎支持外键约束
/*create table tablename(
字段列表) engine= innodb;*/
create table xk1(
sno int ,
cno int,
score int,
foreign key (sno) references xs1(sno));
-- > 1215 - Cannot add foreign key constraint
-- xk1.sno int  xs1.sno char(4)
-- 注意事项：建立外键关系时，两个表中的字段的类型最好一样，要相似
-- 相似：两个字段类型可以相互转换
-- int tinyint 

-- alter table add primary key
-- alter table 时添加外键约束
create table book(
bno char(4) primary key,
bname varchar(20),
price decimal(5,2)  -- -999.99 ~ 999.99
);
create table shopping(
hno char(5),
bno char(4),
sdate date, -- 日期值  time hh:mm:ss
ordertime  datetime);
alter table shopping add foreign key(bno) references book(bno);
-- > OK
desc shopping;

-- 更新数据 
select *from xs1;
select * from xk;
insert into xs1 values('1013','李四','男','网工'),
('1014','李无','男','网工'),
('1015','李六','男','计算机');
insert into xk(sno,cno,score) values('1010','02',80),('1011','01',90);
-- 更新成绩  1011 01 成绩 95
update xk set score =95 where sno ='1011' and cno='01';
-- > Affected rows: 1
select * from xk;
-- 更新xs1 李二 学号变为 1015
update xs1 set sno='1015' where sname='李二';
-- > 1451 - Cannot delete or update a parent row: a foreign key constraint fails (`xsgl`.`xk`, CONSTRAINT `xk_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `xs1` (`sno`))
-- 删除 xs1 里的 1011
delete from xs1 where sno='1011';
-- > 1451 - Cannot delete or update a parent row: a foreign key constraint fails (`xsgl`.`xk`, CONSTRAINT `xk_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `xs1` (`sno`))
delete from xs1 where sno='1013';
-- 1013 没有选课 可以删除 > Affected rows: 1

-- 外键约束的模式 都是针对父表
-- (1)restrict  严格模式 默认
-- 父表（被参照的表）不能删除或更新 一个已经被子表（含有外键约束的表
-- 所引用的数据/记录
-- （2）cascade 级联模式 父表更新时，子表跟着更新  父表删除时，子表也删除
-- （3） set null 置空模式 NULL值替换（NOT NULL 约束不适用）

-- …… on delete restrict on update cascade

create table xk2(
id int unique auto_increment,
sno char(4) ,
cno char(2) ,
score int,
foreign key (sno) references xs1(sno)
on delete restrict on update cascade,  -- 删除严格、更新级联
foreign key (cno) references c(cno)
on delete restrict on update set null);  -- 删除严格、更新置空
-- > OK
insert into xk2(sno,cno,score) values('1013','02',80),('1014','01',90),('1013','01',80),('1014','03',90);
-- 删除学生
delete from xs1 where sno='1013';   -- cannot
select * from xk2;
update xs1 set sno='1016' where sno='1013';
-- > Affected rows: 1
select * from xk2;
select * from xk;

update c set cno='04' where cno='03';
-- > Affected rows: 1
select * from xk2;

/* foreign key (外键字段名） references 父表(主键字段）
  on delete 模式关键字 on update 模式关键字 */

create table hxx(
hno char(5),
hname varchar(20) not null, 
htel char(11));

desc shopping;
alter table shopping add foreign key(hno)
references hxx(hno) on delete restrict on update cascade;
-- > 1822 - Failed to add the foreign key constraint. Missing index for constraint 'shopping_ibfk_2' in the referenced table 'hxx'
alter table hxx add primary key (hno);
-- > OK

alter table shopping add constraint 'fk_hno' foreign key(hno)
references hxx(hno) on delete restrict on update cascade;
--  check the manual
alter table shopping add constraint "fk_hno" foreign key(hno)
references hxx(hno) on delete restrict on update cascade;
--  check the manual
alter table shopping add constraint fk_hno foreign key(hno)
references hxx(hno) on delete restrict on update cascade;
-- > Affected rows: 0
-- 查看表的创建信息
show create table hxx;
/* CREATE TABLE `hxx` (
  `hno` char(5) NOT NULL,
  `hname` varchar(20) NOT NULL,
  `htel` char(11) DEFAULT NULL,
  PRIMARY KEY (`hno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/
show create table shopping;
/*CREATE TABLE `shopping` (
  `hno` char(5) DEFAULT NULL,
  `bno` char(4) DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  KEY `bno` (`bno`),
  KEY `fk_hno` (`hno`),
  CONSTRAINT `fk_hno` FOREIGN KEY (`hno`) REFERENCES `hxx` (`hno`) ON UPDATE CASCADE,
  CONSTRAINT `shopping_ibfk_1` FOREIGN KEY (`bno`) REFERENCES `book` (`bno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_c
*/

-- 删除主键 alter table 表名 drop primary key 主键名
-- 删除外键 alter table 表名 drop foreign key 外键名
alter table shopping drop foreign key fk_hno;
-- > OK
desc shopping;   -- key hno MUL
show create table shopping;
/*CREATE TABLE `shopping` (
  `hno` char(5) DEFAULT NULL,
  `bno` char(4) DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  KEY `bno` (`bno`),
  KEY `fk_hno` (`hno`),
  CONSTRAINT `shopping_ibfk_1` FOREIGN KEY (`bno`) REFERENCES `book` (`bno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/
-- 手动删除键
alter table shopping drop key fk_hno;
-- > OK
desc shopping;
-- 创建外键约束的时候，系统会自动创建一个普通索引
-- 删除外键约束时，只删除外键约束，不删除普通索引，彻底删除手动删除键
-- 外键名都不需要引号

-- 查询借阅过的图书价格有高于59元的读者信息。
use book;
select * from readers where rno in(
select rno from bbi where bno in(
select bno from books where bprice>59));