FROM openjdk:17-alpine
ADD target/*-exec.jar app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]