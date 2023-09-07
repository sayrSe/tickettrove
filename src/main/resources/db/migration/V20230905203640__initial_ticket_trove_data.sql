SET time_zone = '+08:00';

INSERT INTO `movie` (`title`, `poster`, `synopsis`, `short_description`, `release_date`, `runtime`, `rating`, `director`, `actors`)
VALUES
  ('The Nun II', 'https://cdn1.clickthecity.com/images/movies/poster/400/19136_3.jpg', 'In 1956 France, a priest is murdered, and it seems an evil is spreading. Sister Irene once again comes face to face with a demonic force.', 'Sister Irene returns once again and comes face to face with the demonic force Valak, the Nun.', '2023-09-08', 109, 'Rated R', 'Michael Chaves', 'Taissa Farmiga, Jonas Bloquet, Storm Reid'),
  ('Deliver Us', 'https://cdn1.clickthecity.com/images/movies/poster/400/19481_2.jpg', 'A nun pregnant with twins finds herself the target of a terrifying religious sect convinced she’s about to give birth to the apocalypse. As she races into hiding, her only ally is a young priest undergoing a crisis of faith.', 'A nun pregnant with twins finds herself the target of a terrifying religious sect convinced she is about to give birth to the apocalypse', '2023-09-09', 90, 'Rated R', 'Cru Ennis, Lee Roy Kunz', 'Jaune Kimmel, Thomas Kretschmann, Lee Roy Kunz'),
  ('Teenage Mutant Ninja Turtles: Mutant Mayhem', 'https://cdn1.clickthecity.com/images/movies/poster/400/19167_4.jpg', 'After years of being sheltered from the human world, the Turtle brothers set out to win the hearts of New Yorkers and be accepted as normal teenagers through heroic acts.', 'Turtle brothers set out to win the hearts of New Yorkers', '2023-09-02', 100, 'PG', 'Jeff Rowe', 'Nicolas Cantu, Shamon Brown Jr, Micah Abbey'),
  ('Retribution', 'https://cdn1.clickthecity.com/images/movies/poster/400/19481_2.jpg', 'Matt Turner is a successful Berlin based American businessman juggling a booming financial career with family responsibility', 'Driving his kids to school one morning, Matt receives a phone call from a mysterious voice: there’s a bomb under his seat that will detonate unless he completes a specific series of tasks, and fast', '2023-08-23', 100, 'PG', 'Nimrod Antal', 'Liam Neeson, Jack Champion, Emily Kusche'),
  ('Meg 2 The Trench', 'https://api.mycinema.ph/VistaBookingCMS/Images/MEG2---600X900_20230725175225.jpg', 'Jonas Taylor leads a research team on an exploratory dive into the deepest depths of the ocean. Their voyage spirals into chaos when a malevolent mining operation threatens their mission and forces them into a high-stakes battle for survival', 'A research team on an exploratory dive into the deepest depths of the ocean sees their', '2023-08-25', 105, 'PG', 'Ben Wheatley', 'Jason Statham, Jing Wu, Sienna Guillory, Cliff Curtis, Skyler Samuels'),
  ('BARBIE', 'https://api.mycinema.ph/VistaBookingCMS/Images/BARBIE---600X900_20230629184002.jpg', 'societal impact of the Barbie doll on history, accompanied by a clip of the original 1959 Barbie towering over a desert landscape, while little girls playing with baby dolls begin to destroy them', 'She decides to go to the Real World to find the cure in order to make herself perfect again.', '2023-08-25', 104, 'PG', 'Greta Gerwig', 'Margot Robbie, Ryan Gosling, Will Ferrell, Kingsley Ben-Adir'),
  ('Crayon Shin-Chan', 'https://cdn1.clickthecity.com/images/movies/poster/400/19512.jpg', 'Kindergartener Shinnosuke gaining telekinetic superpowers after a white light from space passes through Earth', 'Shinnosuke gaining telekinetic superpowers', '2023-09-13', 94, 'G', 'Hitoshi One', 'Yumiko Kobayashi, Miki Narahashi, Toshiyuki Morikawa'),
  ('Strays', 'https://cdn1.clickthecity.com/images/movies/poster/400/19309_1.jpg', 'When Reggie is abandoned on the mean city streets by his lowlife owner, Doug, Reggie is certain that his beloved owner would never leave him on purpose', 'Reggie is certain that his beloved owner would never leave him on purpose', '2023-09-13', 93, 'G', 'Josh Greenbaum', 'Will Ferrell, Jamie Foxx, Will Forte'),
  ('A Haunting in Venice', 'https://cdn1.clickthecity.com/images/movies/poster/600/19447_1.jpg', 'Celebrated sleuth Hercule Poirot, now retired and living in self-imposed exile in Venice, reluctantly attends a Halloween séance at a decaying, haunted palazzo', 'Hercule Poirot, now retired and living', '2023-09-13', 103, 'PG', 'Kenneth Branagh', 'Kenneth Branagh, Kyle Allen, Camille Cottin'),
  ('Equalizer 3', 'https://cdn1.clickthecity.com/images/movies/poster/600/18884_2.jpg', 'Robert McCall finds himself at home in Southern Italy but he discovers his friends are under the control of local crime bosses.', 'Discovers his friends are under the control of local crime bosses', '2023-09-13', 113, 'PG', 'Antoine Fuqua', 'Denzel Washington, Dakota Fanning, Gaia Scodellaro'),
  ('IU Concert: The Golden Hour', 'https://cdn1.clickthecity.com/images/movies/poster/600/19515.jpg', 'Celebrating the 15th anniversary of the artist’s debut, IU CONCERT : The Golden Hour comes to the big screen in this special Cinematic Cut', 'The Golden Hour comes to the big screen in this special Cinematic Cut', '2023-09-28', 171, 'G', 'An Jong-ho', 'UI');
