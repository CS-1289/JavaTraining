USE lms_db;

CREATE TABLE IF NOT EXISTS courses (
    idcourses INT NOT NULL,
    course_name VARCHAR(45) NOT NULL,
    description VARCHAR(45) NULL,
    PRIMARY KEY (idcourses),
    UNIQUE INDEX idcourses_UNIQUE (idcourses ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT IGNORE INTO courses (idcourses, course_name, description) VALUES
    (1, 'Java Fundamentals', 'Core Java, OOP, arrays and exceptions'),
    (2, 'Spring Framework', 'Spring Core, IoC and dependency injection'),
    (3, 'Hibernate ORM', 'Hibernate mappings, CRUD and HQL'),
    (4, 'SQL and MySQL', 'Database design, SQL queries and MySQL'),
    (5, 'Web Development', 'JSP, Servlets, Spring MVC and Bootstrap');

INSERT INTO users (username, password, full_name, email, role, created_at)
SELECT 'demo.user', 'Demo@123', 'Demo User', 'demo@example.com', 'ADMIN', NOW()
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'demo@example.com');
