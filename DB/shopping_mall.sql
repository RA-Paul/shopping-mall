-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2024-05-30 11:58:56
-- 伺服器版本： 10.4.28-MariaDB
-- PHP 版本： 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `shopping_mall`
--

DELIMITER $$
--
-- 程序
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CountProducts` ()   BEGIN
    SELECT COUNT(*) FROM product;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateMember` (IN `p_account` VARCHAR(255), IN `p_password` VARCHAR(255), IN `p_createdDate` DATETIME, IN `p_lastModifiedDate` DATETIME, OUT `p_memberId` INT)   BEGIN
    INSERT INTO member (member_id, account, password, created_date, last_modified_date)
    VALUES (null, p_account, p_password, p_createdDate, p_lastModifiedDate);

    SET p_memberId = LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateOrder` (IN `p_orderId` VARCHAR(16), IN `p_memberId` INT, IN `p_price` INT, IN `p_payStatus` INT, IN `p_createdDate` DATETIME, IN `p_lastModifiedDate` DATETIME)   BEGIN
    INSERT INTO `order` (order_id, member_id, price, pay_status, created_date, last_modified_date)
    VALUES (p_orderId, p_memberId, p_price, p_payStatus, p_createdDate, p_lastModifiedDate);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateOrderDetails` (IN `p_orderId` VARCHAR(16), IN `p_productId` VARCHAR(4), IN `p_quantity` INT, IN `p_standPrice` INT, IN `p_itemPrice` INT)   BEGIN
    INSERT INTO order_detail (order_item_sn, order_id, product_id, quantity, stand_price, item_price)
    VALUES (NULL, p_orderId, p_productId, p_quantity, p_standPrice, p_itemPrice);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateProduct` (IN `p_productId` VARCHAR(4), IN `p_productName` VARCHAR(120), IN `p_price` INT, IN `p_quantity` INT, IN `p_createdDate` DATETIME, IN `p_lastModifiedDate` DATETIME)   BEGIN
    INSERT INTO product (product_id, product_name, price, quantity, created_date, last_modified_date)
    VALUES (p_productId, p_productName, p_price, p_quantity, p_createdDate, p_lastModifiedDate);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateUser` (IN `p_account` VARCHAR(255), IN `p_password` VARCHAR(255), IN `p_createdDate` TIMESTAMP, IN `p_lastModifiedDate` TIMESTAMP, OUT `p_userId` INT)   BEGIN
    INSERT INTO user (user_id, account, password, created_date, last_modified_date)
    VALUES (null, p_account, p_password, p_createdDate, p_lastModifiedDate);

    SET p_userId = LAST_INSERT_ID();
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetMaxProductId` ()   BEGIN
    SELECT MAX(product_id) FROM product;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetMemberByAccount` (IN `p_account` VARCHAR(255))   BEGIN
    SELECT member_id, account, password, created_date, last_modified_date
    FROM member
    WHERE account = p_account;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetMemberById` (IN `p_memberId` INT)   BEGIN
    SELECT member_id, account, password, created_date, last_modified_date
    FROM member
    WHERE member_id = p_memberId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetOrderById` (IN `p_orderId` VARCHAR(16))   BEGIN
    SELECT order_id, member_id, price, pay_status, created_date, last_modified_date
    FROM `order`
    WHERE order_id = p_orderId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetOrderByMemberId` (IN `p_memberId` INT)   BEGIN
    SELECT order_id, member_id, price, pay_status, created_date, last_modified_date
    FROM `order`
    WHERE member_id = p_memberId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetOrderDetailByOrderId` (IN `p_orderId` VARCHAR(16))   BEGIN
    SELECT order_item_sn, order_id, product_id, quantity, stand_price, item_price
    FROM order_detail
    WHERE order_id = p_orderId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetProductById` (IN `p_productId` VARCHAR(4))   BEGIN
    SELECT product_id, product_name, price, quantity, created_date, last_modified_date
    FROM product
    WHERE product_id = p_productId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetProducts` (IN `p_inStock` INT)   BEGIN
    SELECT product_id, product_name, price, quantity, created_date, last_modified_date
    FROM product
    WHERE quantity > p_inStock;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserByAccount` (IN `p_userAccount` VARCHAR(256))   BEGIN
    SELECT user_id, account, password, created_date, last_modified_date
    FROM user
    WHERE account = p_userAccount;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserById` (IN `p_userId` BIGINT)   BEGIN
    SELECT user_id, account, password, created_date, last_modified_date
    FROM user
    WHERE user_id = p_userId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateProductQuantity` (IN `p_productId` VARCHAR(255), IN `p_quantity` INT, IN `p_lastModifiedDate` DATETIME)   BEGIN
    UPDATE product
    SET quantity = p_quantity, last_modified_date = p_lastModifiedDate
    WHERE product_id = p_productId;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- 資料表結構 `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `member`
--

INSERT INTO `member` (`member_id`, `account`, `password`, `created_date`, `last_modified_date`) VALUES
(1, 'member', 'aa08769cdcb26674c6706093503ff0a3', '2024-05-30 09:04:39', '2024-05-30 09:04:39');

-- --------------------------------------------------------

--
-- 資料表結構 `order`
--

CREATE TABLE `order` (
  `order_id` varchar(16) NOT NULL,
  `member_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `pay_status` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `order`
--

INSERT INTO `order` (`order_id`, `member_id`, `price`, `pay_status`, `created_date`, `last_modified_date`) VALUES
('Ms20240530175258', 1, 492400, 0, '2024-05-30 09:52:58', '2024-05-30 09:52:58');

-- --------------------------------------------------------

--
-- 資料表結構 `order_detail`
--

CREATE TABLE `order_detail` (
  `order_item_sn` int(11) NOT NULL,
  `order_id` varchar(16) NOT NULL,
  `product_id` varchar(4) NOT NULL,
  `quantity` int(11) NOT NULL,
  `stand_price` int(11) NOT NULL,
  `item_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `order_detail`
--

INSERT INTO `order_detail` (`order_item_sn`, `order_id`, `product_id`, `quantity`, `stand_price`, `item_price`) VALUES
(1, 'Ms20240530175258', 'P001', 5, 98000, 490000),
(2, 'Ms20240530175258', 'P002', 2, 1200, 2400);

-- --------------------------------------------------------

--
-- 資料表結構 `product`
--

CREATE TABLE `product` (
  `product_id` varchar(4) NOT NULL,
  `product_name` varchar(120) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `price`, `quantity`, `created_date`, `last_modified_date`) VALUES
('P001', 'osii 舒壓按摩椅', 98000, 0, '2024-05-30 09:07:38', '2024-05-30 09:52:58'),
('P002', '網友最愛起司蛋糕', 1200, 48, '2024-05-30 09:35:19', '2024-05-30 09:52:58'),
('P003', '真愛密碼項鍊', 8500, 20, '2024-05-30 09:35:40', '2024-05-30 09:35:40');

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `user`
--

INSERT INTO `user` (`user_id`, `account`, `password`, `created_date`, `last_modified_date`) VALUES
(1, 'user', 'ee11cbb19052e40b07aac0ca060c23ee', '2024-05-30 09:04:56', '2024-05-30 09:04:56');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`);

--
-- 資料表索引 `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `member_id` (`member_id`);

--
-- 資料表索引 `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_item_sn`),
  ADD KEY `order_id` (`order_id`);

--
-- 資料表索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `quantity` (`quantity`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `order_item_sn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_order_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

--
-- 資料表的限制式 `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `fk_order_detail_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
