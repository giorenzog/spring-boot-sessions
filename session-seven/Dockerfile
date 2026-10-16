FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn -q dependency:go-offline

COPY src ./src
RUN mvn -q package -DskipTests

FROM eclipse-temurin:11-jre
WORKDIR /app
COPY --from=build /app/target/session-seven-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]