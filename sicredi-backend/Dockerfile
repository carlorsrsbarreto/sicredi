#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install
#
# Package stage
#
FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/sicredi-backend-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]