FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
copy . .
RUN apt-get install maven -y
RUN mvn clean install
FROM openjdk:17-jdk-slim
EXPOSE 8080
copy --from=build /target/loginspringweb-0.0.1-SNAPSHOT.jar demo.jar

ENTRYPOINT ["java","-jar","demo.jar"]