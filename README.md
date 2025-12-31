# 🛒 Luigi Market API

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue?style=for-the-badge&logo=postgresql)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue?style=for-the-badge&logo=docker)](https://www.docker.com/)
[![Render](https://img.shields.io/badge/Deploy-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)](https://render.com/)

API REST de alto rendimiento diseñada bajo los estándares de **Clean Architecture** y **Domain-Driven Design (DDD)**. Esta solución gestiona el flujo completo de un supermercado: inventario, categorías y procesamiento transaccional de compras.

---

## 📌 Características Técnicas

* **Arquitectura de Cebolla (Onion Architecture)**: Desacoplamiento total de la lógica de negocio frente a frameworks externos.
* **Persistencia Transaccional**: Gestión robusta de datos con **Spring Data JPA** y PostgreSQL.
* **Data Mapping**: Implementación de **MapStruct** para una conversión eficiente y segura entre Entidades y DTOs.
* **Documentación Viva**: Swagger UI (OpenAPI 3) para exploración y pruebas de endpoints en tiempo real.
* **Ready for Cloud**: Configuración optimizada para despliegue inmediato en Docker, Render, o Railway.

---

## 🧱 Arquitectura y Estructura

El proyecto implementa una **Arquitectura de Cebolla (Onion Architecture)**, garantizando que la lógica de negocio sea independiente de los agentes externos (Base de datos, Frameworks, UI).


### Organización de Archivos
```text
com.luiscacuango.market
├── 🟢 domain                 # Núcleo: Modelos de negocio y Contratos
│   ├── dto                  # Objetos de dominio puros (POJOs)
│   ├── repository           # Interfaces que definen el acceso a datos
│   └── service              # Implementación de reglas de negocio
│
├── 🔵 persistence            # Infraestructura: Implementación técnica
│   ├── crud                 # Repositorios nativos de Spring Data
│   ├── entity               # Modelos de tablas (PostgreSQL)
│   ├── mapper               # Lógica de mapeo (MapStruct)
│   └── repository           # Adaptadores que conectan el Dominio con la DB
│
├── 🟡 web                    # Entrada: Exposición de la API
│   └── controller           # Controladores REST con documentación OpenAPI
│
└── 🚀 MarketApplication      # Punto de entrada de la aplicación
```

## 🛠️ Stack Tecnológico

El proyecto está construido con las tecnologías más modernas y estables del ecosistema Java:

* **☕ Lenguaje:** Java 21 (LTS)
* **🍃 Framework:** Spring Boot 3.4+
* **🗄️ Persistencia:** Spring Data JPA & Hibernate 7
* **🔄 Mapeo:** MapStruct (Conversión eficiente Entity ↔ DTO)
* **☁️ Base de Datos:** PostgreSQL (Cloud via [Neon.com](https://neon.com/))
* **📖 Documentación:** Swagger UI (OpenAPI 3)
* **🐳 Contenedores:** Docker (Multi-stage builds para optimización de imágenes)
* **🐘 Gestor de dependencias:** Gradle (Automatización y construcción)
* **📊 Monitoreo:** [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html) (Métricas y Health Check en tiempo real)

---
## 🌐 Aplicación en Vivo

La API se encuentra actualmente desplegada y operativa en la nube. Puedes interactuar con ella a través de los siguientes enlaces:

* **🚀 API Base URL:** [https://luigiplay.onrender.com/luigi-market](https://luigiplay.onrender.com/luigi-market)
* **📑 Documentación Interactiva:** [Swagger UI - Explorar Endpoints](https://luigiplay.onrender.com/luigi-market/swagger-ui.html)

> **Nota:** Debido al uso del plan gratuito de Render, la aplicación puede tardar entre 30 y 60 segundos en "despertar" si no ha recibido tráfico recientemente.
---

## 🚀 Endpoints Principales
| Método | Path | Descripción |
| :--- | :--- | :--- |
| `GET` | `/actuator/health` | Verifica el estado de salud de la API y la conexión a la DB. |

### 📦 Gestión de Productos
Ruta base: `/api/products`

| Método | Path | Descripción |
| :--- | :--- | :--- |
| `GET` | `/all` | Recupera el listado completo de productos. |
| `GET` | `/{id}` | Busca un producto específico por su ID único. |
| `GET` | `/category/{id}` | Filtra y retorna productos de una categoría específica. |
| `POST` | `/save` | Registra un nuevo producto en el sistema. |
| `DELETE` | `/delete/{id}` | Elimina de forma permanente un producto por su ID. |

---

### 🛍️ Procesamiento de Compras
Ruta base: `/api/purchases`

| Método | Path | Descripción |
| :--- | :--- | :--- |
| `GET` | `/all` | Recupera el historial global de todas las transacciones. |
| `GET` | `/client/{id}` | Obtiene todas las compras realizadas por un cliente específico. |
| `POST` | `/save` | Registra una nueva transacción (Master-Detail). |

---

## 🛠️ Configuración de Producción

Para el despliegue en entornos como **Render** o **Railway**, configura las siguientes variables de entorno para una conexión segura a la base de datos:

| Variable | Descripción |
| :--- | :--- |
| `DB_HOST` | Endpoint del servidor de base de datos remoto. |
| `DB_NAME` | Nombre de la base de datos de producción. |
| `DB_USER` | Usuario con permisos de lectura/escritura. |
| `DB_PASSWORD` | Contraseña del usuario de base de datos. |
| `SPRING_PROFILES_ACTIVE` | Definir como `pdn` para cargar la configuración de producción. |

---

## 📖 Documentación Interactiva (Swagger)

La API cuenta con una interfaz de **Swagger UI (OpenAPI 3)** que permite explorar y probar todos los endpoints de forma interactiva sin necesidad de herramientas externas como Postman.

🔗 **Acceso local:** [http://localhost:8090/luigi-market/api/swagger-ui.html](http://localhost:8090/luigi-market/api/swagger-ui.html)

---

## 🛠️ Despliegue en Producción (Render / Cloud)

El proyecto incluye un **Dockerfile** optimizado basado en una estrategia de *multi-stage build* para generar imágenes ligeras y seguras.

### 🐳 Ejecución Local con Docker
Si deseas emular el entorno de producción en tu máquina local, utiliza los siguientes comandos:

1. **Construir la imagen:**
   ```bash
   docker build -t luigi-market .
    ```
---
## 🤝 Contribuciones

¡Tu ayuda es fundamental para mejorar este proyecto! Valoramos enormemente el tiempo y el esfuerzo de la comunidad.

Si deseas colaborar, te invitamos a:
1. Consultar nuestra **[Guía de Contribución](CONTRIBUTING.md)** para conocer el flujo de trabajo (Git Flow) y los estándares de código.
2. Reportar errores o proponer mejoras abriendo un [Issue](https://github.com/luiscacuango2/tu-repo/issues).
3. Asegurarte de que tus *Pull Requests* sigan las reglas de **Clean Architecture** establecidas.

---

## 📄 Licencia

Este proyecto se distribuye bajo la Licencia MIT - mira el archivo [LICENSE](LICENSE). Esto significa que tienes total libertad para usar, copiar, modificar y distribuir el software, siempre que se incluya el aviso de derechos de autor original.

---

## 👨‍💻 Autor

Desarrollado por **Luis Cacuango** *Especialista en desarrollo Backend con Java y Spring Boot.*

| Plataforma | Perfil |
| :--- | :--- |
| **LinkedIn** | [Luis Cacuango](https://linkedin.com/in/tu-usuario) |
| **GitHub** | [@luiscacuango2](https://github.com/luiscacuango2) |

---

<p align="center">
  <b>© 2025 Luigi Market API</b><br>
  <i>Construido bajo estándares de Arquitectura Limpia y principios SOLID.</i>
</p>