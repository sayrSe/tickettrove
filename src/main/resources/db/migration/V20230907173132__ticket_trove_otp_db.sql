CREATE TABLE IF NOT EXISTS `otp` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `phone_number` VARCHAR(11),
	`code` VARCHAR(6)
);