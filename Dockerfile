FROM openjdk:17-alpine
MAINTAINER Nikita Koval
COPY target/CarSale-0.0.1-SNAPSHOT.jar task-manager.jar
ENTRYPOINT ["java","-jar","task-manager.jar"]