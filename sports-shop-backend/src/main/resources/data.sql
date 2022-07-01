INSERT INTO `sportsdb`.`admin` (`adminId`, `pwd`) VALUES ( 'admin123', 'password123');
INSERT INTO `sportsdb`.`admin` ( `adminId`, `pwd`) VALUES ( 'admin4356', 'passowrd456');

INSERT INTO  `sportsdb`.`category` ( `name`) VALUES ('Women Shoe');
INSERT INTO  `sportsdb`.`category` ( `name`) VALUES ('Men Shoe');
INSERT INTO  `sportsdb`.`category` ( `name`) VALUES ('Kids Shoe');

INSERT INTO `sportsdb`.`eproduct` (`categoryId`, `dateAdded`, `name`, `price`) VALUES ('1', '2022-06-19', 'nike', '200');
INSERT INTO `sportsdb`.`eproduct` (`categoryId`, `dateAdded`, `name`, `price`) VALUES ('1', '2022-06-19', 'Timberland', '200');

INSERT INTO `sportsdb`.`users` (`address`, `age`, `dateAdded`, `emailId`, `fname`, `lname`, `pwd`) VALUES ('ABC', '23', '2022-05-20', 'afrin@hht.com', 'faj', 'afr', '2314Pass');


INSERT INTO `sportsdb`.`purchase_items` (`price`, `productId`, `purchaseId`, `qty`, `rate`, `userId`) VALUES ('234', '1', '1', '1', '1', '1');
