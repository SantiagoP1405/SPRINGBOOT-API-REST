# Práctica curso "Spring Boot 3: desarrollar una API Rest en Java"
***ACTUALIZADO***
---

## Descripción

Este proyecto es una práctica realizada durante el curso **"Spring Boot 3: aplique las mejores prácticas y proteja una API Rest"**, del programa ONE de Alura Latam y Oracle. Su objetivo principal es construir una API RESTful funcional para la gestión de registros médicos, implementando conceptos clave como el mapeo de solicitudes HTTP, exclusión lógica, validaciones y acceso a datos con Spring Data JPA. Además, incorpora funcionalidades avanzadas como autenticación y autorización utilizando JWT (JSON Web Token) y la integración de Spring Security para proteger los endpoints de la API.

---

## ¿Qué hace esta API?

La API permite realizar operaciones CRUD sobre registros médicos con las siguientes funcionalidades principales:

1. **Crear un nuevo médico**: A través de solicitudes `POST`, se pueden agregar nuevos registros.
2. **Consultar médicos activos**: Permite listar únicamente los médicos con estado activo mediante solicitudes `GET`.
3. **Actualizar información de un médico**: Utilizando solicitudes `PUT`, se pueden modificar campos específicos de un registro existente.
4. **Desactivar un médico (exclusión lógica)**: Con solicitudes `DELETE`, se cambia el estado del registro a inactivo sin eliminarlo físicamente.
5. **Consulta personalizada**: Filtrar médicos por criterios específicos, como especialidad o nombre.
6. **Autenticación con JWT**: Se utiliza un token JWT para autenticar solicitudes, protegiendo los endpoints con Spring Security.
7. **Manejo de errores**: Se implementa un manejo centralizado de excepciones para devolver mensajes claros en caso de fallos o solicitudes incorrectas.

---

## ¿Cómo funciona?

1. **Solicitudes HTTP**:
   - `GET`: Recupera información de la base de datos (médicos activos, detalles de un médico).
   - `POST`: Crea nuevos registros.
   - `PUT`: Actualiza registros existentes.
   - `DELETE`: Desactiva registros de forma lógica.

2. **Exclusión lógica**:
   - En lugar de eliminar registros de la base de datos, se utiliza un campo booleano `activo` para marcar los registros como inactivos.

3. **Autenticación y autorización**:
   - La API está protegida con Spring Security, que valida el token JWT en cada solicitud. Los usuarios deben enviar el token JWT en los encabezados de autorización para acceder a los endpoints protegidos.

4. **Validación y manejo de errores**:
   - Se implementan validaciones con `@Valid` y mensajes de error descriptivos.
   - Se utiliza `@Transactional` para asegurar la consistencia de los datos en operaciones críticas.
   - **@ControllerAdvice** maneja excepciones globalmente, devolviendo respuestas adecuadas para errores comunes como `404 Not Found` o `500 Internal Server Error`.

5. **Manejo de parámetros dinámicos**:
   - Uso de `@PathVariable` para capturar valores dinámicos de las URL y personalizar consultas.

---

## Tecnologías implementadas

- **Java**: Versión 17
- **Spring Boot**: Versión 3.x
  - Dependencias clave:
    - **Spring Web**: Para manejar solicitudes HTTP.
    - **Spring Data JPA**: Para interactuar con la base de datos utilizando el ORM Hibernate.
    - **Spring Validation**: Para la validación de datos de entrada.
    - **Spring Security**: Para proteger los endpoints con autenticación basada en JWT.
    - **Flyway**: Gestión eficiente de la estructura de la base de datos, versionado y trazabilidad de cambios.
- **Hibernate**: Para el manejo de entidades y el contexto de persistencia.
- **Base de datos en MySQL Workbench**:
  - Se utiliza como base de datos en memoria para facilitar pruebas rápidas.
- **Insomnia**: Para probar los endpoints de la API.
- **Maven**: Para la gestión de dependencias.
- **Lombok**: Para simplificar la escritura de código (reducción de boilerplate).
- **Auth0 Java JWT**: Para la generación y validación de tokens JWT.

---

## Cómo se estructura el proyecto

1. **Controladores (`Controller`)**:
   - Manejan las solicitudes HTTP y las rutas.
   - Ejemplo: `@PutMapping("/medicos/{id}")` para actualizar un registro.

2. **Entidades (`Entity`)**:
   - Representan tablas de la base de datos.
   - Ejemplo: `Medico` incluye atributos como `nombre`, `documento`, `activo`.

3. **Repositorios (`Repository`)**:
   - Extienden `JpaRepository` para realizar operaciones CRUD y consultas personalizadas.
   - Ejemplo: `findByActivoTrue()` para listar solo médicos activos.

4. **Servicios (`Service`)**:
   - Contienen la lógica de negocio (si aplica).

5. **DTOs (`Data Transfer Object`)**:
   - Se utilizan para transferir datos entre capas de forma eficiente y segura.

6. **Filtros de Seguridad (`SecurityFilter`)**:
   - Personalización de filtros de Spring Security para manejar la validación de tokens JWT en las solicitudes.

---

## Ejemplo de Endpoints

- **GET /medicos**: Listar todos los médicos activos.
- **POST /medicos**: Crear un nuevo médico.
- **PUT /medicos/{id}**: Actualizar información de un médico.
- **DELETE /medicos/{id}**: Desactivar un médico de forma lógica.
- **POST /login**: Endpoint para obtener un token JWT al autenticar un usuario.

---

## Buenas Prácticas en el Proyecto

1. **Estructura del Proyecto**:
   - Refactorización de paquetes y clases para mantener el código organizado.
   - Uso de `ResponseEntity` para manejar respuestas HTTP de forma más controlada y flexible.

2. **Manejo de Errores**:
   - Implementación de un controlador global de excepciones con `@ControllerAdvice` para manejar errores comunes como `400 Bad Request`, `404 Not Found`, y `500 Internal Server Error`.
   - Implementación de mensajes de error descriptivos.

3. **Configuración de Spring Security**:
   - Configuración de Spring Security para autenticar y autorizar las solicitudes mediante JWT.
   - Implementación de filtros personalizados para la validación de tokens.

4. **Uso de DTOs**:
   - Implementación de **DTOs** para transferir datos de forma eficiente entre el frontend y el backend, evitando la sobrecarga de enviar entidades completas.

---

## Resumen de Cambios

- Se implementaron filtros de seguridad para validar tokens JWT y proteger los endpoints.
- Se configuró Spring Security para asegurar que solo los usuarios autenticados puedan acceder a los endpoints protegidos.
- Se utilizó la biblioteca **Auth0 Java JWT** para la generación y validación de tokens.
- Se implementó un manejo centralizado de errores utilizando `@ControllerAdvice` para manejar excepciones de manera global.
- Se refactorizó la estructura del proyecto para seguir buenas prácticas y mejorar la mantenibilidad.

---

## Conclusión

Este proyecto no solo cubre los aspectos básicos de una API RESTful, sino que también implementa mejores prácticas de seguridad, validación de datos y manejo de excepciones, utilizando Spring Security para proteger los endpoints con autenticación basada en JWT. Además, permite conocer cómo estructurar un proyecto de manera eficiente y manejar errores de forma centralizada.

