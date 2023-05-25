BEGIN TRANSACTION;

DROP TABLE IF EXISTS league_memberships, rounds, score_details, scores, handicaps, notifications,
reviews, holes, tee_boxes, courses, league, users, golf_bags,friends, followers, tournaments, leaderboard, achievements, user_achievements;

CREATE TABLE users (
  user_id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE league (
  league_id SERIAL PRIMARY KEY,
  league_name VARCHAR(255) NOT NULL,
  creator_id INT REFERENCES users(user_id)
);

CREATE TABLE league_memberships (
  membership_id SERIAL PRIMARY KEY,
  league_id INT REFERENCES league(league_id),
  user_id INT REFERENCES users(user_id)
);

CREATE TABLE courses (
  course_id SERIAL PRIMARY KEY,
  course_name VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL,
  distance INT NOT NULL,
  course_rating INT NOT NULL,
  slope_rating INT NOT NULL
);

CREATE TABLE scores (
  score_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  course_id INT REFERENCES courses(course_id),
  date_played DATE NOT NULL,
  total_score INT NOT NULL,
  total_putts INT NOT NULL,
  total_fairways_hit INT NOT NULL,
  total_gir INT NOT NULL
);

CREATE TABLE holes (
  hole_id SERIAL PRIMARY KEY,
  course_id INT REFERENCES courses(course_id),
  hole_number INT NOT NULL,
  par INT NOT NULL,
  distance INT NOT NULL,
  hazard BOOLEAN NOT NULL
);

CREATE TABLE score_details (
  score_detail_id SERIAL PRIMARY KEY,
  score_id INT REFERENCES scores(score_id),
  hole_id INT REFERENCES holes(hole_id),
  score INT NOT NULL,
  putts INT NOT NULL,
  fairways_hit BOOLEAN NOT NULL,
  gir BOOLEAN NOT NULL
);

CREATE TABLE tournaments (
  tournament_id SERIAL PRIMARY KEY,
  tournament_name VARCHAR(255) NOT NULL,
  date DATE,
  location VARCHAR(255),
  registration_info TEXT,
  rules TEXT,
  fee DECIMAL(8, 2),
  organizer_user_id INT REFERENCES users(user_id)
);

CREATE TABLE notifications (
  notification_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  notification_type VARCHAR(255),
  message TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE reviews (
  review_id SERIAL PRIMARY KEY,
  course_id INT REFERENCES courses(course_id),
  reviewer_name VARCHAR(255),
  review_date DATE,
  rating INT,
  comments TEXT
);

CREATE TABLE tee_boxes (
  tee_box_id SERIAL PRIMARY KEY,
  course_id INT REFERENCES courses(course_id),
  tee_box_name VARCHAR(255),
  color VARCHAR(255),
  distance INT,
  par INT,
  course_rating DECIMAL(4, 2),
  slope_rating INT
);

CREATE TABLE handicaps (
  handicap_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  handicap_index DECIMAL(4, 2) NOT NULL,
  revision_date DATE NOT NULL
);

CREATE TABLE rounds (
  round_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  course_id INT REFERENCES courses(course_id),
  tee_box_id INT REFERENCES tee_boxes(tee_box_id),
  date_played DATE NOT NULL,
  weather_conditions VARCHAR(255),
  tee_time TIME,
  tee_box_name VARCHAR(255),
  total_score INT NOT NULL,
  total_putts INT NOT NULL,
  total_fairways_hit INT NOT NULL,
  total_gir INT NOT NULL
);

CREATE TABLE golf_bags (
  bag_id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(user_id),
  club_name VARCHAR(255) NOT NULL,
  brand VARCHAR(255),
  club_type VARCHAR(255),
  loft INTEGER,
  shaft_flex VARCHAR(255),
  grip VARCHAR(255),
  balls VARCHAR(255),
  glove VARCHAR(255),
  rang_finder VARCHAR(255)
);

CREATE TABLE friends (
  friendship_id SERIAL PRIMARY KEY,
  user_id1 INT REFERENCES users(user_id),
  user_id2 INT REFERENCES users(user_id)
);

CREATE TABLE followers (
  follower_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  follower_user_id INT REFERENCES users(user_id)
);

CREATE TABLE leaderboard (
  leaderboard_id SERIAL PRIMARY KEY,
  tournament_id INT REFERENCES tournaments(tournament_id),
  user_id INT REFERENCES users(user_id),
  round_id INT REFERENCES rounds(round_id),
  rank INT
);

CREATE TABLE achievements (
  achievement_id SERIAL PRIMARY KEY,
  achievement_name VARCHAR(255) NOT NULL,
  description TEXT,
  requirement TEXT
);

CREATE TABLE user_achievements (
  user_achievement_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  achievement_id INT REFERENCES achievements(achievement_id),
  achieved_date DATE
);


COMMIT;

ROLLBACK;