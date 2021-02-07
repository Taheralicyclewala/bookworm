create table IF NOT EXISTS user(
id bigint primary key auto_increment,
name varchar(100) not null,
username varchar(200) not null unique,
email varchar(200) not null unique)Engine=InnoDB;
