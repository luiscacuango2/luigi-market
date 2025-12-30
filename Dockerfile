# Etapa 1: Build con Gradle 8.12 o superior para soportar Spring Boot 4.x
FROM gradle:8.12-jdk21 AS build
LABEL authors="luigi"

# Copiar el código fuente
COPY --chown=gradle:gradle . /app
WORKDIR /app

# Construir el JAR usando el wrapper si es posible, o gradle directamente
# He cambiado 'gradle' por './gradlew' que es la mejor práctica
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon -x test

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar luigi-market.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "luigi-market.jar"]