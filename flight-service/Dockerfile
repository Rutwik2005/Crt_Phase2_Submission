# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
# Download dependencies to cache them (makes future builds faster)
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage (smaller image footprint for production)
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8084

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
