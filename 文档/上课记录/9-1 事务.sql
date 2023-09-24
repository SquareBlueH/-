#事务 
#同时执行多条SQL语句，SQL同时成功 有一条失败的，其余的都应撤回（回滚）
#A -1000 B +1000
#事务的特点  A C I D
#A原子性 都执行 都不执行
#C一致性
#I 隔离性
#D 持久性
#事务基本操作
#显式开启事务 start transaction  
#提交 commit  回滚rollback
use book;
create table bank(
bid char(4) primary key comment'账号',
bname varchar(10) not null comment'账户名称',
balance decimal(10,2) unsigned comment'余额');
insert into bank values('1001','张航',1000),
('1002','张一',1000),('1003','张二',1000),('1004','张三',1000);
-- 张三 存款1000
update bank set balance=balance+1000 
where bname='张三';
select * from bank;
start transaction;  -- > OK
-- 张三给张一转账500
update bank set balance=balance-500 
where bname='张三';
select * from bank;  -- 1500  1000
update bank set balance=balance+500 
where bname='张一';
select * from bank;  -- 1500 1500 
-- 事务的提交
commit;  -- > OK

-- 张三给张二转账2000
start transaction;  -- > OK
update bank set balance=balance+2000 
where bname='张二';
select * from bank; 
update bank set balance=balance-2000 
where bname='张三';
-- > 1264 - Out of range value for column 'balance' at row 4
select * from bank;  
-- 事务的回滚
rollback;  -- > OK
select * from bank; 

-- autocommit 查看当前会话事务自动提交状态
select @@autocommit;  -- 默认1（自动提交）0（手动提交）
insert into bank values('1005','hah',0); 
-- > Affected rows: 1
select * from bank;
set autocommit=0;
update bank set balance=balance+20000 
where bname='hah';
commit;

-- 张三给张二转账200 张一200
start transaction;
update bank set balance=balance-400 
where bname='张三';
update bank set balance=balance+200 
where bname='张一';
-- 事务的保存点、回滚点
savepoint s1;  -- savepoint 保存点的名字
update bank set balance=balance+2000 
where bname='张二';
select * from bank;
rollback to savepoint s1;  -- > OK  回滚到指定的保存点
select * from bank;
update bank set balance=balance+200 
where bname='张二';
commit;
select * from bank;

#事务的隔离级别
select @@session.transaction_isolation;  -- 当前 
-- REPEATABLE-READ
select @@global.transaction_isolation;  -- 全局
-- REPEATABLE-READ
select @@transaction_isolation;   -- 下一个事务
-- REPEATABLE-READ
#事务没提交的时，另一个客户端是无法读取的（默认）
#（1）读取未提交的事务 read uncommitted; 最低 脏读 
# 模拟张一给hah转账1000元
start transaction;
update bank set balance=balance+1000 
where bname='hah';
rollback;
# (2)读取已提交的事务 read committed;
# 模拟张一给hah转账1000元
start transaction;
update bank set balance=balance+1000 
where bname='hah';
update bank set balance=balance-1000 
where bname='张一';
commit;
# 模拟新开户 存100
start transaction;
insert into bank value('1006','xixi',100);
commit;
#（3）repeatable read 可重复读  MYSQL默认事务隔离级别
# 模拟新开户 存100000
start transaction;
insert into bank value('1007','lili',100000);
commit;
select sum(balance) from bank;  -- 125100.00
#（4） 可串行化  serializable 最高
# 加锁 不会脏读、不可重读、幻读
# 由于加锁 可能会导致超时 锁竞争现象
set session transaction isolation level serializable;
select @@session.transaction_isolation;
start transaction;
select * from bank where bname='张三';
start transaction;
update bank set balance=balance-1000 
where bname='张三';
-- > 1205 - Lock wait timeout exceeded; try restarting transaction
-- 等待超时 影响数据库的并发性能
select @@innodb_lock_wait_timeout;   -- 等待的时间 50
update bank set balance=balance-1000 
where bname='张三';
-- > 1264 - Out of range value for column 'balance' at row 4