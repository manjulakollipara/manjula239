-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 21, 2013 at 11:53 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cmpe239`
--

-- --------------------------------------------------------

--
-- Table structure for table `businesstable`
--

CREATE TABLE IF NOT EXISTS `businesstable` (
  `business_id` varchar(30) NOT NULL,
  `fulladdress` varchar(150) NOT NULL,
  `open` varchar(5) NOT NULL,
  `categories` varchar(150) NOT NULL,
  `city` varchar(100) NOT NULL,
  `review_count` int(11) NOT NULL,
  `bz_name` varchar(100) NOT NULL,
  `longitude` varchar(25) NOT NULL,
  `latitude` varchar(25) NOT NULL,
  `state` varchar(5) NOT NULL,
  `stars` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `businesstable`
--

INSERT INTO `businesstable` (`business_id`, `fulladdress`, `open`, `categories`, `city`, `review_count`, `bz_name`, `longitude`, `latitude`, `state`, `stars`) VALUES
('rncjoVoEFUJGCUoC1JgnUA', '8466 W Peoria Ave\nSte 6\nPeoria, AZ 85345', 'true', 'Accountants,Professional Services,Tax Services,Financial Services,', 'Peoria', 3, 'Peoria Income Tax Service', '-112.241596', '33.581867', 'AZ', '5.0'),
('0FNFSzCFP_rGUoJx8W7tJg', '2149 W Wood Dr\nPhoenix, AZ 85029', 'true', 'Sporting Goods,Bikes,Shopping,', 'Phoenix', 5, 'Bike Doctor', '-112.105933', '33.604054', 'AZ', '5.0'),
('3f_lyB6vFK48ukH6ScvLHg', '1134 N Central Ave\nPhoenix, AZ 85004', 'true', '', 'Phoenix', 4, 'Valley Permaculture Alliance', '-112.0739333', '33.4605258', 'AZ', '5.0'),
('usAsSV36QmUej8--yvN-dg', '845 W Southern Ave\nPhoenix, AZ 85041', 'true', 'Food,Grocery,', 'Phoenix', 5, 'Food City', '-112.0853773', '33.3922099', 'AZ', '3.5'),
('PzOqRohWw7F7YEPBz6AubA', '6520 W Happy Valley Rd\nSte 101\nGlendale Az, AZ 85310', 'true', 'Food,Bagels,Delis,Restaurants,', 'Glendale Az', 14, 'Hot Bagels & Deli', '-112.200264', '33.712797', 'AZ', '3.5'),
('gtQzAiy7D-dPU8WzT3jX3Q', 'The Americana at Brand\n869 Americana Way\nGlendale, CA 91210', 'true', 'Women''s Clothing,Fashion,Shopping,', 'Glendale', 6, 'Barney''s New York Co-op', '-112.481632232666', '33.6077660588006', 'CA', '4.5'),
('FrBCYtCS_jydDjg1KsIgWQ', '1850 W Camelback Rd\nSte 1\nPhoenix, AZ 85015', 'true', 'Music & DVDs,Books, Mags, Music & Video,Vinyl Records,Shopping,', 'Phoenix', 21, 'Zia Record Exchange', '-112.0987501', '33.5096582', 'AZ', '3.5'),
('yaXAD-Mv2K2PEZobmqjIYA', '3415 W Northern Ave\nPhoenix, AZ 85051', 'true', 'Event Planning & Services,Venues & Event Spaces,', 'Phoenix', 4, 'Reflections Bingo', '-112.132866', '33.551903', 'AZ', '5.0'),
('o3ehs4ZEdsizbJyB9_j7uQ', '6938 E 1st St\nScottsdale, AZ 85251', 'true', 'Art Schools,Specialty Schools,Shopping,Jewelry,Accessories,Fashion,Education,', 'Scottsdale', 14, 'Jam', '-111.9312992', '33.492195', 'AZ', '5.0'),
('qarobAbxGSHI7ygf1f7a_Q', '891 E Baseline Rd\nSuite 102\nGilbert, AZ 85233', 'true', 'Sandwiches,Restaurants,', 'Gilbert', 10, 'Jersey Mike''s Subs', '-111.8120071', '33.3788385', 'AZ', '3.5');

-- --------------------------------------------------------

--
-- Table structure for table `reviewtable`
--

CREATE TABLE IF NOT EXISTS `reviewtable` (
  `review_id` varchar(30) NOT NULL,
  `user_id` varchar(30) NOT NULL,
  `business_id` varchar(30) NOT NULL,
  `stars` varchar(5) NOT NULL,
  `date` varchar(15) NOT NULL,
  `review` varchar(2500) NOT NULL,
  `funny` varchar(5) NOT NULL,
  `cool` varchar(5) NOT NULL,
  `useful` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reviewtable`
