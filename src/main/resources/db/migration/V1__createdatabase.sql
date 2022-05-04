
-- CREATE DATABASE SCHEMA

CREATE TABLE IF NOT EXISTS levels(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(20) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS maintenance_plan(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(20) NOT NULL,
    description TEXT,
    price numeric(5,2) NOT NULL
);

CREATE TABLE usser (
  user_id uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
  username varchar(24) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  role varchar(10),
  enabled boolean DEFAULT true);

CREATE TABLE IF NOT EXISTS technician(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    level_id UUID REFERENCES levels(id) ON DELETE CASCADE,
    user_id UUID REFERENCES usser(user_id) ON DELETE CASCADE,
    email varchar(40) UNIQUE,
    license smallint DEFAULT 0,
    phone varchar(15) NOT NULL UNIQUE,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS company(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(30) NOT NULL,
    nif varchar(9) NOT NULL UNIQUE,
    address varchar(50) NOT NULL,
    phone varchar(15) NOT NULL UNIQUE,
    email varchar(40) NOT NULL UNIQUE,
    maintenance_id UUID REFERENCES maintenance_plan(id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS employee(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    company_id UUID REFERENCES company(id) ON DELETE CASCADE,
    phone_ext varchar(10),
    direct_phone varchar(15) UNIQUE,
    email varchar(40) NOT NULL UNIQUE,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS incidence(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    company_id  UUID REFERENCES company(id) ON DELETE CASCADE,
    employee_id  UUID REFERENCES employee(id) ON DELETE CASCADE,
    technician_id  UUID REFERENCES technician(id) ON DELETE CASCADE,
    title varchar(30) NOT NULL,
    description varchar(2000) NOT NULL,
    state varchar(20) NOT NULL,
    priority varchar(20) NOT NULL DEFAULT 'Baja',
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    closed_at timestamp
);

CREATE TABLE IF NOT EXISTS comment(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    incidence_id UUID REFERENCES incidence(id) ON DELETE CASCADE,
    technician_id UUID REFERENCES technician(id) ON DELETE CASCADE,
    message varchar(2000) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

