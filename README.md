# GreatMingWeb
## 配置:
### 安装mariadb
script:
```
CREATE DATABASE GreatMing;
CREATE USER 'greatming'@'localhost'IDENTIFIED BY 'greatming';
GRANT ALL ON GreatMing.* TO 'greatming'@'localhost' IDENTIFIED BY 'greatming';
```
#### Users:
```
CREATE TABLE Users(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(60) NOT NULL, passwd VARCHAR(60) NOT NULL, tag VARCHAR(60) DEFAULT "members", ranks VARCHAR(10), company VARCHAR(10), kills INT DEFAULT 0, attendance INT DEFAULT 0, balance DECIMAL(10, 2) DEFAULT 0.00, userpic VARCHAR(100), createtime datetime not null, updatetime datetime not null);
```
插入数据:
```
{
    "name": "name",
    "passwd": "123456",
    "tag": "New_Player",
    "ranks": "QH",
    "company": "SJ",
    "kills": 1,
    "attendance": 1,
    "balance": 1
}
```
#### products
```
CREATE TABLE Products (
      id INT AUTO_INCREMENT PRIMARY KEY,
      classification VARCHAR(30) CHARACTER SET utf8mb4,
      name VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL,
      price DECIMAL(10, 2) NOT NULL,
      quantity INT NOT NULL,
      description TEXT,
      image_url VARCHAR(255)
);
```

#### orders
```mysql
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    productName VARCHAR(60) NOT NULL,
    username VARCHAR(60) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    sum DECIMAL(10, 2) NOT NULL,
    createTime datetime NOT NULL
);

```
### 安装redis
for windows,you can see: [this doc](https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/).  
and run:  
```sudo service redis-server start```
## TODO
~~将User类和Select类分开，路径使用/user，/select区分。~~  
~~将登录和注册接口的路径添加到拦截器的关闭名单中。~~

## 开发计划：
1. ~~完成订单类和接口~~
2. ~~完成用户购买和退款接口~~
3. 新人填表页面  // 8月2日
4. 军饷记录与溯源  // 8月5日
5. 排行榜系统     // 8月6日
6. 头像系统      // 8月7日
7. 后台管理系统   // 8月15日