# Guía de Contribución - Luigi Market API

¡Gracias por considerar colaborar en este proyecto! Seguir estas guías ayuda a mantener la calidad del código y la coherencia arquitectónica.

---

## Flujo de Trabajo (Workflow)

Para mantener la integridad de la **Arquitectura Limpia** y un historial de Git organizado, seguimos el modelo de *Fork & Pull Request*:

### 1. Preparación
* **Fork**: Crea una copia del repositorio en tu perfil de GitHub haciendo clic en el botón "Fork".
* **Clonación**: Trae el código a tu entorno local:
  ```bash
  git clone https://github.com/luiscacuango2/luigi-market.git
  cd luigi-market
    ```
### 2. Desarrollo
* **Rama de Trabajo**: Crea una rama descriptiva que identifique el tipo de cambio.
    ```bash
   # Para nuevas funcionalidades
    git checkout -b feature/nombre-de-la-mejora
    
   # Para corrección de errores
    git checkout -b fix/descripcion-del-bug
    ```
### 3. Validación de Calidad
Antes de realizar cualquier commit, es obligatorio verificar que los cambios no rompan la estructura del proyecto ni las dependencias de Spring Boot. Ejecuta el wrapper de Gradle:
  ```bash
      # Limpiar y verificar compilación
      ./gradlew clean build -x test
```
### 4. Sincronización y Envío

* **Commit**: Registra tus cambios siguiendo la Convención de Commits.
* **Push**: Sube tu rama a tu fork:
```bash
    git push origin feature/nombre-de-la-mejora
```
* **Pull Request (PR)**: Desde GitHub, abre un PR hacia la rama main del repositorio original.
---
## Flujo de Trabajo (Git Flow)

Para mantener un historial limpio, utilizamos un flujo de trabajo basado en ramas:

1. **Haz un Fork** del repositorio.
2. **Crea una rama** para tu funcionalidad o corrección:
    * Para nuevas funciones: `git checkout -b feature/nombre-de-la-mejora`
    * Para corregir errores: `git checkout -b fix/descripcion-del-error`
3. **Realiza tus cambios** y asegúrate de seguir los estándares de código (ver abajo).
4. **Haz Commit** de tus cambios usando mensajes descriptivos (explicado más abajo):
    * `feat: añadir endpoint para búsqueda por nombre`
    * `fix: corregir mapeo de nulos en CategoryMapper`
5. **Sube tus cambios (Push)**: `git push origin feature/nombre-de-la-mejora`
6. **Abre un Pull Request** detallando qué cambiaste y por qué.

---

## Convención de Commits

Para mantener un historial de cambios profesional y facilitar la generación automática de registros (changelogs), seguimos el estándar de **Conventional Commits**.

Cada mensaje de commit debe tener el siguiente formato:
`<tipo>: <descripción breve en minúsculas>`

| Tipo | Descripción |
| :--- | :--- |
| **`feat`** | Una nueva funcionalidad (ej. un nuevo endpoint o servicio). |
| **`fix`** | Solución a un error o bug reportado. |
| **`docs`** | Cambios exclusivamente en la documentación (README, Swagger). |
| **`refactor`** | Cambios en el código que no añaden funciones ni corrigen errores. |
| **`style`** | Ajustes de formato, espaciado o limpieza de código (sin cambios de lógica). |
| **`test`** | Creación o actualización de pruebas unitarias o de integración. |
| **`chore`** | Tareas de mantenimiento (actualizar dependencias, build scripts). |

### Ejemplos de Commits:
* `feat: implementar búsqueda de productos por rango de precio`
* `fix: corregir error 500 al eliminar categoría sin productos`
* `docs: actualizar guía de despliegue en Render`
* `refactor: optimizar mappers de MapStruct para compras`

---
## Estándares de Código

Dado que este proyecto se basa en **Clean Architecture**, solicitamos que las contribuciones respeten las siguientes reglas:

### 1. Separación de Capas
* **Domain**: No debe tener dependencias de frameworks externos (como anotaciones de Hibernate o Spring). Solo POJOs e interfaces.
* **Persistence**: Aquí deben vivir las entidades de la base de datos y los mappers de MapStruct.
* **Web**: Solo controladores y configuración de Swagger.

### 2. Calidad de Software
* **Principios SOLID**: Evita clases demasiado grandes que hagan más de una cosa.
* **MapStruct**: No realices mapeos manuales si puedes usar la interfaz del mapper.
* **Documentación**: Si añades un nuevo endpoint, asegúrate de añadir las anotaciones de `@Operation` y `@ApiResponse` para Swagger.

### 3. Formato
* Usa **CamelCase** para variables y métodos.
* Mantén el código en **Español** para los nombres de dominio (como `Producto`, `Compra`) para mantener la consistencia con el esquema actual, o usa **Inglés** solo si decides refactorizar toda una capa (previo acuerdo en un Issue).

---

## Pruebas
Si añades lógica compleja en la capa de **Service**, se recomienda incluir pruebas unitarias utilizando **JUnit 5** y **Mockito**.

---

## Comunicación
Si tienes una idea importante pero no estás seguro de cómo implementarla, abre un **Issue** primero para discutirla con el equipo antes de empezar a programar.

¡Gracias por ayudar a que **Luigi Market API** sea mejor!

---

## Código de Conducta

Buscamos un entorno profesional y acogedor. Se espera que los colaboradores traten a los demás con respeto, realicen críticas constructivas y se centren en lo mejor para la comunidad del proyecto.

---
¡Gracias por ayudar a mejorar este proyecto!
**Luis Cacuango** - [luiscacuango2084@gmail.com](mailto:luiscacuango2084@gmail.com)