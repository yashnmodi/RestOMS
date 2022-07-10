
-- --------------------------------------------------------

--
-- Table structure for table `customer_details`
--

CREATE TABLE `customer_details` (
  `order_id` int(11) NOT NULL,
  `table_id` varchar(10) NOT NULL,
  `Item` varchar(20) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(10) NOT NULL,
  `Paid` int(1) NOT NULL,
  `Order_Submit` int(1) NOT NULL,
  `Order_Flag` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_details`
--

INSERT INTO `customer_details` (`order_id`, `table_id`, `Item`, `Price`, `Quantity`, `Paid`, `Order_Submit`, `Order_Flag`) VALUES
(11, 'yash', 'Misal Pav', 50, 3, 1, 1, 1),
(42, 'yash', 'Upma', 45, 2, 1, 1, 1),
(44, 'yash', 'Poha', 40, 1, 1, 1, 1),
(46, 'yash', 'Poha', 40, 2, 1, 1, 1),
(48, 'yash', 'Basil Tomato Soup', 30, 1, 1, 1, 1),
(50, 'yash', 'Veg Kolhapuri', 130, 1, 1, 1, 1),
(52, 'yash', 'Chapati', 20, 2, 1, 1, 1),
(54, 'yash', 'Poha', 40, 2, 1, 0, 1);
