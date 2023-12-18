drop table producto;

CREATE TABLE IF NOT EXISTS producto(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(120),
categoria VARCHAR(120),
valor FLOAT(10)
);

INSERT INTO producto (nombre, categoria, valor) VALUES ('Camiseta de algodón', 'Ropa', 25000.99);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Pantalón vaquero', 'Ropa', 4999.50);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Zapatos de cuero', 'Calzado', 8999.75);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Reloj inteligente', 'Accesorios', 3499.99);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Televisor LED 50 pulgadas', 'Electrónica', 19999.00);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Mochila impermeable', 'Equipaje', 799.95);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Cámara digital profesional', 'Fotografía', 12999.25);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Libro de cocina gourmet', 'Libros', 499.99);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Juego de sartenes antiadherentes', 'Hogar', 899.50);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Bicicleta de montaña', 'Deportes', 5999.00);
INSERT INTO producto (nombre, categoria, valor) VALUES ('Teclado mecánico para gaming', 'Tecnología', 999.75);

drop table clientes;

CREATE TABLE IF NOT EXISTS clientes(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(120),
telefono VARCHAR(120),
direccion VARCHAR(120)
);

INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Johan Castrillon', '310023812', 'Calle 115 # 75');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('María González', '3204567890', 'Carrera 20 # 45-67');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Carlos Rodríguez', '3009876543', 'Avenida 5 # 78-90');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Laura Pérez', '3151234567', 'Calle 30 # 12-34');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Juan García', '3105554321', 'Carrera 10 # 56-78');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Ana Martínez', '3013339999', 'Avenida 15 # 32-45');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Pedro Sánchez', '3187778888', 'Calle 25 # 89-01');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Lucía Gómez', '3042221111', 'Avenida 8 # 67-89');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Andrés Díaz', '3136667777', 'Carrera 40 # 11-22');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Sofía López', '3178882222', 'Calle 12 # 78-90');
INSERT INTO clientes (nombre, telefono, direccion) VALUES ('Diego Hernández', '3021113333', 'Avenida 25 # 56-78');

drop table pedido;

CREATE TABLE IF NOT EXISTS pedido(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(120),
cantidad VARCHAR(120),
direccion VARCHAR(120)
);

INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Camiseta de algodón ', '4', 'Calle 115 # 75');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Pantalón vaquero', '2', 'Calle 120 # 45');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Zapatos deportivos', '1', 'Avenida Principal # 23');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Camisa formal', '3', 'Carrera 50 # 12-34');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Chaqueta de cuero', '1', 'Calle 80 # 67');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Falda estampada', '2', 'Avenida Central # 89');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Gorra de béisbol', '5', 'Avenida Sur # 56');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Vestido de fiesta', '1', 'Calle 70 # 33-45');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Sudadera con capucha', '2', 'Carrera 30 # 78');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Pantalones cortos', '3', 'Avenida Norte # 12-34');
INSERT INTO pedido (nombre, cantidad, direccion) VALUES ('Traje de baño', '1', 'Calle 90 # 56');