INSERT INTO `movie` (`title`, `poster`, `synopsis`, `short_description`, `release_date`, `runtime`, `rating`, `director`, `actors`)
VALUES ('Oppenheimer', 'https://cdn1.clickthecity.com/images/movies/poster/400/18558_2.jpg', 'The story of J. Robert Oppenheimer, the physicist who led the Manhattan Project to develop the atomic bomb during World War II.', 'A biographical drama about the life of J. Robert Oppenheimer.', '2023-09-07', 150, 'PG-13', 'Christopher Nolan', 'Cillian Murph, Emily Blunt, Matt Damon');
INSERT INTO `movie` (`title`, `poster`, `synopsis`, `short_description`, `release_date`, `runtime`, `rating`, `director`, `actors`)
VALUES ('Mission: Impossible - Dead Reckoning Part One', 'https://cdn1.clickthecity.com/images/movies/poster/400/18526_4.jpg', 'Ethan Hunt and his team embark on another high-stakes mission to save the world from imminent danger.', 'Action-packed thriller starring Tom Cruise as Ethan Hunt.', '2023-09-07', 140, 'PG-13', 'Christopher McQuarrie', 'Tom Cruise');

INSERT INTO `cinema` (`name`, `address`) VALUES
('Ayala Malls Manila Bay', '123 Main Street'),
('Mall of Asia Cinema', 'Pasay City'),
('Cinema 3', 'Makati City');

INSERT INTO `hall` (`cinema_id`, `hall_number`, `max_row`, `max_col`) VALUES
(1, 1, 10, 10),
(1, 2, 10, 10),
(2, 1, 10, 10),
(2, 2, 10, 10),
(3, 1, 10, 10);

