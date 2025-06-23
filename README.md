# 🐟 Proyecto\_BACK\_SpringBoot

**Sistema de Gestión para Atunes del Pacífico S.A.**

Este repositorio contiene el **back-end** del sistema de gestión empresarial para Atunes del Pacífico S.A., desarrollado en **Java con Spring Boot**. El sistema permite controlar la producción, inventario, pedidos, clientes, usuarios y generación de reportes clave.

---

## 📌 Descripción General

Este back-end expone una API REST segura que será consumida por un front-end desarrollado con HTML, CSS y JavaScript puro. Toda la autenticación se maneja mediante **Spring Security con JWT**, y los datos se almacenan en una base de datos relacional (MySQL o PostgreSQL).

---

## ✅ Funcionalidades Implementadas

### 🔐 Autenticación y Autorización

* Registro e inicio de sesión de usuarios.
* Seguridad basada en roles: Cliente, Operador y Administrador.
* Cifrado de contraseñas con BCrypt.
* Emisión y validación de tokens JWT.

### 🏭 Gestión de Producción

* Registro de lotes de productos de atún (en aceite, en agua, en salsa).
* Consulta por tipo de producto, fecha de producción y estado.
* Registro y seguimiento de lotes defectuosos.

### 📦 Gestión de Pedidos

* Registro de pedidos por parte de los clientes.
* Cálculo automático del precio total y descuentos por volumen.
* Validación del stock disponible al generar pedidos.
* Actualización automática del inventario al confirmar pedidos.

### 👤 Gestión de Clientes

* Registro y consulta de clientes (RUC, nombre, correo, dirección, etc.).
* Consulta del historial de pedidos por cliente.

### 👥 Gestión de Usuarios y Roles

* Administración de usuarios, asignación de roles y control de acceso.
* Restricciones de acceso según el rol autenticado.

### 📊 Reportes

* Reportes de ventas por producto.
* Reportes de ventas por cliente.
* Reportes de lotes defectuosos.
* Estadísticas del inventario actual.


---

## 🧪 Pruebas y Consumo

La API puede ser testeada con herramientas como Postman o directamente desde Swagger. Para consumir los endpoints protegidos, es necesario incluir el token JWT en el encabezado:

```
Authorization: Bearer <token>
```

---

## ⚙️ Requisitos de Configuración

* Java 17 o superior
* Maven 3.8+
* MySQL o PostgreSQL
* Apache Tomcat (para producción)

Configura tus credenciales de base de datos en `application.properties`.

---

## 📁 Contenido

* Código fuente en Java con Spring Boot.
* Documentación Swagger integrada.
* JWT implementado para acceso seguro.
* README explicativo.
* Listo para desplegar en Tomcat.


