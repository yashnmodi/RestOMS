
-- --------------------------------------------------------

--
-- Table structure for table `customer_details_replica`
--

CREATE TABLE `customer_details_replica` (
  `order_id` int(11) NOT NULL,
  `table_id` varchar(10) NOT NULL,
  `Item` varchar(20) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(10) NOT NULL,
  `Paid` tinyint(1) NOT NULL,
  `Order_Submit` tinyint(1) NOT NULL,
  `Order_Flag` int(1) NOT NULL,
  `bill` double NOT NULL,
  `bill_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
