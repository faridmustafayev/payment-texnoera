# Stage 1: build the jar
FROM gradle:8.3-jdk17 AS build
WORKDIR /home/gradle/project
COPY . .
RUN gradle clean build --no-daemon

# Stage 2: run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
