# GreatMingWeb
## 配置:
### 安装mariadb
script:

#### Users:
```
CREATE TABLE Users(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(60) NOT NULL, passwd VARCHAR(60) NOT NULL, tag VARCHAR(60) DEFAULT "members", ranks VARCHAR(10), company VARCHAR(10), kills INT DEFAULT 0, attendance INT DEFAULT 0, balance DOUBLE DEFAULT 0, userpic VARCHAR(100), createtime datetime not null, updatetime datetime not null);
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
CREATE TABLE products (
      id INT AUTO_INCREMENT PRIMARY KEY,
      classification VARCHAR(30) CHARACTER SET utf8mb4,
      name VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL,
      price DECIMAL(10, 2) NOT NULL,
      quantity INT NOT NULL,
      description TEXT,
      image_url VARCHAR(255)
);
```
### 安装redis
for windows,you can see: [this doc](https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/).  
and run:  
```sudo service redis-server start```
## TODO
~~将User类和Select类分开，路径使用/user，/select区分。~~  
~~将登录和注册接口的路径添加到拦截器的关闭名单中。~~