CREATE TABLE IF NOT EXISTS `movie` (
	  `id` INT AUTO_INCREMENT PRIMARY KEY,
	  `title` VARCHAR(255) NULL,
	  `poster` VARCHAR(255) NULL,
	  `synopsis` VARCHAR(255) NULL,
	  `short_description` VARCHAR(255) NULL,
	  `release_date` DATE NULL,
	  `runtime` INT NULL,
	  `rating` VARCHAR(255) NULL,
	  `director` VARCHAR(255) NULL,
	  `actors` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `cinema` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255) NULL,
	`hall_number` INT,
	`address` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `seat` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`cinema_id` INT,
	`row_num` INT,
	`seat_num` INT,
	`is_reserved` BOOLEAN,
	FOREIGN KEY (cinema_id) REFERENCES cinema (id)
);

CREATE TABLE IF NOT EXISTS `showtime` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`movie_id` INT,
	`cinema_id` INT,
	`start_time` TIMESTAMP NULL,
	`end_time` TIMESTAMP NULL,
	FOREIGN KEY (movie_id) REFERENCES movie (id),
	FOREIGN KEY (cinema_id) REFERENCES cinema (id)
);

CREATE TABLE `booking` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `showtime_id` INT,
    `seat_id` INT,
    `customer_phone` VARCHAR(20) DEFAULT NULL,
    `booking_date` TIMESTAMP DEFAULT NULL,
    `booking_status` VARCHAR(50) DEFAULT NULL,
    `booking_code` VARCHAR(50) DEFAULT NULL,
    FOREIGN KEY (showtime_id) REFERENCES showtime (id),
    FOREIGN KEY (seat_id) REFERENCES seat (id)
);
