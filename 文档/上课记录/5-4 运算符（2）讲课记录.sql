#复习
-- 运算符
-- （1）算术运算符 + - * / % 
-- unsigned 无符号 是否超出取值范围
show databases;
-- cast (字段名 as signed) -- 把对应字段的类型强制转换为有符号
-- null 参与的算术运算结果都是null
-- 常用的数学函数 137页
-- （2） 比较运算符 > = < >= <= != <>  
-- 比较结果 真true 1 假false 0
select 1=1,0>1;
-- 区分 = <=>
-- 取值在区间内 between and  不在区间not between and
-- like'匹配内容' 或 not like'匹配内容'
use jwgl;
-- 查询姓张的学生信息
select * from s where sn like '张%';
select * from s where sn not like '张%';

-- 正则
select * from s where sn regexp '张|李';

select * from s where sn like '张%' or sn like '李%';

-- 姓名是null 学生信息
select * from s where sn is null;
select * from s where sn <=> null;

-- 查询民族非null 的学生信息
select * from s where nation is not null;

select 0>null;
select null=null;  -- 结果是null
select null<=>null;   -- 结果是 1
select null<null,null>null,null<>null; -- 结果是null

-- 查询年龄是18或19岁的学生信息
select * from s where age=18 or age=19;
-- in(值1，值2，……)  
select * from s where age in(18,19);
-- not in
select * from s where age not in(18,19);
select * from s where age!=18 and age!=19;

-- greatest(表达式1,表达式2,表达式3,表达式4,……) 返回最大的
select greatest(2+2,3+3,4+4,1,9);

create table tt(
id int primary key auto_increment,
sno char(2),
cno char(2),
pscj int not null,
khcj int not null,
zcj decimal(4,2));

insert into tt(sno,cno,pscj,khcj)
values('04','01',90,97),
('02','01',87,97),
('03','01',90,77),
('01','02',94,90),
('02','02',97,90),
('03','02',90,97);

-- zcj = pscj*0.3+khcj*0.7
select * from tt;
update tt set zcj = pscj*0.3+khcj*0.7;

select sno,cno,pscj,khcj,zcj,greatest(pscj,khcj,zcj) as max from tt;

-- least() 返回最小
select sno,cno,pscj,khcj,zcj,least(pscj,khcj,zcj) as min from tt;

-- isnull() -- 测试参数是否为空
select id,isnull(zcj) from tt;

-- coalesce() 返回第一个非空的参数
create table t2(
id int primary key auto_increment,
n1 int,
n2 int,
n3 int);
insert into t2(n1) values(1);
insert into t2(n2) values(2);
insert into t2(n3) values(3);
select * from t2;
select id,coalesce(n1,n2,n3) from t2;
update t2 set n1=4 where id=2;
select id,coalesce(n1,n2,n3) from t2;

-- interval() 返回小于第一个参数的参数索引
select interval(5,2,3,4,8);
select interval(5,8,2,3,4);-- 后面要按序排放，否则结果不正确

-- strcmp() 比较两个字符串
select strcmp('a','a');  -- 0
select strcmp('aa','ba');  -- -1
select strcmp('b','a');  -- 1

-- (3) 逻辑运算符 
-- 与 and &&
-- 或 or ||
-- 非 not ！
-- 异或 xor (不同 1 ，相同 0）

-- （4）赋值运算符 = :=
update tt set zcj := pscj*0.3+khcj*0.7 where id=7;
-- > Affected rows: 1
select * from tt;

-- (5) 位运算符 二进制 & | ^ <<  >> ~

-- (6) 运算符优先级 149页