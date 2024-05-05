FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
copy . .
RUN ./maven bootJar --no-daemon
FROM openjdk:17-jdk-slim
EXPOSE 8080
copy --from-main /java/karthick/loginspringweb-1.jar app.jar
