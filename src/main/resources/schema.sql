CREATE TABLE IF NOT EXISTS Skill(
    id INT NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(250) NOT NULL,
    difficulty varchar(100) NOT NULL,
    progress varchar(100) NOT NULL,
    PRIMARY KEY (id)
);