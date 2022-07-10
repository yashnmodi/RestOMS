
-- --------------------------------------------------------

--
-- Table structure for table `login_details`
--

CREATE TABLE `login_details` (
  `id` int(11) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_details`
--

INSERT INTO `login_details` (`id`, `uname`, `password`, `role`) VALUES
(1, 'yash', 'yash', 'Table'),
(2, 'shweta', 'shweta', 'Kitchen'),
(4, 'shwash', 'shwash', 'Admin');
