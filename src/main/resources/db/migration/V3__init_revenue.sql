create table revenue (
    id bigserial not null PRIMARY KEY,
    amount_of_revenue integer not null,
    revenue_date date not null,
    carshowroom_id bigint not null
);
create index revenueDate_indx on revenue(revenue_date);

alter table if exists revenue
    add constraint car_show_room_revenue_fk foreign key (carshowroom_id) references car_sale.public.car_showroom;