/*M!999999\- enable the sandbox mode */
-- MariaDB dump 10.19-11.7.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: GreatMing
-- ------------------------------------------------------
-- Server version	11.7.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `BalanceUpdates`
--

DROP TABLE IF EXISTS `BalanceUpdates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `BalanceUpdates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `isadd` bit(1) NOT NULL,
  `balance` decimal(10,2) NOT NULL,
  `updatedbalance` decimal(10,2) NOT NULL,
  `description` text NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BalanceUpdates`
--

LOCK TABLES `BalanceUpdates` WRITE;
/*!40000 ALTER TABLE `BalanceUpdates` DISABLE KEYS */;
INSERT INTO `BalanceUpdates` VALUES
(20,'111',0x01,2.00,134.00,'At 2025-03-16 attendance with kills 89.At 2025-03-15 attendance with kills 12.At 2025-03-08 attendance with kills 42.At 2025-03-07 attendance with kills 82.At 2025-03-01 attendance with kills 8.','2025-03-22 22:03:33'),
(21,'lumos',0x01,2.00,22.00,'At 2025-03-08 attendance with kills 13.At 2025-03-07 attendance with kills 10.At 2025-03-01 attendance with kills 7.','2025-03-22 22:03:33'),
(22,'jk',0x01,1.00,7.00,'At 2025-03-17 attendance with kills 16.At 2025-03-07 attendance with kills 8.At 2025-03-01 attendance with kills 2.','2025-03-22 22:03:33'),
(23,'Gudrian',0x01,2.00,53.00,'At 2025-03-17 attendance with kills 24.At 2025-03-15 attendance with kills 8.At 2025-03-08 attendance with kills 10.At 2025-03-07 attendance with kills 14.At 2025-03-01 attendance with kills 21.','2025-03-22 22:03:33'),
(24,'DJH',0x01,2.00,17.00,'At 2025-03-17 attendance with kills 15.At 2025-03-15 attendance with kills 6.At 2025-03-08 attendance with kills 8.At 2025-03-07 attendance with kills 12.At 2025-03-01 attendance with kills 35.','2025-03-22 22:03:33'),
(25,'pplove',0x01,1.00,12.00,'At 2025-03-17 attendance with kills 2.At 2025-03-07 attendance with kills 5.At 2025-03-01 attendance with kills 7.','2025-03-22 22:03:33'),
(26,'C_hake',0x01,2.00,110.00,'At 2025-03-16 attendance with kills 19.At 2025-03-15 attendance with kills 15.At 2025-03-08 attendance with kills 10.At 2025-03-07 attendance with kills 18.At 2025-03-01 attendance with kills 8.','2025-03-22 22:03:33'),
(27,'JiangHuDao',0x01,2.00,120.00,'At 2025-03-16 attendance with kills 24.At 2025-03-15 attendance with kills 3.At 2025-03-08 attendance with kills 22.At 2025-03-07 attendance with kills 11.','2025-03-22 22:03:33'),
(28,'SN',0x01,1.00,93.00,'At 2025-03-16 attendance with kills 12.At 2025-03-08 attendance with kills 2.At 2025-03-07 attendance with kills 2.','2025-03-22 22:03:33'),
(29,'mnls',0x01,1.00,8.00,'At 2025-03-15 attendance with kills 4.At 2025-03-08 attendance with kills 4.At 2025-03-07 attendance with kills 4.','2025-03-22 22:03:33'),
(30,'HWHWHW',0x01,1.00,95.00,'At 2025-03-16 attendance with kills 1.At 2025-03-15 attendance with kills 14.At 2025-03-07 attendance with kills 1.At 2025-03-01 attendance with kills 4.','2025-03-22 22:03:33'),
(31,'Constantin',0x01,1.00,76.00,'At 2025-03-16 attendance with kills 3.At 2025-03-15 attendance with kills 3.At 2025-03-08 attendance with kills 7.At 2025-03-07 attendance with kills 6.At 2025-03-01 attendance with kills 8.','2025-03-22 22:03:33'),
(32,'MURONG',0x01,2.00,32.00,'At 2025-03-17 attendance with kills 11.At 2025-03-16 attendance with kills 12.At 2025-03-15 attendance with kills 7.At 2025-03-08 attendance with kills 12.At 2025-03-07 attendance with kills 29.','2025-03-22 22:03:33'),
(33,'xx114514xx',0x01,2.00,6.00,'At 2025-03-15 attendance with kills 5.At 2025-03-08 attendance with kills 4.At 2025-03-07 attendance with kills 7.At 2025-03-01 attendance with kills 18.','2025-03-22 22:03:33'),
(34,'waiguoren',0x01,2.00,7.00,'At 2025-03-15 attendance with kills 4.At 2025-03-08 attendance with kills 19.At 2025-03-07 attendance with kills 26.At 2025-03-01 attendance with kills 18.','2025-03-22 22:03:33'),
(35,'Lanna',0x01,2.00,94.00,'At 2025-03-17 attendance with kills 3.At 2025-03-15 attendance with kills 1.At 2025-03-08 attendance with kills 9.At 2025-03-07 attendance with kills 14.At 2025-03-01 attendance with kills 35.','2025-03-22 22:03:33'),
(36,'borgo',0x01,1.00,78.00,'At 2025-03-17 attendance with kills 6.At 2025-03-16 attendance with kills 26.At 2025-03-08 attendance with kills 2.At 2025-03-07 attendance with kills 8.At 2025-03-01 attendance with kills 2.','2025-03-22 22:03:33'),
(37,'bloeall',0x01,3.00,25.00,'At 2025-03-17 attendance with kills 3.At 2025-03-16 attendance with kills 18.At 2025-03-15 attendance with kills 9.At 2025-03-08 attendance with kills 7.At 2025-03-07 attendance with kills 14.At 2025-03-01 attendance with kills 4.','2025-03-22 22:03:33'),
(38,'Deng',0x01,2.00,61.00,'At 2025-03-15 attendance with kills 12.At 2025-03-07 attendance with kills 12.At 2025-03-01 attendance with kills 18.','2025-03-22 22:03:33');
/*!40000 ALTER TABLE `BalanceUpdates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Products`
--

DROP TABLE IF EXISTS `Products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `Products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classification` varchar(30) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `description` text DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Products`
--

LOCK TABLES `Products` WRITE;
/*!40000 ALTER TABLE `Products` DISABLE KEYS */;
INSERT INTO `Products` VALUES
(1,'未知','骑砍2CDKEY',199.00,47,'骑砍2steam礼物或者CDkey一份。欢迎来到100年前的卡拉狄亚~','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRA4JmE0-ZLUgXCroTtQQ1uBtuxca9RvoJM-oQ51zeKo7X3VucE'),
(2,'未知','燧发手枪模型',99.00,50,'燧发手枪模型，完全合法。禁止非法改装，出事概不负责。','https://gd2.alicdn.com/imgextra/i1/4071172498/O1CN01S20kxX1UK8B4QtK9N_!!4071172498.png_400x400.jpg'),
(3,'未知','燧发长枪模型',259.00,50,'燧发长枪模型，完全合法，禁止非法改装，出事概不负责！','https://gd3.alicdn.com/imgextra/i1/4071172498/O1CN01BE4iuU1UK8B4QXJ11_!!4071172498.jpg_400x400.jpg'),
(4,'未知','明小梢弓，带配件，可选20-40磅',199.00,49,'明小梢弓，可选20-40磅。使用请一定注意安全，正确拉弓禁止空放，禁止对准人或者动物，在安全的射箭馆或专业场地进行射箭。','https://gd4.alicdn.com/imgextra/i3/2212259079269/O1CN017qXiTE2ILFv4l0nZ8_!!2212259079269.jpg_400x400.jpg'),
(5,'未知','苍龙刀',199.00,48,'一把真刀，请安全把玩，拿来cosplay也不错，就是别拿去惹麻烦','https://gd1.alicdn.com/imgextra/i2/2213230961039/O1CN01C84Z3O1JXuO2nqYcM_!!2213230961039.jpg_400x400.jpg'),
(6,'未知','绣春刀模型【需要通过锦衣卫刺刀考核】【禁止重复领取】',0.00,998,'这是被皇帝认可的战士获得的奖励。您拥有这个说明您拥有了不俗的刺刀实力，且拥有合格的军衔。在通过皇帝的锦衣卫刺刀考试后自动获得。锦衣卫测试报名开放时间：12.01-12.16。考试时间：12.16-1.23.届时请留意群公告的报名方式和考试方式。','https://gd3.alicdn.com/imgextra/i2/809581092/O1CN01FV4jMG1JwBCxsj4ue_!!809581092.jpg_400x400.jpg'),
(7,'未知','锦衣卫腰牌【需要通过锦衣卫骑兵考核】',0.00,999,'这是被皇帝认可的战士获得的奖励。您拥有这个说明您拥有了不俗的骑兵实力，且拥有合格的军衔。在通过皇帝的锦衣卫骑兵考试后自动获得。锦衣卫测试报名开放时间：12.01-12.16。考试时间：12.16-1.23.届时请留意群公告的报名方式和考试方式。','https://gd2.alicdn.com/imgextra/i1/291071077/O1CN01bRbTes1JpJQYhzcAT_!!291071077.jpg_400x400.jpg'),
(8,'未知','定制士兵腰牌',29.00,998,'您可以自由选择样式定制一块带有您ID和军衔和战队logo的腰牌！','https://img.alicdn.com/imgextra/i2/291071077/O1CN01K6WiNd1JpJEP6wnIm_!!291071077.jpg'),
(9,'未知','大明五军营乐高兵人模型（送战旗）',5.00,999,'大明五军营乐高兵人模型，途中任选一个~','https://gw.alicdn.com/imgextra/i1/1085815835/O1CN01nvnwTB1syTkZz66qq_!!1085815835.jpg_Q75.jpg_.webp'),
(10,'未知','大明神机营乐高兵人模型',5.00,999,'大明神机营乐高兵人模型，图中任选一个','https://gw.alicdn.com/imgextra/i1/2684707666/O1CN01Pgzp5126V4vljwHvC_!!2684707666.jpg_Q75.jpg_.webp'),
(11,'未知','神机炮模型',5.00,999,'神机炮模型，给您的神机营增添重火力！','https://gw.alicdn.com/bao/uploaded/i2/2684707666/O1CN01ggz88g26V4vz13a0J_!!2684707666.jpg_Q75.jpg_.webp'),
(12,'未知','大明三千营乐高模型',5.00,999,'图中任选一个，战马请另外购买哦~战马要银子的。','https://gw.alicdn.com/imgextra/i3/2499098319/O1CN01TuKX9J2BK9c8Al4W7_!!2499098319.jpg_Q75.jpg_.webp'),
(13,'未知','战马乐高',4.00,998,'给您的三千营配上一匹马！','https://s21.ax1x.com/2024/03/24/pFhXeGq.png'),
(14,'未知','军器图说（书籍）',15.00,999,'大明的军武著作古文影印复刻！喜欢历史的不要错过！','https://gw.alicdn.com/imgextra/i1/919113554/O1CN01Trpwsr1c7mEY7zhrW_!!919113554.jpg_Q75.jpg_.webp'),
(15,'未知','清军乐高兵人',5.00,999,'清军乐高兵人，给你的明军乐高兵人找个伴打架，任选其一','https://gw.alicdn.com/imgextra/i1/2684707666/O1CN01uWdlNX26V4zkdFJrE_!!2684707666.jpg_Q75.jpg_.webp'),
(16,'未知','大明官员，锦衣卫与皇帝任选一个',5.00,999,'什么？？？高贵的官老爷竟然这么便宜？太实惠了！只需要5军饷，皇帝都买得到（bushi）','https://gw.alicdn.com/imgextra/i1/2684707666/O1CN01VSKII026V51ZbhXgd_!!2684707666.jpg_Q75.jpg_.webp'),
(17,'未知','大明军团乐高模型',199.00,5,'大明军团乐高模型，包含完整军团。一下整一支军队不香吗？','https://gw.alicdn.com/bao/uploaded/i4/4230271009/O1CN016JctTH1JKAKz6HfSs_!!4230271009.jpg_Q75.jpg_.webp'),
(18,'未知','麦克风',10.00,999,'没有麦克风但是想开麦交流？没问题！这个麦克风适配3.5耳机孔，包邮到家。您的实惠最优选！','https://gw.alicdn.com/bao/uploaded/i4/2783711212/O1CN01ZUQAne1Kp8vVn3N0Q_!!2783711212.jpg_Q75.jpg_.webp'),
(19,'未知','多功能小刀',5.00,999,'一把i小巧实用的多功能小刀，使用请注意安全','https://gw.alicdn.com/imgextra/i2/2206416450449/O1CN01FcTTyd1FBgaZLeIGJ_!!2206416450449.jpg_Q75.jpg_.webp'),
(20,'未知','檀木小户外刀',25.00,999,'一把精致的小刀，使用请注意安全','https://gw.alicdn.com/imgextra/i3/2210370237306/O1CN01iPMwSY23qCY2XMhJz_!!2210370237306.jpg_Q75.jpg_.webp'),
(21,'未知','十八般兵器模型',20.00,999,'一款精致的十八般兵器模型组，包含全部兵器以及盒子。','https://gw.alicdn.com/bao/uploaded/i3/2681005450/O1CN01ya4rhk1q89J08PT6z_!!2681005450.jpg_Q75.jpg_.webp'),
(22,'未知','直拉弓',40.00,999,'一把弓箭，可选.30或者40磅/不含弓箭。请在专业场地专人指导下使用。','https://gw.alicdn.com/bao/uploaded/i2/2697974950/O1CN01rMUqDM1mR9QzVMu3P_!!2697974950.jpg_Q75.jpg_.webp'),
(23,'未知','10支箭',23.00,999,'10支箭，补充你的弹药~','https://gw.alicdn.com/bao/uploaded/i2/2697974950/O1CN01dsolfJ1mR9Or4j5OU_!!2697974950.jpg_Q75.jpg_.webp'),
(24,'未知','激光弹弓',9.00,999,'一把帅帅的激光弹弓~送200颗泥丸。2套皮筋，剩下的送的自己看图片吧','https://gw.alicdn.com/bao/uploaded/i1/2212495207853/O1CN01GOYBAQ27sj8r36P2g_!!2212495207853.jpg_Q75.jpg_.webp'),
(25,'未知','M416水弹枪（赠品见图）',68.00,999,'M416水弹枪，可切换射击模式。赠品见图。','https://s21.ax1x.com/2024/03/24/pFhXyFA.png'),
(26,'未知','九洲五味掌心脆干脆面零食',5.00,999,'九洲五味掌心脆干脆面零食.总共10包。','https://gw.alicdn.com/imgextra/i2/2216477698371/O1CN01hPgBLH2BhyL4JylTq_!!2216477698371.png_.webp'),
(27,'未知','香葱肉松卷面包',10.00,999,'3包香葱肉松卷面包，给你的早晨补充能量！=w=','https://gw.alicdn.com/imgextra/i4/2939572214/O1CN01m8BCLo1SE3pBjWp51_!!2939572214.jpg_Q75.jpg_.webp'),
(28,'未知','博牛筋辣条士儿时怀旧面筋',10.00,999,'博牛筋辣条士儿时怀旧面筋20包。~好吃的辣条哦~','https://gw.alicdn.com/imgextra/i4/2215044765871/O1CN01jLBgNc1tEyBI4ineG_!!2215044765871.jpg_Q75.jpg_.webp'),
(29,'未知','椰树牌椰汁6盒',20.00,999,'椰树牌椰汁，你一定喝过。没喝过？那快去喝啊！=A=','https://gw.alicdn.com/bao/uploaded/i2/2540372727/O1CN01DPyD6R1W10yWZeHFk_!!2540372727.png_.webp'),
(30,'未知','王老吉红罐凉茶植物饮料310ml*12罐整箱装',39.00,999,'怕上火喝王老吉！','https://gw.alicdn.com/imgextra/O1CN01jGM0Tc1uTumOfL07m_!!3625856039.jpg_Q75.jpg_.webp'),
(31,'未知','双汇玉米肠 8 支',9.00,999,'双汇玉米肠 8 支，您的泡面好搭档！','https://gw.alicdn.com/imgextra/i3/2081314055/O1CN019mq19z1fpEr5xTYhU_!!2081314055.jpg_Q75.jpg_.webp'),
(32,'未知','统一方便面5包',15.00,999,'统一方便面5包口味任选','https://gw.alicdn.com/bao/uploaded/i3/1816075766/O1CN01vmiIpD1sSsdTbd1vr_!!1816075766.jpg_Q75.jpg_.webp'),
(33,'未知','蔬菜自热火锅两盒',15.00,999,'蔬菜自热火锅两盒，买根火腿肠加加？','https://gw.alicdn.com/bao/uploaded/i3/2200542376787/O1CN01bsW292200Ukzy6UGG_!!2200542376787.jpg_Q75.jpg_.webp'),
(34,'未知','旺旺仙贝400g *2 包  (130小包)',45.00,999,'吃了旺旺仙贝！晚上干活不累！','https://gw.alicdn.com/bao/uploaded/i3/354608922/O1CN01Amh8gF2FmKcS6s8Sf_!!354608922.jpg_Q75.jpg_.webp'),
(35,'未知','汪汪雪饼400g*2包（约64包）',40.00,999,'啃了汪汪雪饼，这味值得细品~','https://gw.alicdn.com/bao/uploaded/i3/354608922/O1CN013wU3hi2FmKcRlXCYU_!!354608922.jpg_Q75.jpg_.webp'),
(36,'未知','美好时光海苔',20.00,999,'香香脆脆我的最爱，美好时光海苔~ 一共四袋','https://gw.alicdn.com/bao/uploaded/i1/2212454989134/O1CN018Mw6oG2HLQafVeLMw_!!2212454989134.jpg_Q75.jpg_.webp'),
(37,'未知','骑砍维京征服DLC',39.00,999,'骑砍维京征服DLC，很好的单人剧情，使我的鼠标旋转，爱来自美国~','https://gw.alicdn.com/imgextra/i3/3903061502/O1CN01iflkiT1MxxZqTcjga_!!3903061502.jpg_Q75.jpg_.webp'),
(38,'未知','东方玩偶',93.00,999,'东方Project小玩偶任选一个DA⭐ZE','https://gw.alicdn.com/imgextra/i4/2395664394/O1CN01QUtHTN1iKV5VOa1iD_!!2395664394.jpg_Q75.jpg_.webp'),
(39,'未知','电竞鼠标',15.00,998,'想换鼠标了？这是一款经济的电竞鼠标。满足您大多数的游戏需求。','https://gw.alicdn.com/bao/uploaded/i4/2211695242789/O1CN01b6U7L81WTPYXRJvnf_!!2211695242789-0-scmitem176000.jpg_Q75.jpg_.webp'),
(40,'未知','更多的FUMO!',93.00,999,'提供给你更多的款式选择！','https://gw.alicdn.com/imgextra/i4/2214066041659/O1CN01tOrNzt1O7rs6Q0pQX_!!2214066041659.jpg_Q75.jpg_.webp'),
(41,'未知','小刀剑钥匙扣',8.00,998,'小钥匙扣任选其一（可拔出），放在您的钥匙扣上，您也是带刀出行的侠客啦！','https://gw.alicdn.com/imgextra/i1/2210866654775/O1CN01B5oeXg1l903XJH0aB_!!2210866654775.jpg_Q75.jpg_.webp'),
(42,'未知','三国全面战争国区STEAM激活码',78.00,999,'三国全面战争国区STEAM激活码，很好的全战作品，使我的屏幕旋转，爱来自美国❤','https://img.alicdn.com/imgextra/i1/704871240/O1CN01OAdeD21L1y0NMwx9Q_!!704871240.jpg'),
(43,'未知','战锤3全面战争Steam国区激活码',125.00,999,'战锤3全面战争Steam国区激活码，很好的全战游戏，使我陷入混沌，爱来自震旦~','https://img.alicdn.com/imgextra/i1/704871240/O1CN012kSn9F1L1xr9pvtdA_!!704871240.png');
/*!40000 ALTER TABLE `Products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TeamMembers`
--

DROP TABLE IF EXISTS `TeamMembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `TeamMembers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `qq` varchar(60) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `microphone` varchar(10) DEFAULT NULL,
  `company` varchar(10) DEFAULT NULL,
  `know` varchar(200) DEFAULT NULL,
  `timelength` varchar(10) DEFAULT NULL,
  `disposition` varchar(200) DEFAULT NULL,
  `timeonline` varchar(200) DEFAULT NULL,
  `favoritegames` varchar(200) DEFAULT NULL,
  `pastteams` varchar(200) DEFAULT NULL,
  `position` varchar(200) DEFAULT NULL,
  `behavior` varchar(200) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TeamMembers`
