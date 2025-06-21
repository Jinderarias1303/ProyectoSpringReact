use AtunesDelPacifico;

-- registro producto
INSERT INTO producto (nombreProducto, precio) VALUES 
('Atún en Aceite - Lata 170g', 4500.00),
('Atún en Agua - Lata 170g', 4300.00),
('Atún en Salsa de Tomate - Lata 170g', 4700.00),
('Atún en Aceite - Pack x3', 12800.00),
('Atún en Agua - Pack x6', 25000.00);

-- registro lotes
INSERT INTO lote (codigoLote, fechaProduccion, tipo, cantidadProducida, estado) VALUES
(1001, '2025-06-01', 'atun_en_aceite', 5000, 'Disponible'),
(1002, '2025-06-02', 'atun_en_agua', 3000, 'Vendido'),
(1003, '2025-06-03', 'atun_en_salsa', 2000, 'Disponible'),
(1004, '2025-06-04', 'atun_en_agua', 1500, 'Defectuoso'),
(1005, '2025-06-05', 'atun_en_aceite', 4500, 'Disponible');

-- producto lore 
INSERT INTO productoLote (idProducto, idLote,cantidadProducida) VALUES
(1, 1, 2000),  -- Atún en Aceite de lote 1001
(4, 1, 3000),  -- Pack x3 también del mismo lote de aceite
(2, 2, 3000),  -- Atún en Agua totalmente vendido
(3, 3, 2000),  -- Atún en Salsa disponible
(2, 4, 1500);  -- Atún en Agua defectuoso

-- cliente
INSERT INTO cliente (nomClienteEmpresa, identificacion, correo, telefono, direccion, estado) VALUES
('Comercializadora del Norte S.A.', 900123456, 'ventas@comernorte.com', '3101234567', 'Cra 10 #15-30, Bogotá', 'Activo'),
('Distribuciones Pacífico Ltda.', 901234567, 'contacto@dispacifico.co', '3159876543', 'Av. 3 Oeste #45-90, Cali', 'Activo'),
('Alimentos del Caribe S.A.S.', 902345678, 'compras@caribealimentos.com', '3124567890', 'Calle 80 #50-60, Barranquilla', 'Activo'),
('Supermercado La Economía', 903456789, 'laeconomia@correo.com', '3181239876', 'Calle 5 #8-12, Medellín', 'Inactivo'),
('Importadora Mar Azul', 904567890, 'importaciones@marazul.com', '3006543210', 'Carrera 20 #40-55, Cartagena', 'Activo');

-- pedido
INSERT INTO pedido (idCliente, precioTotal, estadoEntrega, fechaEntrega) VALUES
(1, 13500.00, 'Pendiente', '2025-06-20'),
(2, 25000.00, 'En_proceso', '2025-06-18'),
(3, 4700.00, 'Enviado', '2025-06-14'),
(4, 8600.00, 'Cancelado', '2025-06-16'),
(5, 37800.00, 'Pendiente', '2025-06-22');

-- detalle pedido 
INSERT INTO detallePedido (idPedido, idProducto, cantidad, subtotal) VALUES
(1, 1, 3, 13500.00),       -- Pedido 1: 3 latas de Atún en Aceite (4500 x 3)
(2, 5, 1, 25000.00),       -- Pedido 2: 1 pack de 6 Atunes en Agua
(3, 3, 1, 4700.00),        -- Pedido 3: 1 lata de Atún en Salsa
(4, 2, 2, 8600.00),        -- Pedido 4: 2 latas de Atún en Agua (4300 x 2)
(5, 4, 3, 38400.00);       -- Pedido 5: 3 packs de Atún en Aceite x3 (12800 x 3)

-- roles
INSERT INTO roles (tipoRol) VALUES
('Cliente'),
('Operador'),
('Administrador');

-- usuario
INSERT INTO usuario (username, password, idRol) VALUES
('cliente01', 'cliente1', 1),
('operador01', 'operador1', 2),
('admin01', 'admin1', 3);

-- defecto
INSERT INTO defecto (descripcion) VALUES
('Empaque dañado'),
('Fuga de líquido'),
('Fecha de producción ilegible'),
('Contaminación cruzada'),
('Peso fuera de tolerancia');

-- lote defectuoso 
INSERT INTO loteDefectuoso (idLote, idDefecto) VALUES
(2, 1),  -- Lote 2 con empaque dañado
(4, 3),  -- Lote 4 con fecha ilegible
(4, 5),  -- Lote 4 también con peso fuera de tolerancia (2 defectos en un lote)
(5, 2),  -- Lote 5 con fuga de líquido
(3, 4);  -- Lote 3 con contaminación cruzada



