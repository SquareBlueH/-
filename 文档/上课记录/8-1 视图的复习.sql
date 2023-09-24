#视图 复习 
#视图是有结构但不保存数据的虚拟表，数据来源于基本表
#视图的基表可以是一个，也可以是多个
#一个表能创建多少个视图？  也能创建多个
#s(sno,sname) 创建一个视图 v_s1  
#s(sno,sxb) 创建一个视图 v_s2 
#创建视图的基本语法：
/*create view 视图名 
as
select 语句
[with check option]  检查条件
*/
#视图的优点 ：简化查询语句、安全性控制、逻辑独立
#修改视图：修改的数据的来源 也就是select 语句
/*(1)alter view 视图名 
as
select 语句
[with check option]  检查条件
(2)create or replace 视图名 
as
select 语句
[with check option]  检查条件
*/
#删除视图：drop view 视图名1,视图名2
#通过视图对数据进行操作（操作的是基表的数据）
#不是所有的操作成功
#添加数据注意：基表是多表的视图
#基表是一个表的时候，如果视图中没有包含基表的所有非空列、
#聚合函数、group by子句等 
#修改数据、删除数据
#最常用的数据操作：查询
