# Asociación Cultural Monterde - Gestión de Miembros

Este proyecto es una aplicación web desarrollada con Spring Boot y Thymeleaf para gestionar los miembros de la **Asociación Cultural Monterde**. La aplicación permite crear, listar, editar y eliminar miembros, así como visualizar información sobre los mismos.

## Tecnologías utilizadas

- **Spring Boot**: Framework para la creación de aplicaciones Java.
- **Thymeleaf**: Motor de plantillas para la renderización de vistas.
- **Spring Data JPA**: Para la gestión de la base de datos.
- **H2 Database**: Base de datos en memoria para desarrollo.
- **Spring Security**: Para la gestión de la autenticación y autorización (si se habilita).
- **Swagger**: Para documentar las APIs y facilitar su prueba.

## Funcionalidades

- **Crear un nuevo miembro**: Los administradores pueden agregar nuevos miembros al sistema.
- **Listar miembros activos**: Visualiza todos los miembros que están actualmente activos.
- **Editar miembros**: Modificar la información de un miembro ya existente.
- **Eliminar miembros**: Eliminar un miembro de la base de datos.
- **Formulario de registro**: Formulario fácil de usar para agregar nuevos miembros.

## Requisitos

- **Java 11 o superior**
- **Maven** (para la gestión de dependencias)
- **Base de datos**: H2 (base de datos en memoria para el desarrollo)

## Instrucciones de instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/gestion-miembros-asociacion.git

2. Navega al directorio del proyecto: 
    cd gestion-miembros-asociacion

3. Construye el proyecto con Maven:
    mvn clean install

4. Ejecuta la aplicación:
    mvn spring-boot:run

5. Una vez que la aplicación esté en ejecución, estará disponible en:
    http://localhost:8080
