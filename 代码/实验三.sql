create database if not exists jxgidb default character set utf8;

-- 查看某数据库的所有表
show tables;

-- 查看表的内容
SELECT * FROM s;

-- 查看数据表某的创建信息
SHOW CREATE TABLE C;

-- 11
-- 建立学生信息表S
create table if not exists S(
SNO char(5) COMMENT'学号' primary key,
SNAME varchar(20) COMMENT'姓名',
SSEX char(2) COMMENT'性别' check(SSEX='男' or SSEX='女'),
SAGE char(2) COMMENT'年龄',
SDEPT char(10) COMMENT'系'
); 


INSERT IGNORE INTO S VALUES ('121','李勇','男','20','数学系');
INSERT IGNORE INTO S VALUES ('122','刘晨','女','19','计算机系');
INSERT IGNORE INTO S VALUES ('123','王敏','女','18','电子系');
INSERT IGNORE INTO S VALUES ('125','张立','男','19','机电系');


--建立课程表C
create table if not exists C(
CNO char(4) COMMENT'课程号',
CNAME varchar(20) COMMENT'课程名',
CSEX char(2) COMMENT'前置课程',
CDEPT int COMMENT'学分'
); 

INSERT IGNORE INTO c VALUES ('1','数据库',5,4);
INSERT IGNORE INTO c VALUES ('2','离散数学','',2);
INSERT IGNORE INTO c VALUES ('3','信息系统',5,4);
INSERT IGNORE INTO c VALUES ('4','操作系统',6,3);
INSERT IGNORE INTO c VALUES ('5','数据结构',7,4);
INSERT IGNORE INTO c VALUES ('6','数据处理','',2);
INSERT IGNORE INTO c VALUES ('7','C 语言',6,4);


--建立成绩表SC
create table if not exists SC(
SNO char(4) COMMENT'学号',
CNO char(4) COMMENT'课程号',
GRADE char(4) COMMENT'成绩'
); 


INSERT IGNORE INTO SC VALUES ('121',1,92);
INSERT IGNORE INTO SC VALUES ('121',2,85);
INSERT IGNORE INTO SC VALUES ('121',3,88);
INSERT IGNORE INTO SC VALUES ('122',2,90);
INSERT IGNORE INTO SC VALUES ('122',3,80);
INSERT IGNORE INTO SC VALUES ('122',7,NULL);
-- 222
-- 修改表结构

alter table S add ADDR char(60);
-- 修改列的长度
-- alter table 表名 modify column 字段名 类型; 

alter table C modify column CNAME CHAR(50);

-- 添加约束
-- alter table 表名称 add constraint 约束名称 增加的约束类型 （列名）
-- alter table emp add constraint xxx check(age>20);

alter table S add constraint SAGE check(0<SAGE<150);

-- 修改主键

-- alter table 表格名称 add constraint 约束名称 增加的约束类型 （列名）
-- alter table emp add constraint ppp primary key (id);

alter table C add constraint 主键 primary key (CNO);


-- 主外键约束
-- alter table 表名 add constraint 约束名称 约束类型 (列名) references 被引用的表名称 （列名）
-- alter table emp add constraint jfkdsj foreign key (did) references dept (id);

alter table SC add constraint 主键 foreign key (CNO) references C (CNO);


--删除地址
alter table S drop ADDR;


-- 333
-- 3.4.5 数据插入，根据表格内容录入所有数据。
# 表中有些字段有默认值，则可以直接根据字段插入数据
INSERT IGNORE INTO 表名（字段名1,字段名2,...) VALUES (值 1,值 2,...);

# 按照表中所有字段进行插入数据，一定要与字段在表中定义的顺序一致
INSERT IGNORE INTO 表名 VALUES (值 1,值 2,...);

INSERT IGNORE INTO S VALUES ('126','李晓勇','男','20','计算机系',NULL);
INSERT IGNORE INTO C VALUES ('8','数据分析',5,4);
INSERT IGNORE INTO SC VALUES ('126',1,92);

desc c;




-- 4444
-- 3.4.6 数据的修改和删除，在表S和表C中完成以下操作。

-- 修改年龄

update S set sage=50 where sno=122;

-- 删除信息

delete from S where SNAME='王敏';

-- 清空表的内容
truncate table C;


desc s;






show processlist;
show OPEN TABLES where In_use > 0;




use mydb;
-- 创建视图 CREATE VIEW <视图名> AS <SELECT语句>
-- 全表
create view s_s(s,q,b,h) as select s.sname





