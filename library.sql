-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` varchar(255) NOT NULL,
  `book_category` int(10) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `rent` decimal(10,2) DEFAULT NULL COMMENT '租金 按月算',
  `price` decimal(10,2) DEFAULT NULL,
  `public_time` datetime DEFAULT NULL,
  `supplier` int(10) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL,
  `img` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  KEY `b_category` (`book_category`) USING BTREE,
  KEY `b_supplier` (`supplier`) USING BTREE,
  CONSTRAINT `b_category` FOREIGN KEY (`book_category`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `b_supplier` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (' 9787500782087',8,'红楼梦','曹雪芹',NULL,140.20,NULL,8,197,'https://img1.xinhuashudian.com/bookbasepic/C/00432/97875007820871092956-fm.jpg'),(' 9787807657613',8,'小李飞刀','古龙',NULL,91.20,NULL,9,80,'https://img7.xinhuashudian.com/bookbasepic/C/01562/2508789-fm.jpg'),('977-8969-332',8,'西游记','江泽晖',NULL,108.40,NULL,1,100,'http://www.shicimingju.com/public/image/book/xiyouji.jpg'),('977-8969-333',8,'东游记','江泽晖',NULL,108.40,NULL,2,100,'http://www.kfzimg.com/G07/M00/27/C6/q4YBAFxsFe6ABeUPAAQR63h978U933_n.jpg'),('9787518951130',18,'糖尿病合并冠心病周迎生2019观点(精)/中国医学临床百家','周迎生',NULL,88.88,NULL,4,96,'/book/faceBook/9787518951130/2019070817114576593.jpg'),('9787518952380',29,'骨质疏松症邢小燕卜石2019观点(精)/中国医学临床百家','邢小燕//卜石',NULL,128.00,NULL,2,100,'https://img8.xinhuashudian.com/images/4537912-fm.jpg'),('9787519031572',11,'唐浩明谈曾国藩治国之道','唐浩明',NULL,56.02,NULL,2,75,'https://img2.xinhuashudian.com/images/4528652-fm.jpg'),('9787519036904',11,'孙毓敏评传/中国艺术家评传','李成伟',NULL,47.50,NULL,3,70,'https://img5.xinhuashudian.com/images/4534494-fm.jpg'),('9787519217860',14,'大手印浅释/佛法修证心要丛书','元音老人',NULL,76.00,NULL,9,80,'https://img4.xinhuashudian.com/images/3774088-fm.jpg'),('9787519257620',21,'柬埔寨语参考语法','钟楠',NULL,78.00,NULL,4,70,'https://img5.xinhuashudian.com/images/4533381-fm.jpg'),('9787519410018',19,'中华历史人物童谣：我们的核心价值观','姜宗福',NULL,39.80,NULL,2,65,'https://img1.xinhuashudian.com/images/2019/06/11/813adb12-a4de-4a5e-95cf-2e01a9f31226.jpg'),('9787519415273',17,'社区公共文化服务的广东实践与探索','李智勇',NULL,68.00,NULL,4,56,'https://img1.xinhuashudian.com/images/2019/06/18/748360cc-0352-4290-ac07-05a1464bf52d.jpg'),('9787519423117',9,'妈妈私语','张淑玲',NULL,27.00,NULL,6,80,'https://img1.xinhuashudian.com/images/2019/06/18/8e4c3017-1ea4-4d0d-909b-ca226986802c.jpg'),('9787519423148',9,'浩歌中华','曹永浩',NULL,36.00,NULL,8,50,'https://img1.xinhuashudian.com/images/2019/06/10/b0633805-767c-4db2-b8b7-8b384820e60f.jpg'),('9787519423537',13,'与法同行','江晓 郑盛平',NULL,48.00,NULL,5,85,'https://img1.xinhuashudian.com/images/2019/06/18/2deb7576-66e3-4383-8505-3a61f9a0f70b.jpg'),('9787519439784',17,'铜鼓传奇','黄坚',NULL,48.00,NULL,2,80,'https://img1.xinhuashudian.com/images/2019/06/19/a8910f93-e9c5-477f-97fd-7b772b12f81c.jpg'),('9787519440077',17,'微雕里的民族婚俗大观','严鹰',NULL,58.00,NULL,6,86,'https://img1.xinhuashudian.com/images/2019/06/18/54de2194-4ac2-4c20-b81a-3864d4b17d19.jpg'),('9787519445621',17,'瑶学论丛（第一辑）','中国瑶族文化传承研究中心',NULL,48.00,NULL,5,65,'https://img1.xinhuashudian.com/images/2019/06/18/75c66871-0cc4-495c-99a5-2a11a7096741.jpg'),('9787519448189',17,'锦时素韵——大朗民谣拾絮','叶淑帆',NULL,42.80,NULL,3,75,'https://img1.xinhuashudian.com/images/2019/06/19/86eda073-6bbb-4049-ad60-b5e1048455f2.jpg'),('9787519448509',9,'新丰古今诗词选','张京泉',NULL,118.50,NULL,3,100,'https://img1.xinhuashudian.com/images/2019/06/18/06bd88db-9f02-498b-951e-c68266d2c03a.jpg'),('9787519731144',13,'数字正义(当纠纷解决遇见互联网科技)(精)','(美)伊森·凯什//(以色列)奥娜·拉比诺维奇·艾尼',NULL,89.00,NULL,8,87,'https://img1.xinhuashudian.com/images/4531076-fm.jpg'),('9787519828240',28,'窑洞民居(精)/中国传统聚落与民居研究系列','北京大学聚落研究小组//北京建筑大学ADA研究中心',NULL,368.00,NULL,6,75,'https://img4.xinhuashudian.com/images/4544527-fm.jpg'),('9787520325295',21,'梵文古籍数字化生产流程管理研究','吴志勇',NULL,95.00,NULL,7,85,'https://img1.xinhuashudian.com/images/4323762-fm.jpg'),('9787520330435',16,'中国共产党文化自觉研究/兰州大学马克思主义学院马克思主义理论学术著作丛书','李睿',NULL,75.00,NULL,9,65,'https://img5.xinhuashudian.com/images/4591201-fm.jpg'),('9787520709248',18,'小熊和奇妙女巫(共6册美绘注音桥梁书)','任小霞',NULL,168.00,NULL,4,85,'https://img3.xinhuashudian.com/images/4560317-fm.jpg'),('9787520709637',16,'坚持底线思维(着力防范化解重大风险)','颜晓峰',NULL,68.00,NULL,2,62,'https://img9.xinhuashudian.com/images/4577544-fm.jpg'),('9787520710114',16,'诞生--共和国孕育的十个月','董伟',NULL,69.80,NULL,7,52,'https://img9.xinhuashudian.com/images/4543217-fm.jpg'),('9787520807234',11,'南怀瑾传','金鸿儒',NULL,46.55,NULL,3,80,'https://img6.xinhuashudian.com/images/4540488-fm.jpg'),('9787521306569',21,'剑桥国际英语教程(附光盘2测试用书第5版)','(新西兰)杰克·C.理查兹',NULL,18.00,NULL,6,80,'https://img6.xinhuashudian.com/images/4512467-fm.jpg'),('9787521408843',29,'沈芊绿医案/龙砂医学丛书','(清)沈金鳌',NULL,28.00,NULL,3,100,'https://img3.xinhuashudian.com/images/4537233-fm.jpg'),('9787521410501',29,'任应秋中医基础理论十讲','任应秋',NULL,39.00,NULL,10,70,'https://img3.xinhuashudian.com/images/4526623-fm.jpg'),('9787521700596',23,'重新定义公司(谷歌是如何运营的)(精)','(美)埃里克·施密特//乔纳森·罗森伯格//艾伦·伊格尔',NULL,69.80,NULL,7,90,'https://img9.xinhuashudian.com/images/4526363-fm.jpg'),('9787521701562',24,'慢慢变富','张居营',NULL,69.00,NULL,4,87,'https://img3.xinhuashudian.com/images/4526373-fm.jpg'),('9787521702415',23,'美国陷阱(如何通过非经济手段瓦解他国商业巨头)','(法)弗雷德里克·皮耶鲁齐//马修·阿伦',NULL,68.00,NULL,1,100,'https://img1.xinhuashudian.com/images/4512900-fm.jpg'),('9787521702576',25,'香料图解全书','(日)水野仁辅',NULL,88.00,NULL,10,66,'https://img8.xinhuashudian.com/images/4518619-fm.jpg'),('9787521703634',23,'硅谷帝国(商业巨头如何掌控经济与社会)(精)','(美)露西·格林',NULL,69.00,NULL,3,80,'https://img3.xinhuashudian.com/images/4538005-fm.jpg'),('9787534070471',10,'现代设计的先驱者(从威廉·莫里斯到沃尔特·格罗皮乌斯)(精)','(英)尼古拉斯·佩夫斯纳',NULL,159.60,NULL,3,100,'https://img3.xinhuashudian.com/images/4557463-fm.jpg'),('9787535449429',11,'吾家小史','余秋雨',NULL,55.10,NULL,2,100,'https://img4.xinhuashudian.com/images/4533929-fm.jpg'),('9787535461964',12,'中国文脉','余秋雨',NULL,64.60,NULL,8,75,'https://img7.xinhuashudian.com/images/4534079-fm.jpg'),('9787535685056',19,'希利尔讲绘画(给孩子的艺术启蒙课)','(美)维吉尔·莫里斯·希利尔著',NULL,58.00,NULL,4,85,'https://img7.xinhuashudian.com/images/4553878-fm.jpg'),('9787539496436',20,'英语同步书写能手(8上新目标听写版)','荆霄鹏',NULL,20.00,NULL,5,80,'https://img3.xinhuashudian.com/images/4329162-fm.jpg'),('9787539823188',20,'小学生同步写字课课练(3上新课标人教版配部编版教材)','肖月',NULL,20.00,NULL,4,85,'https://img3.xinhuashudian.com/images/4538511-fm.jpg'),('9787540489113',15,'差异优势','(美)约翰·C.马克斯维尔',NULL,45.00,NULL,8,80,'https://img7.xinhuashudian.com/images/4546057-fm.jpg'),('9787541149481',10,'以眼说话','(美)布鲁斯·布洛克',NULL,94.81,NULL,3,75,'https://img4.xinhuashudian.com/images/4536076-fm.jpg'),('9787543978317',11,'数学的奠基者','(美)迈克尔·J.布拉德利',NULL,42.75,NULL,2,92,'https://img1.xinhuashudian.com/images/4528430-fm.jpg'),('9787544199964',8,'流浪地球','刘慈欣/郝景芳',NULL,47.02,NULL,3,98,'https://img3.xinhuashudian.com/images/4523390-fm.jpg'),('9787544295737',8,'再见了，忍老师','东野圭吾',NULL,42.75,NULL,5,80,'https://img1.xinhuashudian.com/images/2019/06/27/f9300f3e-3073-4a6c-9160-aaf2aae0aff4.jpg'),('9787544489126',15,'游戏治疗/心理咨询与治疗系列丛书','蔡丹//沈勇强',NULL,48.00,NULL,10,70,'https://img9.xinhuashudian.com/images/4526578-fm.jpg'),('9787546175638',9,'剑南诗选','(南宋)陆游',NULL,34.20,NULL,4,90,'https://img7.xinhuashudian.com/images/4401737-fm.jpg'),('9787546206127',8,'鹿鼎记','金庸',NULL,129.20,NULL,5,100,'https://img5.xinhuashudian.com/bookbasepic/C/01856/2645960-fm.jpg'),('9787547023709',9,'繁星春水/春华秋实经典书系','冰心',NULL,18.81,NULL,4,70,'https://img6.xinhuashudian.com/bookbasepic/C/01591/2549455-fm.jpg'),('9787547431412',14,'老子与书画','旭宇//郗吉堂',NULL,88.00,NULL,8,70,'https://img4.xinhuashudian.com/images/4535336-fm.jpg'),('9787547608449',22,'洞见远胜创意(世界最富创意的广告公司BBDO)','(美)菲尔·杜森伯里',NULL,58.00,NULL,3,75,'https://img6.xinhuashudian.com/images/4544964-fm.jpg'),('9787548736103',27,'复杂荷载条件下桥上CRTSⅡ型板式无砟轨道无缝线路纵向力研究','张鹏飞',NULL,138.00,NULL,1,67,'https://img4.xinhuashudian.com/images/4540771-fm.jpg'),('9787548836063',19,'地质科学美绘本(共4册)/大教授小科普','(阿根廷)安德烈斯·福尔格拉',NULL,48.00,NULL,6,60,'https://img7.xinhuashudian.com/images/4529365-fm.jpg'),('9787548836070',19,'宇宙科学美绘本(共4册)/大教授小科普','(阿根廷)亚历山大·刚奇',NULL,64.00,NULL,9,100,'https://img1.xinhuashudian.com/images/4529364-fm.jpg'),('9787548836087',19,'生命科学美绘本(共4册)/大教授小科普','(阿根廷)宝拉·波巴拉',NULL,64.00,NULL,7,80,'https://img4.xinhuashudian.com/images/4529366-fm.jpg'),('9787548836094',19,'动物科学美绘本(共4册)/大教授小科普','(阿根廷)碧碧安娜·维拉',NULL,64.00,NULL,8,95,'https://img9.xinhuashudian.com/images/4529368-fm.jpg'),('9787549627691',22,'超级符号原理(精)','华杉//华楠',NULL,68.00,NULL,2,69,'https://img3.xinhuashudian.com/images/4538070-fm.jpg'),('978755028044',14,'道德经新解','唐汉',NULL,69.00,NULL,4,80,'https://img9.xinhuashudian.com/images/4528871-fm.jpg'),('9787550826700',10,'唐李阳冰谦卦碑/稀见历代名碑名帖','(唐)李阳冰',NULL,64.60,NULL,7,80,'https://img4.xinhuashudian.com/images/4539137-fm.jpg'),('9787551144667',26,'汉字图画书(精)/五味太郎启蒙系列','(日)五味太郎',NULL,49.80,NULL,4,95,'https://img5.xinhuashudian.com/images/4477878-fm.jpg'),('9787551315449',26,'妈妈孕期瑜伽(精)','(德)贝妮塔·阚提妮//凯琳·阿皮特-威斯',NULL,52.80,NULL,8,85,'https://img1.xinhuashudian.com/images/4408482-fm.jpg'),('9787551316286',26,'0-3岁宝宝健康成长宝典(精)','(德)比吉特·格鲍尔-泽斯特亨//安妮·普尔基宁//凯特琳·埃德尔曼',NULL,79.80,NULL,6,90,'https://img6.xinhuashudian.com/images/4530376-fm.jpg'),('9787552025163',14,'孔颜乐道(中国人的幸福心理学)','解真',NULL,48.00,NULL,8,100,'https://img6.xinhuashudian.com/images/4523763-fm.jpg'),('9787552026542',15,'我的孩子得了抑郁症：青少年抑郁家庭指南（第二版）','弗朗西斯·马克·蒙迪莫　帕特里克·凯利',NULL,59.80,NULL,3,85,'https://img1.xinhuashudian.com/images/2019/06/11/b2ec5491-e726-4f63-88b7-3ec6d195d3ff.jpg'),('9787552226416',20,'听力理解巧学精练(高3+高考)/哈佛英语','靳树文',NULL,36.80,NULL,9,60,'https://img2.xinhuashudian.com/images/4535969-fm.jpg'),('9787553515359',27,'威士忌(精)','(法)阿兰-格扎维埃·武斯特',NULL,49.80,NULL,10,100,'https://img8.xinhuashudian.com/images/4552999-fm.jpg'),('9787555280699',14,'智无止境(道德经名句今悟)(精)','敬人',NULL,78.00,NULL,5,85,'https://img3.xinhuashudian.com/images/4541776-fm.jpg'),('9787555411062',9,'初唐四杰诗(上下)','王勃',NULL,114.00,NULL,6,100,'https://img3.xinhuashudian.com/images/4522519-fm.jpg'),('9787556239788',18,'神奇的符号(精)/大科学家讲的小故事','苏步青',NULL,36.00,NULL,10,95,'https://img5.xinhuashudian.com/images/4399573-fm.jpg'),('9787556240418',18,'奇婆婆和怪孙孙/中国当代儿童小说大系','周蜜蜜',NULL,26.00,NULL,9,80,'https://img3.xinhuashudian.com/images/4539121-fm.jpg'),('9787556240425',18,'豌豆/中国当代儿童小说大系','周静',NULL,24.00,NULL,7,75,'https://img4.xinhuashudian.com/images/4539122-fm.jpg'),('9787556240463',18,'风的翅膀/中国当代儿童小说大系','牧铃',NULL,28.00,NULL,8,60,'https://img9.xinhuashudian.com/images/4539063-fm.jpg'),('9787556833993',14,'小窗幽记','(明)陈继儒',NULL,35.00,NULL,7,80,'https://img6.xinhuashudian.com/images/4309752-fm.jpg'),('9787556837946',27,'茶经续茶经/线装中华国粹','(唐)陆羽//(清)陆廷灿',NULL,28.00,NULL,9,100,'https://img9.xinhuashudian.com/images/4478128-fm.jpg'),('9787557014810',15,'重复力(如何把简单的事情做到极致)','梁译文',NULL,38.00,NULL,1,100,'https://img7.xinhuashudian.com/images/4479323-fm.jpg'),('9787557015657',10,'马达加斯加玛瑙','张振锋',NULL,118.50,NULL,3,80,'https://img1.xinhuashudian.com/images/2019/06/19/cb294c72-ac7b-4fd8-af01-fd9c1969d272.jpg'),('9787558905490',18,'黑夜女王/生命传奇系列长篇小说','刘虎',NULL,23.00,NULL,6,80,'https://img9.xinhuashudian.com/images/4466815-fm.jpg'),('9787559434777',15,'乌合之众(大众心理研究)(精)','(法)古斯塔夫·勒庞',NULL,39.80,NULL,3,78,'https://img2.xinhuashudian.com/images/4562211-fm.jpg'),('9787559435958',22,'向上管理(与你的领导相互成就)','萧雨',NULL,39.80,NULL,9,85,'https://img8.xinhuashudian.com/images/4539547-fm.jpg'),('9787559628992',26,'养育健康儿童(精)','刘薇',NULL,108.00,NULL,2,100,'https://img6.xinhuashudian.com/images/4547442-fm.jpg'),('9787559630278',26,'孩子的情绪由你决定(0-6岁情绪教养)','廖玺璸',NULL,48.00,NULL,1,100,'https://img8.xinhuashudian.com/images/4540909-fm.jpg'),('9787559630377',19,'给孩子的宇宙启蒙书(精)','(日)佐藤胜彦',NULL,58.00,NULL,3,75,'https://img2.xinhuashudian.com/images/4523843-fm.jpg'),('9787559631008',19,'酷虫学校(11啼笑皆非的启蒙课)','吴祥敏',NULL,32.00,NULL,1,55,'https://img5.xinhuashudian.com/images/4546652-fm.jpg'),('9787559631855',17,'汉字的故事(精)','王铁钧',NULL,49.50,NULL,8,90,'https://img9.xinhuashudian.com/images/4561722-fm.jpg'),('9787559631862',23,'阿米巴合伙制','帅超',NULL,68.00,NULL,9,75,'https://img8.xinhuashudian.com/images/4556579-fm.jpg'),('9787559714145',18,'游泳去看北极光','邹抒阳',NULL,25.00,NULL,2,95,'https://img3.xinhuashudian.com/images/4563592-fm.jpg'),('9787560068169',21,'伊桑·弗罗姆(3级适合初3高1年级)/书虫牛津英汉双语读物','(美)华顿',NULL,6.90,NULL,2,60,'https://img5.xinhuashudian.com/bookbasepic/C/00783/97875600681691504936-fm.jpg'),('978756017687101',8,'水浒传','施耐庵',NULL,136.61,NULL,7,100,'https://img2.xinhuashudian.com/bookbasepic/C/01682/2685110-fm.jpg'),('9787560443201',11,'编辑生涯忆鲁迅','赵家璧',NULL,47.50,NULL,3,100,'https://img5.xinhuashudian.com/images/4528654-fm.jpg'),('9787562088493',13,'我国刑法中兜底条款研究','马东丽',NULL,78.00,NULL,8,87,'https://img3.xinhuashudian.com/images/4535864-fm.jpg'),('9787562089353',13,'法之力(英美法系经典案例详解)','(新西兰)霍建强',NULL,68.00,NULL,5,100,'https://img7.xinhuashudian.com/images/4535866-fm.jpg'),('9787562089681',13,'何以法大','黄进',NULL,69.00,NULL,3,100,'https://img5.xinhuashudian.com/images/4550019-fm.jpg'),('9787562284796',24,'中国对亚太地区投资合作研究/中国外交与国际合作丛论','王勇辉',NULL,59.00,NULL,9,98,'https://img8.xinhuashudian.com/images/4530788-fm.jpg'),('9787562285113',17,'岁时记与岁时观念--以荆楚岁时记为中心的研究','萧放',NULL,63.00,NULL,10,78,'https://img1.xinhuashudian.com/images/4530793-fm.jpg'),('9787562285540',9,'谭祖安先生手写诗册','谭延闿',NULL,160.55,NULL,8,100,'https://img5.xinhuashudian.com/images/4530784-fm.jpg'),('9787562358763',29,'除颤器信号处理算法及测试应用','张双文//杨衍菲//郭玉英',NULL,36.00,NULL,6,75,'https://img6.xinhuashudian.com/images/4538398-fm.jpg'),('9787562856795',21,'复仇者联盟(Ⅲ无限战争)/大电影双语阅读','美国漫威公司',NULL,45.00,NULL,3,65,'https://img2.xinhuashudian.com/images/4540234-fm.jpg'),('9787562857709',26,'迪士尼幼小衔接英语进阶阅读(2共4册)','美国迪士尼公司',NULL,68.00,NULL,3,95,'https://img2.xinhuashudian.com/images/4535768-fm.jpg'),('9787562857716',26,'迪士尼幼小衔接英语进阶阅读(3共4册)','美国迪士尼公司',NULL,68.00,NULL,5,85,'https://img4.xinhuashudian.com/images/4535766-fm.jpg'),('9787562857723',26,'迪士尼幼小衔接英语进阶阅读(1共4册)','美国迪士尼公司',NULL,68.00,NULL,7,90,'https://img7.xinhuashudian.com/images/4535767-fm.jpg'),('9787563057375',28,'特高拱坝变形安全监控理论和方法及其应用(精)','顾冲时//赵二峰//周钟//蔡德文',NULL,158.00,NULL,7,85,'https://img7.xinhuashudian.com/images/4516606-fm.jpg'),('9787563058341',28,'社会资本参与的大中型水利工程资产管理模式及机制研究','贺骥//张闻笛//吴兆丹//李伟',NULL,68.00,NULL,8,69,'https://img4.xinhuashudian.com/images/4516603-fm.jpg'),('9787564642204',27,'煤矿瓦斯动力灾害及其治理(精)','林柏泉//杨威',NULL,128.00,NULL,3,66,'https://img3.xinhuashudian.com/images/4510934-fm.jpg'),('9787565830297',24,'税语碎言(融创)','张春喜',NULL,102.00,NULL,1,100,'https://img5.xinhuashudian.com/images/4539732-fm.jpg'),('9787566825650',24,'中小企业税务风险分析与控制','罗威',NULL,38.00,NULL,3,85,'https://img7.xinhuashudian.com/images/4542471-fm.jpg'),('9787566825926',9,'风轻莲香(雷冠军诗作三百首)','雷冠军',NULL,47.31,NULL,6,50,'https://img2.xinhuashudian.com/images/4544656-fm.jpg'),('9787567531550',9,'再别康桥','徐志摩',NULL,16.15,NULL,4,60,'https://img5.xinhuashudian.com/bookbasepic/C/01972/3151668-fm.jpg'),('9787567589858',29,'看上去很美(整形美容手术在中国)','文华',NULL,49.80,NULL,4,99,'https://img4.xinhuashudian.com/images/4538862-fm.jpg'),('9787567807891',24,'感悟税务稽查--从入门到进阶的思考与实践','张福伟',NULL,32.00,NULL,2,99,'https://img5.xinhuashudian.com/images/4464345-fm.jpg'),('9787568046749',29,'艾滋病与生活逻辑(精)/玉润健康丛书/艾滋病社会学研究丛书','黄盈盈',NULL,126.00,NULL,7,65,'https://img1.xinhuashudian.com/images/4537938-fm.jpg'),('9787568049092',28,'全能小户型设计(住得小不如住得巧)','漂亮家居编辑部',NULL,59.80,NULL,1,95,'https://img9.xinhuashudian.com/images/4532269-fm.jpg'),('9787568049948',25,'水果进行曲(塞德里克·格罗莱的甜品创意法)(精)','(法)塞德里克·格罗莱',NULL,168.00,NULL,9,77,'https://img7.xinhuashudian.com/images/4532189-fm.jpg'),('9787568050906',11,'汉武大帝全传','林文力',NULL,39.90,NULL,8,100,'https://img1.xinhuashudian.com/images/4532259-fm.jpg'),('9787568602723',11,'我的地质情怀','巩杰生',NULL,39.90,NULL,6,50,'https://img2.xinhuashudian.com/images/4521038-fm.jpg'),('9787568864626',20,'初中数学解题方法(8年级)','金英兰',NULL,30.00,NULL,3,90,'https://img8.xinhuashudian.com/images/4540862-fm.jpg'),('9787569020472',21,'基于跨文化交际的大学英语教学模式建构','朱芬//邵静',NULL,50.00,NULL,8,90,'https://img5.xinhuashudian.com/images/4527715-fm.jpg'),('9787570704576',18,'砂粒与星尘','薛涛',NULL,25.00,NULL,1,100,'https://img5.xinhuashudian.com/images/4548285-fm.jpg'),('9787571301729',25,'世界冠军的烘焙甜点','杨嘉明',NULL,49.80,NULL,2,65,'https://img7.xinhuashudian.com/images/4545387-fm.jpg'),('9787571301873',25,'享瘦轻食','鱼菲',NULL,39.80,NULL,3,75,'https://img8.xinhuashudian.com/images/4552484-fm.jpg'),('9787571301965',25,'零基础学会中式面点','陈麒文',NULL,59.80,NULL,1,55,'https://img1.xinhuashudian.com/images/4545379-fm.jpg'),('ISBN 977-8969-333',8,'东游记','江泽晖',NULL,108.40,NULL,NULL,100,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_img`
