create table IF NOT EXISTS author(
id int primary key auto_increment,
name varchar(50) not null unique)Engine=InnoDB; 

create table IF NOT Exists country(
id int primary key auto_increment,
name char(35) not null unique)Engine=InnoDB; 

create table IF NOT Exists category(
id int primary key auto_increment,
type char(100) not null unique)Engine=InnoDB; 

create table IF NOT Exists language(
id int primary key auto_increment,
name char(35) not null unique)Engine=InnoDB; 

create table IF NOT EXISTS book(
id int auto_increment primary key,
isbn10 varchar(15) not null unique,
title varchar(200) unique not null,
author_id int not null references author(id),
language_id int not null references language(id),
country_id int not null references country(id),
synopsis varchar(500),
publisher varchar(200),
print_length int,
publication_date date)Engine=InnoDB;

create table IF NOT EXISTS book_category_mapping(
book_id int references book(id),
category_id int references category(id),
primary key (book_id,category_id))Engine=InnoDB;
