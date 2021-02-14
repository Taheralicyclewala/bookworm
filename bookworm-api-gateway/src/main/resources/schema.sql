create table IF NOT EXISTS user(
id bigint primary key auto_increment,
name varchar(100) not null,
username varchar(200) not null unique,
email varchar(200) not null unique,
password varchar(255) not null,
role_id bigint not null references roles(id)
)Engine=InnoDB;


create table IF NOT EXISTS roles(
id bigint primary key auto_increment,
name varchar(40) not null
)Engine=InnoDB;