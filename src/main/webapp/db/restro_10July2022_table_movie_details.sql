
-- --------------------------------------------------------

--
-- Table structure for table `movie_details`
--

CREATE TABLE `movie_details` (
  `movie_id` int(4) NOT NULL,
  `movie_name` varchar(40) NOT NULL,
  `movie_path` varchar(40) NOT NULL,
  `music_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
