
# Nutrilud Backend

Nutrilud es un sistema de gestión de nutrición para nutricionistas y pacientes, que permite llevar el control de dietas, consultas, recordatorios y artículos de interés. Desarrollado en Java con Spring Boot, integra funcionalidades para la administración de usuarios, manejo de archivos y publicación de contenido.

## Características principales

- Gestión de usuarios (nutriologos, pacientes, administradores)
- Control de consultas y agenda
- Recordatorios personalizados
- Publicación y consulta de artículos
- Manejo seguro de archivos (subida y descarga)
- Autenticación JWT y gestión de tokens de acceso

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- MySQL
- JWT (Java JWT)
- Maven

## Instalación y configuración

1. Clona el repositorio:
	```bash
	git clone https://github.com/AbrahamCoco/Nutrilud-BackEnd-.git
	```
2. Configura las variables de entorno en `src/main/resources/application.properties`:
	```properties
	spring.datasource.url=jdbc:mysql://localhost:3306/nutrilud_db
	spring.datasource.username=TU_USUARIO
	spring.datasource.password=TU_CONTRASEÑA
	secret_key=TU_SECRET_KEY
	```
3. Instala las dependencias:
	```bash
	./mvnw clean install
	```
4. Ejecuta la aplicación:
	```bash
	./mvnw spring-boot:run
	```

## Endpoints principales

### Usuarios
- `POST /api/v1/users/insert` — Crear usuario
- `GET /api/v1/users/findById?id={id}` — Consultar usuario por ID
- `GET /api/v1/users/findAllPacientes` — Listar pacientes
- `GET /api/v1/users/findAllAdminsAndNutris` — Listar administradores y nutriologos

### Consultas
- `POST /api/v1/tdatos_consultas/insert` — Registrar consulta
- `GET /api/v1/tdatos_consultas/findAgendaByNutriologo?id={id}` — Consultar agenda de nutriologo
- `GET /api/v1/tdatos_consultas/findConsultasByPaciente?id={id}` — Consultar historial de paciente

### Artículos
- `POST /api/v1/tarticulos/insert` — Publicar artículo
- `GET /api/v1/tarticulos/findAllArticles` — Listar artículos
- `GET /api/v1/tarticulos/findById?id={id}` — Consultar artículo por ID

### Archivos
- `POST /api/v1/personal_access_token/insert_archivo` — Subir archivo
- `GET /api/v1/files/{ruta}` — Descargar archivo
- `GET /api/v1/view/{ruta}` — Visualizar archivo

### Autenticación
- `GET /api/v1/personal_access_token/login?usuario={usuario}&contrasenia={contrasenia}` — Login y obtención de token

## Base de datos

El sistema utiliza MySQL. Es necesario crear la base de datos y configurar las credenciales en el archivo de propiedades.

## Ejecución de pruebas

Para ejecutar las pruebas unitarias:
```bash
./mvnw test
```

## Autor

- AbrahamCoco

## Licencia

Este proyecto está bajo la licencia MIT.
