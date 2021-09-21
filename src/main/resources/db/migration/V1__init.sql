create table users(
                     id serial primary key ,
                     username varchar(250) not null unique,
                     password varchar(250) not null,
                     name varchar(250),
                     surname varchar(250),
                     created_at timestamptz not null,
                     email varchar(250) not null unique
);

create table orders(
                      id serial primary key,
                      name varchar(250) not null,
                      price int not null
);

create table user_order(
                           user_id int references users(id),
                           order_id int references orders(id),
                           price int not null,
                           created_at timestamptz not null,
                           PRIMARY KEY (user_id,order_id)
);

