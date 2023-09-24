# 子查询 子查询要在圆括号内
# 嵌套 select语句 （select 语句 （select 语句））
use jwgl;
-- 查询与s1性别相同的学生
select gender from s where sno='s1';
select * from s where gender='女';

-- 内连接 inner join  on 
select * from s as s1 inner join s as s2 
on s1.sno=s2.sno and sno='s1' 
-- > 1052 - Column 'sno' in on clause is ambiguous
select s2.* from s as s1 inner join s as s2 
on s1.gender=s2.gender and s1.sno='s1'

-- 子查询：select gender from s where sno='s1'; 查询结果是一行一列
-- 标量子查询:子查询语句的结果是一行一列（只有一个数据）
select * from s where gender =
(select gender from s where sno='s1');

select * from s where gender !=
(select gender from s where sno='s1');

select * from s where gender !=
select gender from s where sno='s1';
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'select gender from s where sno='s1'' at line 2
select * from s where gender in
(select gender from s where sno='s1');

-- 查询s1学生的选课信息（课程号）
select cno from sc where sno='s1';

-- 查询与s1选课有相同课号的同学信息
select distinct sno from sc where cno in
(select cno from sc where sno='s1');
-- > 1242 - Subquery returns more than 1 row
-- 子查询结果是 一列多行 列子查询

-- 查询s1和s2选课信息
select sno,cno from sc where sno='s1' or sno='s2';
select sno,cno from sc where sno in('s1','s2');

-- 查询与S1性别且院系相同  行子查询  一行多列
select gender,sdept from s where sno='s1';

select * from s 
where gender=(select gender from s where sno='s1')
and sdept=(select sdept from s where sno='s1');

select * from s where (gender,sdept)
= (select gender,sdept from s where sno='s1');

-- 查询“数据库”课程学生成绩 sc c 
select * from c;

select * from sc where cno = 
(select cno from c where cname='数据库');

select sc.* from sc 
inner join c on c.cno=sc.cno 
and cname='数据库';

-- 标量子查询、行子查询、列子查询 where子句
-- select 语句结果是集合 二维表（有行有列）
-- select * from (select 语句) as 表名  表子查询
select sno from (select * from sc where cno='c1') as s1;

select sno from (select * from sc where cno='c1');
-- > 1248 - Every derived table must have its own alias
-- select 语句中from 后跟着表名，select语句一定要设置表名

-- 查询每门课程的最高分
select cno,max(score) from sc 
-- > 1140 - In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'jwgl.sc.CNO'; this is incompatible with sql_mode=only_full_group_by
select cno,max(score) from sc group by cno;

-- 子查询 in /not in 
create table s(id int);
-- > 1050 - Table 's' already exists
create table if not exists s(id int);
-- > OK
desc s;
-- exists关键字：返回结果只有0和1  TRUE false
select distinct sno from sc where cno exists
(select cno from sc where sno='s1');
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'exists (select cno from sc where sno='s1')' at line 1
select distinct sno from sc where exists
(select cno from sc where sno='s1');

select distinct sno from sc where cno in
(select cno from sc where sno='s1');

select distinct sno from sc where exists
(select cno from sc where sno='s9');

select distinct sno from sc where not exists
(select cno from sc where sno='s1');

insert into c(cno,cname) values('c10','python');
insert into sc values('s9','c10',90);
-- > 1452 - Cannot add or update a child row: a foreign key constraint fails (`jwgl`.`sc`, CONSTRAINT `FK_SC_C` FOREIGN KEY (`CNO`) REFERENCES `c` (`CNO`))
 select * from c;
 insert into c(cno,cname) values('c10','python');
 insert into sc values('s9','c10',90);
 -- > Affected rows: 1
 
select distinct sno from sc where not exists
(select cno from sc where sno='s1');

select distinct sno from sc where cno not in
(select cno from sc where sno='s1');

-- any 关键字子查询 判断条件 任意一个
#查询比s1任意课程成绩高的学生信息
select score from sc where sno='s1';
select * from sc where score > any (
select score from sc where sno='s1');

select * from sc where score >
(select min(score) from sc where sno='s1');

-- >any   >min
-- <any   <max
-- =any   in
select * from sc where score < any (
select score from sc where sno='s1') order by score desc;
select * from sc where score <  (
select max(score) from sc where sno='s1');

select * from sc where score = any (
select score from sc where sno='s1');
select * from sc where score in (
select score from sc where sno='s1');

insert into sc values('s10','c10',30);
-- all 关键字 所有
select * from sc where score < all (
select score from sc where sno='s1');
-- <all <min  >all >max
select * from sc where score <  (
select min(score) from sc where sno='s1');

select * from sc where score > all (
select score from sc where sno='s1');

select * from sc where score > (
select max(score) from sc where sno='s1');

-- #查询每门课程的最高分的学生学号、课程编号、成绩
select cno,max(score) from sc group by cno;
-- > 1055 - Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'jwgl.sc.SNO' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
select cno,max(score) from sc group by cno;
select sno,cno,max(score) from sc group by cno;
select sno,cno,max(score) from sc group by sno,cno;
-- 结果不正确
select * from sc order by cno;

select cno,max(score) from sc group by cno;  -- as msc
-- select sno,cno,max(score) from sc inner join msc on sc.cno=msc.cno
select sno,sc.cno,max(score) from 
(select cno,max(score) from sc group by cno) as msc,sc
where msc.cno= sc.cno;
-- > 1140 - In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'jwgl.sc.SNO'; this is incompatible with sql_mode=only_full_group_by

select sno,sc.cno,max(score) from 
(select cno,max(score) from sc group by cno) as msc,sc
where msc.cno= sc.cno group by sno,sc.cno;
-- > 1055 - Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'jwgl.sc.SNO' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
select sno,sc.cno,score from 
(select cno,max(score) from sc group by cno) as msc,sc
where msc.cno= sc.cno;

select sno,sc.cno,ms
from sc,
(select cno as c,max(score) as ms from sc group by cno) as msc
where sc.cno = msc.c and sc.score =msc.ms order by sc.cno;
-- 正确语句

-- #找出每个学生超过其选修课程平均分的课程号(>=)
select sno,avg(score) from sc group by sno;

select sc.sno,cno,score from
(select sno,avg(score) as y from sc group by sno) as avgsc,sc
where sc.sno =avgsc.sno and score >= y order by sc.sno;

select * from sc;

select sno,cno,score from sc where score > 80;
-- 查询分数大于80的学号、课程号、成绩

-- #查询选修的课程成绩均在80分以上的学生名单  all
select sno from sc where all score>80
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'all score>80' at line 1
select sno from sc where score all >80
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'all >80' at line 1
#学生不存在小于80分
select distinct sno from sc where exists(
select sno from sc where score>80);

select distinct sno from sc where not exists(
select * from sc where score<80);

select * from s where not exists
(select sno from sc where score<80 and s.sno = sc.sno)
and sno in (select sno from sc);

select * from s where not exists
(select sno from sc where score<80 and s.sno = sc.sno);