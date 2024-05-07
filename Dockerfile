FROM openjdk:17-alpine
WORKDIR /app
COPY target/us-task-1.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","us-task-1.jar"]