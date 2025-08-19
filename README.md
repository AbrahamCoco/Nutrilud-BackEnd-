# 🥗 Nutrilud Backend - Sistema de Gestión Nutricional Inteligente

Sistema backend diseñado para optimizar la experiencia de profesionales de la nutrición, ofreciendo una plataforma robusta que simplifica la gestión clínica, mejora la productividad y garantiza la seguridad de datos sensibles.

## ✨ Experiencia Integral del Usuario

### 👥 Gestión de Perfiles Multirol
- **Interfaces diferenciadas** para nutriólogos, pacientes y administradores
- **Flujos de trabajo intuitivos** adaptados a cada perfil de usuario
- **Dashboard personalizado** con métricas relevantes para cada rol

### 📅 Sistema de Agenda con Experiencia Fluida
- **Visualización de calendario** con vista semanal/mensual
- **Recordatorios automáticos** integrados con notificaciones push/email
- **Gestión de disponibilidad** con arrastrar y soltar (drag & drop)

### 📚 Centro de Conocimiento Nutricional
- **Editor de artículos** con formato enriquecido
- **Sistema de categorías** para organización intuitiva
- **Búsqueda predictiva** con filtros avanzados

### 🔒 Gestión Documental Segura
- **Subida de archivos** con preview inmediato
- **Organización visual** de documentos por paciente
- **Acceso granular** con permisos específicos

## 🛠 Arquitectura Tecnológica

| Capa | Tecnología | Versión | Propósito |
|------|------------|---------|-----------|
| **Backend** | Java | 21 | Alto rendimiento y seguridad |
| **Framework** | Spring Boot | 3.4.4 | Desarrollo ágil y mantenible |
| **Persistencia** | Spring Data JPA | 3.4.4 | ORM eficiente |
| **Base de Datos** | MySQL | 8.0+ | Transacciones ACID |
| **Autenticación** | Java JWT | Latest | Seguridad enterprise |
| **Build** | Maven | 3.6+ | Gestión de dependencias |

## ⚙️ Configuración con Experiencia de Developer

### Prerrequisitos de Instalación
- ✅ JDK 21 configurado correctamente
- ✅ MySQL 8.0+ ejecutándose localmente
- ✅ Variables de entorno configuradas
- ✅ Puertos disponibles (8080, 3306)

### Flujo de Instalación Guiada

1. **Clonación del Repositorio**
   ```bash
   git clone https://github.com/AbrahamCoco/Nutrilud-BackEnd-.git
   cd Nutrilud-BackEnd-
   ```

2. **Configuración Visual de Variables**
   Editar `src/main/resources/application.properties`:
   ```properties
   # Configuración de Base de Datos (UI intuitiva)
   spring.datasource.url=jdbc:mysql://localhost:3306/nutrilud_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña_segura
   
   # Seguridad JWT (Protección enterprise)
   jwt.secret=clave_super_secreta_compleja
   
   # Configuración de Servidor
   server.port=8080
	 ```
  

3. **Instalación con Feedback Visual**
   ```bash
   ./mvnw clean install -DskipTests
	 ```

4. **Ejecución con Logs Amigables**
   ```bash
   ./mvnw spring-boot:run
	 ```

## 🌐 API REST - Diseño Centrado en el Consumidor

### 👤 Gestión de Usuarios con UX Mejorada
- **POST** `/api/v1/users/insert` - Registro con validación en tiempo real
- **GET** `/api/v1/users/findById?id={id}` — Consultar usuario por ID
- **GET** `/api/v1/users/findAllPacientes` — Listar pacientes
- **GET** `/api/v1/users/findAllAdminsAndNutris` — Listar administradores y nutriologos

### 📋 Consultas con Flujo Natural
- **POST** `/api/v1/tdatos_consultas/insert` — Registrar consulta
- **GET** `/api/v1/tdatos_consultas/findAgendaByNutriologo?id={id}` — Consultar agenda de nutriologo
- **GET** `/api/v1/tdatos_consultas/findConsultasByPaciente?id={id}` — Consultar historial de paciente

### 📰 Gestión de Contenido con Editor Rico
- **POST** `/api/v1/tarticulos/insert` — Publicar artículo
- **GET** `/api/v1/tarticulos/findAllArticles` — Listar artículos
- **GET** `/api/v1/tarticulos/findById?id={id}` — Consultar artículo por ID

### 📁 Archivos con Experiencia Visual
- **POST** `/api/v1/personal_access_token/insert_archivo` — Subir archivo
- **GET** `/api/v1/files/{ruta}` — Descargar archivo
- **GET** `/api/v1/view/{ruta}` — Visualizar archivo

### 🔐 Autenticación Intuitiva
- **GET** `/api/v1/personal_access_token/login` — Login y obtención de token

## 🗃️ Base de Datos con Performance Optimizada

### Esquema Visual Intuitivo
- **Modelo relacional** con relaciones claras
- **Índices optimizados** para búsquedas rápidas
- **Backups automáticos** con retención configurable

### Configuración de Performance
- **Connection pooling** con HikariCP
- **Query optimization** con índices compuestos
- **Caching estratégico** con Redis opcional

## 🧪 Testing con Experiencia de Desarrollo

### Suite de Pruebas Intuitiva
```bash
./mvnw test -Dtest=*Test --no-transfer-progress
```

### Coverage Visual
```bash
./mvnw jacoco:report
```

## 👨‍💻 Autor

**AbrahamCoco** - [GitHub Profile](https://github.com/AbrahamCoco) | [Portfolio](https://abrahamcoco.github.io)

## 📄 Licencia

**Licencia MIT** - Diseñado para la comunidad de desarrollo abierto

---

*💡 Transformando la experiencia digital en nutrición clínica - Un paciente a la vez*