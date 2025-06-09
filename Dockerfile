# Etapa 1: Build do projeto com Maven
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean install

# Etapa 2: Executar a aplicação com Java
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/agenda-visitas-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

