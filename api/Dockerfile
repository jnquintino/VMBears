# Dockerfile
FROM maven:3.6.3-openjdk-11-slim as build
WORKDIR /opt/app
COPY src /opt/app/src
COPY pom.xml /opt/app
RUN mvn -f /opt/app/pom.xml clean package -Dmaven.test.skip=true
# Spring Boot
FROM adoptopenjdk:11-jre-hotspot
COPY --from=build /opt/app/target/xml-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
