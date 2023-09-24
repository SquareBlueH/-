-- 1.创建一个数据库zggl(职工管理)
create database zggl;
--2、创建一个部门信息表D
create table D(
dno char(3) primary key COMMENT '部门编号',
dname varchar(20) NOT NULL COMMENT '部门名称',
dtel char(11) COMMENT '部门联系电话'
);

--3.在D表中插入以下数据
desc d;
select *from d;
insert into d values 
(101,'人事部',15511111111),
(102,'网络部',15522222222),
(103,'销售部',15533333333),
(104,'技术部',15588888888),
(105,'维修部',15566666666);

-- 4.创建一个员工信息表 E

create table E(
eno char(6) primary key COMMENT '员工编号',
ename varchar(20) NOT NULL COMMENT '员工姓名',
etel char(11) COMMENT '员工联系电话',
egender enum('男','女') COMMENT '员工性别',
eage int COMMENT '员工年龄',
edno char(3) COMMENT '所在部门编号',
constraint FK_d_e1 foreign key(edno) references d(dno)
);

desc zggl.d dno;


-- 5.在E表中插入以下数据
desc e;
select *from e;

insert into e values 
(200101,'张三',18888888888,'男',34,101),
(200102,'李四',18888888889,'男',32,102),
(200201,'王五',17777777777,'男',25,103),
(210101,'许六',16666666666,'女',28,103),
(220101,'韩七',19999999999,'女',24,105),
(220102,'黎一',17877887788,'女',28,104);


-- 6.创建一个项目成员表X
show create table e;
-- 查看表结构
show index from e;
-- 删除外键约束
alter table e drop eno;
-- 解除外键约束
ALTER table e drop foreign key eno;
CREATE INDEX FK_d_e2 ON e(eno);


create table X(
id int PRIMARY key AUTO_INCREMENT COMMENT '序号',
xno char(2) NOT NULL COMMENT '项目编号',
eno char(6) COMMENT '员工编号',
constraint FK_e_x foreign key(eno) references e(eno)
)ENGINE=INNODB;
-- 1452可能存在约束不统一



-- 7.在X表中插入以下数据
desc x;
select *from x;
show create table d;
insert into x values 
(1,01,200101),
(2,01,200102),
(3,01,200201),
(4,01,220102),
(5,02,210101),
(6,02,200101),
(7,02,200101),
(8,02,220102),
(9,03,200101),
(10,03,220102);

-- 8.查询每个部门员工参与项目的情况（输出所有项目编号、员工编号、员工姓名及员工所在部门名称，若员工没有参加任何项目，则项目编号为NULL）。
-- 1052可能存在同名，需要详细表达->表.字段
-- select x.xno,x.eno,e.ename,d.dname from x,e,d where x.eno=e.eno and e.edno=d.dno;
select x.xno,x.eno,e.ename,d.dname from e left outer join x on e.eno=x.eno left outer join d on e.edno=d.dno;


-- 9.查询与“黎一”同岁的员工编号、姓名和年龄（要求使用至少3种方法求解）。
select eno,ename,eage from e where ename='黎一';-- 常规作弊查询
select eno,ename,eage from e where eage=(select eage from e where ename='黎一'); -- 标量子查询
select eno,ename,eage from e where eage in (select eage from e where ename='黎一');-- 列子查询


select eno,ename,eage from e where eage BETWEEN 27 and 30;
select eno,ename,eage from e where eage=28;
select eno,ename,eage from e where eage like 28;

-- 10.查询参与了03号项目的员工姓名和部门名称。
SET @i=0;
select current_date,@i:=@i+1 AS '序号',e.ename,d.dname from d,e,x where x.xno=03 and x.eno=e.eno and e.edno=d.dno;

select e.ename,d.dname,e.eage from d,e,x where x.xno=03 and x.eno=e.eno and e.edno=d.dno;

-- 11.查询比所有男生年龄都小的女生的员工编号、姓名和年龄。

select eno,ename,eage from e where egender='女' having eage< any(select min(eage)from e where egender='男');
select eno,ename,eage from e where egender='女' and eage < any(select min(eage)from e where egender='男');
select eno,ename,eage from e having egender='女' and eage < any(select min(eage)from e where egender='男');

-- 12.将外键的模式都设置为：删除数据为置空模式，更新数据为级联模式。

ALTER TABLE e ADD CONSTRAINT fk_ee FOREIGN KEY(edno) REFERENCES d(dno) ON UPDATE CASCADE;
ALTER TABLE e ADD CONSTRAINT FOREIGN KEY(edno) REFERENCES d(dno) ON UPDATE SET NULL; 
	
ALTER TABLE x ADD CONSTRAINT fk_as FOREIGN KEY(eno) REFERENCES e(eno) ON UPDATE CASCADE;
ALTER TABLE x ADD CONSTRAINT FOREIGN KEY(eno) REFERENCES e(eno) ON UPDATE SET NULL; 
show index from x;
-- 13.删除departments表中部门编号为104的数据，并查看employees表中的数据。


DELETE FROM x where eno=104;
DELETE FROM e where edno=104;
DELETE FROM d where dno=104;

-- 14.更改departments表中“维修部”的部门编号更改为“106”，并查看employees表中的数据。

update d set dno=106 where dname='维修部';


DESC d;
DESC nativePlace;
SHOW CREATE TABLE e;
SHOW CREATE TABLE nativePlace;
SHOW FULL COLUMNS FROM nativePlace;
SHOW FULL COLUMNS FROM d;
show index from d;
select * from d;
select * from e;
select * from x;
SET FOREIGN_KEY_CHECKS=0;
SET FOREIGN_KEY_CHECKS=1;





