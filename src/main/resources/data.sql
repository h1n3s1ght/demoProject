drop table if exists customer cascade;
drop table if exists customer_orders cascade;
drop table if exists inventory cascade;
drop table if exists inventory_orders cascade;
drop table if exists Order_Item cascade;
drop sequence if exists customer_seq;
drop sequence if exists inventory_seq;
drop sequence if exists order_seq;


-- create table customer
-- (
--     id    INTEGER not null,
--     email VARCHAR,
--     full_name  VARCHAR,
--     phone VARCHAR
-- );
-- insert into customer(id,email,full_name,phone)
-- values(10001,'sanjana@gmail.com','Sanjana','321-456-7890');
-- insert into customer(id,email,full_name,phone)
-- values(10002,'shika@gmail.com','Shika','543-532-6516');
-- insert into customer(id,email,full_name,phone)
-- values(10003,'pavan@gmail.com','Pavan','523-520-8036');
-- insert into customer(id,email,full_name,phone)
-- values(10004,'rohit@gmail.com','Rohit','524-765-4321');



create table orderItem
(
    id          INTEGER not null,
    dateOrdered DATE,
    timeOrdered TIME,
    status      VARCHAR
);
insert into orderItem(id, dateOrdered, timeOrdered, status)
values(60001, DATE'2022-04-04', TIME '12:32:01.555', 'Approved');
insert into orderItem(id, dateOrdered, timeOrdered, status)
values(60002, DATE'2022-04-03', TIME'19:32:01.555', 'Pending');
insert into orderItem(id, dateOrdered, timeOrdered, status)
values(60003, DATE'2022-04-12', TIME'13:32:01.555', 'Approved');
insert into orderItem(id, dateOrdered, timeOrdered, status)
values(60004, DATE'2022-04-29', TIME'17:32:01.555', 'Approved');



create table inventory
(
    id       INTEGER not null,
    name     VARCHAR not null,
    price    DECIMAL(10,2) not null,
    quantity INTEGER not null
);
insert into inventory(id, name, price, quantity)
values(40001, 'Key Chain', 5.99 , 120);
insert into inventory(id, name, price, quantity)
values(40002, 'Hoodie', 25.99 , 190);
insert into inventory(id, name, price, quantity)
values(40003, 'T-Shirt', 15.99 , 120);
insert into inventory(id, name, price, quantity)
values(40004, 'Water Bottle', 19.99 , 20);
insert into inventory(id, name, price, quantity)
values(40005, 'Sticker', .49 , 2000);
insert into inventory(id, name, price, quantity)
values(40006, 'Video Game', 59.99 , 12);



insert into Ordered_Items(Order_Num, Item_Num)
values(60001, 40002);
insert into Ordered_Items(Order_Num, Item_Num)
values(60001, 40003);
insert into Ordered_Items(Order_Num, Item_Num)
values(60001, 40004);
insert into Ordered_Items(Order_Num, Item_Num)
values(60001, 40005);


insert into Ordered_Items(Order_Num, Item_Num)
values(60002, 40001);
insert into Ordered_Items(Order_Num, Item_Num)
values(60002, 40002);


insert into Ordered_Items(Order_Num, Item_Num)
values(60003, 40001);
insert into Ordered_Items(Order_Num, Item_Num)
values(60003, 40003);
insert into Ordered_Items(Order_Num, Item_Num)
values(60003, 40005);

insert into Ordered_Items(Order_Num, Item_Num)
values(60004, 40006);