
-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `bill_no` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `bill` double NOT NULL,
  `bill_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`bill_no`, `order_id`, `bill`, `bill_date`) VALUES
(43, 42, 90, '2022-03-08 05:34:34'),
(45, 44, 40, '2022-03-08 08:35:06'),
(47, 46, 80, '2022-03-08 08:36:44'),
(49, 48, 30, '2022-03-08 08:44:13'),
(51, 50, 130, '2022-03-08 09:03:34'),
(53, 52, 40, '2022-03-08 09:03:43'),
(55, 54, 80, '2022-07-10 07:40:46');
