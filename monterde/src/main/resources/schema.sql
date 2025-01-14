-- Crear base de datos (aunque H2 no requiere una declaración explícita de CREATE DATABASE en la mayoría de casos)
-- Si deseas utilizar una base de datos persistente, puedes usar:
-- jdbc:h2:~/monterde;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE

-- Tabla: MIEMBRO
CREATE TABLE IF NOT EXISTS MIEMBRO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100),
    apodo VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15),
    direccion TEXT,
    fecha_nacimiento DATE,
    foto TEXT,
    cargo VARCHAR(50),
    fecha_ingreso DATE,
    estado VARCHAR(10) DEFAULT 'activo', -- H2 no soporta ENUM directamente
    LOPD BOOLEAN
);

-- Tabla: EVENTO
CREATE TABLE IF NOT EXISTS EVENTO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    ubicacion TEXT,
    tipo VARCHAR(20) DEFAULT 'otro', -- H2 no soporta ENUM directamente
    estado VARCHAR(20) DEFAULT 'pendiente', -- H2 no soporta ENUM directamente
    presupuesto DECIMAL(10, 2)
);

-- Tabla: PROVEEDOR
CREATE TABLE IF NOT EXISTS PROVEEDOR (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion TEXT,
    telefono VARCHAR(15),
    email VARCHAR(100),
    CIF VARCHAR(20) NOT NULL UNIQUE,
    tipo VARCHAR(20) DEFAULT 'otro' -- H2 no soporta ENUM directamente
);

-- Tabla: FACTURAS
CREATE TABLE IF NOT EXISTS FACTURAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    importe_total DECIMAL(10, 2) NOT NULL,
    concepto TEXT,
    estado VARCHAR(20) DEFAULT 'pendiente', -- H2 no soporta ENUM directamente
    ruta_documento TEXT,
    evento_id INT,
    proveedor_id INT,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE SET NULL,
    FOREIGN KEY (proveedor_id) REFERENCES PROVEEDOR(id) ON DELETE SET NULL
);

-- Tabla: REUNIONES
CREATE TABLE IF NOT EXISTS REUNIONES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    resumen TEXT,
    asunto VARCHAR(200),
    acta TEXT,
    tipo VARCHAR(20) DEFAULT 'ordinaria' -- H2 no soporta ENUM directamente
);

-- Tabla: VOLUNTARIOS
CREATE TABLE IF NOT EXISTS VOLUNTARIOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_alta DATE,
    evento_id INT,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE SET NULL
);

-- Tabla: SUBVENCIONES
CREATE TABLE IF NOT EXISTS SUBVENCIONES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_solicitud DATE NOT NULL,
    monto_solicitado DECIMAL(10, 2),
    estado VARCHAR(20) DEFAULT 'pendiente', -- H2 no soporta ENUM directamente
    entidad_que_otorga VARCHAR(100),
    evento_id INT,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE SET NULL
);

-- Tabla: INVENTARIO (PRODUCTO)
CREATE TABLE IF NOT EXISTS INVENTARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT DEFAULT 0,
    ubicacion TEXT,
    estado VARCHAR(20) DEFAULT 'nuevo', -- H2 no soporta ENUM directamente
    fecha_adquisicion DATE,
    precio_unitario DECIMAL(10, 2)
);

-- Tabla: INGRESOS
CREATE TABLE IF NOT EXISTS INGRESOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    concepto VARCHAR(100)
);

-- Tabla: DOCUMENTOS
CREATE TABLE IF NOT EXISTS DOCUMENTOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20) DEFAULT 'otro', -- H2 no soporta ENUM directamente
    fecha_creacion DATE,
    responsable VARCHAR(100),
    ruta TEXT,
    miembro_id INT,
    reunion_id INT,
    evento_id INT,
    FOREIGN KEY (miembro_id) REFERENCES MIEMBRO(id) ON DELETE SET NULL,
    FOREIGN KEY (reunion_id) REFERENCES REUNIONES(id) ON DELETE SET NULL,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE SET NULL
);

-- Tabla intermedia: MIEMBRO_EVENTO (relación muchos a muchos entre MIEMBRO y EVENTO)
CREATE TABLE IF NOT EXISTS MIEMBRO_EVENTO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    miembro_id INT NOT NULL,
    evento_id INT NOT NULL,
    rol VARCHAR(20) DEFAULT 'participante', -- H2 no soporta ENUM directamente
    FOREIGN KEY (miembro_id) REFERENCES MIEMBRO(id) ON DELETE CASCADE,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE CASCADE
);

-- Tabla intermedia: MIEMBRO_REUNION (relación muchos a muchos entre MIEMBRO y REUNIONES)
CREATE TABLE IF NOT EXISTS MIEMBRO_REUNION (
    id INT AUTO_INCREMENT PRIMARY KEY,
    miembro_id INT NOT NULL,
    reunion_id INT NOT NULL,
    asistencia VARCHAR(20) DEFAULT 'presente', -- H2 no soporta ENUM directamente
    FOREIGN KEY (miembro_id) REFERENCES MIEMBRO(id) ON DELETE CASCADE,
    FOREIGN KEY (reunion_id) REFERENCES REUNIONES(id) ON DELETE CASCADE
);
