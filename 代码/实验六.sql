
delete from user where user='test1' and host='localhost';

drop user 'test5'@'localhost';
-- 1.创建用户 test1，可访问的主机地址为本机，初始密码为654321。
create user 'test1'@'192.168.3.3' identified by '654321';
-- 2.使用alter user语句将用户test1密码设置为过期，实现首次登录重置密码。
alter user 'test1'@'192.168.3.3' password expire;



-- 3.test1用户登录后使用alter user语句修改自己的密码，修改后重新登录。

alter user 'test1'@'192.168.3.3' identified by '111111';

-- 4.使用root用户给test1用户授予查看zggl.employees和zggl.departments表的权限。

grant select on zggl.d to 'test1'@'192.168.3.3';
grant select on zggl.e to 'test1'@'192.168.3.3';
grant select on zggl.x to 'test1'@'192.168.3.3';
-- 5.用test1用户登录查看zggl.employees和zggl.departments表中的数据，并尝试对zggl.employees表进行插入数据、删除数据和修改数据的操作，查看系统是否有相关报错信息。

DELETE FROM x where id=8;
drop table x;
insert into x values (51,1,200101);
update x set eno=123 where xno=2;

-- 6.回收用户test1的所有权限。

revoke select on zggl.d from 'test1'@'192.168.3.3';
revoke select on zggl.e from 'test1'@'192.168.3.3';
revoke select on zggl.x from 'test1'@'192.168.3.3';











