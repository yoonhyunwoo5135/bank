create database bank

use bank

create table member(
	id varchar(20),
	name varchar(20),
	age int(20),
	tel varchar(20)
)

select count(*) from member

insert into member values(id, name, age, tel)

update member set tel = new tel where id = id

delete from member where id = id

select * from member where id = ?

select * from member