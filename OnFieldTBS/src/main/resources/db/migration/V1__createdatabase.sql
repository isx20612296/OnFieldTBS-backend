
-- CREATE DATABASE SCHEMA

CREATE TABLE IF NOT EXISTS nivel(
    id_nivel UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS plan_mantenimiento(
    id_plan UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    nombre varchar(20) NOT NULL,
    descripcion TEXT,
    precio numeric(5,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS tecnico(
    id_tecnico UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    nombre varchar(30) NOT NULL,
    apellido varchar(30) NOT NULL,
    id_nivel UUID REFERENCES nivel(id_nivel) ON DELETE CASCADE,
    nombre_usuario varchar(20) NOT NULL UNIQUE,
    passwd varchar(255) NOT NULL,
    correo varchar(40),
    carnet smallint DEFAULT 0,
    telefono varchar(15) NOT NULL,
    fecha_alta timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS empresa(
    id_empresa UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    nombre varchar(30) NOT NULL,
    nif varchar(9) NOT NULL UNIQUE,
    direccion varchar(50) NOT NULL,
    telefono varchar(15) NOT NULL,
    correo varchar(40) NOT NULL UNIQUE,
    id_plan_mantenimiento  UUID REFERENCES plan_mantenimiento(id_plan) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS empleado(
    id_empleado UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    nombre varchar(30) NOT NULL,
    apellido varchar(30) NOT NULL,
    id_empresa UUID REFERENCES empresa(id_empresa) ON DELETE CASCADE,
    ext_telefono varchar(10),
    telefono_directo varchar(15),
    correo varchar(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS incidencia(
    id_incidencia UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    id_empresa  UUID REFERENCES empresa(empresa) ON DELETE CASCADE,
    id_empleado  UUID REFERENCES empleado(id_empleado) ON DELETE CASCADE,
    id_tecnico  UUID REFERENCES tecnico(id_tecnico) ON DELETE CASCADE,
    titulo varchar(30) NOT NULL,
    descripcion varchar(2000) NOT NULL,
    estado varchar(20) NOT NULL,
    prioridad varchar(20) NOT NULL DEFAULT 'Baja',
    fecha_creacion timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre timestamp
);

CREATE TABLE IF NOT EXISTS comentario_incidencia(
    id_comentario UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    id_incidencia UUID REFERENCES incidencia(id_incidencia) ON DELETE CASCADE,
    id_tecnico UUID REFERENCES tecnico(id_tecnico) ON DELETE CASCADE,
    mensaje varchar(2000) NOT NULL,
    fecha_creacion timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);