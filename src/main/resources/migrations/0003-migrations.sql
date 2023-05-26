create tabel autobuset(
    bus_id int primary key AUTO_INCREMENT not null,
    bus_company int not null,
    bus_seats int,
    foreign key(bus_company) references bus_company(company_id)
);