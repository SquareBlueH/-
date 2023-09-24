show databases;
use xsgl;
show tables;
select * from sc;
# 分组和聚合函数
#group by
-- 查询1010平均分
select avg(score) from sc where sno='1010';
-- 每一个学生的平均
select sno,avg(score) from sc group by sno;

-- 每一个学生的平均 降序排列
select sno,avg(score) from sc group by sno order by avg(score) desc;

-- 取别名 as 省略时可用空格代替
select sno,avg(score) as a from sc group by sno order by a desc;

-- 显示平均分大于70分学号、平均分
select sno,avg(score) from sc group by sno having avg(score)>70;

-- 求每同学的选课程数目 count
select sno,count(cno) from sc group by sno;
select sno,count(cno) from sc group by sno with rollup;
-- 求每同学大于70分的选课程数目 count
select sno,count(cno) from sc where score>70 
group by sno;
select * from sc;

-- 大于70分的选课程数目,课程数>2
select sno,count(cno) from sc where score>70 
group by sno having count(cno)>2;

select sno,count(cno) from sc having count(cno)>8;
-- 注意：having 通常配合group by 使用

-- 聚合函数 max() min() sum()
select sno,max(score),min(score),sum(score) from sc group by sno;
/*
json_arrayagg() 将符合条件的参数字段值作为单个json数组返回
json_objectagg() 将符合条件的参数字段值作为单个json对象返回
*/
-- 查01课程的选课学生学号
select sno from sc where cno='01';

select json_arrayagg(sno) from sc where cno='01';
-- ["1010", "1011", "1018"]


-- 查每一门的选课学生学号
select cno,sno from sc group by cno; -- 一个cno 匹配多个多个学号

select cno,json_arrayagg(sno) from sc group by cno;

-- 查询每个学生的选修的课程号
select sno,json_arrayagg(cno) from sc group by sno;

select sno,json_arrayagg(cno),json_arrayagg(score)
from sc group by sno;
-- 1010	["01", "02", "03"]	[89, 90, 89]

-- json_objectagg()
select sno,json_objectagg(cno,score) from sc group by sno;
-- 1010  {"01": 89, "02": 90, "03": 89}
-- 1011  {"1": 9, "01": 90, "03": 90}
-- 对象 键值对 键：值

-- group_concat()  返回符合条件的字段值的连接后的字符串
select cno,group_concat(sno) from sc group by cno;
select cno,json_arrayagg(sno) from sc group by cno;


use xu;
show tables;
desc c;
insert into c(sno,cno,pscj,khcj) values('3222','C03',-90,92);
-- > 1264 - Out of range value for column 'pscj' at row 1
select sno,pscj+10 from c

select sno,pscj-90 from c
-- > BIGINT UNSIGNED value is out of range in '(`xu`.`c`.`pscj` - 90)'
select id,id-100 from c

select sno,pscj-100 from c
-- cast(字段名 as signed)
select sno,cast(pscj as signed)-100 from c

-- 除运算 div  /
select 8 div 3, 8/3  -- 2	2.6667
-- div 只保留整数部分（不会四舍五入）
-- / 浮点数
select *from c

-- 更新zcj = pscj*0.4+khcj*0.6
-- update zcj set 
update c set zcj = pscj*0.4+khcj*0.6
select zcj from c
desc c;  -- zcj	decimal(4,2)
select zcj*1,zcj*1.0 from c;

select zcj/0 from c  -- 除数是0 结果都是null

select null+2,null-9,null*9,null/9,null%9;
-- 			null 参与 结果都是null
select 8 mod 3 ,8%3,mod(8,3)

select ceil(6.1),floor(6.8),format(8.7897897,2),round(8.9),round(8.1)
-- 7 6 8.79 9 8
select round(8.80987,2),truncate(8.80987,2) -- 8.81	8.80
select RAND(); -- [0,1]
-- 查c最高分的信息
select * from c order by zcj desc limit 1;
select * from c order by zcj  limit 1;
select * from s limit 3
select * from s limit rand() -- error
-- floor(1+rand()*(6-1))
select  * from s order by id desc limit 1
select * from s limit 3,1
select  * from s group by id order by rand() limit 1
select floor(1+rand()*(6-1))  -- (1,2,3,4,5,6)

70-80

-- 比较运算符 
-- = > < <= >= != <>
select 9>3  -- true 1 false 0 null

-- = <=>区别 后者可以与null进行比较
-- 查询商品编号id是1的信息
select * from s where id=1;
select * from s where id<=>1;
desc s;
insert into s(spname) values('水杯');

-- 价格在3-10
select * from s where price >=3 and price <=10
-- 价格为null 商品信息
select * from s where price is null;
select * from s where price = null;
select * from s where price <=> null;

-- between ... and
-- 价格在3-10 []
select * from s where price between 3 and 10

-- 价格不在3-10之间
select * from s where price not between 3 and 10
select * from s where price <3 and price >10
select * from s where price <3 or price >10

-- 逻辑运算符 
-- 逻辑与 and &&
select * from s where price >3 and price <10;
select * from s where price >3 && price <10;

-- 逻辑或 or ||
select * from s where price <3 || price >10;

-- 逻辑非 not !

-- like 查询商品名称含“笔"
select * from s where spname like '%笔%'
select * from s where spname not like '%笔%'

