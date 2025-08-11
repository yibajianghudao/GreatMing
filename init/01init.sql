-- 创建数据库
CREATE DATABASE IF NOT EXISTS GreatMing;
-- 创建用户并授权
CREATE USER IF NOT EXISTS 'greatming'@'%' IDENTIFIED BY 'greatming';
GRANT ALL PRIVILEGES ON GreatMing.* TO 'greatming'@'%';
FLUSH PRIVILEGES;
