create sequence hibernate_sequence start with 1 increment by 1;

create table bid (
id bigint not null,
address varchar(255) not null check (address<=100),
credit_amount bigint not null,
initial_fee bigint not null,
buyer_id bigint,
seller_id bigint,
primary key (id));

create table buyer (
id bigint not null,
day_of_birth timestamp not null,
name varchar(32),
passport_number varchar(255),
patronymic varchar(32),
phone_number varchar(255),
surname varchar(32),
primary key (id));

create table seller (
id bigint not null,
company_title varchar(32),
day_of_birth timestamp,
company_inn varchar(12),
name varchar(32),
passport_number varchar(255),
patronymic varchar(32),
phone_number varchar(255),
surname varchar(32),
primary key (id));

alter table bid add constraint FKfbfgg6mh2dud0jk5xcj5iw7uh foreign key (buyer_id) references buyer;

alter table bid add constraint FKfxh4fonmvns5s9q5s72w3rmly foreign key (seller_id) references seller;