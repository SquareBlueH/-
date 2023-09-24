drop database if exists five;
create database five;
use five;

drop table if exists s;
create table s(
sno char(3) primary key,
sname varchar(10),
ssex enum('男','女' ) default '男',
sage int,
sdept enum('数学系','计算机系','电子系','机电系')
)charset utf8;
insert into s values('121','李勇',default,20,'数学系'),
('122','刘晨','女',19,'计算机系'),
('123','王敏','女',18,'电子系'),
('125','刘晨',default,19,'机电系');

drop table if exists c;
create table c(
cno char(1) primary key,
cname varchar(20),
cpno int,
ccredit int
)charset utf8;
insert into c values(1,'数据库',5,4),
(3,'信息系统',5,4),
(4,'操作系统',6,3),
(5,'数据结构',7,4),
(7,'C语言',6,4);
insert into c(cno,cname,ccredit) 
values(6,'数据处理',2),
(2,'离散数学', 2);

drop table if exists sc;
create table sc(
sno char(3),
cno char(1),
grade int);
insert into sc values(121,1,92),
(121,2,85),
(121,3,88),
(122,2,90),
(122,3,80),
(122,7,NULL);



-- (1)查询全体学生的学号、姓名和年龄
select sno ,sname ,sage from s;

-- (2)查询所有计算机系学生的详细记录
select sno, sname, ssex, sage, sdept from s where sdept regexp '计算机系';

-- (3)找出考试成绩为优秀（90分及以上）或不及格的学生的学号、课程号及成绩
select sno,cno,grade from sc having grade>90||grade<60;

-- （4）查询年龄不在19~20岁之间的学生姓名、性别和年龄
select sname,ssex,sage from s having sage>20||sage<19;

-- （5）查询数学系、电子系的学生的姓名和所在系
select sname,sdept from s where sdept regexp '计算机系|数学系';

-- （6）查询名称中包含“数据”的所有课程的课程号、课程名及其学分
select cno,cname,ccredit from c where cname regexp '数据';

-- （7) 找出所有没有选修课成绩的学生学号和课程号
select sno,cno from sc where grade is null;

-- （9）查询选修了2号课程的学生的学号及其成绩，查询结果按成绩升序排列
select sno,grade from sc where cno regexp '2' group by grade;

-- (10) 查询每个学生的信息以及他（她）所选修的课程。
select s.*,c.cno,cname from s,c,sc where s.sno=sc.sno and sc.cno=c.cno;

-- (11) 查询学生的学号、姓名、选修的课程名及成绩。
select s.sno,sname,c.cname,sc.grade from s,c,sc where s.sno=sc.sno and sc.cno=c.cno;

-- (12) 查询选修离散数学课程且成绩为90 分以上的学生学号、姓名及成绩。
select s.sno,sname,sc.grade from s,c,sc where s.sno=sc.sno and sc.cno=c.cno and sc.grade>=90 and c.cname regexp '离散数学';

-- (13) 查询每一门课的间接先行课（即先行课的先行课）。
select sc.cno,c.cname,cpno from sc,c where sc.cno=c.cno;




show databases;

select * from s;
select * from news;

insert into news select * from s; -- 复制表结构

-- 主键冲突更新
insert into news values on duplicate key update 字段1=值1......

-- 主键冲突替换
replace into news (a,b,c) values ()


-- 清除数据
delete from news where sno='1';

create table t(
id int uiqes auto_increment,
tno char(2) primary key,
tname varchar(10) not null,
sdept varchar(20) default '极大孙'
)charset utf8;

insert into t(tno,tname) values('01','ww'),('02','ee');
select * from t;


-- 查询范围的信息
select * from 某表 order by 数据 desc limit 1,4; -- 零包含在内

-- 更新分数最低的同学加两分
select * from 表 order by a asc limit 1;
update 表 set a=a+2 order by a asc limit 1;


-- 删除最低分
delete from 表 order by a asc limit 1;

delete from 表 where a=50; -- 删除50分的数据



create view s_poor as select s.sno,s.sname,s.sdept,sc.grade from s,sc where s.sno=sc.sno;

select * from s_poor;

update s_poor set sname='大哥' where grade='85';

create view s_poor as select * from sc where grade>90 with check option;












