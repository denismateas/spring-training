set search_path to shop;

CREATE EXTENSION "uuid-ossp";

alter table if exists orders drop constraint if exists FKp1mlwxe5nhua51hv0fo39ywbw;
alter table if exists product drop constraint if exists FKbvdd7owwhvkamc6unq83xdcrj;
alter table if exists stock drop constraint if exists FK3wsg6ykqr8aw8r77rsogn5jwi;
alter table if exists stock drop constraint if exists FK2qw3dn28c2ycrur4qc7tm8u2u;
drop table if exists customer cascade;
drop table if exists location cascade;
drop table if exists order_detail cascade;
drop table if exists orders cascade;
drop table if exists product cascade;
drop table if exists product_category cascade;
drop table if exists stock cascade;

create table customer (id uuid not null default uuid_generate_v4(), email_address varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), primary key (id));
create table location (id uuid not null default uuid_generate_v4(), city varchar(255), country varchar(255), county varchar(255), name varchar(255), street varchar(255), primary key (id));
create table order_detail (quantity integer not null, location uuid, orders uuid not null, product uuid not null, primary key (orders, product));
create table orders (created_at timestamp(6), customer uuid, id uuid not null default uuid_generate_v4(), city varchar(255), country varchar(255), county varchar(255), street varchar(255), primary key (id));
create table product (weight float(53) not null, price bigint not null, id uuid not null default uuid_generate_v4(), product_category uuid not null, description varchar(255), image_url varchar(255), name varchar(255), primary key (id));
create table product_category (id uuid not null default uuid_generate_v4(), description varchar(255), name varchar(255), primary key (id));
create table stock (quantity integer not null, location_id uuid not null, product_id uuid not null, primary key (location_id, product_id));
alter table if exists order_detail add constraint FKgn4buybec6yic8a026fnk27g8 foreign key (orders) references orders;
alter table if exists order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product;
alter table if exists orders add constraint FKp1mlwxe5nhua51hv0fo39ywbw foreign key (customer) references customer;
alter table if exists product add constraint FKbvdd7owwhvkamc6unq83xdcrj foreign key (product_category) references product_category;
alter table if exists stock add constraint FK3wsg6ykqr8aw8r77rsogn5jwi foreign key (location_id) references location;
alter table if exists stock add constraint FK2qw3dn28c2ycrur4qc7tm8u2u foreign key (product_id) references product;