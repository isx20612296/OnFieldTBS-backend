-- TEST DATA

INSERT INTO nivel(nombre, descripcion) VALUES
	('N0', 'Atender llamadas y correos, crear incidencias'),
	('N1', 'Resolución de problemas hasta media complejidad'),
	('N2', 'Resolución de problemas de alto nivel');

INSERT INTO plan_mantenimiento(nombre, descripcion, precio) VALUES
	('Plan básico', 'Plan que cubre soporte básico indispensable', 12.99),
	('Plan avanzado', 'Plan con más cobertura que el básico', 15.99),
	('Plan completo', 'Plan a todo riesgo sin limite de tiempo', 18.99);

INSERT INTO tecnico(nombre, apellido, id_nivel, nombre_usuario, passwd, correo, carnet, telefono) VALUES
	('Juan', 'Garcia', (SELECT id_nivel FROM nivel WHERE nombre='N0'), 'jgarcia', 'Jg@rc1A', 'jgarcia@oftbs.org', 0, '666 001 002'),
	('Marina', 'Gonzalez', (SELECT id_nivel FROM nivel WHERE nombre='N2'), 'mgonzalez', 'Mg0nz@l3Z', 'mgonzalez@oftbs.org', 1, '666 003 004'),
	('Alberto', 'Gimenez', (SELECT id_nivel FROM nivel WHERE nombre='N1'), 'agimenez', 'Ag1m3neZ', 'agimenez@oftbs.org', 1, '666 005 006'),
	('Nuria', 'Lopez', (SELECT id_nivel FROM nivel WHERE nombre='N0'), 'nlopez', 'Nl0p3Z', 'nlopez@oftbs.org', 0, '666 007 008'),
	('Rodrigo', 'Garriga', (SELECT id_nivel FROM nivel WHERE nombre='N1'), 'rgarriga', 'Rg@rr1gA', 'rgarriga@oftbs.org', 1, '666 009 010');

INSERT INTO empresa(nombre, nif, direccion, telefono, correo, id_plan_mantenimiento) VALUES
	('ENOTECH', '11211314G', 'Carrer de Muntaner, 252, 08021 Barcelona', '934 001 002', 'contacte@enotech.cat', (SELECT id_plan FROM plan_mantenimiento WHERE precio = 12.99)),
	('GAMBATRON', '11311415H', 'Carrer de Roger de Llúria, 29, 08009 Barcelona', '934 002 003', 'contacte@gambatron.es', (SELECT id_plan FROM plan_mantenimiento WHERE precio = 15.99)),
	('XURRERIA MONTSE', '11411516J', 'Carrer del Vallespir, 183, 08014 Barcelona', '934 003 004', 'contacte@xurrosm.bcn', (SELECT id_plan FROM plan_mantenimiento WHERE precio = 12.99));

INSERT INTO empleado(nombre, apellido, id_empresa, ext_telefono, telefono_directo, correo) VALUES
	('Anna', 'Serra', (SELECT id_empresa FROM empresa WHERE nombre='ENOTECH'), '203', null, 'aserra@enotech.cat'),
	('Diego', 'Fernandez', (SELECT id_empresa FROM empresa WHERE nombre='ENOTECH'), '209', null,  'dfernandez@enotech.cat'),
	('Guillermo', 'Hermoso', (SELECT id_empresa FROM empresa WHERE nombre='GAMBATRON'), '68', null, 'ghermoso@gambatron.es'),
	('John', 'Kennedy', (SELECT id_empresa FROM empresa WHERE nombre='GAMBATRON'), '66', null,  'jkennedy@gambatron.es'),
	('Luis', 'Zamora', (SELECT id_empresa FROM empresa WHERE nombre='XURRERIA MONTSE'), null, '666 100 200', 'lzamora@xurrosm.bcn'),
	('Xavier', 'Carcall', (SELECT id_empresa FROM empresa WHERE nombre='XURRERIA MONTSE'), null, '666 101 201', 'xcarcall@xurrosm.bcn');

INSERT INTO incidencia(id_empresa, id_empleado, id_tecnico, titulo, descripcion, estado, prioridad, fecha_creacion) VALUES 
	((SELECT id_empresa FROM empresa WHERE nombre='ENOTECH'), (SELECT id_empleado FROM empleado WHERE nombre='Anna'), (SELECT id_tecnico FROM tecnico WHERE nombre='Juan'), 'Problema Enotech 1', 'Problema baja prioridad Enotech', 'Abierto', 'Baja', current_timestamp),
	((SELECT id_empresa FROM empresa WHERE nombre='GAMBATRON'), (SELECT id_empleado FROM empleado WHERE nombre='Guillermo'), (SELECT id_tecnico FROM tecnico WHERE nombre='Nuria'), 'Problema Gambatron 1', 'Problema prioridad media Gambatron', 'Abierto', 'Media', current_timestamp),
	((SELECT id_empresa FROM empresa WHERE nombre='XURRERIA MONTSE'), (SELECT id_empleado FROM empleado WHERE nombre='Xavier'), (SELECT id_tecnico FROM tecnico WHERE nombre='Alberto'), 'Problema Xurreria Montse 1', 'Problema alta prioridad Xurreria Montse', 'Abierto', 'Alta', current_timestamp);

INSERT INTO comentario_incidencia(id_incidencia, id_tecnico, mensaje, fecha_creacion) VALUES
    ((SELECT id_incidencia FROM incidencia WHERE titulo='Problema Enotech 1'),(SELECT id_tecnico FROM tecnico WHERE nombre='Juan'),'Se ha arreglado X ahora voy a revisar Y', current_timestamp),
    ((SELECT id_incidencia FROM incidencia WHERE titulo='Problema Enotech 1'),(SELECT id_tecnico FROM tecnico WHERE nombre='Juan'),'Y solucionado mañana he quedado con Anna a las 16:30', current_timestamp),
    ((SELECT id_incidencia FROM incidencia WHERE titulo='Problema Gambatron 1'),(SELECT id_tecnico FROM tecnico WHERE nombre='Nuria'),'La impresora no se conecta la wifi ahora, llamo a proveedores', current_timestamp),
    ((SELECT id_incidencia FROM incidencia WHERE titulo='Problema Gambatron 1'),(SELECT id_tecnico FROM tecnico WHERE nombre='Nuria'),'Proveedores no contestan, vuelvo a intentar mañana', current_timestamp),
    ((SELECT id_incidencia FROM incidencia WHERE titulo='Problema Xurreria Montse 1'),(SELECT id_tecnico FROM tecnico WHERE nombre='Alberto'),'El amplificador wifi no tiene suficiente rango', current_timestamp);