#模拟另一个客户端
use book;
select * from bank;   -- 2000 1000
-- 在提交事务之后
select * from bank;   -- 1500 1500
select * from bank;

-- 更改当前会话事务的隔离级别为读取未提交( 模拟hah)
-- set [session|global] transaction isolation level 事务隔离级别值
-- [session|global] 都省略 ，修改下一个事务隔离级别
set session transaction isolation level read uncommitted;
-- > OK
select @@session.transaction_isolation; -- READ-UNCOMMITTED
select * from bank where bname='hah'; -- 21000
select * from bank where bname='hah'; -- 20000
-- 脏读 读取其他事务未提交的数据 

-- 更改当前会话事务的隔离级别为读取提交( 模拟hah)
set session transaction isolation level read committed;
-- > OK
select @@session.transaction_isolation; -- READ-COMMITTED
select * from bank where bname='hah'; -- 20000
select * from bank where bname='hah'; -- 21000
-- 求账号里的所有余额总额
Select sum(balance) from bank;   -- 25000
Select sum(balance) from bank;   -- 25100
-- 不可重复读

-- 更改当前会话事务的隔离级别为可重复读取( 模拟hah)
set session transaction isolation level repeatable read;
-- > OK
select @@session.transaction_isolation; -- REPEATABLE-READ
-- 求账号里的所有余额总额
start transaction;
Select sum(balance) from bank;   -- 25100 账户lili未开
Select sum(balance) from bank;   -- 25100 账户lili已开

-- 更改当前会话事务的隔离级别为可串行化
set session transaction isolation level serializable;
select @@session.transaction_isolation;
start transaction;
update bank set balance=balance-1000 
where bname='张三';
update bank set balance=balance+1000 
where bname='张一';
commit;