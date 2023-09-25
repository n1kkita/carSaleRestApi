FROM openjdk:17-alpine
MAINTAINER Nikita Koval
COPY target/CarSale-0.0.1-SNAPSHOT.jar car-sale-api.jar
ENTRYPOINT ["java","-jar","car-sale-api.jar"]