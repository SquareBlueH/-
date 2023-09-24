drop database if exists jxglDB1;
create database jxglDB1;
use jxglDB1;

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