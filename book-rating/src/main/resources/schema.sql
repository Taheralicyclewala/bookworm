create table IF NOT EXISTS user_rating (
book_id varchar(15) not null,
user_id varchar(255) not null,
rating  tinyint not null,
primary key (book_id,user_id))Engine=InnoDB;


create table IF NOT EXISTS book_rating (
book_id varchar(15) not null primary key,
ratings bigint not null,
avg_rating float(4,3) not null)Engine=InnoDB;

