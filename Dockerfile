#FROM ghcr.io/thekoguryo/graalvm/jdk:17
FROM container-registry.oracle.com/graalvm/jdk:17
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
