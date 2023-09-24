# 复习
-- 运算符 
-- in() / not in()
-- between and
-- not between and
-- like / not like
-- is null / is not null
-- greatest()  least()
use jwgl;

# 新内容 多表操作
-- （1） 联合查询  关键字union
-- 合并一起显示 ：多个select语句的查询字段数相同,与字段类型无关
select * from s where sdept='计算机';
select * from s1 where sdept='计算机';

select * from s where sdept='计算机'
union
select * from s1 where sdept='计算机';

select sno,sn,gender from s
union
select sno,age from s1;
-- > 1222 - The used SELECT statements have a different number of columns

select sno,sn,gender from s
union
select sno,age,nation from s1;
/*多张表的数据结构是一样，但是存的数据不同，合并一起显示*/

select * from s where sdept='计算机'
union 
select * from s where sdept='机电工程';

-- 等价于
select * from s where sdept='机电工程' or sdept='计算机';
select * from s where sdept in('机电工程','计算机');

-- 查询男生的信息 按年龄升序
select * from s where gender='男' order by age;
-- -- 查询女生的信息 按年龄降序
select * from s where gender='女' order by age desc;

select * from s  order by age desc;
-- 在同一个结果里显示 男生升序 女生降序
select * from s where gender='男' order by age
union
select * from s where gender='女' order by age desc;
-- > 1064 - You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'union select * from s where gender='女' order by age desc' at line 2

-- 联合查询时，order by 语句 要增加圆括号
(select * from s where gender='男' order by age)
union
(select * from s where gender='女' order by age desc);
-- 结果不对 在用order by 语句时，联合查询的结果排序正确 结合limit一起使用
-- 建议使用限制记录数大于实际记录数
(select * from s where gender='男' order by age limit 20)
union
(select * from s where gender='女' order by age desc limit 20);

-- 练习：男生年龄最大，女生年最小的 男女各要一条信息
(select * from s where gender='男' order by age desc limit 1)
union
(select * from s where gender='女' order by age limit 1);
/*查询同一张表时，需求不同，可以使用union*/
(select nation,age from s where gender='男' order by age desc limit 2)
union
(select nation,age from s where gender='女' order by age limit 2);
/* 汉	19
侗	19
壮	20*/
(select sno,nation,age from s where gender='男' order by age desc limit 2)
union
(select sno,nation,age from s where gender='女' order by age limit 2);
/*S10	汉	19
S6	侗	19
S11	汉	19
S12	壮	20*/
-- 保留所有的查询结果 all 关键字
-- distinct 去除重复结果
select nation,age from s ;
select distinct nation,age from s;
/*基本语法：
select [all|distinct]  查询字段 from 表名 [where 查询条件] [order by语句]……
union
select 语句
[union
select 语句]
*/
-- (2)连接查询  将多张表连接到一起 （先连接表，再查询）
select * from s;
select * from sc;
#A.交叉连接：返回结果是被连接的两个表中所有的数据行的笛卡儿积
#语法：select 查询字段 from 表1 cross join 表2;
select sno,sn,cno,cname from s cross join c;
#交叉连接存在的意义：保证连接结构的完整性
#在实际使用时，尽量避免

#B.内连接：最常见的连接，结果：根据匹配条件，返回两个表都满足的记录
/*语法：select 查询字段 from 表1 [inner] join 表2 on 匹配条件
[inner join 表3 on 匹配条件];*/
-- 查询学生成绩 ，显示学生姓名，课程号和成绩
select sn,cno,score from s 
inner join sc on s.sno = sc.sno;  -- > 时间: 0s
-- 数据表名.字段名 （指明具体表中的具体字段）
select * from s;
select * from sc;
-- use 数据库名;
-- 数据库名.数据表名
show databases;
select * from book.readers;

/*where 代替on 效率没有on高*/
select sn,cno,score from s 
inner join sc where s.sno = sc.sno;

-- 查询课程名称，学号，成绩
select cname,sno,score from c 
inner join sc on c.sno = sc.sno;
-- > 1054 - Unknown column 'c.sno' in 'on clause'
select cname,sno,score from c 
inner join sc on c.cno = sc.sno;  -- 课程表中课程号=选课表中学号  结果NULL
select cname,sno,score from c 
inner join sc on c.cno = sc.cno;

-- 查询姓名、课程名称、成绩
select sn,cname,score from s 
inner join sc on sc.sno=s.sno
inner join c on sc.cno=c.cno;

-- 查询与“左惠”院系相同的学生信息
select sdept from s where sn='左惠';
select * from s where sdept='机电工程';

select * from s inner join s on sn='左惠' and s.sno=s.sno;
-- > 1066 - Not unique table/alias: 's'

-- 列取别名 as 空格代替 字段名 as 字段别名
-- 表也可取别名 表名 as 表别名
select * from s as s1 inner join s as s2 on sn='左惠' and s1.sno=s2.sno;
-- > 1052 - Column 'sn' in on clause is ambiguous
select s1.sno,s1.sn,s.depet from s as s1 inner join s as s2 
on s2.sn='左惠' and s1.sno=s2.sno;
-- 查询与“左惠”院系相同的学生信息
select s1.sno,s1.sn,s1.sdept from s as s1 inner join s as s2 
on s2.sn='左惠' and s1.sdept=s2.sdept;
-- 同一个表 取表的别名 ，有相同查询字段名的时候要指定数据表

-- 查询学号、姓名、课程名称、成绩
select sno,sn,cname,score from s 
inner join sc on sc.sno=s.sno
inner join c on sc.cno=c.cno;
-- > 1052 - Column 'sno' in field list is ambiguous
select s.sno,sn,cname,score from s 
inner join sc on sc.sno=s.sno
inner join c on sc.cno=c.cno;

#C.外连接 outer join 
#c1.左外连接：返回的符合条件的左表的记录，若右表无数据设置null
#语法：select 查询字段 from 左表 left [outer]  join 右表 on 匹配条件
select sn,cno,score from s 
left outer join sc on s.sno = sc.sno; 
select sn,cno,score from s 
inner join sc on s.sno = sc.sno; 
#C2.右外连接：返回的符合条件的右表的记录，若左表无数据设置null
#语法：select 查询字段 from 左表 lright [outer]  join 右表 on 匹配条件
select sn,cno,score from sc 
right outer join s on s.sno = sc.sno; 
-- using 关键字  using(同名的字段名） 在实际过程中，
-- 不同表字段名相同的情况比较少，尽量少用using
-- 连接条件时，代替on
select sn,cno,score from s 
inner join sc using(sno);
/*s(sno,sname,……）
sc(s_sno,c_cno,score)
s.sno=sc.s_sno
*/