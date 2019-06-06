DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL
);

INSERT INTO movies (title) VALUES
  ('Full Metal Jacket'),
  ('Barry Lyndon'),
  ('Paths of Glory'),
  ('Eyes Wide Shut');
