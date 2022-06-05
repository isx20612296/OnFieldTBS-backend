-- FUNCTION TO Encrypted ENCRYPTED PASSWORD
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- TEST DATA

INSERT INTO usser (username, password) VALUES
    ('admin', crypt('adminadmin', gen_salt('bf'))),
    ('jgarcia', crypt('Jg@rc1A', gen_salt('bf'))),
    ('mgonzalez', crypt('Mg0nz@l3Z', gen_salt('bf'))),
    ('agimenez', crypt('Ag1m3neZ', gen_salt('bf'))),
    ('nlopez', crypt('Nl0p3Z', gen_salt('bf'))),
    ('rgarriga', crypt('Rg@rr1gA', gen_salt('bf')));

INSERT INTO levels(name, description) VALUES
	('N0', 'Atender llamadas y correos, crear incidencias'),
	('N1', 'Resolución de problemas hasta media complejidad'),
	('N2', 'Resolución de problemas de alto nivel');

INSERT INTO maintenance_plan(name, description, price) VALUES
	('Plan básico', 'Plan que cubre soporte básico indispensable', 12.99),
	('Plan avanzado', 'Plan con más cobertura que el básico', 15.99),
	('Plan completo', 'Plan a todo riesgo sin limite de tiempo', 18.99);


INSERT INTO technician(name, lastname, level_id, user_id, email, license, phone) VALUES
	('Juan', 'Garcia', (SELECT id FROM levels WHERE name='N0'), (SELECT user_id FROM usser WHERE username = 'jgarcia'), 'jgarcia@oftbs.org', 0, '666 001 002'),
	('Marina', 'Gonzalez', (SELECT id FROM levels WHERE name='N2'), (SELECT user_id FROM usser WHERE username = 'mgonzalez'), 'mgonzalez@oftbs.org', 1, '666 003 004'),
	('Alberto', 'Gimenez', (SELECT id FROM levels WHERE name='N1'), (SELECT user_id FROM usser WHERE username = 'agimenez'), 'agimenez@oftbs.org', 1, '666 005 006'),
	('Nuria', 'Lopez', (SELECT id FROM levels WHERE name='N0'), (SELECT user_id FROM usser WHERE username = 'nlopez'), 'nlopez@oftbs.org', 0, '666 007 008'),
	('Rodrigo', 'Garriga', (SELECT id FROM levels WHERE name='N1'), (SELECT user_id FROM usser WHERE username = 'rgarriga'), 'rgarriga@oftbs.org', 1, '666 009 010');

INSERT INTO company(name, nif, address, phone, email, maintenance_id) VALUES
	('ENOTECH', '11211314G', 'Carrer de Muntaner, 252, 08021 Barcelona', '934 001 002', 'contacte@enotech.cat', (SELECT id FROM maintenance_plan WHERE name = 'Plan básico')),
	('GAMBATRON', '11311415H', 'Carrer de Roger de Llúria, 29, 08009 Barcelona', '934 002 003', 'contacte@gambatron.es', (SELECT id FROM maintenance_plan WHERE name = 'Plan avanzado')),
	('XURRERIA MONTSE', '11411516J', 'Carrer del Vallespir, 183, 08014 Barcelona', '934 003 004', 'contacte@xurrosm.bcn', (SELECT id FROM maintenance_plan WHERE name = 'Plan básico'));

INSERT INTO employee(name, lastname, company_id, phone_ext, direct_phone, email) VALUES
	('Anna', 'Serra', (SELECT id FROM company WHERE name='ENOTECH'), '203', null, 'aserra@enotech.cat'),
	('Diego', 'Fernandez', (SELECT id FROM company WHERE name='ENOTECH'), '209', null,  'dfernandez@enotech.cat'),
	('Guillermo', 'Hermoso', (SELECT id FROM company WHERE name='GAMBATRON'), '68', null, 'ghermoso@gambatron.es'),
	('John', 'Kennedy', (SELECT id FROM company WHERE name='GAMBATRON'), '66', null,  'jkennedy@gambatron.es'),
	('Luis', 'Zamora', (SELECT id FROM company WHERE name='XURRERIA MONTSE'), null, '666 100 200', 'lzamora@xurrosm.bcn'),
	('Xavier', 'Carcall', (SELECT id FROM company WHERE name='XURRERIA MONTSE'), null, '666 101 201', 'xcarcall@xurrosm.bcn');

INSERT INTO incidence(company_id, employee_id, technician_id, title, description, status, priority) VALUES
	((SELECT id FROM company WHERE name='ENOTECH'), (SELECT id FROM employee WHERE name='Anna'), (SELECT id FROM technician WHERE name='Juan'), 'Problema Enotech 1', 'Problema baja prioridad Enotech', 'Abierta', 'Baja'),
	((SELECT id FROM company WHERE name='GAMBATRON'), (SELECT id FROM employee WHERE name='Guillermo'), (SELECT id FROM technician WHERE name='Nuria'), 'Problema Gambatron 1', 'Problema prioridad media Gambatron', 'Abierta', 'Media'),
	((SELECT id FROM company WHERE name='XURRERIA MONTSE'), (SELECT id FROM employee WHERE name='Xavier'), (SELECT id FROM technician WHERE name='Alberto'), 'Problema Xurreria Montse 1', 'Problema alta prioridad Xurreria Montse', 'Abierta', 'Alta');

INSERT INTO comment(incidence_id, technician_id, message) VALUES
    ((SELECT id FROM incidence WHERE title='Problema Enotech 1'),(SELECT id FROM technician WHERE name='Juan'),'Se ha arreglado X ahora voy a revisar Y'),
    ((SELECT id FROM incidence WHERE title='Problema Enotech 1'),(SELECT id FROM technician WHERE name='Juan'),'Y solucionado mañana he quedado con Anna a las 16:30'),
    ((SELECT id FROM incidence WHERE title='Problema Gambatron 1'),(SELECT id FROM technician WHERE name='Nuria'),'La impresora no se conecta la wifi ahora, llamo a proveedores'),
    ((SELECT id FROM incidence WHERE title='Problema Gambatron 1'),(SELECT id FROM technician WHERE name='Nuria'),'Proveedores no contestan, vuelvo a intentar mañana'),
    ((SELECT id FROM incidence WHERE title='Problema Xurreria Montse 1'),(SELECT id FROM technician WHERE name='Alberto'),'El amplificador wifi no tiene suficiente rango');