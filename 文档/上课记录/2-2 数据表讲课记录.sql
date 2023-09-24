-- 创建数据库 create database a;  
create database xsgl;

-- 查看所有的数据库
show databases;
-- 查看数据库的创建信息
show create database xsgl;

-- 删除 drop database a;  注意不随意执行
drop database a;

#注释内容
/* 计划建立客户健康良好、
hgjkgjkgjh
*/
-- 选择数据库的语句 use 数据库名;
use xsgl;

-- 创建学生信息表s
-- 学号 姓名 性别  民族  年龄
create table if not exists sy(
sno char(4) COMMENT'学号',
sname varchar(20) COMMENT'姓名',
sxb char(2) COMMENT'性别',
nation char(4) COMMENT'民族', 
age int COMMENT'年龄'
); 
-- > 1050 - Table 's' already exists
-- 查看某个数据库里的所有表
show tables;
-- 查看数据表s1的创建信息
show create table s1;
/* CREATE TABLE `s1` (
  `sno` char(4) DEFAULT NULL COMMENT '学号',
  `sname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sxb` char(2) DEFAULT NULL COMMENT '性别',
  `nation` char(4) DEFAULT NULL COMMENT '民族',
  `age` int(11) DEFAULT NULL COMMENT '年龄'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_c */

-- 查看数据表的状态信息 SHOW TABLE STATUS
SHOW TABLE STATUS;

-- 
show tables like 's';  -- tablename == s
show tables like 's%'; -- tablename == s任意个字符  
-- % 通配符 代表任意个字符 0 1 多个
show tables like 's_';  -- _代表的是一个任意字符  通配符
show tables like '_1%'; 

# 语法格式1
-- ALTER TABLE 旧表名 RENAME [TO|AS] 新表名;
alter table s12222 rename to s12;

# 语法格式2
-- RENAME TABLE 旧表名1 TO 新表名1[, 旧表名2 TO 新表名2] ...;
rename table s12 to  xs,y22 to y;
show tables;

-- 修改s1表的字符集为CHARSET=utf8
alter table s1 charset=utf8;
show create table s1;

-- 查看表的字段信息
DESCRIBE s1;   -- 查看s1表所有字段
desc sy;
desc s1 sname; -- 查看s1表sname字段

show full columns from s1.s;   --  数据库名.数据表名  

-- 修改学号sno xh 字段的名称  数据类型  change
alter table s1 change sno xh char(10);  -- > OK
desc s1 xh;
desc s1;

-- 修改xh 类型  char(10)  int 修改字段类型 modify
alter table s1 MODIFY xh int;

-- 修改age字段 放在 sname字段后  修改字段位置 first(第一个)   after 字段名
alter table s1 modify age int after sname;
desc s1;

-- 给s1表里增加一个字段  sdept char(10)
alter table s1 add sdept char(10);
desc s1;

-- 增加stel char(11),saddress varchar(30)
alter table s1 add (stel char(11),saddress varchar(30));
desc s1;

-- 地址 删除saddress 
alter table s1 drop saddress;
desc s1;

-- 删除数据表Drop table tablename  危险  
drop table y;
show tables;
