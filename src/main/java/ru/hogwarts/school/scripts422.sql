create table person(
id serial primary key,
name text,
age integer,
driver_license boolean
car_id integer references car (id)
);
create table car(
id serial primary key,
brand text,
model text,
price integer
);
