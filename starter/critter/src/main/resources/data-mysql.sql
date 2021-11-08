insert ignore into customer
set id           = 1,
    name         = 'Halil URAL',
    notes        = 'Owner of the cat',
    phone_number = '999999999';

insert ignore into pet
set id         = 1,
    birth_date = now(),
    name       = 'Cat',
    notes      = 'Kitty Cat',
    owner_id   = 1,
    type       = 0;

#employee

insert ignore into employee
set id   = 1,
    name = 'Kevin Goodman';

delete
from employee_days_available;
delete
from employee_skills;
delete
from schedule_pets;
delete
from schedule_activities;
delete
from schedule_employees;

insert ignore into employee_days_available
set employee_id    = 1,
    days_available = 0;

insert ignore into employee_days_available
set employee_id    = 1,
    days_available = 1;

insert ignore into employee_days_available
set employee_id    = 1,
    days_available = 2;

insert ignore into employee_days_available
set employee_id    = 1,
    days_available = 3;

insert ignore into employee_days_available
set employee_id    = 1,
    days_available = 4;

insert ignore into employee_skills
set employee_id = 1,
    skills      = 0;

insert ignore into employee_skills
set employee_id = 1,
    skills      = 1;

insert ignore into employee_skills
set employee_id = 1,
    skills      = 2;

#schedule

insert ignore into schedule
set id   = 1,
    date = NOW();

insert ignore into schedule
set id   = 1,
    date = NOW();

insert ignore into schedule_activities
set schedule_id = 1,
    activities  = 0;

insert ignore into schedule_activities
set schedule_id = 1,
    activities  = 1;

insert ignore into schedule_activities
set schedule_id = 1,
    activities  = 2;

insert ignore into schedule_employees
set schedule_id  = 1,
    employees_id = 1;

insert ignore into schedule_pets
set schedule_id = 1,
    pet_id      = 1;


