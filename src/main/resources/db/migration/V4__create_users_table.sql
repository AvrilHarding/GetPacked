create table users (
user_id SERIAL PRIMARY KEY,
first_name VARCHAR(60),
last_name VARCHAR(60),
username VARCHAR(60),
email_address VARCHAR(100),
password VARCHAR(20)
);