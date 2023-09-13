
create table revenue (
    id bigserial not null PRIMARY KEY,
    amount_of_revenue integer not null,
    revenue_date date not null
);
create index revenueDate_indx on revenue(revenue_date);