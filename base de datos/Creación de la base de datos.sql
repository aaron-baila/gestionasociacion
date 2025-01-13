-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS AsociacionDB;
USE AsociacionDB;

-- Tabla: MIEMBRO
CREATE TABLE MIEMBRO (
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
    estado ENUM('activo', 'inactivo') DEFAULT 'activo',
    LOPD BOOLEAN NOT NULL
);

-- Tabla: ASOCIACION
CREATE TABLE ASOCIACION (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    fecha_fundacion DATE,
    direccion TEXT,
    telefono VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    numero_miembros INT DEFAULT 0
);

-- Tabla: EVENTO
CREATE TABLE EVENTO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    ubicacion TEXT,
    tipo ENUM('cultural', 'benéfico', 'formativo', 'otro') DEFAULT 'otro',
    estado ENUM('pendiente', 'en curso', 'finalizado') DEFAULT 'pendiente',
    presupuesto DECIMAL(10, 2)
);

-- Tabla: REUNIONES
CREATE TABLE REUNIONES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    resumen TEXT,
    asunto VARCHAR(200),
    acta TEXT,
    tipo ENUM('ordinaria', 'extraordinaria') DEFAULT 'ordinaria'
);

-- Tabla: VOLUNTARIOS
CREATE TABLE VOLUNTARIOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_alta DATE
);

-- Tabla: SUBVENCIONES
CREATE TABLE SUBVENCIONES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_solicitud DATE NOT NULL,
    monto_solicitado DECIMAL(10, 2),
    estado ENUM('pendiente', 'aprobada', 'rechazada') DEFAULT 'pendiente',
    entidad_que_otorga VARCHAR(100)
);

-- Tabla: INVENTARIO (PRODUCTO)
CREATE TABLE INVENTARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT DEFAULT 0,
    ubicacion TEXT,
    estado ENUM('nuevo', 'usado', 'dañado') DEFAULT 'nuevo',
    fecha_adquisicion DATE,
    precio_unitario DECIMAL(10, 2)
);

-- Tabla: FACTURAS
CREATE TABLE FACTURAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    importe_total DECIMAL(10, 2) NOT NULL,
    concepto TEXT,
    estado ENUM('pendiente', 'pagada') DEFAULT 'pendiente',
    ruta_documento TEXT
);

-- Tabla: INGRESOS
CREATE TABLE INGRESOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    concepto VARCHAR(100)
);

-- Tabla: PROVEEDOR
CREATE TABLE PROVEEDOR (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion TEXT,
    telefono VARCHAR(15),
    email VARCHAR(100),
    CIF VARCHAR(20) NOT NULL UNIQUE,
    tipo ENUM('suministros', 'servicios', 'otro') DEFAULT 'otro'
);

-- Tabla: DOCUMENTOS
CREATE TABLE DOCUMENTOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('contrato', 'acta', 'informe', 'otro') DEFAULT 'otro',
    fecha_creacion DATE,
    responsable VARCHAR(100),
    ruta TEXT
);

-- Relaciones
CREATE TABLE MIEMBRO_ASOCIACION (
    miembro_id INT,
    asociacion_id INT,
    FOREIGN KEY (miembro_id) REFERENCES MIEMBRO(id) ON DELETE CASCADE,
    FOREIGN KEY (asociacion_id) REFERENCES ASOCIACION(id) ON DELETE CASCADE,
    PRIMARY KEY (miembro_id, asociacion_id)
);

CREATE TABLE MIEMBRO_REUNIONES (
    miembro_id INT,
    reunion_id INT,
    FOREIGN KEY (miembro_id) REFERENCES MIEMBRO(id) ON DELETE CASCADE,
    FOREIGN KEY (reunion_id) REFERENCES REUNIONES(id) ON DELETE CASCADE,
    PRIMARY KEY (miembro_id, reunion_id)
);

CREATE TABLE ASOCIACION_EVENTO (
    asociacion_id INT,
    evento_id INT,
    FOREIGN KEY (asociacion_id) REFERENCES ASOCIACION(id) ON DELETE CASCADE,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE CASCADE,
    PRIMARY KEY (asociacion_id, evento_id)
);

CREATE TABLE EVENTO_VOLUNTARIOS (
    evento_id INT,
    voluntario_id INT,
    FOREIGN KEY (evento_id) REFERENCES EVENTO(id) ON DELETE CASCADE,
    FOREIGN KEY (voluntario_id) REFERENCES VOLUNTARIOS(id) ON DELETE CASCADE,
    PRIMARY KEY (evento_id, voluntario_id)
);

CREATE TABLE ASOCIACION_SUBVENCIONES (
    asociacion_id INT,
    subvencion_id INT,
    FOREIGN KEY (asociacion_id) REFERENCES ASOCIACION(id) ON DELETE CASCADE,
    FOREIGN KEY (subvencion_id) REFERENCES SUBVENCIONES(id) ON DELETE CASCADE,
    PRIMARY KEY (asociacion_id, subvencion_id)
);

CREATE TABLE ASOCIACION_INVENTARIO (
    asociacion_id INT,
    producto_id INT,
    FOREIGN KEY (asociacion_id) REFERENCES ASOCIACION(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES INVENTARIO(id) ON DELETE CASCADE,
    PRIMARY KEY (asociacion_id, producto_id)
);

CREATE TABLE FACTURA_PROVEEDOR (
    factura_id INT,
    proveedor_id INT,
    FOREIGN KEY (factura_id) REFERENCES FACTURAS(id) ON DELETE CASCADE,
    FOREIGN KEY (proveedor_id) REFERENCES PROVEEDOR(id) ON DELETE CASCADE,
    PRIMARY KEY (factura_id, proveedor_id)
);

CREATE TABLE FACTURA_INGRESOS (
    factura_id INT,
    ingreso_id INT,
    FOREIGN KEY (factura_id) REFERENCES FACTURAS(id) ON DELETE CASCADE,
    FOREIGN KEY (ingreso_id) REFERENCES INGRESOS(id) ON DELETE CASCADE,
    PRIMARY KEY (factura_id, ingreso_id)
);

CREATE TABLE DOCUMENTOS_ASOCIACION (
    documento_id INT,
    asociacion_id INT,
    FOREIGN KEY (documento_id) REFERENCES DOCUMENTOS(id) ON DELETE CASCADE,
    FOREIGN KEY (asociacion_id) REFERENCES ASOCIACION(id) ON DELETE CASCADE,
    PRIMARY KEY (documento_id, asociacion_id)
);
