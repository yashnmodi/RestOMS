
-- --------------------------------------------------------

--
-- Table structure for table `menu_details`
--

CREATE TABLE `menu_details` (
  `Menu_Id` int(11) NOT NULL,
  `item` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `Img_Path` varchar(255) NOT NULL,
  `category` varchar(30) NOT NULL,
  `specification` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu_details`
--

INSERT INTO `menu_details` (`Menu_Id`, `item`, `price`, `Img_Path`, `category`, `specification`) VALUES
(1, 'Misal Pav', 50, 'breakfast\\misal.jpg', 'breakfast', 'breakfast'),
(2, 'Poha', 40, 'breakfast\\poha.jpg', 'breakfast', 'breakfast'),
(3, 'Upma', 45, 'breakfast\\upma.jpg', 'breakfast', 'breakfast'),
(4, 'Chicago Pizza', 180, 'starter\\Chicago_pizza.jpg', 'starter', 'starter'),
(5, 'Farmhouse Pizza', 190, 'starter\\FarmHouse_Pizza.jpg', 'starter', 'pizza'),
(6, 'French Fries', 80, 'starter\\French_Fries.jpg', 'starter', 'starter'),
(7, 'Manchurian', 80, 'starter\\manchurian.jpg', 'starter', 'starter'),
(8, 'Margarita Pizza', 160, 'starter\\Margherit_Pizza.jpg', 'starter', 'pizza'),
(9, 'Masala Papad', 30, 'starter\\Masala_papad.jpg', 'starter', 'starter'),
(10, 'Basil Tomato Soup', 30, 'starter\\Tomato_Soup.jpg', 'starter', 'soup'),
(11, 'Veg Noodles', 90, 'starter\\Veg_Noodles.jpg', 'starter', 'starter'),
(12, 'Tandoori Roti', 30, 'maincourse\\tandooriroti.jpg', 'maincourse', 'roti'),
(13, 'Chapati', 20, 'maincourse\\chapati.jpg', 'maincourse', 'roti'),
(14, 'Aloo Paratha', 45, 'maincourse\\aluparatha.jpg', 'maincourse', 'paratha'),
(15, 'Gobi Paratha', 50, 'maincourse\\gobipartha.jpg', 'maincourse', 'paratha'),
(16, 'Naan', 55, 'maincourse\\Naan.jpg', 'maincourse', 'roti'),
(17, 'Veg Hyderabadi', 130, 'maincourse\\veghyderabadi.jpg', 'maincourse', 'sabji'),
(18, 'Paneer Butter Masala', 150, 'maincourse\\paneerbuttermasala.jpg', 'maincourse', 'sabji'),
(19, 'Paneer Handi', 140, 'maincourse\\paneerhandi.jpg', 'maincourse', 'sabji'),
(20, 'Veg Kolhapuri', 130, 'maincourse\\vegkolhapuri.jpg', 'maincourse', 'sabji'),
(21, 'Plain Rice', 60, 'maincourse\\whiterice.jpg', 'maincourse', 'rice'),
(22, 'Jeera Rice', 80, 'maincourse\\jeerarice.jpg', 'maincourse', 'rice'),
(23, 'Paneer Biryani', 130, 'maincourse\\paneerbiryani.jpg', 'maincourse', 'rice'),
(24, 'Walnut Brownie', 100, 'dessert\\brownie.jpg', 'dessert', 'icecream'),
(25, 'Mango Icecream', 30, 'dessert\\mangoicecream.jpg', 'dessert', 'icecream'),
(26, 'Vanilla Icecream', 25, 'dessert\\vanniaicecream.jpg', 'dessert', 'icecream'),
(27, 'Chocolate Icecream', 30, 'dessert\\chocolateiceCream.jpg', 'dessert', 'icecream');
