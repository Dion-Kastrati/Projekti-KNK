create table oraret(
	orari_id integer not null,
    company_name varchar(255) not null,
    prej varchar(255) not null,
    deri varchar(255) not null,
    koha_nisjes varchar(9) not null,
    koha_arritjes varchar(9) not null,
    cmimi_biletes double,
    PRIMARY KEY (company_name, prej, koha_nisjes)
);