CREATE TABLE `sobytylnik`.`profiles` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT(3) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `birthDate` VARCHAR(10) NOT NULL,
  `twitterPage` VARCHAR(45),
  `instagramPage` VARCHAR(45),
  `facebookPage` VARCHAR(45),
  `telegramUserName` VARCHAR(45),
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = UTF8MB4 ;