create table autobuset(
bus_id integer not null auto_increment,
bus_company varchar(256) not null ,
bus_seats integer,
primary key(bus_id,bus_company));