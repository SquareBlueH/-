use xsgl;
select * from sc;
select * from s;
select * from c;
-- 查看学生姓名、成绩、课程名称
select sname,score,cname from sc,s,c
-- 无连接条件 交叉连接  笛卡儿积
select sc.sno,sname,score,cname from sc
join s on sc.sno=s.sno
join c on sc.cno=c.cno   -- 内连接 等值  同时记录满足的记录才显示

-- 修改1008的学号变为1018
update s set sno='1018' where sno='1008'

-- 查询数据库的学生成绩
select * from sc where cno = (select cno from c where cname='数据库')
select * from sc where cno = (select cno from c where cname='大学英语')

select * from (select sc.sno,sname,score,cname from sc
join s on sc.sno=s.sno
join c on sc.cno=c.cno ) as sc1(xh,xm,fs,kc) where kc='数据库'
select * from sc1 where kc='数据库'
-- > 1054 - Unknown column 'kc' in 'where clause'
select * from sc1;
-- 视图
-- 虚拟表:有表结构 但是不保存数据 数据仍然存在基本表

-- 创建视图的基本语法
/*create view 视图名称 as select 语句 */
create view v_sc
as 
select sc.sno,sname,score,cname from sc
join s on sc.sno=s.sno
join c on sc.cno=c.cno;   -- > OK

select * from v_sc;
select * from v_sc where cname='数据库';
show tables;   -- 基本数据表之外， 视图可见，临时表不可见
/*create table 表名(字段列表);
create table 新表名 like 旧表;
*/
grant select
on xsgl.v_sc
-- 视图的优点 201页

#视图的创建可以基于多张基本表，可以基于一张基本表
create view v_table1
as 
select sno,sname from s;
select * from v_table1;
desc v_sc;
show create view v_sc;
#CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sc` AS select `sc`.`sno` AS `sno`,`s`.`sname` AS `sname`,`sc`.`score` AS `score`,`c`.`cname` AS `cname` from ((`sc` join `s` on((`sc`.`sno` = `s`.`sno`))) join `c` on((`sc`.`cno` = `c`.`cno`)))  
# .frm
#修改视图 语法  修改视图 修改视图的数据来源
#(1)alter view 视图名 as select 语句;
alter view v_table1
as 
select sno,sname,nation from s;
#(2)替换已有视图
#create or replace view 视图名 as select 语句;
create or replace view v_table1
as 
select sno,sname,sxb from s;
select * from v_table1;

create or replace view v_table2
as 
select cname,xf from c;
-- create or replace 创建或者替换，有就替换，无就创建
create view if not exists v_table2
as select * from s;
create table if not exists v_table2(
t int unsigned primary key  auto_increment,
t1 char(2));
-- > 1075 - Incorrect table definition; there can be only one auto column and it must be defined as a key
create table if not exists v_table2(
t1 int,
t2 char(2));  -- > OK
desc v_table2;  -- 显示视图结构  表和视图名称不能重
# 删除视图 drop view 视图名称；
drop table v_table2;  -- > 1051 - Unknown table 'xsgl.v_table2'
drop view v_table2;   -- > OK
-- 查看视图状态信息
show table status like 'v_table1';
-- 查看表的状态信息
show table status like 'sc';
select * from v_sc;
# 视图的数据操作 
# 查询（最常用） 与基本表的查询操作是一致的  select 语句
# 查询视图v_Sc中的全部信息 按成绩降序显示
select * from v_sc order by score desc;
# 插入数据
insert into v_table1(sno,sname) values('1008','随便');
-- > Affected rows: 1
select * from v_table1;
select * from s;
select * from v_sc;
insert into v_sc
values('1008','随便',88,'数据库');
-- > 1394 - Can not insert into join view 'xsgl.v_sc' without fields list
insert into v_sc(sno,sname,score,cname)
values('1008','随便',88,'数据库');
-- > > 1393 - Can not modify more than one base table through a join view 'xsgl.v_sc'
create table sss like s;  -- 复制表结构
desc sss;
alter table sss add primary key (sno);
alter table sss modify column sname varchar(20) not null;
alter table sss modify column nation char(4) not null;
select * from s;
-- 从s表复制民族非空的数据到sss表中
insert into sss select * from s where nation is not null;
-- > Affected rows: 11
select * from sss;
create or replace view v_table11
as 
select sno,sname,sxb from sss;
select * from v_table11;
insert into v_table11(sno,sname) values('1008','随便');
-- > 1423 - Field of view 'xsgl.v_table11' underlying table doesn't have a default value
insert into v_table11(sno,sname,sxb) values('1008','随便','女');
-- > 1423 - Field of view 'xsgl.v_table11' underlying table doesn't have a default value
desc sss;
insert into sss(sno,sname,sxb) values('1008','随便','女');
-- > 1364 - Field 'nation' doesn't have a default value
-- 插入数据 ： 字段数量=值数量  数据要数据类型匹配  
#              若只插入部分字段，一定要包含所有的非空字段
#视图插入数据，通过视图往基表中插入
#注意事项：1.基于多表创建的视图，插入会失败
#      2.基于单表创建的视图，视图没有包含所有的非空字段，插入失败
#      3.没有满足视图的基本表字段的约束
#      4.select语句（可以包含聚合函数，数字表达式）
create view xsxk
as 
select sno,count(cno) from sc group by sno
insert into xsxk values('1008',3);
-- > 1471 - The target table xsxk of the INSERT is not insertable-into
# 修改数据
select * from v_table1;
update v_table1 set sxb='男' where sname='随便';
-- > Affected rows: 1
update v_table1 set nation ='壮族' where sname='随便';
-- > 1054 - Unknown column 'nation' in 'field list'
select * from s;
-- enum('男','女')  update female
# 删除数据
delete from v_table11 where sno='1001';  -- > Affected rows: 1
select * from sss;
# 视图检查条件  with check option  用于对视图数据的操作进行条件检查
create view v_table111
as 
select * from sss where age>=19;
select * from v_table111;   -- 年龄大于19岁的视图
update v_table111 set age = 18 where sno='1002';   -- 修改成功的
select * from sss;
create view v_table1111
as 
select * from sss where age>=19
with check option;  -- > OK
select * from v_table1111;
update v_table1111 set age = 18 where sno='1004';
-- > 1369 - CHECK OPTION failed 'xsgl.v_table1111'
update v_table1111 set age = 28 where sno='1004';  
-- > Affected rows: 1
update sss set age = 18 where sno='1004';   -- 允许