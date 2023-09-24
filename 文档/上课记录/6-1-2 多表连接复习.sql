#1123 复习 多表操作
-- （1）联合查询 union 
-- select 语句 合并时，要查询的字段数相同，字段类型无关
-- 多张表  同一张表
-- order by 要加上圆括号  结果是排序正确 要加上limit
-- 查s表中 
select * from s ;
show databases;
use xsgl;
show tables;
-- 查s表中汉族和壮族的学生信息要各1条
(select * from s where nation='汉族'  limit 1)
union
(select * from s where nation ='壮族' limit 1)

select * from s where nation='汉族' or nation ='壮族' limit 2

-- 连接查询 
-- 交叉连接：结果是笛卡儿积  cross join 避免使用
-- 内连接： inner join
-- 语法 select 查询字段 from 表1 [inner] join 表2 on 匹配条件
-- 表1和表2都符合查询条件的记录
-- 查询学生的姓名、成绩
select sname,score from s inner join sc on s.sno = sc.sno
select * from sc;
select * from s;
insert into s values(1010,'李九','男','瑶族',18)
insert into s values(1011,'李时','女','瑶族',18)
select sname 姓名,avg(score) 平均分 from s 
inner join sc on s.sno = sc.sno and sname='李时'
select sname 姓名,avg(score) 平均分 from s 
inner join sc on s.sno = sc.sno and sname='李时'

/*sno=1010 sno=1011 都显示平均分
求每一位学生的平均分*/
select sno,avg(score) from sc group by sno;
/*1010	89.3333
1011	63.0000
1018	75.0000*/
select sno,avg(score) from sc;
-- 1010 75.8750
select sno,avg(score) from sc where sno='1010';
-- 1010	89.3333

select sname 姓名,avg(score) 平均分 from s 
inner join sc on s.sno = sc.sno group by sno;
-- > 1052 - Column 'sno' in group statement is ambiguous

select sname 姓名,avg(score) 平均分 from s 
inner join sc on s.sno = sc.sno group by s.sno;

-- 查询学生的姓名、课程名、成绩
select sname,cname,score from s 
inner join sc on s.sno = sc.sno
inner join c on sc.cno=c.cno;
/*李九	数据库	89
李九	大学英语	90
李九	数据库设计	89
李时	数据库	90
李时	数据库设计	90
*/
-- 外连接 左连接、右连接
-- 返回结果：返回符合左表信息的记录,右表无记录用NULL   
select sname 姓名,avg(score) 平均分 from s 
left outer join sc on s.sno = sc.sno group by s.sno;
-- 返回符合右表信息的记录,左表无记录用NULL
select sname 姓名,avg(score) 平均分 from s 
right outer join sc on s.sno = sc.sno group by s.sno;

select sname 姓名,avg(score) 平均分 from s 
right outer join sc using(sno) group by s.sno;

