DROP DATABASE IF EXISTS epam_feel;
DROP USER IF EXISTS epam_feel_app;

-- Create epam_feel user
CREATE USER epam_feel_app WITH password 'epam_feel_app';
-- Create database  
CREATE DATABASE epam_feel WITH OWNER = epam_feel_app ENCODING = 'UTF8' TABLESPACE = pg_default;