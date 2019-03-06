CREATE TABLE `sobytylnik`.`profiles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NULL,
  `location` VARCHAR(200) NULL,
  `birthday` DATETIME NOT NULL,
  `twitter_page` VARCHAR(200) NULL,
  `instagram_page` VARCHAR(200) NULL,
  `facebook_page` VARCHAR(200) NULL,
  `telegram_username` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

