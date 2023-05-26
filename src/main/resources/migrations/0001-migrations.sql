create table oraret(
	bus_id int,
    prej varchar(255) not null,
    deri varchar(255) not null,
    koha_nisjes time,
    koha_arritjes time,
    cmimi_biletes real,
	PRIMARY KEY (bus_id, prej, deri, koha_nisjes),
    FOREIGN KEY (bus_id) REFERENCES autobuset(bus_id));