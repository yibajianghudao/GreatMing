Create table script:
Users:
``` mysql
CREATE TABLE Users(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(60) NOT NULL, passwd VARCHAR(60) NOT NULL, tag VARCHAR(60) DEFAULT "members", ranks VARCHAR(10), company VARCHAR(10), kills INT DEFAULT 0, attendance INT DEFAULT 0, balance DOUBLE DEFAULT 0, userpic VARCHAR(100), createtime datetime not null, updatetime datetime not null);
```
```
insert into Users(name, passwd, tag, ranks, company, kills, attendance, balance, enrollmentTime) values ('zhengde', '123456', 'Admin', 'SQ', 'ZJH', 0, 0, 100, '2014-01-01');
```

将User类和Select类分开，路径使用/user，/select区分。
将登录和注册接口的路径添加到拦截器的关闭名单中。