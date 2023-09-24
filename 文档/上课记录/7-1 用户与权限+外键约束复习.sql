#复习 用户与权限
#创建用户 create user 'user'@'host';  -- 没有密码
#create user …… identified with 验证插件名称 by 明文密码
#alter user  修改用户
#drop user 删除用户
#授权 grant 权限类型（select delete ……）（字段列表）
#     on 数据库.数据表  *.*
#     to 用户
#     with grant option 
#回收权限 Revoke 权限类型（select delete ……）（字段列表）
#     on 数据库.数据表  *.*
#     from 用户
#     with grant option 
#all privileges 除去 grant option 和proxy(代理权）

#外键约束 foreign key(字段名1) references  主表(字段名2)
#主键与外键 两个字段的类型可以相互转换 int char 不能相互
#主表(字段名2) 要么是主键 要么具有唯一性约束
#主键 primary key 非空性、唯一性
#唯一性 unique
#innodb存储引擎支持外键约束
/* create table 表名(
字段列表,
foreign key(字段名1) references  主表(字段名2));*/
/*alter table 表名 add constraint 外键名 foreign key
(字段名1) references  主表(字段名2));*/
#drop foreign key 外键名;
#desc 表名 表结构时 key mul
#drop key 键名;
#外键约束的模式（针对主表/父表）
#（1）restrict 严格模式
#（2）cascade  级联模式
#（3）set null 置空模式




use book;

create table d(
dname char(10))charset = latin1;  -- 不支持中文
insert D values('公共');  -- - Incorrect string value

create table D1(
dname char(10))charset = utf8;
insert D1 values('你好');

-- latin1 char(6)
-- utf8 char(6)

-- 外键约束
/* 外键指的是在一个表中引用另一个表的一列或多列，被引用
的列应该具有主键约束或唯一性约束，从而保证数据的一致性和
完整性。*/
/*engine=innodb 两个表charset一致 字段类型可以相互转换*/
-- can't  add foreign key CONSTRAINT