--

LOCK TABLES `TeamMembers` WRITE;
/*!40000 ALTER TABLE `TeamMembers` DISABLE KEYS */;
INSERT INTO `TeamMembers` VALUES
(9,'test','111110911',NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'无',NULL,'2025-04-01 14:50:44'),
(10,'borgo','1231112',NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'无',NULL,'2025-04-01 14:51:06'),
(11,'jhddd','132130923',NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'无',NULL,'2025-04-01 14:51:18');
/*!40000 ALTER TABLE `TeamMembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `passwd` varchar(60) NOT NULL,
  `tag` varchar(60) DEFAULT 'members',
  `ranks` varchar(10) DEFAULT NULL,
  `company` varchar(10) DEFAULT NULL,
  `kills` int(11) DEFAULT 0,
  `attendance` int(11) DEFAULT 0,
  `balance` decimal(10,2) DEFAULT 0.00,
  `userpic` varchar(100) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES
(1,'JiangHuDao','fcea920f7412b5da7be0cf42b8c93759','Admin','QH','SQ',1538,172,120.00,'http://localhost:9000/greatming/cc17a4cbf9e346c1b585718f1bfbe9d1.png','2024-08-01 17:42:00','2025-03-26 20:27:27'),
(2,'borgo','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','SQ',1112,147,78.00,NULL,'2024-08-01 17:42:00','2024-08-01 17:42:00'),
(3,'Iris','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SQ',320,59,15.00,NULL,'2024-08-01 17:42:01','2024-08-01 17:42:01'),
(4,'OsmanSudan','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','SQ',524,131,22.00,NULL,'2024-08-01 17:42:01','2024-08-01 17:42:01'),
(5,'HongZhi','e10adc3949ba59abbe56e057f20f883e','NewPlayer','DZH','SQ',321,106,17.00,NULL,'2024-08-01 17:42:01','2024-08-01 17:42:01'),
(6,'Nick','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SQ',354,82,36.00,NULL,'2024-08-01 17:42:02','2024-08-01 17:42:02'),
(7,'C_hake','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','SQ',1601,125,110.00,NULL,'2024-08-01 17:42:02','2024-08-01 17:42:02'),
(8,'badan','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SQ',721,113,23.00,NULL,'2024-08-01 17:42:02','2024-08-01 17:42:02'),
(9,'huoqubing','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','WJ',433,67,36.00,NULL,'2024-08-01 17:42:03','2024-08-01 17:42:03'),
(10,'Add','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SQ',999,88,4.00,NULL,'2024-08-01 17:42:03','2024-08-01 17:42:03'),
(11,'RogersJam','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',6,2,0.00,NULL,'2024-08-01 17:42:04','2024-08-01 17:42:04'),
(12,'janson','7ba0e31f3bcedc81d8fd65d45b3912eb','NewPlayer','YB[I]','SQ',259,22,4.00,NULL,'2024-08-01 17:42:04','2024-08-09 20:25:08'),
(13,'BeiHu','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',80,7,0.00,NULL,'2024-08-01 17:42:05','2024-08-01 17:42:05'),
(14,'dadada','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',32,4,0.00,NULL,'2024-08-01 17:42:05','2024-08-01 17:42:05'),
(15,'hanphlay','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SQ',46,12,0.00,NULL,'2024-08-01 17:42:05','2024-08-01 17:42:05'),
(16,'PBONE','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','SQ',419,66,0.00,NULL,'2024-08-01 17:42:06','2024-08-01 17:42:06'),
(17,'T','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SQ',120,31,0.00,NULL,'2024-08-01 17:42:06','2024-08-01 17:42:06'),
(18,'chuanjianguo','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SQ',32,15,0.00,NULL,'2024-08-01 17:42:06','2024-08-01 17:42:06'),
(19,'Dabai','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SQ',71,17,0.00,NULL,'2024-08-01 17:42:07','2024-08-01 17:42:07'),
(20,'Katrina','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SQ',322,92,0.00,NULL,'2024-08-01 17:42:07','2024-08-01 17:42:07'),
(21,'baluga','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SQ',79,13,0.00,NULL,'2024-08-01 17:42:08','2024-08-01 17:42:08'),
(22,'huoqiang','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SQ',75,10,0.00,NULL,'2024-08-01 17:42:08','2024-08-01 17:42:08'),
(23,'Lutiya','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SQ',220,95,0.00,NULL,'2024-08-01 17:42:09','2024-08-01 17:42:09'),
(24,'power','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SQ',28,13,0.00,NULL,'2024-08-01 17:42:09','2024-08-01 17:42:09'),
(25,'batboy','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',0,0,0.00,NULL,'2024-08-01 17:42:10','2024-08-01 17:42:10'),
(26,'baijiaofei','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SQ',109,33,0.00,NULL,'2024-08-01 17:42:10','2024-08-01 17:42:10'),
(27,'111','e10adc3949ba59abbe56e057f20f883e','NewPlayer','DW[II]','SJP',5541,296,134.00,NULL,'2024-08-01 17:42:11','2024-08-01 17:42:11'),
(28,'Gustav','e10adc3949ba59abbe56e057f20f883e','NewPlayer','ZH','SJ',1591,278,139.00,NULL,'2024-08-01 17:42:11','2024-08-01 17:42:11'),
(29,'9527','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJP',534,106,57.00,NULL,'2024-08-01 17:42:11','2024-08-01 17:42:11'),
(30,'SN','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJ',1104,174,93.00,NULL,'2024-08-01 17:42:12','2024-08-01 17:42:12'),
(31,'GMRN','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','SJP',1189,168,15.00,NULL,'2024-08-01 17:42:12','2024-08-01 17:42:12'),
(32,'free','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',468,62,30.00,NULL,'2024-08-01 17:42:13','2024-08-01 17:42:13'),
(33,'Tiga','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',478,60,24.00,NULL,'2024-08-01 17:42:13','2024-08-01 17:42:13'),
(34,'SBA','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','SJ',561,142,65.00,NULL,'2024-08-01 17:42:43','2024-08-01 17:42:43'),
(35,'LIUMAO','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',137,49,22.00,NULL,'2024-08-01 17:42:44','2024-08-01 17:42:44'),
(36,'Lanna','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','SJ',976,131,94.00,NULL,'2024-08-01 17:42:44','2024-08-01 17:42:44'),
(37,'feng','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',204,26,7.00,NULL,'2024-08-01 17:42:45','2024-08-01 17:42:45'),
(38,'XB','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','SJ',1221,242,59.00,NULL,'2024-08-01 17:42:45','2024-08-01 17:42:45'),
(39,'Stont','e10adc3949ba59abbe56e057f20f883e','NewPlayer','CH','SJP',1099,196,68.00,NULL,'2024-08-01 17:42:45','2024-08-01 17:42:45'),
(40,'HIV','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',42,14,0.00,NULL,'2024-08-01 17:42:46','2024-08-01 17:42:46'),
(41,'ssss','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',90,18,7.00,NULL,'2024-08-01 17:42:46','2024-08-01 17:42:46'),
(42,'KAI','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SJ',371,89,0.00,NULL,'2024-08-01 17:42:47','2024-08-01 17:42:47'),
(43,'paoxiao','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',15,8,0.00,NULL,'2024-08-01 17:42:47','2024-08-01 17:42:47'),
(44,'weiliang','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJ',139,33,9.00,NULL,'2024-08-01 17:42:47','2024-08-01 17:42:47'),
(45,'Rapier','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',4,2,0.00,NULL,'2024-08-01 17:42:48','2024-08-01 17:42:48'),
(46,'ANYA','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',30,3,1.00,NULL,'2024-08-01 17:42:48','2024-08-01 17:42:48'),
(47,'MinghuN','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',18,10,0.00,NULL,'2024-08-01 17:42:49','2024-08-01 17:42:49'),
(48,'danzhu','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,0,0.00,NULL,'2024-08-01 17:42:49','2024-08-01 17:42:49'),
(49,'big_ass','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',22,6,0.00,NULL,'2024-08-01 17:42:50','2024-08-01 17:42:50'),
(50,'KaLian','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',20,8,0.00,NULL,'2024-08-01 17:42:50','2024-08-01 17:42:50'),
(51,'233333','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',5,2,1.00,NULL,'2024-08-01 17:42:50','2024-08-01 17:42:50'),
(52,'chenxuran','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,2,0.00,NULL,'2024-08-01 17:42:51','2024-08-01 17:42:51'),
(53,'monster','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',2,1,0.00,NULL,'2024-08-01 17:42:51','2024-08-01 17:42:51'),
(54,'adawdwa','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,1,2.00,NULL,'2024-08-01 17:42:51','2024-08-01 17:42:51'),
(55,'guchen','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','SJ',170,105,0.00,NULL,'2024-08-01 17:42:52','2024-08-01 17:42:52'),
(56,'qbc','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',1,2,0.00,NULL,'2024-08-01 17:42:52','2024-08-01 17:42:52'),
(57,'123','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',83,31,0.00,NULL,'2024-08-01 17:42:52','2024-08-01 17:42:52'),
(58,'AK47','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',15,8,0.00,NULL,'2024-08-01 17:42:53','2024-08-01 17:42:53'),
(59,'liuzongmin','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',10,13,0.00,NULL,'2024-08-01 17:42:53','2024-08-01 17:42:53'),
(60,'SUN','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJP',132,25,0.00,NULL,'2024-08-01 17:42:54','2024-08-01 17:42:54'),
(61,'Sleepless','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJ',48,26,0.00,NULL,'2024-08-01 17:42:54','2024-08-01 17:42:54'),
(62,'tiepao','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SJ',245,94,0.00,NULL,'2024-08-01 17:42:54','2024-08-01 17:42:54'),
(63,'MESSI','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',19,15,0.00,NULL,'2024-08-01 17:42:55','2024-08-01 17:42:55'),
(64,'xiaochuan','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SJ',147,53,0.00,NULL,'2024-08-01 17:42:55','2024-08-01 17:42:55'),
(65,'LVP','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,2,0.00,NULL,'2024-08-01 17:42:56','2024-08-01 17:42:56'),
(66,'hanhan','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',1,2,0.00,NULL,'2024-08-01 17:42:56','2024-08-01 17:42:56'),
(67,'Danta','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',2,1,0.00,NULL,'2024-08-01 17:42:57','2024-08-01 17:42:57'),
(68,'CTU','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',24,19,0.00,NULL,'2024-08-01 17:42:57','2024-08-01 17:42:57'),
(69,'Zhengde','e10adc3949ba59abbe56e057f20f883e','NewPlayer','Gnl','SJ',781,196,71.00,NULL,'2024-08-01 17:42:57','2024-08-01 17:42:57'),
(70,'xingyun','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',19,8,0.00,NULL,'2024-08-01 17:42:58','2024-08-01 17:42:58'),
(71,'theworld','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',3,3,0.00,NULL,'2024-08-01 17:42:58','2024-08-01 17:42:58'),
(72,'AH0','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJ',13,5,0.00,NULL,'2024-08-01 17:42:59','2024-08-01 17:42:59'),
(73,'ELTV','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',2,2,0.00,NULL,'2024-08-01 17:43:00','2024-08-01 17:43:00'),
(74,'Taicheng','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',13,7,0.00,NULL,'2024-08-01 17:43:00','2024-08-01 17:43:00'),
(75,'aaa','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,1,0.00,NULL,'2024-08-01 17:43:01','2024-08-01 17:43:01'),
(76,'MasterWang','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',4,1,0.00,NULL,'2024-08-01 17:43:01','2024-08-01 17:43:01'),
(77,'LUWEICAO','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,1,0.00,NULL,'2024-08-01 17:43:02','2024-08-01 17:43:02'),
(78,'cc','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',2,5,0.00,NULL,'2024-08-01 17:43:02','2024-08-01 17:43:02'),
(79,'qiguai','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJ',18,1,0.00,NULL,'2024-08-01 17:43:02','2024-08-01 17:43:02'),
(80,'FMH','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SJ',211,59,9.00,NULL,'2024-08-01 17:43:03','2024-08-01 17:43:03'),
(81,'Henry','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',8,2,0.00,NULL,'2024-08-01 17:43:03','2024-08-01 17:43:03'),
(82,'JJYY','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJ',37,8,0.00,NULL,'2024-08-01 17:43:04','2024-08-01 17:43:04'),
(83,'sucha','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',9,3,0.00,NULL,'2024-08-01 17:43:04','2024-08-01 17:43:04'),
(84,'sunbod','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,1,0.00,NULL,'2024-08-01 17:43:04','2024-08-01 17:43:04'),
(85,'Wangyang','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',4,2,0.00,NULL,'2024-08-01 17:43:05','2024-08-01 17:43:05'),
(86,'Lion','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SJP',96,20,0.00,NULL,'2024-08-01 17:43:05','2024-08-01 17:43:05'),
(87,'Sonny','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',1,1,0.00,NULL,'2024-08-01 17:43:06','2024-08-01 17:43:06'),
(88,'Zick','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',2,1,0.00,NULL,'2024-08-01 17:43:06','2024-08-01 17:43:06'),
(89,'jty','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',1,1,0.00,NULL,'2024-08-01 17:43:07','2024-08-01 17:43:07'),
(90,'XCF','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJP',81,28,0.00,NULL,'2024-08-01 17:43:08','2024-08-01 17:43:08'),
(91,'121g','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',2,2,0.00,NULL,'2024-08-01 17:43:08','2024-08-01 17:43:08'),
(92,'Twobad','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',10,3,0.00,NULL,'2024-08-01 17:43:08','2024-08-01 17:43:08'),
(93,'gg','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',10,2,0.00,NULL,'2024-08-01 17:43:09','2024-08-01 17:43:09'),
(94,'cybercharlie','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','SJ',38,16,0.00,NULL,'2024-08-01 17:43:09','2024-08-01 17:43:09'),
(95,'sihio','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',4,1,0.00,NULL,'2024-08-01 17:43:10','2024-08-01 17:43:10'),
(96,'Deemo','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',1,0,0.00,NULL,'2024-08-01 17:43:10','2024-08-01 17:43:10'),
(97,'Topsolo','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',4,0,0.00,NULL,'2024-08-01 17:43:10','2024-08-01 17:43:10'),
(98,'Laosun','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,0,0.00,NULL,'2024-08-01 17:43:11','2024-08-01 17:43:11'),
(99,'xingba','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',11,2,0.00,NULL,'2024-08-01 17:43:11','2024-08-01 17:43:11'),
(100,'ours','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,0,0.00,NULL,'2024-08-01 17:43:11','2024-08-01 17:43:11'),
(101,'xue','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,0,0.00,NULL,'2024-08-01 17:43:12','2024-08-01 17:43:12'),
(102,'xuanxuan','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,0,0.00,NULL,'2024-08-01 17:43:12','2024-08-01 17:43:12'),
(103,'liuzi','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',0,0,0.00,NULL,'2024-08-01 17:43:13','2024-08-01 17:43:13'),
(104,'0459','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',448,69,41.00,NULL,'2024-08-01 17:43:13','2024-08-01 17:43:13'),
(105,'Constantin','e10adc3949ba59abbe56e057f20f883e','NewPlayer','QH','WJ',477,97,76.00,NULL,'2024-08-01 17:43:14','2024-08-01 17:43:14'),
(106,'MQM','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','WJ',52,21,12.00,NULL,'2024-08-01 17:43:14','2024-08-01 17:43:14'),
(107,'mikasa','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',434,90,41.00,NULL,'2024-08-01 17:43:15','2024-08-01 17:43:15'),
(108,'N','e10adc3949ba59abbe56e057f20f883e','NewPlayer','ZH','WJ',1850,239,125.00,NULL,'2024-08-01 17:43:15','2024-08-01 17:43:15'),
(109,'lumos','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',351,58,22.00,NULL,'2024-08-01 17:43:15','2024-08-01 17:43:15'),
(110,'KOKOMI','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','WJ',118,22,8.00,NULL,'2024-08-01 17:43:16','2024-08-01 17:43:16'),
(111,'Zach','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','WJ',270,58,23.00,NULL,'2024-08-01 17:43:16','2024-08-01 17:43:16'),
(112,'QQ','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',333,84,6.00,NULL,'2024-08-01 17:43:17','2024-08-01 17:43:17'),
(113,'Deng','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',1109,96,61.00,NULL,'2024-08-01 17:43:18','2024-08-01 17:43:18'),
(114,'Neil','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',281,52,0.00,NULL,'2024-08-01 17:43:19','2024-08-01 17:43:19'),
(115,'fgio','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',175,43,6.00,NULL,'2024-08-01 17:43:19','2024-08-01 17:43:19'),
(116,'Yongle','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','WJ',327,61,1.00,NULL,'2024-08-01 17:43:20','2024-08-01 17:43:20'),
(117,'shuke','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',25,7,0.00,NULL,'2024-08-01 17:43:20','2024-08-01 17:43:20'),
(118,'huanghuibin','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',10,4,2.00,NULL,'2024-08-01 17:43:20','2024-08-01 17:43:20'),
(119,'shuguang','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',13,3,1.00,NULL,'2024-08-01 17:43:22','2024-08-01 17:43:22'),
(120,'WP31','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',77,5,1.00,NULL,'2024-08-01 17:43:23','2024-08-01 17:43:23'),
(121,'Rommel','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',10,1,0.00,NULL,'2024-08-01 17:43:25','2024-08-01 17:43:25'),
(122,'mnls','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',149,52,8.00,NULL,'2024-08-01 17:43:25','2024-08-01 17:43:25'),
(123,'noarinxx','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',12,6,0.00,NULL,'2024-08-01 17:43:25','2024-08-01 17:43:25'),
(124,'Musashi','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',16,6,0.00,NULL,'2024-08-01 17:43:26','2024-08-01 17:43:26'),
(125,'Forodaw','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','WJ',598,339,0.00,NULL,'2024-08-01 17:43:26','2024-08-01 17:43:26'),
(126,'WDY','e10adc3949ba59abbe56e057f20f883e','NewPlayer','DW[II]','WJ',989,125,17.00,NULL,'2024-08-01 17:43:27','2024-08-01 17:43:27'),
(127,'ggy','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',132,39,0.00,NULL,'2024-08-01 17:43:27','2024-08-01 17:43:27'),
(128,'M_Joestar','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',138,37,0.00,NULL,'2024-08-01 17:43:27','2024-08-01 17:43:27'),
(129,'Jianwen','e10adc3949ba59abbe56e057f20f883e','NewPlayer','TZ','WJ',62,11,0.00,NULL,'2024-08-01 17:43:28','2024-08-01 17:43:28'),
(130,'Tggundem','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',28,7,0.00,NULL,'2024-08-01 17:43:28','2024-08-01 17:43:28'),
(131,'moxuan','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',10,9,0.00,NULL,'2024-08-01 17:43:28','2024-08-01 17:43:28'),
(132,'BoxWall','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',2,1,0.00,NULL,'2024-08-01 17:43:29','2024-08-01 17:43:29'),
(133,'Spirit','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',8,4,0.00,NULL,'2024-08-01 17:43:30','2024-08-01 17:43:30'),
(134,'machinery','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',58,25,0.00,NULL,'2024-08-01 17:43:36','2024-08-01 17:43:36'),
(135,'konghao','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',14,5,0.00,NULL,'2024-08-01 17:43:36','2024-08-01 17:43:36'),
(136,'NB_MAN','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',17,3,0.00,NULL,'2024-08-01 17:43:37','2024-08-01 17:43:37'),
(137,'biglin','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',7,3,0.00,NULL,'2024-08-01 17:43:37','2024-08-01 17:43:37'),
(138,'v7orange','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',1,2,0.00,NULL,'2024-08-01 17:43:38','2024-08-01 17:43:38'),
(139,'WQ','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',0,2,0.00,NULL,'2024-08-01 17:43:38','2024-08-01 17:43:38'),
(140,'Seran','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',6,5,0.00,NULL,'2024-08-01 17:43:38','2024-08-01 17:43:38'),
(141,'Ivanhoe','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',1,4,0.00,NULL,'2024-08-01 17:43:39','2024-08-01 17:43:39'),
(142,'Gabendie','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',6,4,0.00,NULL,'2024-08-01 17:43:39','2024-08-01 17:43:39'),
(143,'Dou','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',10,1,0.00,NULL,'2024-08-01 17:43:39','2024-08-01 17:43:39'),
(144,'Fyy3243','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',15,3,0.00,NULL,'2024-08-01 17:43:40','2024-08-01 17:43:40'),
(145,'strickyfinger','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',14,5,0.00,NULL,'2024-08-01 17:43:40','2024-08-01 17:43:40'),
(146,'Anibal','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',16,7,0.00,NULL,'2024-08-01 17:43:41','2024-08-01 17:43:41'),
(147,'Starff','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',0,0,0.00,NULL,'2024-08-01 17:43:41','2024-08-01 17:43:41'),
(148,'Belief','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',2,1,0.00,NULL,'2024-08-01 17:43:41','2024-08-01 17:43:41'),
(149,'Vigil','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',0,0,0.00,NULL,'2024-08-01 17:43:42','2024-08-01 17:43:42'),
(150,'Noobslayer','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',15,3,0.00,NULL,'2024-08-01 17:43:45','2024-08-01 17:43:45'),
(151,'yuyu','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',119,48,3.00,NULL,'2024-08-01 17:43:45','2024-08-01 17:43:45'),
(152,'Rider','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','WJ',61,18,0.00,NULL,'2024-08-01 17:43:46','2024-08-01 17:43:46'),
(153,'XJB','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',5,3,0.00,NULL,'2024-08-01 17:43:46','2024-08-01 17:43:46'),
(154,'moran','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',3,3,0.00,NULL,'2024-08-01 17:43:47','2024-08-01 17:43:47'),
(155,'Polina','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',0,0,0.00,NULL,'2024-08-01 17:43:47','2024-08-01 17:43:47'),
(156,'3ok','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','WJ',119,18,0.00,NULL,'2024-08-01 17:43:47','2024-08-01 17:43:47'),
(157,'Angela','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',0,2,0.00,NULL,'2024-08-01 17:43:48','2024-08-01 17:43:48'),
(158,'weilong','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',6,3,0.00,NULL,'2024-08-01 17:43:48','2024-08-01 17:43:48'),
(159,'oit','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',24,4,0.00,NULL,'2024-08-01 17:43:49','2024-08-01 17:43:49'),
(160,'MMX','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',36,13,2.00,NULL,'2024-08-01 17:43:49','2024-08-01 17:43:49'),
(161,'klase','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',15,4,1.00,NULL,'2024-08-01 17:43:49','2024-08-01 17:43:49'),
(162,'owo','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',4,2,0.00,NULL,'2024-08-01 17:43:50','2024-08-01 17:43:50'),
(163,'xiaoliu','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',2,2,0.00,NULL,'2024-08-01 17:43:50','2024-08-01 17:43:50'),
(164,'Aaili','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SQ',1194,81,55.00,NULL,'2024-08-01 17:43:51','2024-08-01 17:43:51'),
(165,'MURONG','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SQ',892,54,32.00,NULL,'2024-08-01 17:43:51','2024-08-01 17:43:51'),
(166,'HWHWHW','e10adc3949ba59abbe56e057f20f883e','NewPlayer','DZH','WJ',1273,190,95.00,NULL,'2024-08-01 17:43:52','2024-08-01 17:43:52'),
(167,'range','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','WJ',191,27,16.00,NULL,'2024-08-01 17:43:52','2024-08-01 17:43:52'),
(168,'JiangLi','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',22,4,2.00,NULL,'2024-08-01 17:43:53','2024-08-01 17:43:53'),
(169,'CQD','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','WJ',412,31,20.00,NULL,'2024-08-01 17:43:53','2024-08-01 17:43:53'),
(170,'ponalun','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',58,8,5.00,NULL,'2024-08-01 17:43:54','2024-08-01 17:43:54'),
(171,'Aoisorae','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',99,15,5.00,NULL,'2024-08-01 17:43:55','2024-08-01 17:43:55'),
(172,'bloeall','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',441,37,25.00,NULL,'2024-08-01 17:43:55','2024-08-01 17:43:55'),
(173,'anknk','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',24,6,2.00,NULL,'2024-08-01 17:43:56','2024-08-01 17:43:56'),
(174,'CCChromium','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',52,10,4.00,NULL,'2024-08-01 17:43:56','2024-08-01 17:43:56'),
(175,'Walt','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','WJ',0,2,0.00,NULL,'2024-08-01 17:43:56','2024-08-01 17:43:56'),
(176,'DJH','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',826,27,17.00,NULL,'2024-08-01 17:43:57','2024-08-01 17:43:57'),
(177,'jk','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',84,15,7.00,NULL,'2024-08-01 17:43:57','2024-08-01 17:43:57'),
(178,'Cavalry','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',29,4,2.00,NULL,'2024-08-01 17:43:57','2024-08-01 17:43:57'),
(179,'smnz','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WS',88,10,2.00,NULL,'2024-08-01 17:43:58','2024-08-01 17:43:58'),
(180,'TaiHao','e10adc3949ba59abbe56e057f20f883e','NewPlayer','BH','SJP',608,97,29.00,NULL,'2024-08-01 17:43:58','2024-08-01 17:43:58'),
(181,'Waiguoren','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',234,12,7.00,NULL,'2024-08-01 17:43:59','2024-08-01 17:43:59'),
(182,'pplove','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[I]','SJ',147,25,12.00,NULL,'2024-08-01 17:43:59','2024-08-01 17:43:59'),
(183,'Chengeng','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SQ',28,8,2.00,NULL,'2024-08-01 17:43:59','2024-08-01 17:43:59'),
(184,'himf','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',12,5,1.00,NULL,'2024-08-01 17:44:00','2024-08-01 17:44:00'),
(185,'juyi','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SQ',204,5,2.00,NULL,'2024-08-01 17:44:00','2024-08-01 17:44:00'),
(186,'xx114514xx','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',86,8,6.00,NULL,'2024-08-01 17:44:01','2024-08-01 17:44:01'),
(187,'StarrySky','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','SJ',18,2,0.00,NULL,'2024-08-01 17:44:01','2024-08-01 17:44:01'),
(188,'Eternal','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',13,3,1.00,NULL,'2024-08-01 17:44:01','2024-08-01 17:44:01'),
(189,'Zhanji','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',91,10,5.00,NULL,'2024-08-01 17:44:02','2024-08-01 17:44:02'),
(190,'HaMa','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',22,2,0.00,NULL,'2024-08-01 17:44:02','2024-08-01 17:44:02'),
(191,'Powre','e10adc3949ba59abbe56e057f20f883e','NewPlayer','XW','WJ',2,1,0.00,NULL,'2024-08-01 17:44:03','2024-08-01 17:44:03'),
(192,'asuka','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[III]','SJ',74,3,2.00,NULL,'2024-08-01 17:44:03','2024-08-01 17:44:03'),
(193,'Romo','e10adc3949ba59abbe56e057f20f883e','NewPlayer','YB[II]','WJ',106,9,4.00,NULL,'2024-08-01 17:44:04','2024-08-01 17:44:04'),
(194,'Gudrian','e10adc3949ba59abbe56e057f20f883e','NewPlayer','JYW','SJ',1026,84,53.00,NULL,'2024-08-01 17:50:24','2024-08-01 17:50:24');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `greatminglogs`
--

DROP TABLE IF EXISTS `greatminglogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `greatminglogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `name` varchar(60) NOT NULL,
  `kills` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `greatminglogs`
--

LOCK TABLES `greatminglogs` WRITE;
/*!40000 ALTER TABLE `greatminglogs` DISABLE KEYS */;
INSERT INTO `greatminglogs` VALUES
(1,'2025-03-17 00:00:00','Lanna',3),
(2,'2025-03-17 00:00:00','Add',6),
(3,'2025-03-17 00:00:00','jk',16),
(4,'2025-03-17 00:00:00','Gudrian',24),
(5,'2025-03-17 00:00:00','DJH',15),
(6,'2025-03-17 00:00:00','borgo',6),
(7,'2025-03-17 00:00:00','Nick',7),
(8,'2025-03-17 00:00:00','mero',8),
(9,'2025-03-17 00:00:00','MURONG',11),
(10,'2025-03-17 00:00:00','bloeall',3),
(11,'2025-03-17 00:00:00','HELLME',12),
(12,'2025-03-17 00:00:00','pplove',2),
(13,'2025-03-16 00:00:00','badan',10),
(14,'2025-03-16 00:00:00','HWHWHW',1),
(15,'2025-03-16 00:00:00','mero',17),
(16,'2025-03-16 00:00:00','Constantin',3),
(17,'2025-03-16 00:00:00','MURONG',12),
(18,'2025-03-16 00:00:00','Fanefg',18),
(19,'2025-03-16 00:00:00','C_hake',19),
(20,'2025-03-16 00:00:00','xunjian',5),
(21,'2025-03-16 00:00:00','JiangHuDao',24),
(22,'2025-03-16 00:00:00','111',89),
(23,'2025-03-16 00:00:00','StarrySky',0),
(24,'2025-03-16 00:00:00','HongZhi',7),
(25,'2025-03-16 00:00:00','borgo',26),
(26,'2025-03-16 00:00:00','lyc',10),
(27,'2025-03-16 00:00:00','bloeall',18),
(28,'2025-03-16 00:00:00','SN',12),
(29,'2025-03-15 00:00:00','Gudrian',8),
(30,'2025-03-15 00:00:00','DJH',6),
(31,'2025-03-15 00:00:00','HWHWHW',14),
(32,'2025-03-15 00:00:00','Constantin',3),
(33,'2025-03-15 00:00:00','MURONG',7),
(34,'2025-03-15 00:00:00','Tiga',4),
(35,'2025-03-15 00:00:00','XB',9),
(36,'2025-03-15 00:00:00','Free',11),
(37,'2025-03-15 00:00:00','xx114514xx',5),
(38,'2025-03-15 00:00:00','waiguoren',4),
(39,'2025-03-15 00:00:00','C_hake',15),
(40,'2025-03-15 00:00:00','Lanna',1),
(41,'2025-03-15 00:00:00','JiangHuDao',3),
(42,'2025-03-15 00:00:00','111',12),
(43,'2025-03-15 00:00:00','StarrySky',5),
(44,'2025-03-15 00:00:00','HongZhi',1),
(45,'2025-03-15 00:00:00','ssss',3),
(46,'2025-03-15 00:00:00','bloeall',9),
(47,'2025-03-15 00:00:00','Deng',12),
(48,'2025-03-15 00:00:00','mnls',4),
(49,'2025-03-08 00:00:00','lumos',13),
(50,'2025-03-08 00:00:00','Klase',3),
(51,'2025-03-08 00:00:00','Gudrian',10),
(52,'2025-03-08 00:00:00','DJH',8),
(53,'2025-03-08 00:00:00','Constantin',7),
(54,'2025-03-08 00:00:00','MURONG',12),
(55,'2025-03-08 00:00:00','Tiga',5),
(56,'2025-03-08 00:00:00','juyi',8),
(57,'2025-03-08 00:00:00','Gustav',4),
(58,'2025-03-08 00:00:00','xx114514xx',4),
(59,'2025-03-08 00:00:00','waiguoren',19),
(60,'2025-03-08 00:00:00','C_hake',10),
(61,'2025-03-08 00:00:00','fks',9),
(62,'2025-03-08 00:00:00','ManMan',3),
(63,'2025-03-08 00:00:00','Lanna',9),
(64,'2025-03-08 00:00:00','JiangHuDao',22),
(65,'2025-03-08 00:00:00','111',42),
(66,'2025-03-08 00:00:00','borgo',2),
(67,'2025-03-08 00:00:00','CQD',10),
(68,'2025-03-08 00:00:00','bloeall',7),
(69,'2025-03-08 00:00:00','mnls',4),
(70,'2025-03-08 00:00:00','SN',2),
(71,'2025-03-07 00:00:00','lumos',10),
(72,'2025-03-07 00:00:00','jk',8),
(73,'2025-03-07 00:00:00','Gudrian',14),
(74,'2025-03-07 00:00:00','DJH',12),
(75,'2025-03-07 00:00:00','pplove',5),
(76,'2025-03-07 00:00:00','N',22),
(77,'2025-03-07 00:00:00','C_hake',18),
(78,'2025-03-07 00:00:00','111',82),
(79,'2025-03-07 00:00:00','JiangHuDao',11),
(80,'2025-03-07 00:00:00','CQD',3),
(81,'2025-03-07 00:00:00','mnls',4),
(82,'2025-03-07 00:00:00','SN',2),
(83,'2025-03-07 00:00:00','LIUMAO',5),
(84,'2025-03-07 00:00:00','HWHWHW',1),
(85,'2025-03-07 00:00:00','Constantin',6),
(86,'2025-03-07 00:00:00','MURONG',29),
(87,'2025-03-07 00:00:00','Aaili',1),
(88,'2025-03-07 00:00:00','MQM',5),
(89,'2025-03-07 00:00:00','XB',8),
(90,'2025-03-07 00:00:00','Gustav',11),
(91,'2025-03-07 00:00:00','xx114514xx',7),
(92,'2025-03-07 00:00:00','waiguoren',26),
(93,'2025-03-07 00:00:00','Lanna',14),
(94,'2025-03-07 00:00:00','borgo',8),
(95,'2025-03-07 00:00:00','bloeall',14),
(96,'2025-03-07 00:00:00','Deng',12),
(97,'2025-03-07 00:00:00','0459',23),
(98,'2025-03-07 00:00:00','Mikasa',4),
(99,'2025-03-01 00:00:00','badan',23),
(100,'2025-03-01 00:00:00','lumos',7),
(101,'2025-03-01 00:00:00','jk',2),
(102,'2025-03-01 00:00:00','Zhanji',2),
(103,'2025-03-01 00:00:00','Gudrian',21),
(104,'2025-03-01 00:00:00','DJH',35),
(105,'2025-03-01 00:00:00','HWHWHW',4),
(106,'2025-03-01 00:00:00','Constantin',8),
(107,'2025-03-01 00:00:00','pplove',7),
(108,'2025-03-01 00:00:00','range',10),
(109,'2025-03-01 00:00:00','xx114514xx',18),
(110,'2025-03-01 00:00:00','waiguoren',18),
(111,'2025-03-01 00:00:00','C_hake',8),
(112,'2025-03-01 00:00:00','Lanna',35),
(113,'2025-03-01 00:00:00','111',8),
(114,'2025-03-01 00:00:00','smnz',4),
(115,'2025-03-01 00:00:00','borgo',2),
(116,'2025-03-01 00:00:00','bloeall',4),
(117,'2025-03-01 00:00:00','Feng',10),
(118,'2025-03-01 00:00:00','Romo',2),
(119,'2025-03-01 00:00:00','Deng',18),
(120,'2025-03-01 00:00:00','Mikasa',8),
(121,'2025-03-01 00:00:00','LIUMAO',10);
/*!40000 ALTER TABLE `greatminglogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `productName` varchar(60) NOT NULL,
  `username` varchar(60) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sum` decimal(10,2) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-04-02 21:25:46
