--
-- Dumping data for table `bills`
--

LOCK
TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills`
VALUES (1, '2023-12-10 00:34:39.951956', 'BC9EZNC45RY4E', 'PAYID-MV2WB3Q6AX65103A9352141R',
        '2023-12-10 13:56:49.979220', 0, 12, 3),
       (2, '2023-12-10 00:38:23.112957', NULL, NULL, NULL, 1, 12, 3),
       (3, '2023-12-10 00:50:12.543527', 'BC9EZNC45RY4E', 'PAYID-MV2KVPI8MB50787YR319564M',
        '2023-12-10 00:59:10.754297', 0, 12, 3),
       (4, '2023-12-10 01:00:30.556309', 'BC9EZNC45RY4E', 'PAYID-MV2KWRA03R61003UP4191612',
        '2023-12-10 01:00:50.249282', 0, 12, 3),
       (5, '2023-12-10 01:05:26.164948', 'BC9EZNC45RY4E', 'PAYID-MV2KY4A2SW74624845025319',
        '2023-12-10 01:05:55.113936', 0, 12, 3),
       (6, '2023-12-10 01:12:07.015800', 'BC9EZNC45RY4E', 'PAYID-MV2K36Y4XS68499VL0558153',
        '2023-12-10 01:12:29.885416', 0, 12, 3),
       (7, '2023-12-10 13:59:29.870594', NULL, NULL, NULL, 1, 14, 3);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `categories`
--

LOCK
TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories`
VALUES (2, 'Khoa học viễn tưởng'),
       (6, 'Hành động'),
       (7, 'Phiêu lưu'),
       (9, 'Hài'),
       (10, 'Kinh dị'),
       (11, 'Lãng mạng'),
       (12, 'Hoạt hình'),
       (13, 'Khoa học'),
       (14, 'Giả tưởng'),
       (15, 'Tội phạm');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `movie_categories`
--

LOCK
TABLES `movie_categories` WRITE;
/*!40000 ALTER TABLE `movie_categories` DISABLE KEYS */;
INSERT INTO `movie_categories`
VALUES (6, 2),
       (3, 6),
       (4, 6),
       (6, 6),
       (10, 6),
       (6, 7),
       (10, 7),
       (7, 9),
       (5, 10),
       (11, 10),
       (12, 11),
       (1, 12),
       (2, 12),
       (7, 12),
       (8, 12),
       (9, 12),
       (10, 12),
       (2, 14),
       (3, 14),
       (4, 14),
       (8, 14);
