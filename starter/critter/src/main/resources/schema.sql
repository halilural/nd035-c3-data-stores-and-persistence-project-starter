create table IF NOT EXISTS customer
(
    id           bigint not null auto_increment,
    name         nvarchar(255),
    notes        varchar(255),
    phone_number varchar(255) unicode,
    primary key (id)
);

create table if not exists employee
(
    id   bigint not null auto_increment,
    name nvarchar(255),
    primary key (id)
);

create table if not exists employee_days_available
(
    employee_id    bigint not null,
    days_available integer
);

create table if not exists employee_skills
(
    employee_id bigint not null,
    skills      integer
);


create table if not exists schedule
(
    id   bigint not null auto_increment,
    date date,
    primary key (id)
);

create table if not exists schedule_activities
(
    schedule_id bigint not null,
    activities  integer
);

create table if not exists schedule_employees
(
    schedule_id  bigint not null,
    employees_id bigint not null,
    primary key (schedule_id, employees_id)
);

create table if not exists pet
(
    id         bigint not null auto_increment,
    birth_date date,
    name       varchar(255),
    notes      varchar(255),
    owner_id   bigint,
    type       varchar(50),
    primary key (id)
);

create table if not exists customer_pets
(
    customer_id bigint not null,
    pet_id      bigint not null
);

create table if not exists schedule_pets
(
    schedule_id bigint not null,
    pet_id      bigint not null
);