# Spring Template Project
This project is to test out my local Kubernetes setup and learn some Spring Boot.

Technologies
- Gradle - java build tools
- Spring Boot - java framework for DI. I'm using Spring Boot Web to build a REST API
- MongoDB - NoSQL document database
- Docker - dockerfile to containerize app
- GitHub Actions - CI to build docker image and 

## Setup
Normal Build
- install Java 20
- install Gradle
- run `gradlew build`
---
Prod Build
- `docker build -- tag 'todo-spring-app:0.1.0' .`

# Notes
## Steps1
- install Gradle - [https://gradle.org/releases/](https://gradle.org/releases/)
  - add to PATH
- `gradle init`
- add `.gitignore`
- update `build.gradle` with dependencies
- write Java Spring Boot code
- write Dockerfile
- write GitHub Actions YAML

## Glossary
- Gradle - build tool using Groovy or Kotlin for scripting
  - gradle vs gradlew - gradlew is a gradle wrapper that runs a platform-independent gradlew script to build gradle projects
  - plugins - extensions to extend Gradle functionality and introduce specific build features (eg: `org.springframework.boot` plugin enables Spring Boot-specific configurations)
  - dependencies - external libraries or modules
- Maven - build tool using XML config
  - NOTE: By default, both Maven and Gradle download artifacts from Maven Central
- Spring Boot - java framework for using Dependency Injection, Aspect-oriented programming, etc.
- Hibernate - ORM to map Java objects to database tables

