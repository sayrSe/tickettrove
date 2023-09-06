INSERT INTO `movie` (`title`, `poster`, `synopsis`, `short_description`, `release_date`, `runtime`, `rating`, `director`, `actors`)
VALUES
    ('Barbie', 'https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg', 'synopsis 3', 'short_description 3', '2023-09-05', 99, 'rating 3', 'director 3', 'cast 3'),
    ('Oppenheimer', 'https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', '2023-09-05', 24, 'rating 2', 'director 2', 'cast 2'),
    ('Barbie', 'https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg', 'synopsis 3', 'short_description 3', '2023-09-05', 99, 'rating 3', 'director 3', 'cast 3'),
    ('Avengers: Infinity War', 'https://image.tmdb.org/t/p/w500/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg', 'synopsis 1', 'short_description 1', '2023-09-05', 1, 'rating 1', 'director 1', 'cast 1'),
    ('Oppenheimer', 'https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', '2023-09-05', 24, 'rating 2', 'director 2', 'cast 2'),
    ('Oppenheimer', 'https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', '2023-09-05', 24, 'rating 2', 'director 2', 'cast 2'),
    ('Barbie', 'https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg', 'synopsis 3', 'short_description 3', '2023-09-05', 99, 'rating 3', 'director 3', 'cast 3'),
    ('Oppenheimer', 'https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', '2023-09-05', 24, 'rating 2', 'director 2', 'cast 2'),
    ('Barbie', 'https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg', 'synopsis 3', 'short_description 3', '2023-09-05', 99, 'rating 3', 'director 3', 'cast 3'),
    ('Oppenheimer', 'https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', 'The story of J. Robert Oppenheimer’s role in the development of the atomic bomb during World War II.', '2023-09-05', 24, 'rating 2', 'director 2', 'cast 2'),
    ('Barbie', 'https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg', 'synopsis 3', 'short_description 3', '2023-09-05', 99, 'rating 3', 'director 3', 'cast 3'),
    ('Blade Runner 2049', 'https://m.media-amazon.com/images/M/MV5BNzA1Njg4NzYxOV5BMl5BanBnXkFtZTgwODk5NjU3MzI@._V1_FMjpg_UX1000_.jpg', 'Thirty years after the events of Blade Runner (1982), a new Blade Runner, L.A.P.D. Officer K (Ryan Gosling), unearths a long-buried secret that has the potential to plunge what\'s left of society into chaos.', ' K\'s discovery of a long-buried secret leads him to track down former Blade Runner Rick Deckard.', '2023-09-05', 164, 'Rated R', 'Denis Villeneuve', 'Harrison Ford, Ryan Gosling, Ana de Armas'),
    ('Blade Runner 2049', 'https://m.media-amazon.com/images/M/MV5BNzA1Njg4NzYxOV5BMl5BanBnXkFtZTgwODk5NjU3MzI@._V1_FMjpg_UX1000_.jpg', 'Thirty years after the events of Blade Runner (1982), a new Blade Runner, L.A.P.D. Officer K (Ryan Gosling), unearths a long-buried secret that has the potential to plunge what\'s left of society into chaos.', ' K\'s discovery of a long-buried secret leads him to track down former Blade Runner Rick Deckard.', '2023-09-05', 164, 'Rated R', 'Denis Villeneuve', 'Harrison Ford, Ryan Gosling, Ana de Armas');

-- Insert data into the `cinema` table
INSERT INTO `cinema` (`name`, `hall_number`, `address`) VALUES
('Ayala Malls Manila Bay', 1, '123 Main Street'),
('Ayala Malls Manila Bay', 2, '123 Main Street'),
('Mall of Asia Cinema', 1, 'Pasay City'),
('Mall of Asia Cinema', 2, 'Pasay City'),
('Cinema 3', 1, 'Makati City');

-- Insert data into the `seat` table
INSERT INTO `seat` (`cinema_id`, `row_num`, `seat_num`, `is_reserved`) VALUES
(1, 1, 1, 0),
(1, 1, 2, 0),
(1, 1, 3, 0),
(1, 2, 1, 0),
(1, 2, 2, 0),
(1, 2, 3, 0),
(2, 1, 1, 0),
(2, 1, 2, 0),
(2, 1, 3, 0),
(2, 2, 1, 0),
(2, 2, 2, 0),
(2, 2, 3, 0),
(3, 1, 1, 0),
(3, 1, 2, 0),
(3, 1, 3, 0),
(4, 1, 1, 0),
(4, 1, 2, 0),
(4, 1, 3, 0),
(5, 1, 1, 0),
(5, 1, 2, 0),
(5, 1, 3, 0);

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `start_time`, `end_time`)
VALUES
    (1, 1, '2023-09-18 10:00:00', '2023-09-18 11:30:00'),
    (1, 1, '2023-09-19 13:00:00', '2023-09-19 14:30:00'),
    (1, 1, '2023-09-20 16:00:00', '2023-09-20 17:30:00');


INSERT INTO `showtime` (`movie_id`, `cinema_id`, `start_time`, `end_time`)
VALUES
    (2, 2, '2023-09-18 10:00:00', '2023-09-18 11:30:00'),
    (2, 2, '2023-09-19 13:00:00', '2023-09-19 14:30:00'),
    (2, 2, '2023-09-20 16:00:00', '2023-09-20 17:30:00');

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `start_time`, `end_time`)
VALUES
    (4, 4, '2023-09-18 10:00:00', '2023-09-18 11:30:00'),
    (4, 4, '2023-09-19 13:00:00', '2023-09-19 14:30:00'),
    (4, 4, '2023-09-20 16:00:00', '2023-09-20 17:30:00');

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `start_time`, `end_time`)
VALUES
    (13, 3, '2023-09-18 10:00:00', '2023-09-18 11:30:00'),
    (13, 3, '2023-09-19 13:00:00', '2023-09-19 14:30:00'),
    (13, 3, '2023-09-20 16:00:00', '2023-09-20 17:30:00');
