# Etapa 1: Build con Gradle y JDK 21 (Compilación)
# Se usa JDK 21 por ser la versión LTS más estable para Spring Boot 3
FROM gradle:8.5-jdk21 AS build
LABEL authors="luigi"

# Copiar el código fuente con permisos adecuados para el usuario gradle
COPY --chown=gradle:gradle . /app
WORKDIR /app

# Construir el JAR saltando las pruebas para acelerar el despliegue en Render
RUN gradle bootJar --no-daemon -x test

# Etapa 2: Runtime con JRE 21 (Ejecución)
# Usamos JRE en lugar de JDK para reducir el tamaño de la imagen final
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar el JAR generado desde la etapa de build
# Se renombra a app.jar para mayor simplicidad
COPY --from=build /app/build/libs/*.jar luigi-market.jar

# Exponer el puerto configurado en tu aplicación
EXPOSE 8080

# Comando de inicio activando el perfil de producción
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "luigi-market.jar"]