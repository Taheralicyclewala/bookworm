create table IF NOT EXISTS user_review(
book_id varchar(15) not null,
user_id varchar(255) not null,
review varchar(500) not null,
primary key (book_id,user_id))Engine=InnoDB;
