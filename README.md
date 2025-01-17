# Práctica curso "Spring Boot 3: documentar, probar y preparar una API para su implementación"
---

## Descripción

Este proyecto es una práctica realizada durante el curso **"Spring Boot 3: documentar, probar y preparar una API para su implementación"**, del programa ONE de Alura Latam y Oracle. Su objetivo principal es construir una API RESTful funcional para la gestión de registros médicos, implementando conceptos clave como el mapeo de solicitudes HTTP, exclusión lógica, validaciones y acceso a datos con Spring Data JPA. Además, incorpora funcionalidades avanzadas como autenticación y autorización utilizando JWT (JSON Web Token) y la integración de Spring Security para proteger los endpoints de la API.

---

## ¿Qué hace esta API?

La API permite realizar operaciones CRUD sobre registros médicos con las siguientes funcionalidades principales:

1. **Crear un nuevo médico o paciente**: A través de solicitudes `POST`, se pueden agregar nuevos registros.
2. **Consultar médicos o pacientes activos**: Permite listar únicamente los médicos y pacientes con estado activo mediante solicitudes `GET`.
3. **Actualizar información de un médico o paciente**: Utilizando solicitudes `PUT`, se pueden modificar campos específicos de un registro existente.
4. **Desactivar un médico o paciente (exclusión lógica)**: Con solicitudes `DELETE`, se cambia el estado del registro a inactivo sin eliminarlo físicamente.
5. **Registrar consultas médicas**: Permite relacionar médicos y pacientes mediante su ID para crear un registro de consulta.
6. **Listar consultas registradas**: Devuelve un listado de todas las consultas realizadas.
7. **Autenticación con JWT**: Se utiliza un token JWT para autenticar solicitudes, protegiendo los endpoints con Spring Security.
8. **Manejo de errores**: Se implementa un manejo centralizado de excepciones para devolver mensajes claros en caso de fallos o solicitudes incorrectas.

---

## ¿Cómo funciona?

1. **Solicitudes HTTP**:
   - `GET`: Recupera información de la base de datos (médicos, pacientes activos o consultas).
   - `POST`: Crea nuevos registros (médicos, pacientes o consultas).
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

5. **Relación entre entidades**:
   - Las consultas médicas relacionan los ID de médicos y pacientes, registrando la fecha y otros detalles relevantes.

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
- **MySQL Workbench**: Base de datos utilizada para almacenar la información.
- **Insomnia**: Para probar los endpoints de la API.
- **Maven**: Para la gestión de dependencias.
- **Lombok**: Para simplificar la escritura de código (reducción de boilerplate).
- **Auth0 Java JWT**: Para la generación y validación de tokens JWT.

---

## Cómo se estructura el proyecto

1. **Controladores (`Controller`)**:
   - Manejan las solicitudes HTTP y las rutas.
   - Ejemplo: `@PostMapping("/consultas")` para registrar una consulta médica.

2. **Entidades (`Entity`)**:
   - Representan tablas de la base de datos.
   - Ejemplo: `Consulta` relaciona los atributos de médico y paciente.

3. **Repositorios (`Repository`)**:
   - Extienden `JpaRepository` para realizar operaciones CRUD y consultas personalizadas.
   - Ejemplo: `findByActivoTrue()` para listar solo médicos o pacientes activos.

4. **Servicios (`Service`)**:
   - Contienen la lógica de negocio (si aplica).

5. **DTOs (`Data Transfer Object`)**:
   - Se utilizan para transferir datos entre capas de forma eficiente y segura.

6. **Filtros de Seguridad (`SecurityFilter`)**:
   - Personalización de filtros de Spring Security para manejar la validación de tokens JWT en las solicitudes.

---

## Ejemplo de Endpoints

- **GET /medicos**: Listar todos los médicos activos.
- **GET /pacientes**: Listar todos los pacientes activos.
- **POST /medicos**: Crear un nuevo médico.
- **POST /pacientes**: Crear un nuevo paciente.
- **POST /consultas**: Registrar una consulta médica.
- **GET /consultas**: Listar todas las consultas realizadas.
- **PUT /medicos/{id}**: Actualizar información de un médico.
- **PUT /pacientes/{id}**: Actualizar información de un paciente.
- **DELETE /medicos/{id}**: Desactivar un médico de forma lógica.
- **DELETE /pacientes/{id}**: Desactivar un paciente de forma lógica.
- **POST /login**: Endpoint para obtener un token JWT al autenticar un usuario.

---

## Conclusión

Este proyecto no solo cubre los aspectos básicos de una API RESTful, sino que también implementa mejores prácticas de seguridad, validación de datos y manejo de excepciones, utilizando Spring Security para proteger los endpoints con autenticación basada en JWT. Además, incluye funcionalidades para manejar la relación entre médicos y pacientes a través del registro de consultas médicas, proporcionando una solución robusta y bien estructurada.