/*!40000 ALTER TABLE `movie_categories` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `movies`
--

LOCK
TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies`
VALUES (1, 'Mizuta Wasabi, Megumi Oohara',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11117_105_100008.jpg',
        'Doraemon: Nobita và vùng đất lý tưởng trên bầu trời - kể câu chuyện khi Nobita tìm thấy một hòn đảo hình lưỡi liềm trên trời mây. Ở nơi đó, tất cả đều hoàn hảo… đến mức cậu nhóc Nobita mê ngủ ngày cũng có thể trở thành một thần đồng toán học, một siêu sao thể thao. Cả hội Doraemon cùng sử dụng một món bảo bối độc đáo chưa từng xuất hiện trước đây để đến với vương quốc tuyệt vời này. Cùng với những người bạn ở đây, đặc biệt là chàng robot mèo Sonya, cả hội đã có chuyến hành trình tới vương quốc trên mây tuyệt vời… cho đến khi những bí mật đằng sau vùng đất lý tưởng này được hé lộ.',
        'Douyama Takumi', 108, '2024-02-02 00:00:00.000000', 80,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11117_103_100004.jpg', 0,
        '2023-09-02 00:00:00.000000', 75, 'Doraemon: Nobita và Vùng Đất Lý Tưởng Trên Bầu Trời',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieMedia/202305/11117_301_100001.mp4'),
       (2, 'Oscar Isaac, Shameik Moore, Hailee Steinfeld, Jake Johnson.',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11037_105_100003.jpg',
        'Miles Morales tái xuất trong phần tiếp theo của bom tấn hoạt hình từng đoạt giải Oscar - Spider-Man: Across the Spider-Verse. Sau khi gặp lại Gwen Stacy, chàng Spider-Man thân thiện đến từ Brooklyn phải du hành qua đa vũ trụ và gặp một nhóm Người Nhện chịu trách nhiệm bảo vệ các thế giới song song. Nhưng khi nhóm siêu anh hùng xung đột về cách xử lý một mối đe dọa mới, Miles buộc phải đọ sức với các Người Nhện khác và phải xác định lại ý nghĩa của việc trở thành một người hùng để có thể cứu những người cậu yêu thương nhất.',
        'Justin K. Thompson, Kemp Powers, Joaquim Dos Santos', 140, '2024-02-02 00:00:00.000000', 75,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11037_103_100002.jpg', 1,
        '2023-09-02 00:00:00.000000', 55, 'Người Nhện: Du Hành Vũ Trụ Nhện',
        'https://www.youtube.com/watch?v=HVgwRbQfpCc'),
       (3, 'Vin Diesel, Michelle Rodriguez, Tyrese Gibson, Ludacris, Jason Momoa',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11094_105_100007.jpg',
        'Dom Toretto và gia đình của anh ấy bị trở thành mục tiêu của người con trai đầy thù hận của ông trùm ma túy Hernan Reyes.',
        'Louis Leterrier', 141, '2024-02-02 00:00:00.000000', 76,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11094_103_100002.jpg', 3,
        '2023-09-02 00:00:00.000000', 60, 'Fast & Furious 10',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieMedia/202305/11094_301_100001.mp4'),
       (4, 'Ma Dong Seok, Lee Joon Hyuk. Munetake Aoki, Lee Beom Soo',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11170_105_100009.jpg',
        'Quái vật cơ bắp Seok-do (Ma Dong Seok) dẫn đầu đội hình sự truy lùng đường dây buôn chất cấm của thiếu gia Joo Seong Cheol. Cuộc truy đuổi càng thêm gay cấn khi cú đấm công lý \"chú Ma\" chạm trán thanh kiếm lừng lẫy chốn giang hồ Nhật Bản.',
        'Lee Sang Young', 105, '2024-02-02 00:00:00.000000', 55,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11170_103_100003.jpg', 4,
        '2023-09-02 00:00:00.000000', 65, 'Vây Hãm Không Lối Thoát',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieMedia/202305/11170_301_100001.mp4'),
       (5, 'Phuwin Tangsakyuen, Up Poompat Iam-samang, Nick Kunatip Pinpradab', NULL,
        'Được lấy cảm hứng từ loại bùa hình nhân hộ mệnh nổi tiếng ở Thái Lan, phim theo chân Tham trong hành trình đến một hòn đảo hẻo lánh để tìm người anh trai của mình đang tu hành ở đó. Tham phát hiện ra anh trai đã bị sát hại sau khi bị buộc tội giết người và trộm cắp. Quyết tâm ở lại hòn đảo để điều tra cũng như minh oan cho anh trai nhưng Tham lại vô tình khám phá ra nhiều cái chết bí ẩn khác tại ngôi làng bên cạnh.',
        'Mike Phontharis Chotkijsadarsopon', 101, '2024-02-02 00:00:00.000000', 50,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11169_103_100001.jpg', 3,
        '2023-09-02 00:00:00.000000', 50, 'Hoon Payon: Bùa Hình Nhân', NULL),
       (6, 'Michelle Yeoh, Dominique Fishback, Ron Perlman',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11108_105_100007.jpg',
        'Bộ phim dựa trên sự kiện Beast Wars trong loạt phim hoạt hình \"Transformers\", nơi mà các robot có khả năng biến thành động vật khổng lồ cùng chiến đấu chống lại một mối đe dọa tiềm tàng.',
        'Steven Caple Jr.', 127, '2024-02-02 00:00:00.000000', 58,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11108_103_100004.jpg', 2,
        '2023-09-02 00:00:00.000000', 40, 'Transformers: Quái thú trỗi dậy',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieMedia/202305/11108_301_100001.mp4'),
       (7, 'Leah Lewis, Mamoudou Athie',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11128_105_100009.jpg',
        'Xứ Sở Các Nguyên Tố từ Disney và Pixar lấy bối cảnh tại thành phố các nguyên tố, nơi lửa, nước, đất và không khí cùng chung sống với nhau. Câu chuyện xoay quanh nhân vật Ember, một cô nàng cá tính, thông minh, mạnh mẽ và đầy sức hút. Tuy nhiên, mối quan hệ của cô với Wade - một anh chàng hài hước, luôn thuận thế đẩy dòng - khiến Ember cảm thấy ngờ vực với thế giới này. Được đạo diễn bởi Peter Sohn, sản xuất bởi Denise Ream, và lồng tiếng bởi Leah Lewis (Ember) và Mamoudou Athie (Wade), phim khởi chiếu tại rạp vào 23.06.2023.',
        'Peter Sohn', 109, '2024-06-02 00:00:00.000000', 0,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11128_103_100003.jpg', 1,
        '2023-12-02 00:00:00.000000', 0, 'Xứ Sở Các Nguyên Tố',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieMedia/202306/11128_301_100001.mp4'),
       (8, 'natadenysenko, artem pyvovarov, nazar zadniprovskyi, olena kravets, serhii prytula', '',
        'Nội dung của bộ phim xoay quanh nhân vật chính Mavka - người nắm giữ linh hồn của rừng xanh. Cô vô tình gặp và phải lòng với Lucas - nhạc sĩ tài ba đến khu rừng nhằm tìm kiếm loài cây mang đến sự sống vĩnh cửu theo lời dụ dỗ của Kylina. Lucas không hề biết rằng Kylina đang ấp ủ một tham vọng độc ác, đó là đoạt lấy sự bình yên của khu rừng. Mavka sẽ phải làm gì khi đứng trước hai sự lựa chọn, tình yêu và nghĩa vụ bảo vệ khu rừng. ',
        'oleksandra ruban, Oleh Malamuzh', 85, '2024-06-02 00:00:00.000000', 0,
        'https://rapchieuphim.com/photos/9/than-thoai-rung-xanh-thumb.jpg', 2, '2023-12-02 00:00:00.000000', 0,
        'Thần Thoại Rừng Xanh', ''),
       (9, 'ami touma, Takumi Kitamura, ashida mana',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11187_105_100001.jpg',
        'Bộ phim xoay quanh cô bé Kokoro - một học sinh lớp bảy luôn sống trong sự cô độc, không tiếp xúc với ai. Bên trong sâu thẳng của Kokoro là vết thương tâm lý tưởng chừng như khó có thể chữa lành. Nhưng cho đến một ngày, Kokoro phát hiện tấm gương trong phòng mình phát sáng, và khi cô bé bước qua, Kokoro nhìn thấy bản thân ở trong một toà lâu đài với sáu người bạn khác cũng chung hoàn cảnh.',
        'hara keiichi', 119, '2024-06-02 00:00:00.000000', 0,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11187_103_100001.jpg', 2,
        '2023-12-02 00:00:00.000000', 0, 'Cô Thành Trong Gương', ''),
       (10, '', 'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11119_105_100001.jpg',
        'Thân phận của Ai Haibara đang dần bị bại lộ và tính mạng của cô cũng gặp nguy hiểm. Conan sẽ phải đối đầu với Gin và Tổ chức Áo Đen như thế nào? Liệu phe cảnh sát chính diện hay tổ chức Áo Đen phản diện sẽ nắm được phần thắng trong cuộc đối đầu này?',
        'Yuzuru Tachikawa', NULL, '2024-09-27 00:00:00.000000', 0,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202305/11119_103_100002.jpg', 2,
        '2024-01-27 00:00:00.000000', 0, 'Thám tử lừng danh conan: tàu ngầm sắt màu đen', ''),
       (11, 'Kaity Nguyễn, Rocker Nguyễn, Tuấn Trần, ca sĩ naomi, Gi A Nguyễn, Quốc Khánh',
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202301/11050_105_100001.jpg',
        'Móng vuốt dẫn dắt câu chuyện đi từ buổi tiệc dã ngoại náo nhiệt của một nhóm bạn đến một kết cục kinh hoàng. Bộ phim thuộc thể loại giật gân, kinh dị dựa theo câu chuyện nguyên tác của Trần Khánh Hoàng – biên kịch và cũng là người bạn thân thiết của đạo diễn Lê Thanh Sơn, đã từng cùng anh tạo nên thành công của Em chưa 18. Với Móng vuốt, đạo diễn Lê Thanh Sơn tiếp tục thử thách bản thân ở một thể loại hoàn toàn mới sau phim hành động (Bẫy rồng) và hài – tình cảm (Em chưa 18).',
        'Lê Thanh Sơn', NULL, '2024-09-27 00:00:00.000000', 0,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202301/11050_103_100001.jpg', 3,
        '2024-01-27 00:00:00.000000', 0, 'Móng vuốt', ''),
       (12, '1', '', '1', '1', 100, '2024-09-27 00:00:00.000000', 0,
        'https://media.lottecinemavn.com/Media/MovieFile/MovieImg/202306/11188_103_100001.jpg', 0,
        '2024-01-27 00:00:00.000000', 0, 'Ngày xưa có một chuyện tình', '');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `roles`
--

LOCK
TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `rooms`
--

LOCK
TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms`
VALUES (1, 98, 'Phòng 101', 1),
       (2, 98, 'Phòng 102', 1),
       (3, 98, 'Phòng 103', 1),
       (4, 98, 'Phòng 101', 2),
       (5, 98, 'Phòng 102', 2),
       (6, 98, 'Phòng 103', 2);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `schedules`
--

LOCK
TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules`
VALUES (12, 45000, '2023-12-10 08:45:00.000000', 1, 1),
       (13, 50000, '2023-12-10 11:15:00.000000', 1, 2),
       (14, 55000, '2023-12-10 14:15:00.000000', 1, 3),
       (15, 55000, '2023-12-10 16:45:00.000000', 1, 4),
       (16, 50000, '2023-12-10 19:00:00.000000', 1, 5),
       (17, 40000, '2023-12-10 22:15:00.000000', 1, 6),
       (18, 45000, '2023-12-11 08:45:00.000000', 1, 1),
       (19, 50000, '2023-12-11 11:15:00.000000', 1, 2),
       (20, 55000, '2023-12-11 14:15:00.000000', 1, 3),
       (21, 55000, '2023-12-11 16:45:00.000000', 1, 4),
       (22, 50000, '2023-12-11 19:00:00.000000', 1, 5),
       (23, 40000, '2023-12-11 22:15:00.000000', 1, 6),
       (24, 45000, '2023-12-12 08:45:00.000000', 1, 1),
       (25, 50000, '2023-12-12 11:15:00.000000', 1, 2),
       (26, 55000, '2023-12-12 14:15:00.000000', 1, 3),
       (27, 55000, '2023-12-12 16:45:00.000000', 1, 4),
       (28, 50000, '2023-12-12 19:00:00.000000', 1, 5),
       (29, 40000, '2023-12-12 22:15:00.000000', 1, 6),
       (30, 45000, '2023-12-13 08:45:00.000000', 1, 1),
       (31, 50000, '2023-12-13 11:15:00.000000', 1, 2),
       (32, 55000, '2023-12-13 14:15:00.000000', 1, 3),
       (33, 55000, '2023-12-13 16:45:00.000000', 1, 4),
       (34, 50000, '2023-12-13 19:00:00.000000', 1, 5),
       (35, 40000, '2023-12-13 22:15:00.000000', 1, 6),
       (36, 45000, '2023-12-14 08:45:00.000000', 1, 1),
       (37, 50000, '2023-12-14 11:15:00.000000', 1, 2),
       (38, 55000, '2023-12-14 14:15:00.000000', 1, 3),
       (39, 55000, '2023-12-14 16:45:00.000000', 1, 4),
       (40, 50000, '2023-12-14 19:00:00.000000', 1, 5),
       (41, 40000, '2023-12-14 22:15:00.000000', 1, 6);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `seats`
--

LOCK
TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats`
VALUES (1, 'A1', 1),
       (2, 'A2', 1),
       (3, 'A3', 1),
       (4, 'A4', 1),
       (5, 'A5', 1),
       (6, 'A6', 1),
       (7, 'A7', 1),
       (8, 'A8', 1),
       (9, 'A9', 1),
       (10, 'A10', 1),
       (11, 'A11', 1),
       (12, 'A12', 1),
       (13, 'A13', 1),
       (14, 'A14', 1),
       (15, 'B1', 1),
       (16, 'B2', 1),
       (17, 'B3', 1),
       (18, 'B4', 1),
       (19, 'B5', 1),
       (20, 'B6', 1),
       (21, 'B7', 1),
       (22, 'B8', 1),
       (23, 'B9', 1),
       (24, 'B10', 1),
       (25, 'B11', 1),
       (26, 'B12', 1),
       (27, 'B13', 1),
       (28, 'B14', 1),
       (29, 'C1', 1),
       (30, 'C2', 1),
       (31, 'C3', 1),
       (32, 'C4', 1),
       (33, 'C5', 1),
       (34, 'C6', 1),
       (35, 'C7', 1),
       (36, 'C8', 1),
       (37, 'C9', 1),
       (38, 'C10', 1),
       (39, 'C11', 1),
       (40, 'C12', 1),
       (41, 'C13', 1),
       (42, 'C14', 1),
       (43, 'D1', 1),
       (44, 'D2', 1),
       (45, 'D3', 1),
       (46, 'D4', 1),
       (47, 'D5', 1),
       (48, 'D6', 1),
       (49, 'D7', 1),
       (50, 'D8', 1),
       (51, 'D9', 1),
       (52, 'D10', 1),
       (53, 'D11', 1),
       (54, 'D12', 1),
       (55, 'D13', 1),
       (56, 'D14', 1),
       (57, 'E1', 1),
       (58, 'E2', 1),
       (59, 'E3', 1),
       (60, 'E4', 1),
       (61, 'E5', 1),
       (62, 'E6', 1),
       (63, 'E7', 1),
       (64, 'E8', 1),
       (65, 'E9', 1),
       (66, 'E10', 1),
       (67, 'E11', 1),
       (68, 'E12', 1),
       (69, 'E13', 1),
       (70, 'E14', 1),
       (71, 'F1', 1),
       (72, 'F2', 1),
       (73, 'F3', 1),
       (74, 'F4', 1),
       (75, 'F5', 1),
       (76, 'F6', 1),
       (77, 'F7', 1),
       (78, 'F8', 1),
       (79, 'F9', 1),
       (80, 'F10', 1),
       (81, 'F11', 1),
       (82, 'F12', 1),
       (83, 'F13', 1),
       (84, 'F14', 1),
       (85, 'G1', 1),
       (86, 'G2', 1),
       (87, 'G3', 1),
       (88, 'G4', 1),
       (89, 'G5', 1),
       (90, 'G6', 1),
       (91, 'G7', 1),
       (92, 'G8', 1),
       (93, 'G9', 1),
       (94, 'G10', 1),
       (95, 'G11', 1),
       (96, 'G12', 1),
       (97, 'G13', 1),
       (98, 'G14', 1),
       (99, 'A1', 2),
       (100, 'A2', 2),
       (101, 'A3', 2),
       (102, 'A4', 2),
       (103, 'A5', 2),
       (104, 'A6', 2),
       (105, 'A7', 2),
       (106, 'A8', 2),
       (107, 'A9', 2),
       (108, 'A10', 2),
       (109, 'A11', 2),
       (110, 'A12', 2),
       (111, 'A13', 2),
       (112, 'A14', 2),
       (113, 'B1', 2),
       (114, 'B2', 2),
       (115, 'B3', 2),
       (116, 'B4', 2),
       (117, 'B5', 2),
       (118, 'B6', 2),
       (119, 'B7', 2),
       (120, 'B8', 2),
       (121, 'B9', 2),
       (122, 'B10', 2),
       (123, 'B11', 2),
       (124, 'B12', 2),
       (125, 'B13', 2),
       (126, 'B14', 2),
       (127, 'C1', 2),
       (128, 'C2', 2),
       (129, 'C3', 2),
       (130, 'C4', 2),
       (131, 'C5', 2),
       (132, 'C6', 2),
       (133, 'C7', 2),
       (134, 'C8', 2),
       (135, 'C9', 2),
       (136, 'C10', 2),
       (137, 'C11', 2),
       (138, 'C12', 2),
       (139, 'C13', 2),
       (140, 'C14', 2),
       (141, 'D1', 2),
       (142, 'D2', 2),
       (143, 'D3', 2),
       (144, 'D4', 2),
       (145, 'D5', 2),
       (146, 'D6', 2),
       (147, 'D7', 2),
       (148, 'D8', 2),
       (149, 'D9', 2),
       (150, 'D10', 2),
       (151, 'D11', 2),
       (152, 'D12', 2),
       (153, 'D13', 2),
       (154, 'D14', 2),
       (155, 'E1', 2),
       (156, 'E2', 2),
       (157, 'E3', 2),
       (158, 'E4', 2),
       (159, 'E5', 2),
       (160, 'E6', 2),
       (161, 'E7', 2),
       (162, 'E8', 2),
       (163, 'E9', 2),
       (164, 'E10', 2),
       (165, 'E11', 2),
       (166, 'E12', 2),
       (167, 'E13', 2),
       (168, 'E14', 2),
       (169, 'F1', 2),
       (170, 'F2', 2),
       (171, 'F3', 2),
       (172, 'F4', 2),
       (173, 'F5', 2),
       (174, 'F6', 2),
       (175, 'F7', 2),
       (176, 'F8', 2),
       (177, 'F9', 2),
       (178, 'F10', 2),
       (179, 'F11', 2),
       (180, 'F12', 2),
       (181, 'F13', 2),
       (182, 'F14', 2),
       (183, 'G1', 2),
       (184, 'G2', 2),
       (185, 'G3', 2),
       (186, 'G4', 2),
       (187, 'G5', 2),
       (188, 'G6', 2),
       (189, 'G7', 2),
       (190, 'G8', 2),
       (191, 'G9', 2),
       (192, 'G10', 2),
       (193, 'G11', 2),
       (194, 'G12', 2),
       (195, 'G13', 2),
       (196, 'G14', 2),
       (197, 'A1', 3),
       (198, 'A2', 3),
       (199, 'A3', 3),
       (200, 'A4', 3),
       (201, 'A5', 3),
       (202, 'A6', 3),
       (203, 'A7', 3),
       (204, 'A8', 3),
       (205, 'A9', 3),
       (206, 'A10', 3),
       (207, 'A11', 3),
       (208, 'A12', 3),
       (209, 'A13', 3),
       (210, 'A14', 3),
       (211, 'B1', 3),
       (212, 'B2', 3),
       (213, 'B3', 3),
       (214, 'B4', 3),
       (215, 'B5', 3),
       (216, 'B6', 3),
       (217, 'B7', 3),
       (218, 'B8', 3),
       (219, 'B9', 3),
       (220, 'B10', 3),
       (221, 'B11', 3),
       (222, 'B12', 3),
       (223, 'B13', 3),
       (224, 'B14', 3),
       (225, 'C1', 3),
       (226, 'C2', 3),
       (227, 'C3', 3),
       (228, 'C4', 3),
       (229, 'C5', 3),
       (230, 'C6', 3),
       (231, 'C7', 3),
       (232, 'C8', 3),
       (233, 'C9', 3),
       (234, 'C10', 3),
       (235, 'C11', 3),
       (236, 'C12', 3),
       (237, 'C13', 3),
       (238, 'C14', 3),
       (239, 'D1', 3),
       (240, 'D2', 3),
       (241, 'D3', 3),
       (242, 'D4', 3),
       (243, 'D5', 3),
       (244, 'D6', 3),
       (245, 'D7', 3),
       (246, 'D8', 3),
       (247, 'D9', 3),
       (248, 'D10', 3),
       (249, 'D11', 3),
       (250, 'D12', 3),
       (251, 'D13', 3),
       (252, 'D14', 3),
       (253, 'E1', 3),
       (254, 'E2', 3),
       (255, 'E3', 3),
       (256, 'E4', 3),
       (257, 'E5', 3),
       (258, 'E6', 3),
       (259, 'E7', 3),
       (260, 'E8', 3),
       (261, 'E9', 3),
       (262, 'E10', 3),
       (263, 'E11', 3),
       (264, 'E12', 3),
       (265, 'E13', 3),
       (266, 'E14', 3),
       (267, 'F1', 3),
       (268, 'F2', 3),
       (269, 'F3', 3),
       (270, 'F4', 3),
       (271, 'F5', 3),
       (272, 'F6', 3),
       (273, 'F7', 3),
       (274, 'F8', 3),
       (275, 'F9', 3),
       (276, 'F10', 3),
       (277, 'F11', 3),
       (278, 'F12', 3),
       (279, 'F13', 3),
       (280, 'F14', 3),
       (281, 'G1', 3),
       (282, 'G2', 3),
       (283, 'G3', 3),
       (284, 'G4', 3),
       (285, 'G5', 3),
       (286, 'G6', 3),
       (287, 'G7', 3),
       (288, 'G8', 3),
       (289, 'G9', 3),
       (290, 'G10', 3),
       (291, 'G11', 3),
       (292, 'G12', 3),
       (293, 'G13', 3),
       (294, 'G14', 3),
       (295, 'A1', 4),
       (296, 'A2', 4),
       (297, 'A3', 4),
       (298, 'A4', 4),
       (299, 'A5', 4),
       (300, 'A6', 4),
       (301, 'A7', 4),
       (302, 'A8', 4),
       (303, 'A9', 4),
       (304, 'A10', 4),
       (305, 'A11', 4),
       (306, 'A12', 4),
       (307, 'A13', 4),
       (308, 'A14', 4),
       (309, 'B1', 4),
       (310, 'B2', 4),
       (311, 'B3', 4),
       (312, 'B4', 4),
       (313, 'B5', 4),
       (314, 'B6', 4),
       (315, 'B7', 4),
       (316, 'B8', 4),
       (317, 'B9', 4),
       (318, 'B10', 4),
       (319, 'B11', 4),
       (320, 'B12', 4),
       (321, 'B13', 4),
       (322, 'B14', 4),
       (323, 'C1', 4),
       (324, 'C2', 4),
       (325, 'C3', 4),
       (326, 'C4', 4),
       (327, 'C5', 4),
       (328, 'C6', 4),
       (329, 'C7', 4),
       (330, 'C8', 4),
       (331, 'C9', 4),
       (332, 'C10', 4),
       (333, 'C11', 4),
       (334, 'C12', 4),
       (335, 'C13', 4),
       (336, 'C14', 4),
       (337, 'D1', 4),
       (338, 'D2', 4),
       (339, 'D3', 4),
       (340, 'D4', 4),
       (341, 'D5', 4),
       (342, 'D6', 4),
       (343, 'D7', 4),
       (344, 'D8', 4),
       (345, 'D9', 4),
       (346, 'D10', 4),
       (347, 'D11', 4),
       (348, 'D12', 4),
       (349, 'D13', 4),
       (350, 'D14', 4),
       (351, 'E1', 4),
       (352, 'E2', 4),
       (353, 'E3', 4),
       (354, 'E4', 4),
       (355, 'E5', 4),
       (356, 'E6', 4),
       (357, 'E7', 4),
       (358, 'E8', 4),
       (359, 'E9', 4),
       (360, 'E10', 4),
       (361, 'E11', 4),
       (362, 'E12', 4),
       (363, 'E13', 4),
       (364, 'E14', 4),
       (365, 'F1', 4),
       (366, 'F2', 4),
       (367, 'F3', 4),
       (368, 'F4', 4),
       (369, 'F5', 4),
       (370, 'F6', 4),
       (371, 'F7', 4),
       (372, 'F8', 4),
       (373, 'F9', 4),
       (374, 'F10', 4),
       (375, 'F11', 4),
       (376, 'F12', 4),
       (377, 'F13', 4),
       (378, 'F14', 4),
       (379, 'G1', 4),
       (380, 'G2', 4),
       (381, 'G3', 4),
       (382, 'G4', 4),
       (383, 'G5', 4),
       (384, 'G6', 4),
       (385, 'G7', 4),
       (386, 'G8', 4),
       (387, 'G9', 4),
       (388, 'G10', 4),
       (389, 'G11', 4),
       (390, 'G12', 4),
       (391, 'G13', 4),
       (392, 'G14', 4),
       (393, 'A1', 5),
       (394, 'A2', 5),
       (395, 'A3', 5),
       (396, 'A4', 5),
       (397, 'A5', 5),
       (398, 'A6', 5),
       (399, 'A7', 5),
       (400, 'A8', 5),
       (401, 'A9', 5),
       (402, 'A10', 5),
       (403, 'A11', 5),
       (404, 'A12', 5),
       (405, 'A13', 5),
       (406, 'A14', 5),
       (407, 'B1', 5),
       (408, 'B2', 5),
       (409, 'B3', 5),
       (410, 'B4', 5),
       (411, 'B5', 5),
       (412, 'B6', 5),
       (413, 'B7', 5),
       (414, 'B8', 5),
       (415, 'B9', 5),
       (416, 'B10', 5),
       (417, 'B11', 5),
       (418, 'B12', 5),
       (419, 'B13', 5),
       (420, 'B14', 5),
       (421, 'C1', 5),
       (422, 'C2', 5),
       (423, 'C3', 5),
       (424, 'C4', 5),
       (425, 'C5', 5),
       (426, 'C6', 5),
       (427, 'C7', 5),
       (428, 'C8', 5),
       (429, 'C9', 5),
       (430, 'C10', 5),
       (431, 'C11', 5),
       (432, 'C12', 5),
       (433, 'C13', 5),
       (434, 'C14', 5),
       (435, 'D1', 5),
       (436, 'D2', 5),
       (437, 'D3', 5),
       (438, 'D4', 5),
       (439, 'D5', 5),
       (440, 'D6', 5),
       (441, 'D7', 5),
       (442, 'D8', 5),
       (443, 'D9', 5),
       (444, 'D10', 5),
       (445, 'D11', 5),
       (446, 'D12', 5),
       (447, 'D13', 5),
       (448, 'D14', 5),
       (449, 'E1', 5),
       (450, 'E2', 5),
       (451, 'E3', 5),
       (452, 'E4', 5),
       (453, 'E5', 5),
       (454, 'E6', 5),
       (455, 'E7', 5),
       (456, 'E8', 5),
       (457, 'E9', 5),
       (458, 'E10', 5),
       (459, 'E11', 5),
       (460, 'E12', 5),
       (461, 'E13', 5),
       (462, 'E14', 5),
       (463, 'F1', 5),
       (464, 'F2', 5),
       (465, 'F3', 5),
       (466, 'F4', 5),
       (467, 'F5', 5),
       (468, 'F6', 5),
       (469, 'F7', 5),
       (470, 'F8', 5),
       (471, 'F9', 5),
       (472, 'F10', 5),
       (473, 'F11', 5),
       (474, 'F12', 5),
       (475, 'F13', 5),
       (476, 'F14', 5),
       (477, 'G1', 5),
       (478, 'G2', 5),
       (479, 'G3', 5),
       (480, 'G4', 5),
       (481, 'G5', 5),
       (482, 'G6', 5),
       (483, 'G7', 5),
       (484, 'G8', 5),
       (485, 'G9', 5),
       (486, 'G10', 5),
       (487, 'G11', 5),
       (488, 'G12', 5),
       (489, 'G13', 5),
       (490, 'G14', 5),
       (491, 'A1', 6),
       (492, 'A2', 6),
       (493, 'A3', 6),
       (494, 'A4', 6),
       (495, 'A5', 6),
       (496, 'A6', 6),
       (497, 'A7', 6),
       (498, 'A8', 6),
       (499, 'A9', 6),
       (500, 'A10', 6),
       (501, 'A11', 6),
       (502, 'A12', 6),
       (503, 'A13', 6),
       (504, 'A14', 6),
       (505, 'B1', 6),
       (506, 'B2', 6),
       (507, 'B3', 6),
       (508, 'B4', 6),
       (509, 'B5', 6),
       (510, 'B6', 6),
       (511, 'B7', 6),
       (512, 'B8', 6),
       (513, 'B9', 6),
       (514, 'B10', 6),
       (515, 'B11', 6),
       (516, 'B12', 6),
       (517, 'B13', 6),
       (518, 'B14', 6),
       (519, 'C1', 6),
       (520, 'C2', 6),
       (521, 'C3', 6),
       (522, 'C4', 6),
       (523, 'C5', 6),
       (524, 'C6', 6),
       (525, 'C7', 6),
       (526, 'C8', 6),
       (527, 'C9', 6),
       (528, 'C10', 6),
       (529, 'C11', 6),
       (530, 'C12', 6),
       (531, 'C13', 6),
       (532, 'C14', 6),
       (533, 'D1', 6),
       (534, 'D2', 6),
       (535, 'D3', 6),
       (536, 'D4', 6),
       (537, 'D5', 6),
       (538, 'D6', 6),
       (539, 'D7', 6),
       (540, 'D8', 6),
       (541, 'D9', 6),
       (542, 'D10', 6),
       (543, 'D11', 6),
       (544, 'D12', 6),
       (545, 'D13', 6),
       (546, 'D14', 6),
       (547, 'E1', 6),
       (548, 'E2', 6),
       (549, 'E3', 6),
       (550, 'E4', 6),
       (551, 'E5', 6),
       (552, 'E6', 6),
       (553, 'E7', 6),
       (554, 'E8', 6),
       (555, 'E9', 6),
       (556, 'E10', 6),
       (557, 'E11', 6),
       (558, 'E12', 6),
       (559, 'E13', 6),
       (560, 'E14', 6),
       (561, 'F1', 6),
       (562, 'F2', 6),
       (563, 'F3', 6),
       (564, 'F4', 6),
       (565, 'F5', 6),
       (566, 'F6', 6),
       (567, 'F7', 6),
       (568, 'F8', 6),
       (569, 'F9', 6),
       (570, 'F10', 6),
       (571, 'F11', 6),
       (572, 'F12', 6),
       (573, 'F13', 6),
       (574, 'F14', 6),
       (575, 'G1', 6),
       (576, 'G2', 6),
       (577, 'G3', 6),
       (578, 'G4', 6),
       (579, 'G5', 6),
       (580, 'G6', 6),
       (581, 'G7', 6),
       (582, 'G8', 6),
       (583, 'G9', 6),
       (584, 'G10', 6),
       (585, 'G11', 6),
       (586, 'G12', 6),
       (587, 'G13', 6),
       (588, 'G14', 6);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `theaters`
--

LOCK
TABLES `theaters` WRITE;
/*!40000 ALTER TABLE `theaters` DISABLE KEYS */;
INSERT INTO `theaters`
VALUES (1, 'Tầng 4, Mê Linh Plaza Hà Đông, Đ. Tô Hiệu, Q. Hà Đông', 'Hà Nội', 'CINEMA Hà Đông', '0938473829', 1),
       (2, '216 Đ. Võ Văn Ngân, Bình Thọ, Thủ Đức', 'Hồ Chí Minh', 'CINEMA Thủ Đức', '1902006017', 2);
