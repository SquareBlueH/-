/*
CREATE DATABASE IF NOT EXISTS mydb;
创建数据库mydb*/

/*
USE mydb;
CREATE TABLE subscribe(
id INT COMMENT '编号',
email VARCHAR(60) COMMENT '邮件订阅的邮箱地址',
status INT COMMENT '是否确认，0未确认，1已确认',
code VARCHAR (10) COMMENT '邮箱确认的验证码')
DEFAULT CHARSET=utf8;
创建mydb的表格subscribe
*/

/*
INSERT INTO subscribe VALUES
(1,'tom123@63.com',1,'TRBXPO'),
(2,'lucy123@63.com',1,'LOICPE'),
(3,'lily123@63.com',0,'JIXDAMI'),
(4,'jimmy123@63.com',0,'QKOLPH'),
(5,'joy123@63.com',1,'JSMWNL');
添加表格内容*/

/*
SELECT * FROM subscribe;
查看表格内容*/

/*
SELECT * FROM subscribe WHERE status =1;
查看同类status为1的内容*/

/*
UPDATE subscribe SET status =1 WHERE id =4;
修改ID:4的status为1*/

/*
SELECT * FROM subscribe WHERE id =4;
查看ID：4的状态*/

/*
DELETE FROM subscribe WHERE id =5;
删除ID：5*/


-- 2.给用户信息表里插入数据
insert into subscribe values ('7','qqq1234@63.com','2','QQQ');

-- 3.复制刚创建的用户信息表结构

CREATE TABLE sub LIKE subscribe;
select * from sub;

-- 4.复制用户信息表的数据到题3的表中

insert into sub select * from subscribe;

-- 5.尝试用主键冲突更新、主键冲突替换的方式解决主键冲突的问题

-- 主键冲突更新问题

-- INSERT [INTO] 数据表名 [(字段列表)] {VALUES | VALUE} (字段列表) ON DUPLICATE KEY UPDATE 字段名1 = 新值1[,字段名2 = 新值2] …;

-- 增加主键
alter table subscribe add primary key (code);

INSERT INTO sub (id,email,status,code) values (1,'tom123@63.com',1,'TRBXPO')
ON duplicate key update id='2',status='1';


desc sub;


