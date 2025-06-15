drop database if exists AtunesDelPacifico;
create database AtunesDelPacifico;
use AtunesDelPacifico;

CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE lote (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo_lote INT NOT NULL UNIQUE,
    fecha_produccion DATE NOT NULL,
    tipo ENUM('atun_en_aceite', 'atun_en_agua', 'atun_en_salsa'),
    cantidad_producida INT NOT NULL,
    estado ENUM('Disponible', 'Vendido', 'Defectuoso')
);


CREATE TABLE producto_lote (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_producto INT NOT NULL,
    id_lote INT NOT NULL,
    cantidad_producida INT NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES producto(id),
    FOREIGN KEY (id_lote) REFERENCES lote(id)
);

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom_cliente_empresa VARCHAR(50) NOT NULL,
    identificacion INT NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(50),
    direccion VARCHAR(150),
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo'
);

CREATE TABLE pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    precio_total DECIMAL(10,2),
    estado_entrega ENUM('Pendiente', 'En_proceso', 'Enviado', 'Cancelado'),
    fecha_entrega DATE,
    fecha_pedido  DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);


CREATE TABLE detalle_pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_rol ENUM('Cliente', 'Operador', 'Administrador') NOT NULL
);

CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    id_rol INT NOT NULL,
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
    FOREIGN KEY (id_rol) REFERENCES roles(id)
);

	CREATE TABLE defecto (
	    id INT PRIMARY KEY AUTO_INCREMENT,
	    descripcion TEXT NOT NULL
	);

CREATE TABLE lote_defectuoso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_lote INT NOT NULL,
    id_defecto INT NOT NULL,
    FOREIGN KEY (id_lote) REFERENCES lote(id),
    FOREIGN KEY (id_defecto) REFERENCES defecto(id)
);


