-- 1.为图书信息表的图书名称、作者、出版社创建一个名为V_BOOKS的视图。
create view V_BOOKS as select BNAME,BAUTHOR,BPUBLISH from books;

select * from v_books;

-- 2.在图书信息表和借阅表上创建一个名为V_BCOUNT视图，获得图书编号、图书名称和被借阅的次数（不包含未被借阅的图书）。
create view V_BCOUNT as select bbi.BNO,books.bname, count(*) as '被借阅的次数' from bbi left outer join books on bbi.bno=books.bno group by bbi.bno;

select * from v_BCOUNT;

-- 3.在读者信息表和借阅表上创建一个名为V_RCOUNT视图，获得读者编号、读者名称和读者借阅图书的次数（不包含未借阅过图书的读者）。
create view v_RCOUNT as select readers.rno,readers.rname,count(*) as '读者借阅图书的次数' from bbi left outer join readers on bbi.rno=readers.rno group by bbi.rno;

select * from v_RCOUNT;

-- 4.在图书信息表、读者信息表和借阅表上创建一个名为V_BR视图，获得读者编号、读者姓名、图书名称、借书日期。
create view v_BR as select readers.rno,readers.rname, books.bname,bbi.borrowdate from books,readers,bbi where readers.rno=bbi.rno and bbi.bno=books.bno;

select * from v_BR;

-- 5.修改视图V_BCOUNT，包含未被借阅的图书。
alter view v_BCOUNT as select books.bno,books.bname, count(bbi.bno) as '被借阅的次数' from books left outer join bbi on bbi.bno=books.bno group by bbi.bno,books.bno;

select * from v_BcOUNT;

-- 6.删除视图V_RCOUNT。
drop view v_RCOUNT;

select* from v_RCOUNT;

-- 7.把图书名称为“MYSQL数据库原理”，作者是“黑马程序员”，出版社为“清华大学出版社”的数据插入到视图V_BOOKS，查看系统是否有相关报错信息。
alter table bbi drop foreign key bbi_ibfk_1;
alter table books drop primary key;
alter table books modify bno varchar(13) null;
alter table books modify bpdate date nuil;
alter table books modify bprice decimal(5,2) null;
insert into V_BOOKS values('MYsQL数据库原理','黑马程序员','清华大学出版社');
-- 造成该问题的原因是： 当向视图中插入数据时，同时也会向原表插入数据插入数据，而原表(employees)中存在多个字段不允许为空，所以无法插入 ，将这些不允许为空的字段修改为允许为空即可。

desc books;

select * from v_books;

-- 8.删除视图V_BCOUNT中借阅次数为0的数据，查看系统是否有相关报错信息。
delete from v_bcount where 被借阅的次数=0;

SHOW CREATE TABLE v_bcount;
-- 9.将视图V_BR中读者编号为“201910090001”的读者姓名修改为“吴适宜”，查看系统是否有相关报错信息。
update v_br set rname='吴适宜' where rno='201910090001';

select * from v_br;

-- 10. 7-9题中若有报错信息，请分析原因；若无报错信息，可忽略本题。
