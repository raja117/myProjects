drop table user_login_details;

drop table user_bank_details;

drop table user_details;

create table user_details(user_id int primary key auto_increment, Name varchar(50),gender varchar(10),address varchar(50), city varchar(20), state varchar(20),country varchar(20));

create table user_bank_details(user_bank_id int primary key auto_increment, bank_name varchar(30), acc_no varchar(20), ssn varchar(10), fk_user_id int, foreign key(fk_user_id) references user_details(user_id));

create table user_login_details (user_email varchar(40) primary key, user_password varchar(20), fk_user_id int, foreign key(fk_user_id) references user_details(user_id));