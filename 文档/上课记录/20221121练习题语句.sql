-- 20221121 练习题
use book;
/*2.查询借阅了图书的读者姓名和读者编号
（提示：使用distinct消除重复行，连接bbi表和readers表）。*/
select rname,rno from readers;
select distinct rno from bbi;
select rname,bbi.rno from readers inner join bbi
on readers.rno = bbi.rno;

select distinct rname,bbi.rno from readers inner join bbi
on readers.rno = bbi.rno; -- (正确)

/*3. 查询被借阅图书的图书编号、图书名称、出版社和图书价格
（提示：使用distinct消除重复行，连接bbi表和books表）。*/
select distinct bbi.bno,bname,bpublish,bprice from books
inner join bbi on books.bno = bbi.bno;  -- 正确
select all bbi.bno,bname,bpublish,bprice from books
inner join bbi on books.bno = bbi.bno; 
/*4. 查询借阅表中读者的姓名及其借阅的书名和借阅日期
（提示：bbi，readers和books三个表连接）。*/
select rname,bname,borrowdate from readers as r
inner join bbi on r.rno = bbi.rno 
inner join books as b on bbi.bno = b.bno;

select rname,bname,borrowdate
from readers as r, books as b, bbi
where r.rno = bbi.rno  and bbi.bno = b.bno;

/*5. 要统计所有读者的借书情况，要求显示所有借阅了
图书的读者每次借阅的书籍编号和借书日期，没借书的读者也要显示
（提示：左外连接，readers为主表，bbi为从表）。*/
select r.rno,bno,borrowdate from readers r
left outer join bbi on bbi.rno = r.rno;   -- 正确

select bbi.rno,bno,borrowdate from readers r
left outer join bbi on bbi.rno = r.rno;

/*6. 查询所有读者的编号、姓名、借书次数
（提示：连接readers和bbi表，group by分组，count函数）。*/
select r.rno,rname,count(bno) from readers r
inner join bbi on r.rno = bbi.rno 
group by rno

select r.rno,rname,count(bno) from readers r
left join bbi on r.rno = bbi.rno 
group by rno

/*7. 查询所有图书的编号、名称、被借阅次数
（提示：连接books和bbi表，group by分组，count函数）。*/
select b.bno,bname,count(rno) from books b
inner join bbi on b.bno = bbi.bno 
group by bno

select b.bno,bname,count(rno) from books b
left join bbi on b.bno = bbi.bno 
group by bno

/*8. 运用左外连接查询未借书的读者姓名
提示：使用LEFT  JOIN… ON，WHERE）。*/
select rname from readers left join bbi on bbi.rno=readers.rno
where borrowdate is null;

select rname from readers left join bbi on bbi.rno=readers.rno
where bno is null;

select rname,bbi.* from readers 
left join bbi on bbi.rno=readers.rno

/*9. 运用右外连接查询未借书的读者姓名
（提示：使用RIGHT JOIN… ON，WHERE）。*/
select rname from bbi right join readers  on bbi.rno=readers.rno
where bno is null;

/*10. 查询借阅了图书的读者编号、姓名、借书总数和所有借阅图书的总价
（提示：内连接，group by分组）。*/
select r.rno,rname,count(bno),sum(bprice) from readers as r
inner join bbi on bbi.rno= r.rno 
inner join books on bbi.bno = books.bno group by rno
-- > 1052 - Column 'bno' in field list is ambiguous

select r.rno,rname,count(bbi.bno),sum(bprice) from readers as r
inner join bbi on bbi.rno= r.rno 
inner join books on bbi.bno = books.bno group by rno

/*11. 查询所有读者的编号、姓名、借书总数和所有借阅图书的总价
（提示：左外连接，group by分组，count、sum函数）。*/
select r.rno,rname,count(bbi.bno),sum(bprice) from readers as r
left outer join bbi on bbi.rno= r.rno 
left join books on bbi.bno = books.bno group by rno