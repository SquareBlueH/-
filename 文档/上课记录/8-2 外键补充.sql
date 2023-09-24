use book;
show create table bbi;
CREATE TABLE `bbi` (
  `BNO` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `RNO` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cno` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `BORROWDATE` datetime NOT NULL,
  `RETURNDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`BNO`,`RNO`,`BORROWDATE`) USING BTREE,
  KEY `RNO` (`RNO`) USING BTREE,
  CONSTRAINT `bbi_ibfk_1` FOREIGN KEY (`BNO`) REFERENCES `books` (`bno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bbi_ibfk_2` FOREIGN KEY (`RNO`) REFERENCES `readers` (`rno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC

在图书信息表、读者信息表和借阅表上创建一个名为V_BR视图，获得读者编号、读者姓名、图书名称、借书日期。
-- 学号、学生姓名、课程号、分数
-- group by 学号
create view v_br
as
select r.rno,r.rname,b.bname,bbi.borrowdate
from readers as r inner join bbi on bbi.rno=r.rno
inner join books as b on bbi.bno=b.bno
-- > 1055 - Expression #3 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'book.b.BNAME' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

select * from v_br;

update v_br1 set rname='五一' where rno='201910090002';

update v_br1 set rno='202310090002' where rname='五一';
-- > 1288 - The target table v_br1 of the UPDATE is not updatable
update bbi set rno='202310090002' where rno='201910090002';
-- > 1452 - Cannot add or update a child row: a foreign key constraint fails (`book`.`bbi`, CONSTRAINT `bbi_ibfk_2` FOREIGN KEY (`RNO`) REFERENCES `readers` (`rno`) ON DELETE RESTRICT ON UPDATE RESTRICT)
select * from readers;
-- 外键约束 从表 主表 可以是同一个表吗？可以的
-- 课程信息表 cno cname xf xxcno
-- 课程表：01 - 10 先修课程为11号（不合理）
--  xxcno 外键 参照 06课程先修课程是03号
-- 大一上、大二上、先修课程（课程表）
-- 先修课程编号作为外键时参照课程表里的课程编号
create table ccc(
cno char(2) primary key,
cname varchar(20) not null,
xf int,
xxcno char(2) comment '先修课程编号',
foreign key (xxcno) references ccc(cno)
on delete restrict on update cascade
);
insert into ccc values(02,'数据结构',2,01);
select * from ccc;