-- 复习：数据表的创建、删除、修改（改数据表名、表选项、字段名、
-- 字段类型、字段顺序、新增字段、删除字段）
show databases;   -- 查看所有数据库
use xsgl;
create table if not exists ssss(
id int comment '编号',
sname varchar(20) comment '名称'   -- 最后一个字段后不能使用逗号
);

create table if not exists s1.ssss(   -- 数据库名.数据表名
id int comment '编号',
sname varchar(20) comment '名称'   -- 最后一个字段后不能使用逗号
);

show tables;

-- 查看数据表的结构
describe ssss;
desc ssss;

-- 查看数据表的状态信息
show table status  from xsgl  like 's%';

-- 修改表名 ssss 改为ss
rename table ssss to ss;
alter table ssss rename ss;  -- 等价于25行

-- 修改 ss表中sname字段名为sn  alter table
alter table ss change sname sn;   -- 错误语句
alter table ss change sname sn varchar(20);

alter table ss modify sn varchar(10);

desc ss;

alter table ss modify sn varchar(10) first; 

alter table ss add gender char(2);  -- after  

alter table ss drop id;

drop table ss;

show tables;

-- 插入数据 insert 语句
/*语法格式： insert into 表名(字段列表)
             values(值列表)*/
desc s;
insert into s(sno,sname,sxb,nation,age)
values('1001','张三','男','汉族',18);
-- > Affected rows: 1   代表这行数据插入成功
insert into s(sname,sno,sxb,nation,age)
values('张四','1002','男','汉族',18);

insert into s
values('1003','李四','女','汉族',18);
-- > Affected rows: 1 

-- 查询数据 select 语句 select 字段列表 from 数据表名
select sname,sno,sxb,nation,age from s;
select * from s;   -- *通配符 代表所有字段
desc s;

select sno,sname from s;

insert into s(sname,sno,sxb)  -- 给部分字段插入数据
values('张五','1004','男');

insert into s(sname,sno,sxb)
values('张五','1004','男','汉族',18);
-- > 1136 - Column count doesn't match value count at row 1


insert into s(sname,sno,sxb)
values('张五','1004');
-- > 1136 - Column count doesn't match value count at row 1

insert into s
values('1003','李四','女','汉族','汉族');
-- > 1366 - Incorrect integer value: '汉族' for column 'age' at row 1
insert into s
values('1003','李四','女',18,'汉族');
-- > 1366 - Incorrect integer value: '汉族' for column 'age' at row 1
insert into s
values('1003','李四','女','汉族',18);
-- > Affected rows: 1
-- 插入数据的注意事项
/* 1.数据值要和字段数据类型相一致
2.字段列表的数量 == 值列表的数量
3.如果省略字段列表，值列表里值的顺序要与表结构中字段顺序一致
4.给部分字段插入数据，非空字段一定要有数据（非空约束）*/

-- 插入多行数据
insert into s(sno,sname,sxb,age,nation)
values('1005','李五','女',18,'汉族'),
('1006','李六','女',18,'汉族'),
('1007','张七','女',19,'汉族'),
('1008','李八','女',18,'汉族'),
('1009','李旧','女',20,'汉族');
-- > Affected rows: 5
select * from s;
-- 修改数据 update 语句  update 数据表名 set 字段名=值 where 修改条件
update s set nation='壮族' where sname='张五';

update s set age=19 where sname='张五';

-- 所有人的年龄增加一岁
update s set age=age+1;    -- > Affected rows: 10
-- 注意：在更新数据的时候一定要注意更新条件 否则 全部更新
select * from s;
-- 删除数据 delete 语句  delete from 数据表名 where 删除条件
delete from s where sname='李四';   --  Affected rows: 2
-- 注意：没有删除条件时，数据表中所有数据都会被删掉

-- 查询19岁的学生信息 
select * from s where age=19;

-- 查询20岁且为壮族的学生信息
select sname from s where age=20 and nation='壮族';

-- 18 19岁
select * from s where age=18 or age=19;