--

DROP TABLE IF EXISTS `book_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_img` (
  `book_img_id` int(255) NOT NULL,
  `book` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_img_id`) USING BTREE,
  KEY `b_book` (`book`) USING BTREE,
  CONSTRAINT `b_book` FOREIGN KEY (`book`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_img`
--

LOCK TABLES `book_img` WRITE;
/*!40000 ALTER TABLE `book_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(10) NOT NULL,
  `category_name` varchar(20) DEFAULT NULL,
  `category_img` varchar(255) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'历史',NULL,NULL,NULL),(2,'人文社科',NULL,NULL,NULL),(3,'少儿图书','',NULL,NULL),(4,'教育考试',NULL,NULL,NULL),(5,'经济经融',NULL,NULL,NULL),(6,'生活休闲',NULL,NULL,NULL),(7,'科学技术',NULL,NULL,NULL),(8,'小说','/category/8/2019071319263184407.png',1,NULL),(9,'文学',NULL,1,NULL),(10,'艺术',NULL,1,NULL),(11,'传记',NULL,1,NULL),(12,'历史','',2,NULL),(13,'法律',NULL,2,NULL),(14,'哲学宗教',NULL,2,NULL),(15,'心理',NULL,2,NULL),(16,'政治军事',NULL,2,NULL),(17,'文化',NULL,2,NULL),(18,'儿童文学',NULL,3,NULL),(19,'科普百科',NULL,3,NULL),(20,'中小教辅',NULL,4,NULL),(21,'外语学习',NULL,4,NULL),(22,'管理',NULL,5,NULL),(23,'经济',NULL,5,NULL),(24,'金融会计',NULL,5,NULL),(25,'烹饪美食',NULL,6,NULL),(26,'育儿早教',NULL,6,NULL),(27,'工业科技',NULL,7,NULL),(28,'建筑',NULL,7,NULL),(29,'医学',NULL,7,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (5);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `history_id` varchar(255) NOT NULL,
  `book` varchar(20) DEFAULT NULL,
  `user` int(10) DEFAULT NULL,
  `rent_time` datetime DEFAULT NULL,
  `remand_time` datetime DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0未还 1已还',
  `time` int(16) DEFAULT NULL,
  PRIMARY KEY (`history_id`) USING BTREE,
  KEY `h_user` (`user`) USING BTREE,
  KEY `h_book` (`book`) USING BTREE,
  CONSTRAINT `h_book` FOREIGN KEY (`book`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `h_user` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES ('201907121047588799471',' 9787500782087',10001,'2019-07-11 21:47:59',NULL,1.96,1,0,7),('201907131733349237411',' 9787500782087',10001,'2019-07-13 04:33:34',NULL,0.28,1,0,1),('201907131734307859511',' 9787500782087',10001,'2019-07-13 04:34:31',NULL,0.28,1,0,1),('2019071317513893076301',' 9787807657613',10002,'2019-07-13 04:51:38','2019-07-13 04:52:21',5.47,1,1,30);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `manager_id` int(10) NOT NULL,
  `manager_name` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (10086,'江泽晖','tf511925','/Manager/10001/2019070720121111139.jpeg');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rank`
--

DROP TABLE IF EXISTS `rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rank` (
  `level` int(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`level`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` VALUES (1,'假的会员',1.00),(2,'白银会员',0.95),(3,'黄金会员',0.93),(4,'白金会员',0.90),(5,'钻石会员',0.85),(6,'王者会员',0.80);
/*!40000 ALTER TABLE `rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `rend_id` int(11) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `rent_count` varchar(255) DEFAULT NULL,
  `rent_time` datetime DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`rend_id`),
  KEY `FK7u1o98l8bcckxpcm314cu7haj` (`book`),
  KEY `FKabhlrs3mcsqqk5ok65h1vjaha` (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplier_id` int(10) NOT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `phone_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'西南交通大学出版社','13992543333'),(2,'北京邮电大学出版社','13992543361'),(3,'西南财经大学出版社','13992543351'),(4,'西安建筑科技大学出版社','13992543352'),(5,'成都大学出版社','13992543353'),(6,'电子科技大学出北京','13992543354'),(7,'成都电子科技大学出版社','13992543355'),(8,'北京大学出版社','13992543356'),(9,'清华大学出版社','13992543357'),(10,'西安电子科技大学出版社','13992543358');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(18) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_num` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '0不可用 1可用',
  `head_img` varchar(255) DEFAULT NULL,
  `rank` int(1) DEFAULT '1',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `u_phone_num` (`phone_num`) USING BTREE,
  KEY `u_rank` (`rank`) USING BTREE,
  CONSTRAINT `u_rank` FOREIGN KEY (`rank`) REFERENCES `rank` (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10001,'江泽晖','男','tf511925.','13992543350','2019-06-14 18:04:33','2019-07-13 05:27:15',1,'http://hbimg.b0.upaiyun.com/6740150bc1ce3b6a8051da8a4cfbdc3f2159e7b28e32-FB0LQI_fw658',6),(10002,'没有姓名','女','tf511925','13992543332','2019-07-12 08:25:40','2019-07-13 04:49:36',1,'/user/headImg/10002/2019071317500573453.jpg',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-13 19:50:40
