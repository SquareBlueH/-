#用户与权限
SHOW DATABASES;
use mysql;
show tables;
desc user;
select * from user;
select plugin,authentication_string from user where user='root';
select plugin,authentication_string from user;
select user,account_locked from user;
#创建用户 推荐使用  create user 用户名   -- 要拥有权限
create user user1;
-- > OK
select user,account_locked,plugin,authentication_string from user;
select host,user from user;

/*CREATE USER [IF NOT EXISTS]
账户名 [用户身份验证选项][, 账户名 [用户身份验证选项]]…
[WITH 资源控制选项][密码管理选项 | 账户锁定选项]
*/
create user 'user2'@'localhost' identified by '123456';
-- > OK
select user,account_locked,plugin,authentication_string from user
where user like 'user%';

create user 'user3'@'localhost' identified by '123456'
with max_user_connections 2;
-- > OK
create user 'user4'@'localhost' identified with mysql_native_password by '123456';
create user 'user5'@'localhost' identified with mysql_native_password by '123456' PASSWORD EXPIRE INTERVAL 180 DAY;
CREATE USER 'user6'@'localhost' IDENTIFIED BY '777777'
PASSWORD EXPIRE ACCOUNT LOCK;
select user,account_locked from user;
# 修改用户
# 修改密码： ALTER USER 账户名 IDENTIFIED BY '明文密码';
alter user user1 identified by 'user1';
-- > OK
select * from user where user like'user%';

-- SET PASSWORD [FOR账户名] = '明文密码'
SET PASSWORD FOR user2 = '1234';
-- > 1133 - Can't find any matching row in the user table
set password for user1='1234';  -- > OK
SET PASSWORD FOR 'user2'@'localhost' = '1234';  -- > OK
select user,account_locked from user where user like 'user%';
alter user 'user2'@'localhost' account lock;  -- > OK  锁定user2用户
alter user 'user2'@'localhost' account unlock;  -- > OK  解锁user2用户
# 删除用户 Drop user
drop user user6;
-- > 1396 - Operation DROP USER failed for 'user6'@'%'
drop user 'user6'@'localhost';-- > OK
-- Create user if not exists 
-- drop user if exists
drop user 'user5'@'localhost','user4'@'localhost';

/*权限管理
GRANT 权限类型 [字段列表][, 权限类型 [字段列表]] ...
ON [目标类型] 权限级别
TO 账户名 [用户身份验证选项] [, 账户名 [用户身份验证选项]] ...
[REQUIRE 连接方式]
[WITH {GRANT OPTION | 资源控制选项}]
权限类型：指的就是SELECT、DROP、CREATE等权限。
字段列表：用于设置列权限。
目标类型：默认为TABLE，表示将全局、数据库、表或列中的某些权限授予给指定的用户。其他值为FUNCTION（函数）或PROCEDURE（存储过程）。
权限级别：用于定义全局权限、数据库权限和表权限。
添加GRANT OPTION：表示当前账户可以为其他账户进行授权。
*/
SHOW GRANTS FOR 'root'@'localhost';
SHOW GRANTS FOR 'user1'@'%';  -- USAGE表示没有任何权限。
# jwgl 查询权限
grant select on jwgl.* to 'user1'@'%';  -- > OK

# 授予user2 jwgl.c 查询权限
grant select on jwgl.c to 'user2'@'localhost';

grant select on *.* to 'user3'@'localhost';

grant insert on jwgl.s to 'user3'@'localhost';

grant all privileges on book.* to 'user2'@'localhost';

SHOW GRANTS FOR 'user2'@'localhost';
SHOW GRANTS FOR 'user3'@'localhost';
grant all privileges on book.* to 'user3'@'localhost' with grant option;

create user user4;

grant select(rno,rname) on book.readers to 'user4'@'%';  -- > OK

#回收权限
REVOKE 权限类型 [(字段列表)] [, 权限类型[(字段列表)]] …
ON [目标类型] 权限级别 FROM 账户名 [, 账户名] …

REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'user3'@'localhost'; 

revoke select(rno,rname) on book.readers from 'user4'@'%'; 

#刷新权限
flush privileges;

mysqladmin -u root -p reload

#user1 用户连接
create database book1;
-- > 1044 - Access denied for user 'user1'@'%' to database 'book1'

alter user user1 identified by '123';
-- > OK
alter user 'user2'@'localhost' identified by '123';
-- > 1227 - Access denied; you need (at least one of) the CREATE USER privilege(s) for this operation
alter user user2 identified by '123';

show databases;
use jwgl;
show tables;
select * from sc;
delete from c where cno='c1';
-- > 1142 - DELETE command denied to user 'user1'@'localhost' for table 'c'
update c set cname='MYSQL' where cno='c1';
-- > 1142 - UPDATE command denied to user 'user1'@'localhost' for table 'c'

-- user2用户连接的语句
show databases;
use jwgl;
show tables;

use book;
show tables;
select * from bbi;  
update bbi set returndate = now() where bno='978700873729'

grant select on book.bbi to 'user1'@'%';
-- > 1142 - GRANT command denied to user 'user2'@'localhost' for table 'bbi'

-- user3用户连接的语句
use jwgl;
select * from s;
insert into s values('S55','潘丽','女','侗',22,'电子信息');
-- > Affected rows: 1
delete from s where sno='s55';
-- > 1142 - DELETE command denied to user 'user3'@'localhost' for table 's'

--  ALL PRIVILEGES表示除GRANT OPTION（授权权限）和PROXY（代理权限）外的所有权限。

grant select on book.books to 'user4'@'%';   -- > OK
grant select on jwgl.s to 'user4'@'%';    -- > 1142 - GRANT command denied to user 'user3'@'localhost' for table 's'

-- user4用户连接的语句
use book;
show tables;
select * from readers;
-- > 1142 - SELECT command denied to user 'user4'@'localhost' for table 'readers'
select rno,rname from book.readers;
select * from books;