Create table script:
Users:
``` mysql
CREATE TABLE Users(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(60) NOT NULL, passwd VARCHAR(60) NOT NULL, tag VARCHAR(60) DEFAULT "members", ranks VARCHAR(10), company VARCHAR(10), kills INT DEFAULT 0, attendance INT DEFAULT 0, balance DOUBLE DEFAULT 0, enrollmentTime VARCHAR(60), createtime timestamp DEFAULT CURRENT_TIMESTAMP, updatetime timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);
```
```
insert into Users(name, passwd, tag, ranks, company, kills, attendance, balance, enrollmentTime) values ('zhengde', '123456', 'Admin', 'SQ', 'ZJH', 0, 0, 100, '2014-01-01');
```