INSERT INTO `seat` (`hall_id`, `grid_row`, `grid_col`, `is_available`) VALUES
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

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (1, 1, 1, '2023-09-08 10:00:00', '2023-09-08 12:00:00'),
    (1, 1, 2, '2023-09-08 14:00:00', '2023-09-08 16:00:00'),
    (1, 2, 3, '2023-09-08 10:00:00', '2023-09-08 12:00:00'),
    (1, 3, 5, '2023-09-08 14:00:00', '2023-09-08 16:00:00'),
    (1, 3, 5, '2023-09-09 14:00:00', '2023-09-09 16:30:00'),
    (1, 3, 5, '2023-09-09 16:00:00', '2023-09-09 18:30:00'),
    (1, 2, 3, '2023-09-10 10:00:00', '2023-09-10 12:30:00');


INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (6, 1, 1, '2023-09-08 12:00:00', '2023-09-08 14:00:00'),
    (6, 1, 2, '2023-09-08 16:00:00', '2023-09-08 18:00:00'),
    (6, 2, 3, '2023-09-08 12:00:00', '2023-09-08 14:00:00'),
    (6, 3, 5, '2023-09-08 12:00:00', '2023-09-08 14:00:00'),
    (6, 3, 5, '2023-09-09 10:00:00', '2023-09-09 12:30:00'),
    (6, 2, 4, '2023-09-10 12:00:00', '2023-09-09 14:30:00');


INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (12, 1, 1, '2023-09-08 10:00:00', '2023-09-08 12:00:00'),
    (12, 1, 2, '2023-09-08 14:00:00', '2023-09-08 16:00:00'),
    (12, 1, 1, '2023-09-09 10:00:00', '2023-09-09 12:00:00'),
    (12, 2, 5, '2023-09-09 10:00:00', '2023-09-09 12:00:00'),
    (12, 3, 5, '2023-09-09 12:00:00', '2023-09-09 14:30:00'),
    (12, 3, 5, '2023-09-10 10:00:00', '2023-09-09 12:30:00'),
    (12, 1, 1, '2023-09-10 10:00:00', '2023-09-09 12:30:00');

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (2, 1, 1, '2023-09-11 10:00:00', '2023-09-11 12:00:00'),
    (2, 2, 3, '2023-09-11 10:00:00', '2023-09-11 12:00:00');

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (3, 1, 2, '2023-09-11 12:00:00', '2023-09-11 14:00:00'),
    (3, 2, 3, '2023-09-11 12:00:00', '2023-09-11 14:00:00');

INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (5, 1, 1, '2023-09-11 16:00:00', '2023-09-11 18:00:00'),
    (5, 2, 4, '2023-09-11 16:00:00', '2023-09-11 18:00:00');
INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (7, 1, 2, '2023-09-11 18:00:00', '2023-09-11 20:00:00'),
    (7, 2, 3, '2023-09-11 18:00:00', '2023-09-11 20:00:00'),
    (8, 1, 2, '2023-09-11 20:00:00', '2023-09-11 22:00:00'),
    (8, 3, 5, '2023-09-11 20:00:00', '2023-09-11 22:00:00'),
    (9, 2, 3, '2023-09-11 10:00:00', '2023-09-11 12:00:00'),
    (9, 3, 5, '2023-09-11 10:00:00', '2023-09-11 12:00:00'),
    (10, 2, 4, '2023-09-11 12:00:00', '2023-09-11 14:00:00'),
    (10, 3, 5, '2023-09-11 12:00:00', '2023-09-11 14:00:00'),
    (11, 2, 3, '2023-09-11 14:00:00', '2023-09-11 16:00:00'),
    (11, 3, 5, '2023-09-11 14:00:00', '2023-09-11 16:00:00');


INSERT INTO `showtime` (`movie_id`, `cinema_id`, `hall_id`, `start_time`, `end_time`)
VALUES
    (13, 3, 5, '2023-09-11 16:00:00', '2023-09-11 18:00:00'),
    (13, 3, 5, '2023-09-11 18:00:00', '2023-09-11 20:00:00');
Update movie
set  short_description   = 'Action-packed Thriller'
where id = 13;