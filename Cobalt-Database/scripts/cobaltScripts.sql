create table cobalt.userlist(id integer not null generated always as identity (start with 1, increment by 1), device varchar(20) not null unique, constraint primary_key primary key (id));
drop table cobalt.userlist;

