USE `demo`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id`   int(11) NOT NULL AUTO_INCREMENT,
  `age`  int(11),
  `name` varchar(255) COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
)





