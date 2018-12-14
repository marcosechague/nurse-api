# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import py.com.jmml.client.*;
import py.com.jmml.client.auth.*;
import py.com.jmml.client.model.*;
import py.com.jmml.client.api.AdminApiApi;

import java.io.File;
import java.util.*;

public class AdminApiApiExample {

    public static void main(String[] args) {
        
        AdminApiApi apiInstance = new AdminApiApi();
        Integer idRol = 56; // Integer | Id de rol a actualizar
        RolActualizacionDTO rolActualizacionDTO = new RolActualizacionDTO(); // RolActualizacionDTO | Body para actualizacion de datos del rol
        try {
            Rol result = apiInstance.actualizarRolUsingPUT(idRol, rolActualizacionDTO);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminApiApi#actualizarRolUsingPUT");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://jmml.ml:8080/taller-martinez-api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AdminApiApi* | [**actualizarRolUsingPUT**](docs/AdminApiApi.md#actualizarRolUsingPUT) | **PUT** /v1/roles/{id-rol} | Actualizar un rol
*AdminApiApi* | [**actualizarUsuarioUsingPUT**](docs/AdminApiApi.md#actualizarUsuarioUsingPUT) | **PUT** /v1/usuarios/{id-usuario} | Actualizar un usuario
*AdminApiApi* | [**cambiarPasswordUsuarioUsingPATCH**](docs/AdminApiApi.md#cambiarPasswordUsuarioUsingPATCH) | **PATCH** /v1/usuarios/{id-usuario}/password | Cambiar password a usuario
*AdminApiApi* | [**crearRolUsingPOST**](docs/AdminApiApi.md#crearRolUsingPOST) | **POST** /v1/roles | Crear un nuevo rol
*AdminApiApi* | [**crearUsuarioUsingPOST**](docs/AdminApiApi.md#crearUsuarioUsingPOST) | **POST** /v1/usuarios | Crear un usuario
*AdminApiApi* | [**obtenerAccionesUsingGET**](docs/AdminApiApi.md#obtenerAccionesUsingGET) | **GET** /v1/acciones | Obtener listado de acciones
*AdminApiApi* | [**obtenerRolesUsingGET**](docs/AdminApiApi.md#obtenerRolesUsingGET) | **GET** /v1/roles | Obtener listado de roles
*AdminApiApi* | [**obtenerUsuarioUsingGET**](docs/AdminApiApi.md#obtenerUsuarioUsingGET) | **GET** /v1/usuarios/{id-usuario} | Obtener  usuario por id
*AdminApiApi* | [**obtenerUsuariosUsingGET**](docs/AdminApiApi.md#obtenerUsuariosUsingGET) | **GET** /v1/usuarios | Obtener un listado de usuarios 
*AdminApiApi* | [**relacionarRolAccionUsingPATCH**](docs/AdminApiApi.md#relacionarRolAccionUsingPATCH) | **PATCH** /v1/roles/{id-rol}/acciones | Relacionar acciones a un rol
*AuthApiApi* | [**invalidateAccessTokenUsingDELETE**](docs/AuthApiApi.md#invalidateAccessTokenUsingDELETE) | **DELETE** /v1/sesion | Invalidacion de sesion
*AuthApiApi* | [**loginUsingPOST**](docs/AuthApiApi.md#loginUsingPOST) | **POST** /v1/sesion | Creacion de sesion
*CajaApiApi* | [**cerrarCajaUsingDELETE**](docs/CajaApiApi.md#cerrarCajaUsingDELETE) | **DELETE** /v1/caja | Cierre de caja
*CajaApiApi* | [**obtenerEstadoCajaUsingGET**](docs/CajaApiApi.md#obtenerEstadoCajaUsingGET) | **GET** /v1/caja/estado | Retorna el estado actual de la caja
*CajaApiApi* | [**registrarAperturaCajaUsingPOST**](docs/CajaApiApi.md#registrarAperturaCajaUsingPOST) | **POST** /v1/caja | Apertura de caja
*ClientesApiApi* | [**actualizarClienteUsingPUT**](docs/ClientesApiApi.md#actualizarClienteUsingPUT) | **PUT** /v1/clientes/{id-cliente} | Actualizacion de cliente
*ClientesApiApi* | [**obtenerClientePorIdUsingGET**](docs/ClientesApiApi.md#obtenerClientePorIdUsingGET) | **GET** /v1/clientes/{identificacion}/numero/{numero} | Obtiene datos de un cliente por id ó nro. de documento
*ClientesApiApi* | [**obtenerClientesUsingGET**](docs/ClientesApiApi.md#obtenerClientesUsingGET) | **GET** /v1/clientes | Obtiene un listado de clientes
*ClientesApiApi* | [**registrarClienteUsingPOST**](docs/ClientesApiApi.md#registrarClienteUsingPOST) | **POST** /v1/clientes | Registro de cliente
*ComprasApiApi* | [**anularCompraUsingDELETE**](docs/ComprasApiApi.md#anularCompraUsingDELETE) | **DELETE** /v1/compras/{id-compra} | Anula una compra
*ComprasApiApi* | [**obtenerComprasPorFechaUsingGET**](docs/ComprasApiApi.md#obtenerComprasPorFechaUsingGET) | **GET** /v1/compras | Obtiene un listado de compras
*ComprasApiApi* | [**registrarCompraUsingPOST**](docs/ComprasApiApi.md#registrarCompraUsingPOST) | **POST** /v1/compras | Registra una nueva compra
*DatosGeneralesApiApi* | [**obtenerCiudadPorIdUsingGET**](docs/DatosGeneralesApiApi.md#obtenerCiudadPorIdUsingGET) | **GET** /v1/ciudades/{id-ciudad} | Obtiene una ciudad
*DatosGeneralesApiApi* | [**obtenerCiudadesUsingGET**](docs/DatosGeneralesApiApi.md#obtenerCiudadesUsingGET) | **GET** /v1/ciudades | Obtiene un listado de ciudades
*DatosGeneralesApiApi* | [**registrarCiudadUsingPOST**](docs/DatosGeneralesApiApi.md#registrarCiudadUsingPOST) | **POST** /v1/ciudades | Registra una nueva ciudad
*EmpleadosApiApi* | [**actualizarEmpleadoUsingPUT**](docs/EmpleadosApiApi.md#actualizarEmpleadoUsingPUT) | **PUT** /v1/empleados/{id-empleado} | Actualizacion de empleado
*EmpleadosApiApi* | [**obtenerEmpleadoPorIdUsingGET**](docs/EmpleadosApiApi.md#obtenerEmpleadoPorIdUsingGET) | **GET** /v1/empleados/{identificacion}/numero/{numero} | Obtiene datos de un empleado por id ó nro. de documento
*EmpleadosApiApi* | [**obtenerEmpleadosUsingGET**](docs/EmpleadosApiApi.md#obtenerEmpleadosUsingGET) | **GET** /v1/empleados | Obtiene un listado de empleados
*EmpleadosApiApi* | [**registrarEmpleadoUsingPOST**](docs/EmpleadosApiApi.md#registrarEmpleadoUsingPOST) | **POST** /v1/empleados | Registro de empleado
*OperacionesApiApi* | [**obtenerMovimientosUsingGET**](docs/OperacionesApiApi.md#obtenerMovimientosUsingGET) | **GET** /v1/operaciones | Obtiene operaciones
*ProductosApiApi* | [**actualizarProductoParcialUsingPATCH**](docs/ProductosApiApi.md#actualizarProductoParcialUsingPATCH) | **PATCH** /v1/productos/{id-producto} | Actualizacion parcial del producto
*ProductosApiApi* | [**actualizarProductoTotalUsingPUT**](docs/ProductosApiApi.md#actualizarProductoTotalUsingPUT) | **PUT** /v1/productos/{id-producto} | Actualizacion total del producto
*ProductosApiApi* | [**buscarProductosUsingGET**](docs/ProductosApiApi.md#buscarProductosUsingGET) | **GET** /v1/productos | Obtener el listado de productos
*ProductosApiApi* | [**obtenetCategoriaPorIdUsingGET**](docs/ProductosApiApi.md#obtenetCategoriaPorIdUsingGET) | **GET** /v1/categorias-productos/{id-categoria} | Obtener categoria por id
*ProductosApiApi* | [**obtenetCategoriasUsingGET**](docs/ProductosApiApi.md#obtenetCategoriasUsingGET) | **GET** /v1/categorias-productos | Obtener categorias
*ProductosApiApi* | [**obtenetProductoPorIdUsingGET**](docs/ProductosApiApi.md#obtenetProductoPorIdUsingGET) | **GET** /v1/productos/{id-producto} | Obtener productos por id
*ProductosApiApi* | [**registrarProductoUsingPOST**](docs/ProductosApiApi.md#registrarProductoUsingPOST) | **POST** /v1/productos | Crear un nuevo producto
*ProveedorApiApi* | [**actualizarProveedorUsingPUT**](docs/ProveedorApiApi.md#actualizarProveedorUsingPUT) | **PUT** /v1/proveedores | Actualizar un proveedor
*ProveedorApiApi* | [**obtenerProveedorPorIdUsingGET**](docs/ProveedorApiApi.md#obtenerProveedorPorIdUsingGET) | **GET** /v1/proveedores/{id-proveedor} | Obtiene un proveedor
*ProveedorApiApi* | [**obtenerProveedoresUsingGET**](docs/ProveedorApiApi.md#obtenerProveedoresUsingGET) | **GET** /v1/proveedores | Obtiene proveedores
*ProveedorApiApi* | [**registrarProveedorUsingPOST**](docs/ProveedorApiApi.md#registrarProveedorUsingPOST) | **POST** /v1/proveedores | Crea un nuevo proveedor
*RepuestosApiApi* | [**actualizarRepuestoUsingPUT**](docs/RepuestosApiApi.md#actualizarRepuestoUsingPUT) | **PUT** /v1/repuestos | Actualizacion de datos de un repuesto
*RepuestosApiApi* | [**eliminarRepuestoUsingDELETE**](docs/RepuestosApiApi.md#eliminarRepuestoUsingDELETE) | **DELETE** /v1/repuestos/{id} | Elimnar un repuesto por Id
*RepuestosApiApi* | [**obtenerRepuestoPorIdUsingGET**](docs/RepuestosApiApi.md#obtenerRepuestoPorIdUsingGET) | **GET** /v1/repuestos/{id} | Obtener repuesto por codigo
*RepuestosApiApi* | [**obtenerRespuestosUsingGET**](docs/RepuestosApiApi.md#obtenerRespuestosUsingGET) | **GET** /v1/repuestos/ | Obtener lista de repuestos
*RepuestosApiApi* | [**registrarRepuestoUsingPOST**](docs/RepuestosApiApi.md#registrarRepuestoUsingPOST) | **POST** /v1/repuestos | Registro de repuestos
*VehiculosApiApi* | [**actualizarProductoParcialUsingPATCH1**](docs/VehiculosApiApi.md#actualizarProductoParcialUsingPATCH1) | **PATCH** /v1/vehiculos/{id-producto} | Actualizacion parcial del producto
*VehiculosApiApi* | [**actualizarProductoTotalUsingPUT1**](docs/VehiculosApiApi.md#actualizarProductoTotalUsingPUT1) | **PUT** /v1/vehiculos/{id-producto} | Actualizacion total del producto
*VehiculosApiApi* | [**buscarProductosUsingGET1**](docs/VehiculosApiApi.md#buscarProductosUsingGET1) | **GET** /v1/vehiculos | Obtener el listado de vehiculos
*VehiculosApiApi* | [**obtenetProductoPorIdUsingGET1**](docs/VehiculosApiApi.md#obtenetProductoPorIdUsingGET1) | **GET** /v1/vehiculos/{id-vehiculo} | Obtener vehiculos por id
*VehiculosApiApi* | [**registrarProductoUsingPOST1**](docs/VehiculosApiApi.md#registrarProductoUsingPOST1) | **POST** /v1/vehiculos | Crear un nuevo producto
*VentasApiApi* | [**anularVentaUsingDELETE**](docs/VentasApiApi.md#anularVentaUsingDELETE) | **DELETE** /v1/ventas/{id-venta} | Anula una venta
*VentasApiApi* | [**obtenerVentasPorFechaUsingGET**](docs/VentasApiApi.md#obtenerVentasPorFechaUsingGET) | **GET** /v1/ventas | Obtiene lastado de ventas
*VentasApiApi* | [**registrarVentaUsingPOST**](docs/VentasApiApi.md#registrarVentaUsingPOST) | **POST** /v1/ventas | Registra una venta


## Documentation for Models

 - [Accion](docs/Accion.md)
 - [ActualizacionEmpleadoDTO](docs/ActualizacionEmpleadoDTO.md)
 - [ActualizacionParcialProductoDTO](docs/ActualizacionParcialProductoDTO.md)
 - [ActualizarClienteDTO](docs/ActualizarClienteDTO.md)
 - [CambioPasswordToUsuarioDTO](docs/CambioPasswordToUsuarioDTO.md)
 - [Categoria](docs/Categoria.md)
 - [Ciudad](docs/Ciudad.md)
 - [Cliente](docs/Cliente.md)
 - [Compra](docs/Compra.md)
 - [CrearClienteDTO](docs/CrearClienteDTO.md)
 - [CrearEmpleadoDTO](docs/CrearEmpleadoDTO.md)
 - [CrearProductoDTO](docs/CrearProductoDTO.md)
 - [CrearSesionDTO](docs/CrearSesionDTO.md)
 - [DetalleCompra](docs/DetalleCompra.md)
 - [DetalleVenta](docs/DetalleVenta.md)
 - [Empleado](docs/Empleado.md)
 - [FlujoCaja](docs/FlujoCaja.md)
 - [ObtenerClientesResponse](docs/ObtenerClientesResponse.md)
 - [Operacion](docs/Operacion.md)
 - [Producto](docs/Producto.md)
 - [Proveedor](docs/Proveedor.md)
 - [ProveedoresResponse](docs/ProveedoresResponse.md)
 - [RegistroCompraDTO](docs/RegistroCompraDTO.md)
 - [RegistroVentaDTO](docs/RegistroVentaDTO.md)
 - [RepuestoDto](docs/RepuestoDto.md)
 - [RepuestoListResponse](docs/RepuestoListResponse.md)
 - [Rol](docs/Rol.md)
 - [RolAccionRelaccionDTO](docs/RolAccionRelaccionDTO.md)
 - [RolActualizacionDTO](docs/RolActualizacionDTO.md)
 - [RolCreacionDTO](docs/RolCreacionDTO.md)
 - [Sesion](docs/Sesion.md)
 - [Usuario](docs/Usuario.md)
 - [UsuarioActualizacionDTO](docs/UsuarioActualizacionDTO.md)
 - [UsuarioCreacionDTO](docs/UsuarioCreacionDTO.md)
 - [UsuariosResponse](docs/UsuariosResponse.md)
 - [Venta](docs/Venta.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



