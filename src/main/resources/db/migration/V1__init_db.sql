create table car (
    left_in_stock integer not null,
    price float(53) not null,
    year integer not null,
    carshowroom_id bigint,
    id bigserial not null,
    mark varchar(255) not null,
    model varchar(255) not null,
    type varchar(255) not null check (type in ('PASSENGER_CAR','FREIGHTER_CAR','SPORT_CAR')),
    primary key (id)
);

create table car_showroom (
    id bigserial not null,
    name varchar(255) not null,
    primary key (id)
);

create table orders (
    car_id bigint not null,
    date_of_sale timestamp(6) not null,
    id bigserial not null,
    salesman_id bigint not null,
    primary key (id)
);

create table seller (
    age integer not null,
    number_of_cars_sold integer not null,
    carshowroom_id bigint,
    id bigserial not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    role varchar(255) not null check (role in ('SELLER','MANAGER')),
    primary key (id)
);

create index carshowroom_car_indx on car (carshowroom_id);

create index order_salesman_indx on orders (salesman_id);

create index order_car_indx on orders (car_id);

create index car_shoow_room_seller_indx on seller (carshowroom_id);

alter table if exists car
    add constraint car_shoow_romm_fk foreign key (carshowroom_id) references car_showroom;

alter table if exists orders
    add constraint order_car_fkey foreign key (car_id) references car;

alter table if exists orders
    add constraint order_salesman_fkey foreign key (salesman_id) references seller;

alter table if exists seller
    add constraint car_shoow_room_seller_fk foreign key (carshowroom_id) references car_showroom;