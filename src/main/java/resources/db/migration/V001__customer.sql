create table customer(
id BIGSERIAL primary key,
name varchar(100) not null,
cpf varchar(11) not null,
postal_code varchar(100) not null,
street varchar(100) not null,
state varchar(100) not null,
city varchar(100) not null,
created_data timestamp
);create table account (
id BIGSERIAL not null primary key,
account_number bigint not null,
customer_id BIGSERIAL not null,
balance_money numeric not null,
created_data timestamp,

CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id)
REFERENCES customer(id)
);