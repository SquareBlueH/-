use jwgl;
show tables;
# 复习 排序与限量
# 排序 order by 
select * from sc order by score desc; -- 降序
select * from sc order by score;
-- 先按课程号升序再按成绩降序
select * from sc order by cno asc,score desc;
select * from sc order by cno desc,score desc;
-- 多字段排序时，各字段的降序/升序各自标明
#限量  limit [开始位置,] 记录的条数   开始位置默认是0
select * from sc order by score desc limit 1;
select * from sc order by score desc limit 5;
select * from sc order by score desc limit 0,2;  
select * from sc order by score desc limit 1,2; 

-- 查询里用排序和限量，在删除与更新都可以用
-- 给后5名每人加2分
select * from sc  order by score asc limit 5;
update sc set score=score+2 order by score asc limit 5;
-- > Affected rows: 5
select * from sc  order by score asc limit 5;

-- 新内容学习：分组与聚合函数
-- 聚合函数：sum() avg() max() min()
-- 查询s1学生的成绩
select score from sc where sno='s1';

-- 查询s1学生的平均分
select avg(score) from sc where sno='s1';

select sum(score),avg(score),max(score),min(score)
from sc where sno='s1';
select avg(score),max(score),min(score)
from sc where cno='c1';
select * from sc order by sno;
-- 分组：group by  
-- 查询每一个学生的平均分  sno,avg(score)
select sno,avg(score) from sc group by sno;
-- 查询每门课程的最高分
select cno,max(score) from sc group by cno;

create table newsc like sc;

insert into newsc select * from sc;
-- 给newsc增加一列 tno char(2)
alter table newsc add tno char(2);
select * from newsc;

-- 更新 c1 tno=01
update newsc set tno ='01' where cno='c1';
update newsc set tno ='02' where cno='c2';
update newsc set tno ='03' where cno='c3';
update newsc set tno ='03' where cno='c4';
update newsc set tno ='01' where cno='c5';
update newsc set tno ='03' where cno='c7';
update newsc set tno ='02' where cno='c8';
update newsc set tno ='03' where cno='c9';

-- sno ='s4' cno ='c2' 更新tno='04'
update newsc set tno='04' where sno='s4' and cno='c2';


select tno,cno,max(score) from sc

select sno,max(score) from sc group by sno;
select cno,max(score) from sc group by cno;
select tno,max(score) from newsc group by tno;

select tno,cno from newsc;

select distinct tno,cno from newsc;
-- 多字段分组
-- 求每个教师上每门课程的最高分
select tno,cno,max(score) from newsc 
-- > 1140 - In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'jwgl.newsc.tno'; this is incompatible with sql_mode=only_full_group_by
select max(score) from newsc;
select distinct sno from newsc;
select sno,max(score) from newsc group by sno

select tno,cno,max(score) from newsc  group by tno
-- > 1055 - Expression #2 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'jwgl.newsc.CNO' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
select tno,cno,max(score) from newsc group by tno,cno
-- 正确

select tno,cno,max(score) from newsc group by tno asc,cno
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'asc,cno' at line 1
-- 分组排序 mysql 8.0 group by不再使用隐式排序
-- 如需排序必须要用order by 显式
select tno,cno,max(score) from newsc
group by tno,cno
order by tno asc

select tno,cno,max(score) from newsc
order by tno asc group by tno,cno
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'group by tno,cno' at line 2

select tno,cno,max(score) from newsc
group by tno,cno
order by cno asc
select * from newsc;

-- select sno,max(score) from sc group by sno; 按分数升序
select sno,max(score) from sc group by sno order by max(score);
select sno,max(score) from sc group by sno order by score;
-- > 1055 - Expression #1 of ORDER BY clause is not in GROUP BY clause and contains nonaggregated column 'jwgl.sc.SCORE' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

-- 给字段取别名 as 关键字 可省略
select sno,max(score) as m from sc group by sno order by max(score);
select sno,max(score) as m from sc group by sno order by m;
select sno,max(score) m from sc group by sno order by m;

select sno sn from s;
select sno,sn from s;

-- 回溯统计 with rollup
-- 每门课程选课人数 count() 计数 不包括值为NULL的记录
select cno,count(sno) from sc group by cno;
select cno,count(sno) from sc group by cno with rollup;
-- NULL 新的统计数是上面的和
-- 在根据指定字段分组之后，系统自动对分组数据进行自动统计，新的数据，
-- 该数据对应的字段值是NULL

-- 每个教师的每门课程选课人数
select tno,cno,count(sno) from newsc group by tno,cno

select tno,cno,count(sno) from newsc group by tno,cno with rollup;

select tno,cno,count(sno) from newsc group by tno,cno order by cno desc;

select tno,cno,count(sno) from newsc group by tno,cno
order by cno desc
with rollup;
--  1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'with rollup' at line 3
select tno,cno,count(sno) from newsc group by tno,cno
with rollup order by tno desc;
-- 注意mysql版本

-- 分组筛选 having 关键字
-- 查询c1最高分
select max(score) from sc where cno='c1';

-- 查询选课人数大于2 的
-- select tno,cno,count(sno) from newsc group by tno,cno
select tno,cno,count(sno) from newsc group by tno,cno
where count(sno)>=2
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where count(sno)>=2' at line 2
select tno,cno,count(sno) from newsc
where count(sno)>=2 group by tno,cno
-- > 1111 - Invalid use of group function

select tno,cno,count(sno) from newsc
group by tno,cno having count(sno)>=2
-- 正确的
-- 统计每门课程大于70分的学生人数
select cno,count(sno) from sc where score>70 group by cno;
-- 显示每门课程选课人数大于等于2的
select cno,count(sno) from sc group by cno having count(sno)>=2;

-- where 和 having 的区别
/*1.where在group by 之前，having 在group by 之后
2.where是对分组之前的数据进行筛选
having是对分组后的数据进行筛选
3.聚合函数 可以在having里使用，where里不允许使用聚合函数*/
-- 统计每门课程大于70分的学生人数，显示人数大于等于2的
select cno,count(sno) from sc where score>70 group by cno
having count(sno)>=2;