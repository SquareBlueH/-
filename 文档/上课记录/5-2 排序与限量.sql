-- 2022 11 11 复习
show databases;
use jwgl;
show tables;
create table news like s;  -- 复制表结构
desc news;

select * from s;
select * from news;

insert into news select * from s;  -- 复制表中的数据
-- > Affected rows: 13
select * from news;
desc news;

create temporary table news1 like news;
show tables;
desc news1;
select * from news1;

insert into news(sno,sn,nation)
values('s777','莉莉','漢');
-- > 1062 - Duplicate entry 's777' for key 'news.PRIMARY'

-- 主键冲突更新
-- insert into news values on duplicate key update 字段1=值1……
select * from news where sno='s777';
insert into news(sno,sn,nation)
values('s777','莉莉','漢')
on duplicate key update sn='莉莉',nation='漢'
-- > Affected rows: 2
select * from news where sno='s777';

-- 主键冲突替换
replace into news(sno,gender,age,sdept)
values('s777','女',18,'計算機');
-- > Affected rows: 2
select * from news where sno='s777';

insert into news(sno,sn,nation)
values('s777','莉莉','漢')
on duplicate key update sn='莉莉',nation='漢'

-- 新内容
insert into news1 select * from news;
-- 清除数据
delete from news1 where sno='s777';
delete from news1;
-- > Affected rows: 13
-- > 时间: 0s
select * from news1;
-- truncate [table] tablename;
truncate news1;
-- > OK
-- > 时间: 0.003s
-- DDL:CREATE DROP ALTER truncate
-- DML:insert select update delete 


create table t(
id int unique auto_increment,
tno char(2) primary key,
tname varchar(10) not null,
sdept varchar(20) default '計算機')charset utf8;

insert into t(tno,tname) values('01','haha'),('02','xixi');
select * from t;

delete from t where id=2;
insert into t(tno,tname) values('03','yuyu'),('04','jixi');
delete from t;

truncate t where id=2;
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where id=2' at line 1

select sdept from news;

-- 去除重复数据  distinct  在select 字段列表中间
select distinct sdept from news;
-- 重复数据是指完全一致

select sno,sdept from news;
select distinct sno,sdept from news;

-- 排序 order by 
select * from sc;

-- 按成绩从低到高显示  升序
select * from sc order by score asc;

select * from sc order by score desc;   -- 降序

select * from sc order by score;   -- 默认：升序

-- 按课程号降序排序
select * from sc order by cno desc;
 
-- 先按照课程号降序，再按成绩升序
select * from sc order by cno desc,score asc;   -- 正确语句

select * from sc order by cno desc and score asc;
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'and score asc' at line 1
-- 先按学号升序，再按分数降序
selEct * from sc order by sno asc,score desc;

selEct * from sc order by score desc,sno asc;

select * from sc order by score desc;

-- 限量 limit
select * from sc order by score desc limit 1;

select * from sc  limit 1;

select * from sc  limit 1 order by score desc;
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'order by score desc' at line 1

select * from sc order by score desc limit 0,5;
select * from sc order by score desc limit 1,5;

 -- 89 88 3 
select * from sc order by score desc limit 2,3;
-- 查询学生成绩时，从第3名开始，要3个学生的成绩
select * from sc order by score desc limit 3,1;
select * from sc order by score desc limit 4;

-- 更新分数最低同学分数加2分
select * from sc order by score asc limit 1;
update sc set score=score+2 order by score asc limit 1;
update sc set score=score+2 order by score desc limit 1;

insert into sc values('s1','c7',50);
insert into sc values('s1','c8',50);
insert into sc values('s1','c9',50);
select * from sc order by score;
-- 删除最低分的一条数据
delete from sc order by score asc limit 1;
-- > Affected rows: 1
delete from sc where score=50;  -- 删除50分的数据

delete from sc where score=50 , cno = 'c7';
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ', cno = 'c7'' at line 1
delete from sc where score=50 and cno = 'c7';

delete from sc where score=50 or cno = 'c7';
