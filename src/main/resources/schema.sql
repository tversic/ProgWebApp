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
create table if not exists user (
                                    id identity,
                                    username varchar(100) not null unique,
                                    password varchar(1000) not null
);
create table if not exists authority (
                                         id identity,
                                         authority_name varchar(100) not null unique
);
create table if not exists user_authority (
                                              user_id bigint not null,
                                              authority_id bigint not null,
                                              constraint fk_user foreign key (user_id) references user(id),
                                              constraint fk_authority foreign key (authority_id) references authority(id)
);
