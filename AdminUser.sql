CREATE DATABASE IF NOT EXISTS app;

use app;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost'
WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%'
WITH GRANT OPTION;

flush privileges;