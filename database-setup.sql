CREATE DATABASE IF NOT EXISTS ic_project_db;

CREATE USER IF NOT EXISTS 'ic_user'@'localhost' IDENTIFIED BY 'ic_password';
GRANT ALL PRIVILEGES ON ic_project_db.* TO 'ic_user'@'localhost';
FLUSH PRIVILEGES;

USE ic_project_db;
