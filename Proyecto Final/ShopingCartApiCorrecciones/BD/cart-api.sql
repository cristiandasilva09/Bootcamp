-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2018 a las 02:41:48
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cart-api`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addProductCart` (IN `idU` LONG, `idC` LONG, `idP` LONG, `quant` INT, `total` FLOAT)  BEGIN
insert into  `product-cart` values(idU,idC,idP,quant,total);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buyCart` (IN `buyed` BOOLEAN, `dateB` DATE, `idU` LONG, `idUs` LONG)  BEGIN
update cart set buyed=buyed,dateBuy=dateB where idCart=idU and idUser=idUs;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `changeQuiantityProductCart` (IN `quiantity` INT, `idP` LONG, `idC` LONG, `idU` LONG)  BEGIN
update `product-cart` set quantity =quiantity where `product-cart`.idProduct=idP and `product-cart`.idCart=idC and `product-cart`.idUser=idU;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createProduct` (IN `id` LONG, `nameU` VARCHAR(50), `cat` VARCHAR(50), `price` FLOAT)  BEGIN
insert into product values(id,nameU,cat,price);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createUser` (IN `idUs` LONG, `nameUs` VARCHAR(50), `lastNameUs` VARCHAR(50), `nicknameUs` VARCHAR(50), `passwordUs` VARCHAR(50), `moneyy` FLOAT)  BEGIN
insert into user values(idUs,nameUs,lastNameUs,nicknameUs,passwordUs,moneyy);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCart` (IN `id` LONG, `idU` LONG)  BEGIN
delete from `product-cart` where `product-cart`.idCart=id;
delete from cart where idCart=id and idUser=idU;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteProduct` (IN `id` LONG)  BEGIN
delete from product where idProduct=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteProductCart` (IN `idProd` LONG, `idC` LONG)  BEGIN
delete from `product-cart` where  `product-cart`.idProduct=idProd and `product-cart`.idcart=idC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser` (IN `id` LONG)  BEGIN
delete from user where idUser=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllCartsByUser` (IN `id` LONG)  BEGIN
select * from cart  where cart.idUser=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllProducts` ()  BEGIN
select * from product;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllProductsByCart` (IN `id` LONG)  BEGIN
select * from `product-cart` JOIN `product` ON `product`.idProduct= `product-cart`.idProduct where `product-cart`.idCart=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllUsers` ()  BEGIN
select * from user;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findProductByCart` (IN `idCar` LONG, `idProd` LONG)  BEGIN
select * from `product-cart` JOIN `product` ON `product`.idProduct= `product-cart`.idProduct where `product-cart`.idCart=idCar and
                `product-cart`.idProduct=idProd;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findProductByCategory` (IN `cat` VARCHAR(50))  BEGIN
select * from product where  category=cat;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findProductById` (IN `id` LONG)  BEGIN
select * from product where idProduct=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findProductByName` (IN `nameProd` VARCHAR(50))  BEGIN
select * from product where  nameProduct=nameProd;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findrecomendedProduct` (IN `id` LONG)  BEGIN
select idProduct,nameProduct,category,price
from `product` p 
where p.category in(
select distinct category 
FROM `product-cart` pc
JOIN `product` p1
 ON pc.idProduct= p1.idProduct 
 where pc.idUser=id)
 and p.idProduct not in
 (
select distinct p2.idProduct 
 FROM `product-cart` pc2
 join `product` p2 ON pc2.idProduct= p2.idProduct 
 where pc2.idUser=id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findUserById` (IN `idUs` LONG)  BEGIN
select * from user where idUser=idUs;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findUserByName` (IN `nameClient` VARCHAR(50))  BEGIN
select * from user where  firstName=nameClient;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findUserByNickName` (IN `nickUser` VARCHAR(50))  BEGIN
select * from user where nickName=nickUser;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getCart` (IN `id` LONG)  BEGIN
select * from cart  where cart.idCart=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getTotalCostCart` (IN `id` LONG)  BEGIN
select sum(totalImport) from `product-cart` where idCart=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `saveCart` (IN `idU` LONG, `idC` LONG, `buyed` BOOLEAN, `dateB` DATE)  BEGIN
insert into cart  values(idU,idC,buyed,dateB);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProduct` (IN `id` LONG, `nameU` VARCHAR(50), `cat` VARCHAR(50), `priceP` FLOAT)  BEGIN
update product set nameProduct=nameU,category=cat,price=priceP where idProduct=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser` (IN `idUs` LONG, `nameUs` VARCHAR(50), `lastNameUs` VARCHAR(50), `nicknameUs` VARCHAR(50), `passwordUs` VARCHAR(50), `moneyy` FLOAT)  BEGIN
update user set firstName=nameUs,lastName=lastNameUs,nickname=nicknameUs,password=passwordUs,money=moneyy where idUser=idUs;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUsermoney` (IN `moneyU` FLOAT, `idUserU` LONG)  BEGIN
update `user` set money=moneyU where `user`.idUser=idUserU;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cart`
--

CREATE TABLE `cart` (
  `idUser` bigint(20) NOT NULL,
  `idCart` bigint(20) NOT NULL,
  `buyed` tinyint(1) DEFAULT NULL,
  `dateBuy` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cart`
--

INSERT INTO `cart` (`idUser`, `idCart`, `buyed`, `dateBuy`) VALUES
(1, 1, 1, '2018-12-19'),
(1, 2, NULL, NULL),
(1, 3, 0, NULL),
(1, 4, 0, NULL),
(2, 2, 1, '2018-12-21'),
(2, 3, 0, NULL),
(2, 5, 1, '2018-12-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `idProduct` bigint(20) NOT NULL,
  `nameProduct` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`idProduct`, `nameProduct`, `category`, `price`) VALUES
(1, 'rice1Kg', 'food', 30),
(2, 'meat1KG', 'food', 100),
(3, 'Spaghetti1Kg', 'food', 40),
(4, 'water2Lt', 'drink', 25),
(5, 'Coca-cola2Lt', 'drink', 50),
(6, 'Lemonade1Lt', 'drink', 25),
(7, 'beer1Lt', 'alcoholic-drinks', 110),
(8, 'wine1Lt', 'alcoholic-drinks', 90),
(9, 'fernet1Lt', 'alcoholic-drinks', 350),
(10, 'apple1Kg', 'fruit', 60),
(11, 'banana1Kg', 'fruit', 50),
(12, 'orange1Kg', 'fruit', 75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product-cart`
--

CREATE TABLE `product-cart` (
  `idCart` bigint(20) NOT NULL,
  `idUser` bigint(20) NOT NULL,
  `idProduct` bigint(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `totalImport` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product-cart`
--

INSERT INTO `product-cart` (`idCart`, `idUser`, `idProduct`, `quantity`, `totalImport`) VALUES
(1, 1, 1, 1, 30),
(1, 1, 2, 1, 200),
(1, 1, 5, 4, 200),
(1, 1, 7, 3, 110);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `idUser` bigint(20) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`idUser`, `firstName`, `lastName`, `nickname`, `password`, `money`) VALUES
(1, 'Carlos', 'Perez', 'CarlosP', '123456', 560),
(2, 'Cristian', 'Da Silva', NULL, '123465', 400);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idUser`,`idCart`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idProduct`);

--
-- Indices de la tabla `product-cart`
--
ALTER TABLE `product-cart`
  ADD PRIMARY KEY (`idCart`,`idUser`,`idProduct`),
  ADD KEY `idUser` (`idUser`,`idCart`),
  ADD KEY `idProduct` (`idProduct`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Filtros para la tabla `product-cart`
--
ALTER TABLE `product-cart`
  ADD CONSTRAINT `product-cart_ibfk_1` FOREIGN KEY (`idUser`,`idCart`) REFERENCES `cart` (`idUser`, `idCart`),
  ADD CONSTRAINT `product-cart_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
