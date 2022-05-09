create table hardware(
     id long auto_increment(3) not null primary key,
     name varchar(100),
     code varchar(100) not null,
     price double not null,
     type varchar(100) not null,
     stock int not null
);
create table review(
    id long auto_increment not null,
    name varchar(255),
    tekst varchar(256),
    ocjena varchar(256),
    id_hardware long,
    FOREIGN KEY (id_hardware) REFERENCES hardware(id)
);
