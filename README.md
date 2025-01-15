# Práctica curso "Spring Boot 3: desarrollar una API Rest en Java"

---

## Descripción

Este proyecto es una práctica realizada durante el curso **"Spring Boot 3: desarrollar una API Rest en Java"**, del programa ONE de Alura Latam y Oracle. Su objetivo principal es construir una API RESTful funcional para la gestión de registros médicos, implementando conceptos clave como el mapeo de solicitudes HTTP, exclusión lógica, validaciones y acceso a datos con Spring Data JPA.

---

## ¿Qué hace esta API?

La API permite realizar operaciones CRUD sobre registros médicos con las siguientes funcionalidades principales:

1. **Crear un nuevo médico**: A través de solicitudes `POST`, se pueden agregar nuevos registros.
2. **Consultar médicos activos**: Permite listar únicamente los médicos con estado activo mediante solicitudes `GET`.
3. **Actualizar información de un médico**: Utilizando solicitudes `PUT`, se pueden modificar campos específicos de un registro existente.
4. **Desactivar un médico (exclusión lógica)**: Con solicitudes `DELETE`, se cambia el estado del registro a inactivo sin eliminarlo físicamente.
5. **Consulta personalizada**: Filtrar médicos por criterios específicos, como especialidad o nombre.

---

## ¿Cómo funciona?

1. **Solicitudes HTTP**:
   - `GET`: Recupera información de la base de datos (médicos activos, detalles de un médico).
   - `POST`: Crea nuevos registros.
   - `PUT`: Actualiza registros existentes.
   - `DELETE`: Desactiva registros de forma lógica.

2. **Exclusión lógica**:
   - En lugar de eliminar registros de la base de datos, se utiliza un campo booleano `activo` para marcar los registros como inactivos.

3. **Validación y manejo de errores**:
   - Se implementan validaciones con `@Valid` y mensajes de error descriptivos.
   - Se utiliza `@Transactional` para asegurar la consistencia de los datos en operaciones críticas.

4. **Manejo de parámetros dinámicos**:
   - Uso de `@PathVariable` para capturar valores dinámicos de las URL.

---

## Tecnologías implementadas

- **Java**: Versión 17
- **Spring Boot**: Versión 3.x
  - Dependencias clave:
    - **Spring Web**: Para manejar solicitudes HTTP.
    - **Spring Data JPA**: Para interactuar con la base de datos utilizando el ORM Hibernate.
    - **Spring Validation**: Para la validación de datos de entrada.
- **Hibernate**: Para el manejo de entidades y el contexto de persistencia.
- **Base de datos en MySQL Workbench**:
  - Se utiliza como base de datos en memoria para facilitar pruebas rápidas.
- **Insomnia**: Para probar los endpoints de la API.
- **Maven**: Para la gestión de dependencias.
- **Lombok**: Simplificar entidades
- **Flyway**: Gestión eficiente de la estructura de la base de datos, versionado y trazabilidad de cambios.

---

## Cómo se estructura el proyecto

1. **Controladores (`Controller`)**:
   - Manejan las solicitudes HTTP y las rutas.
   - Ejemplo: `@PutMapping("/medicos/{id}")` para actualizar un registro.

2. **Entidades (`Entity`)**:
   - Representan tablas de la base de datos.
   - Ejemplo: `Medico` incluye atributos como `nombre`, `documento` y `activo`.

3. **Repositorios (`Repository`)**:
   - Extienden `JpaRepository` para realizar operaciones CRUD y consultas personalizadas.
   - Ejemplo: `findByActivoTrue()` para listar solo médicos activos.

4. **Servicios (`Service`)**:
   - Contienen la lógica de negocio (si aplica).

5. **DTOs (`Data Transfer Object`)**:
   - Se utilizan para transferir datos entre capas de forma eficiente y segura.

---

## Ejemplo de Endpoints

- **GET /medicos**: Listar todos los médicos activos.
- **POST /medicos**: Crear un nuevo médico.
- **PUT /medicos/{id}**: Actualizar información de un médico.
- **DELETE /medicos/{id}**: Desactivar un médico de forma lógica.

---

