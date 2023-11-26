# Use a base image with Java and Gradle pre-installed
FROM gradle:jdk8-jammy AS build
LABEL org.opencontainers.image.source=https://github.com/Borghese-Gladiator/todo-spring-app
LABEL org.opencontainers.image.description="Sample image description"
LABEL org.opencontainers.image.licenses=MIT

# Set the working directory in the container
WORKDIR /app
# Copy the Gradle project files (build.gradle, settings.gradle, etc.)
COPY settings.gradle app/build.gradle /app/
# Copy java source code
COPY /app/src /app
# Build the application using Gradle
RUN gradle build --no-daemon

# Use a lightweight base image for running the application
FROM adoptopenjdk/openjdk11:alpine-jre
# Set the working directory in the container
WORKDIR /app
# Copy the JAR file built in the previous stage to the container
COPY --from=build /app/build/libs/*.jar /app/app.jar
# Expose the port your application listens on (change if needed)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
