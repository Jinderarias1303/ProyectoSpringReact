drop database if exists AtunesDelPacifico;

create database AtunesDelPacifico;
use AtunesDelPacifico;

CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombreProducto VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE lote (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigoLote INT NOT NULL UNIQUE,
    fechaProduccion DATE NOT NULL,
    tipo ENUM('atun_en_aceite', 'atun_en_agua', 'atun_en_salsa'),
    cantidadProducida INT NOT NULL,
    estado ENUM('Disponible', 'Vendido', 'Defectuoso')
);


CREATE TABLE productoLote (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idProducto INT NOT NULL,
    idLote INT NOT NULL,
    cantidadProducida INT NOT NULL,
    FOREIGN KEY (idProducto) REFERENCES producto(id),
    FOREIGN KEY (idLote) REFERENCES lote(id)
);

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nomClienteEmpresa VARCHAR(50) NOT NULL,
    identificacion INT NOT NULL UNIQUE,
    correo VARCHAR(100) NOT null UNIQUE,
    telefono VARCHAR(50),
    direccion VARCHAR(150),
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo'
);

CREATE TABLE pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    precioTotal DECIMAL(10,2),
    estadoEntrega ENUM('Pendiente', 'En_proceso', 'Enviado', 'Cancelado'),
    fechaEntrega DATE,
    fechaPedido  DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);

CREATE TABLE detallePedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idPedido INT NOT NULL,
    idProducto INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (idPedido) REFERENCES pedido(id),
    FOREIGN KEY (idProducto) REFERENCES producto(id)
);

CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipoRol ENUM('Cliente', 'Operador', 'Administrador') NOT null UNIQUE
);

CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    id_rol BIGINT NOT NULL,
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
    FOREIGN KEY (id_rol) REFERENCES roles(id)
);

	CREATE TABLE defecto (
	    id INT PRIMARY KEY AUTO_INCREMENT,
	  	descripcion TEXT NOT NULL
	);

CREATE TABLE loteDefectuoso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idLote INT NOT NULL,
    idDefecto INT NOT NULL,
    FOREIGN KEY (idLote) REFERENCES lote(id),
    FOREIGN KEY (idDefecto) REFERENCES defecto(id)
);


