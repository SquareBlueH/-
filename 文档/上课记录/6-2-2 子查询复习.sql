# 复习 子查询
# select 语句（select 语句）
# select 语句 where 字段名称 (select 字段名称 from ……）
use jwgl;
# 查询与“雷胜珍”性别相同的学生  标量查询
Select * from s where gender =
(select gender from s where sn='雷胜珍');

select gender from s where sn='雷胜珍';
# 查询女生的信息
select * from s where gender='女';

# 查询与“雷胜珍”性别且院系相同的学生  行子查询
Select * from s where gender =
(select gender from s where sn='雷胜珍')
and sdept=(select sdept from s where sn='雷胜珍');

select gender,sdept from s where sn='雷胜珍';

select * from s where (gender,sdept)=
(select gender,sdept from s where sn='雷胜珍');

# 查询S1选修的课程信息(cno,cname……) #列子查询
select * from c where cno in (
select cno from sc where sno='s1');

# 标量、列、行子查询：
# 子查询select语句在外层查询的where子句
# 表子查询 from子句
# 查询S1选修的课程信息(cno,cname……) #表子查询
select distinct c.* from c ,(
select cno from sc where sno='s1') as s1_c(s1_cno)
where c.cno=s1_c.s1_cno

select * from s,c;
select * from s cross join c;
-- as 表名(字段名)

-- in、not in
-- exists / not exists
-- 查询有不及格的学生信息
select * from s where score<60;
-- > 1054 - Unknown column 'score' in 'where clause'
select distinct s.* from s,sc where score<60;

select distinct s.* from s join sc on s.sno=sc.sno
where score<60;  -- (第1种)

select distinct sno from sc;

-- 查询有不及格的学生信息
select * from s where sno in
(select sno from sc where score<60);   -- 第2种

select * from s where exists
(select sno from sc where score<60 and s.sno=sc.sno);

select * from s where exists
(select sno from sc where score<60);

-- 查询所有科目的成绩均高于80分的学生信息
select * from s where not exists
(select sno from sc where score<80 and s.sno=sc.sno);

select * from s where not exists
(select sno from sc where score<80 and s.sno=sc.sno) and sno in(select sno from sc);


select * from s where not exists
(select sno from sc where score<80 and s.sno=sc.sno) and score is not null;
-- > 1054 - Unknown column 'score' in 'where clause'

select * from s where not exists
(select sno from sc where score<80 and s.sno=sc.sno
and score is not null) ;

-- any all 
-- 查询所有科目的成绩均高于80分的学生信息
-- min(score)>80 
select sno,min(score) from sc 
group by sno;

select * from s ,
(select sno,min(score) from sc 
group by sno) as s1(sno,mins) where mins >80 and
 s.sno = s1.sno;
 
select * from s where sno in
(select sno,min(score) from sc group by sno 
having min(score)>80); 
-- > 1241 - Operand should contain 1 column(s)

select * from s where sno in
(select sno from sc group by sno 
having min(score)>80);

-- >all(score 80)
select distinct sno from sc where score < 
all(select score from sc where score>80);

-- any some 任意
-- >any >min <any <max
-- >all >max <all <min 