/*!40000 ALTER TABLE `theaters` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `tickets`
--

LOCK
TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets`
VALUES (1, 'https://i.ibb.co/v4Lj45b/ac4c2a7be4ad.png', 1, 1),
       (2, 'https://i.ibb.co/s2KQbB1/f4904d126b12.png', 2, 2),
       (3, 'https://i.ibb.co/t2f2drH/6eb830e6aceb.png', 3, 3),
       (4, 'https://i.ibb.co/47SMvY1/7a30f2fd3ff4.png', 3, 4),
       (5, 'https://i.ibb.co/2jcKpkF/dc90d1a23c0c.png', 4, 5),
       (6, 'https://i.ibb.co/yYwLg3Y/2aadffee95e7.png', 4, 6),
       (7, 'https://i.ibb.co/hWdhZXb/ae7b0e0499da.png', 5, 7),
       (8, 'https://i.ibb.co/nBjBD8L/07867dc683f4.png', 6, 8),
       (9, 'https://i.ibb.co/dkDD7dX/09968e73610e.png', 7, 197);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `users`
--

LOCK
TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users`
VALUES (1, 'admin_ha_dong@gmail.com', _binary '', _binary '\0',
        '$2a$10$LWv1K/4YNJsCrnqMelldwuTYYOqvFbMnlDs5wKhx45fczrCEEF3IK', 'admin_ha_dong'),
       (2, 'admin_thu_duc@gmail.com', _binary '', _binary '\0',
        '$2a$10$eXsl44h416nM67Knox7KK.XkO71sXRa05TII245bu4deNt11lEoK.', 'admin_thu_duc'),
       (3, 'hongduc@gmail.com', _binary '', _binary '\0',
        '$2a$10$eV8szMETF9ZKjzGJGAk3WO33j4wSV7QFpj/poQPZ2Upfx/JNRLzYC', 'hongduc2002'),
       (4, 'duchai2002@gmail.com', _binary '', _binary '\0',
        '$2a$10$q46/MUtOzlGd2LpnXV6p2u51f2O5fjs7vA.twHJFFrd8B0K0R0mi.', 'duchai2002');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping data for table `users_roles`
--

LOCK
TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-10 22:30:28
