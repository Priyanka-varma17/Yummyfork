CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL,
  `adminname` varchar(50) DEFAULT NULL,
  `adminaddress` varchar(50) DEFAULT NULL,
  `adminmobile` bigint(20) DEFAULT NULL,
  `adminemail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `admin` (`adminid`, `adminname`, `adminaddress`, `adminmobile`, `adminemail`) VALUES(1, 'VPriyanka123', 'Thane,421201', 9090123565, 'vPriyanka@gmail.com');

CREATE TABLE `cart` (
  `cart_Id` int(11) NOT NULL,
  `food_Id` int(11) DEFAULT NULL,
  `customer_Email` varchar(50) DEFAULT NULL,
  `cart_Quantity` int(11) DEFAULT NULL,
  `foodname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `customer` (
  `custid` int(11) NOT NULL,
  `custname` varchar(50) DEFAULT NULL,
  `custaddress` varchar(50) DEFAULT NULL,
  `custmobile` bigint(20) DEFAULT NULL,
  `custemail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `customer` (`custid`, `custname`, `custaddress`, `custmobile`, `custemail`) VALUES(2, 'Pooja1234', 'Bhandup', 9594306774, 'pooja@gmail.com');
INSERT INTO `customer` (`custid`, `custname`, `custaddress`, `custmobile`, `custemail`) VALUES(4, 'Reena', 'Kalyan', 9989778909, 'Reena@gmail.com');
INSERT INTO `customer` (`custid`, `custname`, `custaddress`, `custmobile`, `custemail`) VALUES(8, 'Meghna', 'Kalyan', 8356788890, 'meghna@gmail.com');

CREATE TABLE `food` (
  `foodid` int(11) NOT NULL,
  `foodname` varchar(50) DEFAULT NULL,
  `foodprice` double(10,2) DEFAULT NULL,
  `foodquantity` int(11) DEFAULT NULL,
  `foodcategory` varchar(50) DEFAULT NULL,
  `imageFileName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(73, 'Idli', 50.00, 10, 'South Indian', 'idli2.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(74, 'Fry Idli', 80.00, 13, 'South Indian', 'idli4.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(75, 'Dahi Idli', 80.00, 15, 'South Indian', 'idli3.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(76, 'Dahi Fry Idli', 90.00, 50, 'North Indian', 'idli4.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(77, 'Plain Dosa', 100.00, 15, 'South Indian', 'dosa2.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(78, 'Masala Dosa', 150.00, 25, 'South Indian', 'dosa1.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(79, 'Onion Plain Dosa', 160.00, 20, 'South Indian', 'dosa2.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(80, 'Paper Masala Dosa', 150.00, 17, 'South Indian', 'dosa3.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(81, 'Chicken Kabab platter', 230.00, 25, 'North Indian', 'chicken1.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(82, 'Chicken Tandoor', 240.00, 15, 'North Indian', 'chicken2.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(83, 'Chicken Schezwan', 270.00, 21, 'North Indian', 'chicken3.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(84, 'Special Chicken Thaali', 180.00, 24, 'Maharashtrian', 'chicken1.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(85, 'Chicken Masala', 110.00, 20, 'Maharashtrian', 'biryani3.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(86, 'Chicken Biryani', 90.00, 26, 'Maharashtrian', 'biryani1.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(87, 'Mutton Biryani', 140.00, 21, 'Maharashtrian', 'biryani2.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(88, 'Fried Rice', 80.00, 10, 'Chinese', 'friedrice2.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(89, 'Schezwan Rice', 100.00, 10, 'Chinese', 'friedrice1.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(90, 'Paneer Fried Rice', 120.00, 10, 'Chinese', 'friedrice3.jpg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(91, 'Hakka Noodles', 80.00, 10, 'Chinese', 'noodles1.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(92, 'Schezwan Noodles', 90.00, 16, 'Chinese', 'noodles2.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(94, 'Paneer Noodles', 100.00, 12, 'Chinese', 'noodles3.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(95, 'Biryani', 500.00, 5, 'North Indian', 'biryani3.jpeg');
INSERT INTO `food` (`foodid`, `foodname`, `foodprice`, `foodquantity`, `foodcategory`, `imageFileName`) VALUES(107, 'Chicken', 300.00, 2, 'North Indian', 'biryani2.jpeg');

CREATE TABLE `foodcategory` (
  `foodcatename` varchar(50) NOT NULL,
  `maincategory` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Bengali', 'non veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Chinese', 'veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Gujrati', 'veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Italian', 'veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Kashmiri', 'veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Maharashtrian', 'non veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('North Indian', 'non veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Punjabi', 'veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('Rajasthani', 'veg');
INSERT INTO `foodcategory` (`foodcatename`, `maincategory`) VALUES('South Indian', 'veg');

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `total_price` double(10,2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `cust_email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `orders` (`orderid`, `total_price`, `status`, `cust_email`) VALUES(1226, 450.00, 'completed', 'priyanka@gmail.com');
INSERT INTO `orders` (`orderid`, `total_price`, `status`, `cust_email`) VALUES(1227, 140.00, 'completed', 'priyanka@gmail.com');
INSERT INTO `orders` (`orderid`, `total_price`, `status`, `cust_email`) VALUES(1228, 0.00, 'completed', 'priyanka@gmail.com');
INSERT INTO `orders` (`orderid`, `total_price`, `status`, `cust_email`) VALUES(1229, 1040.00, 'completed', 'meghna@gmail.com');
INSERT INTO `orders` (`orderid`, `total_price`, `status`, `cust_email`) VALUES(1230, 850.00, 'completed', 'Reena@gmail.com');
INSERT INTO `orders` (`orderid`, `total_price`, `status`, `cust_email`) VALUES(1231, 50.00, 'completed', 'pooja@gmail.com');

CREATE TABLE `personprofile` (
  `email` varchar(50) DEFAULT NULL,
  `image` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
  `role` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`role`, `username`, `password`) VALUES('Customer', 'Meghna@gmail.com', 'meghna@123');
INSERT INTO `user` (`role`, `username`, `password`) VALUES('Customer', 'Pooja@gmail.com', 'pooja@123');
INSERT INTO `user` (`role`, `username`, `password`) VALUES('Customer', 'Reena@gmail.com', 'reena@12345');
INSERT INTO `user` (`role`, `username`, `password`) VALUES('Admin', 'vPriyanka@gmail.com', 'vpriyanka@123');


ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminid`);

ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_Id`),
  ADD KEY `cart_food_id_fkc` (`food_Id`);

ALTER TABLE `customer`
  ADD PRIMARY KEY (`custid`);

ALTER TABLE `food`
  ADD PRIMARY KEY (`foodid`),
  ADD KEY `food_cate_fkc` (`foodcategory`);

ALTER TABLE `foodcategory`
  ADD PRIMARY KEY (`foodcatename`);

ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderid`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);


ALTER TABLE `admin`
  MODIFY `adminid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `cart`
  MODIFY `cart_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

ALTER TABLE `customer`
  MODIFY `custid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

ALTER TABLE `food`
  MODIFY `foodid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;

ALTER TABLE `orders`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1232;


ALTER TABLE `cart`
  ADD CONSTRAINT `cart_food_id_fkc` FOREIGN KEY (`food_Id`) REFERENCES `food` (`foodid`);

ALTER TABLE `food`
  ADD CONSTRAINT `food_cate_fkc` FOREIGN KEY (`foodcategory`) REFERENCES `foodcategory` (`foodcatename`);


