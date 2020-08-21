--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'NXB Tre','NXB Tre',NULL,NULL,NULL,NULL),(2,'Nha Nam','Nha Nam',NULL,NULL,NULL,NULL),(3,'NXB Pham Hung','NXB Pham Hung',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Hue',NULL,NULL,NULL,NULL),(2,'HCM',NULL,NULL,NULL,NULL),(3,'Ha Noi',NULL,NULL,NULL,NULL),(4,'Da Nang',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Author 1','1992-07-07',NULL,NULL,NULL,NULL),(2,'Author 2','1993-06-07',NULL,NULL,NULL,NULL),(3,'Author 3','1998-09-22',NULL,NULL,NULL,NULL),(4,'Author 4','1994-03-05',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `author_address`
--

LOCK TABLES `author_address` WRITE;
/*!40000 ALTER TABLE `author_address` DISABLE KEYS */;
INSERT INTO `author_address` VALUES (1,1),(2,2),(2,3),(3,4);
/*!40000 ALTER TABLE `author_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Book 1','Desc Book 1',1,2020,NULL,NULL,NULL,NULL),(2,'Book 2','Desc Book 2',1,2019,NULL,NULL,NULL,NULL),(3,'Book 3','Desc Book 3',2,2020,NULL,NULL,NULL,NULL),(4,'Book 4','Desc Book 4',3,2018,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `author_book`
--

LOCK TABLES `author_book` WRITE;
/*!40000 ALTER TABLE `author_book` DISABLE KEYS */;
INSERT INTO `author_book` VALUES (1,1),(1,2),(2,2),(3,3),(3,4),(4,4);
/*!40000 ALTER TABLE `author_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `history_publisher`
--

LOCK TABLES `history_publisher` WRITE;
/*!40000 ALTER TABLE `history_publisher` DISABLE KEYS */;
INSERT INTO `history_publisher` VALUES (1,'NXB Cu',NULL,NULL,NULL,NULL),(2,'NXB Thoi Dai',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `history_publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book_history_publisher`
--

LOCK TABLES `book_history_publisher` WRITE;
/*!40000 ALTER TABLE `book_history_publisher` DISABLE KEYS */;
INSERT INTO `book_history_publisher` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `book_history_publisher` ENABLE KEYS */;
UNLOCK TABLES;