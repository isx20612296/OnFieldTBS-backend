# Set Encoding to UFT8
# ALTER DATABASE uf4_db CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;


# CREATE DATABASE SCHEMA

CREATE TABLE IF NOT EXISTS nivel(
    id_nivel INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(50),
    PRIMARY KEY(id_nivel)
);

CREATE TABLE IF NOT EXISTS plan_mantenimiento(
    id_plan INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(50),
    precio DECIMAL(5,2) NOT NULL,
    PRIMARY KEY(id_plan)
);

CREATE TABLE IF NOT EXISTS tecnico(
    id_tecnico INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    id_nivel INT UNSIGNED,
    nombre_usuario VARCHAR(20) NOT NULL UNIQUE,
    passwd longblob NOT NULL,
    correo VARCHAR(40), 
    carnet TINYINT DEFAULT 0,
    telefono VARCHAR(15) NOT NULL,   
    PRIMARY KEY(id_tecnico),
    FOREIGN KEY(id_nivel) REFERENCES nivel(id_nivel) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS empresa(
    id_empresa INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    nif VARCHAR(9) NOT NULL,
    direccion VARCHAR(50) NOT NULL UNIQUE,
    telefono VARCHAR(15) NOT NULL,  
    correo VARCHAR(40) NOT NULL, 
    id_plan_mantenimiento  INT UNSIGNED NOT NULL, 
    PRIMARY KEY(id_empresa),
    FOREIGN KEY(id_plan_mantenimiento) REFERENCES plan_mantenimiento(id_plan) ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE IF NOT EXISTS empleado(
    id_empleado INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    id_empresa INT UNSIGNED NOT NULL,
    ext_telefono VARCHAR(10),
    telefono_directo VARCHAR(15),    
    correo VARCHAR(40) NOT NULL, 
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_empresa) REFERENCES empresa(id_empresa) ON DELETE CASCADE ON UPDATE CASCADE,
);


CREATE TABLE IF NOT EXISTS incidencia(
    id_incidencia INT UNSIGNED AUTO_INCREMENT,
    id_empresa  INT UNSIGNED NOT NULL,
    id_empleado  INT UNSIGNED ,
    id_tecnico  INT UNSIGNED,
    titulo VARCHAR(30) NOT NULL, 
    descripcion VARCHAR(2000) NOT NULL,
    estado VARCHAR(20) NOT NULL, 
    prioridad VARCHAR(20) NOT NULL DEFAULT 'Baja',
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre DATETIME,
    PRIMARY KEY(id_incidencia),
    FOREIGN KEY(id_empresa) REFERENCES empleado(id_empresa) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_tecnico) REFERENCES tecnico(id_tecnico) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE IF NOT EXISTS comentario_incidencia(
    id_comentario INT UNSIGNED AUTO_INCREMENT,
    id_incidencia INT UNSIGNED NOT NULL,
    id_tecnico INT UNSIGNED NOT NULL,
    mensaje VARCHAR(2000) NOT NULL, 
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id_comentario),
    FOREIGN KEY(id_incidencia) REFERENCES incidencia(id_incidencia) ON DELETE CASCADE ON UPDATE CASCADE
    FOREIGN KEY(id_tecnico) REFERENCES tecnico(id_tecnico) ON DELETE CASCADE ON UPDATE CASCADE
);

