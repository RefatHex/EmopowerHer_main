# Use a Maven image to build the project
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the rest of the project and build it
COPY src ./src
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK image to run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/EmpowerHer-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port Spring Boot will run on
EXPOSE 8080