--

INSERT INTO `reviewtable` (`review_id`, `user_id`, `business_id`, `stars`, `date`, `review`, `funny`, `cool`, `useful`) VALUES
('fWKvX83p0-ka4JS3dc6E5A', 'rLtl8ZkDX5vH5nAx9C3q5Q', '9yKzy9PApeiPPOUJEtnvkg', '5', '2011-01-26', 'My wife took me here on my birthday for breakfast and it was excellent.  The weather was perfect which made sitting outside overlooking their grounds an absolute pleasure.  Our waitress was excellent and our food arrived quickly on the semi-busy Saturday morning.  It looked like the place fills up pretty quickly so the earlier you get here the better.\n\nDo yourself a favor and get their Bloody Mary.  It was phenomenal and simply the best I''ve ever had.  I''m pretty sure they only use ingredients from their garden and blend them fresh when you order it.  It was amazing.\n\nWhile EVERYTHING on the menu looks excellent, I had the white truffle scrambled eggs vegetable skillet and it was tasty and delicious.  It came with 2 pieces of their griddled bread with was amazing and it absolutely made the meal complete.  It was the best "toast" I''ve ever had.\n\nAnyway, I can''t wait to go back!', '0', '2', '5'),
('IjZ33sJrzXqU-0X6U8NwyA', '0a2KyEL0d3Yb1V6aivbIuQ', 'ZRJwVLyzEJq1VAihDhYiow', '5', '2011-07-27', 'I have no idea why some people give bad reviews about this place. It goes to show you, you can please everyone. They are probably griping about something that their own fault...there are many people like that.\n\nIn any case, my friend and I arrived at about 5:50 PM this past Sunday. It was pretty crowded, more than I thought for a Sunday evening and thought we would have to wait forever to get a seat but they said we''ll be seated when the girl comes back from seating someone else. We were seated at 5:52 and the waiter came and got our drink orders. Everyone was very pleasant from the host that seated us to the waiter to the server. The prices were very good as well. We placed our orders once we decided what we wanted at 6:02. We shared the baked spaghetti calzone and the small "Here''s The Beef" pizza so we can both try them. The calzone was huge and we got the smallest one (personal) and got the small 11" pizza. Both were awesome! My friend liked the pizza better and I liked the calzone better. The calzone does have a sweetish sauce but that''s how I like my sauce!\n\nWe had to box part of the pizza to take it home and we were out the door by 6:42. So, everything was great and not like these bad reviewers. That goes to show you that  you have to try these things yourself because all these bad reviewers have some serious issues.', '0', '0', '0'),
('IESLBzqUCLdSzSqm0eCSxQ', '0hT2KtfLiobPvh6cDC8JQg', '6oRAC4uyJCsJl1X0WZpVSA', '4', '2012-06-14', 'love the gyro plate. Rice is so good and I also dig their candy selection :)', '0', '0', '1'),
('G-WvGaISbqqaMHlNnByodA', 'uZetl9T0NcROGOyFfughhg', '_1QQZuf4zZOyFCvXc0o6Vg', '5', '2010-05-27', 'Rosie, Dakota, and I LOVE Chaparral Dog Park!!! It''s very convenient and surrounded by a lot of paths, a desert xeriscape, baseball fields, ballparks, and a lake with ducks.\n\nThe Scottsdale Park and Rec Dept. does a wonderful job of keeping the park clean and shaded.  You can find trash cans and poopy-pick up mitts located all over the park and paths.\n\nThe fenced in area is huge to let the dogs run, play, and sniff!', '0', '1', '2'),
('1uJFq2r5QfJG_6ExMRCaGw', 'vYmM4KTsC8ZfQBg-j5MWkw', '6ozycU1RpktNG2-1BroVtw', '5', '2012-01-05', 'General Manager Scott Petello is a good egg!!! Not to go into detail, but let me assure you if you have any issues (albeit rare) speak with Scott and treat the guy with some respect as you state your case and I''d be surprised if you don''t walk out totally satisfied as I just did. Like I always say..... "Mistakes are inevitable, it''s how we recover from them that is important"!!!\n\nThanks to Scott and his awesome staff. You''ve got a customer for life!! .......... :^)', '0', '0', '0'),
('m2CKSsepBCoRYWxiRUsxAg', 'sqYN3lNgvPbPCTRsMFu27g', '-yxfBYGB6SEqszmxJxd97A', '4', '2007-12-13', 'Quiessence is, simply put, beautiful.  Full windows and earthy wooden walls give a feeling of warmth inside this restaurant perched in the middle of a farm.  The restaurant seemed fairly full even on a Tuesday evening; we had secured reservations just a couple days before.\n\nMy friend and I had sampled sandwiches at the Farm Kitchen earlier that week, and were impressed enough to want to eat at the restaurant.  The crisp, fresh veggies didn''t disappoint: we ordered the salad with orange and grapefruit slices and the crudites to start.  Both were very good; I didn''t even know how much I liked raw radishes and turnips until I tried them with their pesto and aioli sauces.\n\nFor entrees, I ordered the lamb and my friend ordered the pork shoulder.  Service started out very good, but trailed off quickly.  Waiting for our food took a very long time (a couple seated after us received and finished their entrees before we received our''s), and no one bothered to explain the situation until the maitre''d apologized almost 45 minutes later.  Apparently the chef was unhappy with the sauce on my entree, so he started anew.  This isn''t really a problem, but they should have communicated this to us earlier.  For our troubles, they comped me the glass of wine I ordered, but they forgot to bring out with my entree  as I had requested.  Also, they didn''t offer us bread, but I will echo the lady who whispered this to us on her way out: ask for the bread.  We received warm foccacia, apple walnut, and pomegranate slices of wonder with honey and butter.  YUM.\n\nThe entrees were both solid, but didn''t quite live up to the innovation and freshness of the vegetables.  My lamb''s sauce was delicious, but the meat was tough.  Maybe the vegetarian entrees are the way to go?  But our dessert, the gingerbread pear cake, was yet another winner.\n\nIf the entrees were tad more inspired, or the service weren''t so spotty, this place definitely would have warranted five stars.  If I return, I''d like to try the 75$ tasting menu.  Our bill came out to about 100$ for two people, including tip, no drinks.', '1', '4', '3'),
('riFQ3vxNpP4rWLk_CSri2A', 'wFweIWhv2fREZV_dYkz_1g', 'zp713qNhx8d9KCJJnrw1xA', '5', '2010-02-12', 'Drop what you''re doing and drive here. After I ate here I had to go back the next day for more.  The food is that good.\n\nThis cute little green building may have gone competely unoticed if I hadn''t been driving down Palm Rd to avoid construction.  While waiting to turn onto 16th Street the "Grand Opening" sign caught my eye and my little yelping soul leaped for joy!  A new place to try!\n\nIt looked desolate from the outside but when I opened the door I was put at easy by the decor, smell and cleanliness inside.  I ordered dinner for two, to go.  The menu was awesome.  I loved seeing all the variety: poblano peppers, mole, mahi mahi, mushrooms...something wrapped in banana leaves.  It made it difficult to choose something.  Here''s what I''ve had so far: La Condesa Shrimp Burro and Baja Sur Dogfish Shark Taco.  They are both were very delicious meals but the shrimp burro stole the show.  So much flavor.  I snagged some bites from my hubbys mole and mahi mahi burros- mmmm such a delight.  The salsa bar is endless.  I really stocked up.  I was excited to try the strawberry salsa but it was too hot, in fact it all was, but I''m a big wimp when it comes to hot peppers. The horchata is handmade and delicious.  They throw pecans and some fruit in there too which is a yummy bonus!\n\nAs if the good food wasn''t enough to win me over the art in this restaurant sho did!  I''m a sucker for Mexican folk art and Frida Kahlo is my Oprah.  There''s a painting of her and Diego hanging over the salsa bar, it''s amazing.  All the paintings are great, love the artist.', '4', '7', '7'),
('JL7GXJ9u4YMx7Rzs05NfiQ', '1ieuYcKS7zeAv_U15AB13A', 'hW0Ne_HTHEAgGF1rAdmR-g', '4', '2012-07-12', 'Luckily, I didn''t have to travel far to make my connecting flight. And for this, I thank you, Phoenix.\n\nMy brief layover was pleasant as the employees were kind and the flight was on time.  Hopefully, next time I can grace Phoenix with my presence for a little while longer.', '0', '0', '1'),
('XtnfnYmnJYi71yIuGsXIUA', 'Vh_DlizgGhSqQh4qfZ2h6A', 'wNUea3IXZWD63bbOQaOH-g', '4', '2012-08-17', 'Definitely come for Happy hour! Prices are amazing, sake bombers for $3...Great atmosphere and wait staff was incredibly nice and right on to all of our needs, didn''t have to ask for a thing They were always spot on...Place gets crowded in the evening especially if you plan on sitting outside. I only wish there were one in Apollo Beach or Brandon!', '0', '0', '0'),
('jJAIXA46pU1swYyRCdfXtQ', 'sUNkXg8-KFtCMQDV6zRzQg', 'nMHhuYan8e3cONo3PornJA', '5', '2010-08-11', 'Nobuo shows his unique talents with everything on the menu. Carefully crafted features with much to drink. Start with the pork belly buns and a stout. Then go on until you can no longer.', '0', '0', '1');

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE IF NOT EXISTS `usertable` (
  `user_id` varchar(30) NOT NULL,
  `name` varchar(25) NOT NULL,
  `stars` varchar(10) NOT NULL,
  `review_count` varchar(5) NOT NULL,
  `cool` varchar(5) NOT NULL,
  `funny` varchar(5) NOT NULL,
  `useful` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`user_id`, `name`, `stars`, `review_count`, `cool`, `funny`, `useful`) VALUES
('CR2y7yEm4X035ZMzrTtN9Q', 'Jim', '5.0', '6', '0', '0', '7'),
('_9GXoHhdxc30ujPaQwh6Ew', 'Kelle', '1.0', '2', '0', '0', '1'),
('8mM-nqxjg6pT04kwcjMbsw', 'Stephanie', '5.0', '2', '0', '0', '1'),
('Ch6CdTR2IVaVANr-RglMOg', 'T', '5.0', '2', '0', '0', '2'),
('NZrLmHRyiHmyT1JrfzkCOA', 'Beth', '1.0', '1', '0', '0', '0'),
('mWx5Sxt_dx-sYBZg6RgJHQ', 'Amy', '3.79', '19', '36', '30', '45'),
('hryUDaRk7FLuDAYui2oldw', 'Beach', '3.83', '207', '31', '28', '130'),
('2t6fZNLtiqsihVmeO7zggg', 'christine', '3.0', '2', '1', '1', '0'),
('mn6F-eP5WU37b-iLTop2mQ', 'Denis', '4.5', '4', '2', '0', '3'),
('myXq7PFXkD_yfXT580SXMw', 'Shawn', '3.9', '10', '9', '5', '24');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
