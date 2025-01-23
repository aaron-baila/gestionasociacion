-- Insertar datos en la tabla MIEMBRO
INSERT INTO MIEMBRO (dni, nombre, apellidos, apodo, email, telefono, direccion, fecha_nacimiento, foto, cargo, fecha_ingreso, estado, LOPD)
VALUES
('12345678A', 'Juan', 'Pérez García', 'Juanito', 'juanito@ejemplo.com', '123456789', 'Calle Ficticia 123, Ciudad', '1985-06-15', 'foto1.jpg', 'Presidente', '2022-01-01', 'ACTIVO', TRUE),
('23456789B', 'Ana', 'López Fernández', 'Anita', 'anita@ejemplo.com', '987654321', 'Calle Real 456, Ciudad', '1990-11-23', 'foto2.jpg', 'Secretaria', '2023-05-15', 'ACTIVO', FALSE),
('99456789B', 'Elimia', 'elim Fernández', 'Elimin', 'anita@ejemplo.com', '987654321', 'Calle Real 456, Ciudad', '1990-11-23', 'foto2.jpg', 'Secretaria', '2023-05-15', 'INACTIVO', FALSE),
('34567890C', 'Carlos', 'Martínez Rodríguez', 'Carlitos', 'carlitos@ejemplo.com', '111223344', 'Avenida Libertad 789, Ciudad', '1992-03-10', 'foto3.jpg', 'Tesorero', '2024-07-20', 'ACTIVO', TRUE);

-- Insertar datos en la tabla EVENTO
INSERT INTO EVENTO (nombre, fecha_inicio, fecha_fin, ubicacion, tipo, estado, presupuesto)
VALUES
('Concierto Benéfico', '2025-03-10', '2025-03-10', 'Auditorio Central', 'benéfico', 'pendiente', 5000.00),
('Taller Cultural', '2025-04-15', '2025-04-16', 'Centro Cultural', 'cultural', 'pendiente', 2000.00),
('Conferencia sobre Historia', '2025-05-05', '2025-05-05', 'Sala de Conferencias', 'formativo', 'pendiente', 1500.00);

-- Insertar datos en la tabla PROVEEDOR
INSERT INTO PROVEEDOR (nombre, direccion, telefono, email, CIF, tipo)
VALUES
('Proveedora S.A.', 'Calle Proveedores 101, Ciudad', '223344556', 'contacto@proveedora.com', 'A12345678', 'suministros'),
('Servicios Rápidos', 'Avenida Comercio 456, Ciudad', '332211445', 'servicios@rapidos.com', 'B23456789', 'servicios'),
('Distribuciones Generales', 'Calle Distribución 789, Ciudad', '998877665', 'info@distribuciones.com', 'C34567890', 'otro');

-- Insertar datos en la tabla FACTURAS
INSERT INTO FACTURAS (fecha, importe_total, concepto, estado, ruta_documento, evento_id, proveedor_id)
VALUES
('2025-03-12', 5000.00, 'Alquiler de sala para Concierto Benéfico', 'pendiente', '/docs/factura1.pdf', 1, 1),
('2025-04-17', 2000.00, 'Materiales para Taller Cultural', 'pendiente', '/docs/factura2.pdf', 2, 2),
('2025-05-06', 1500.00, 'Honorarios del conferencista', 'pendiente', '/docs/factura3.pdf', 3, 3);

-- Insertar datos en la tabla REUNIONES
INSERT INTO REUNIONES (fecha, resumen, asunto, acta, tipo)
VALUES
('2025-01-15', 'Reunión para planificar los próximos eventos', 'Planificación de eventos', 'Acta disponible en el sistema', 'ordinaria'),
('2025-02-10', 'Reunión urgente para resolver problemas logísticos', 'Logística para el Concierto Benéfico', 'Acta disponible en el sistema', 'extraordinaria');

-- Insertar datos en la tabla VOLUNTARIOS
INSERT INTO VOLUNTARIOS (nombre, fecha_alta, evento_id)
VALUES
('Luis Gómez', '2025-02-01', 1),
('María Rodríguez', '2025-03-10', 2),
('Pedro López', '2025-04-20', 3);

-- Insertar datos en la tabla SUBVENCIONES
INSERT INTO SUBVENCIONES (fecha_solicitud, monto_solicitado, estado, entidad_que_otorga, evento_id)
VALUES
('2025-01-10', 3000.00, 'pendiente', 'Ministerio de Cultura', 1),
('2025-02-20', 1000.00, 'pendiente', 'Fundación Cultural', 2);

-- Insertar datos en la tabla INVENTARIO
INSERT INTO INVENTARIO (nombre, cantidad, ubicacion, estado, fecha_adquisicion, precio_unitario)
VALUES
('Micrófono inalámbrico', 5, 'Almacén Central', 'nuevo', '2024-12-01', 150.00),
('Pantalla LED', 2, 'Sala de eventos', 'nuevo', '2024-11-15', 500.00),
('Proyector', 3, 'Sala de conferencias', 'usado', '2023-06-10', 300.00);

-- Insertar datos en la tabla INGRESOS
INSERT INTO INGRESOS (fecha, monto, concepto)
VALUES
('2025-01-01', 2000.00, 'Donación para el Concierto Benéfico'),
('2025-02-10', 1500.00, 'Venta de entradas Taller Cultural');

-- Insertar datos en la tabla DOCUMENTOS
INSERT INTO DOCUMENTOS (tipo, fecha_creacion, responsable, ruta, miembro_id, reunion_id, evento_id)
VALUES
('contrato', '2025-01-05', 'Juan Pérez', '/docs/contrato1.pdf', 1, 1, 1),
('acta', '2025-01-15', 'Ana López', '/docs/acta1.pdf', 2, 1, 2),
('informe', '2025-04-01', 'Carlos Martínez', '/docs/informe1.pdf', 3, 2, 3);

-- Insertar datos en la tabla MIEMBRO_EVENTO
INSERT INTO MIEMBRO_EVENTO (miembro_id, evento_id, rol)
VALUES
(1, 1, 'organizador'),
(2, 2, 'participante'),
(3, 3, 'participante');

-- Insertar datos en la tabla MIEMBRO_REUNION
INSERT INTO MIEMBRO_REUNION (miembro_id, reunion_id, asistencia)
VALUES
(1, 1, 'presente'),
(2, 1, 'ausente'),
(3, 2, 'presente');
