FROM amazoncorretto:17-alpine-jdk
MAINTAINER RBSOFT
EXPOSE 9191
COPY /build/libs/ApiMarket-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]