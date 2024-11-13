# Stage 1: Build the application
FROM gradle:jdk21 AS build
WORKDIR /app

# Copy only necessary files to leverage Docker caching for dependencies
COPY build.gradle settings.gradle /app/
RUN gradle build --no-daemon || return 0  # Pre-download dependencies to optimize build

# Copy the remaining source files
COPY . /app

# Build the application
RUN gradle clean build --no-daemon

# Stage 2: Run the application in a lightweight container
FROM eclipse-temurin:21-jre
WORKDIR /app


# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/calisthenic-skills-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot app will use
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]