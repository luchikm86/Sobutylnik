CREATE TABLE `sobytylnik`.`profiles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `birthday` VARCHAR(45) NULL,
  `twitter_page` VARCHAR(45) NULL,
  `instagram_page` VARCHAR(45) NULL,
  `facebook_page` VARCHAR(45) NULL,
  `telegram_username` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

