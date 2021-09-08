create table user(
                     id serial primary key ,
                     username varchar(250) not null,
                     password varchar(250) not null,
                     name varchar(250),
                     surname varchar(250),
                     created_at timestamptz not null
);

create table order(
                      id serial primary key,
                      name varchar(250) not null,
                      price int not null
);

create table user_order(
                           user_id int references user(id),
                           order_id int references order(id),
                           price int not null,
                           created_at timestamptz not null,
                           PRIMARY KEY (user_id,order_id)
);

