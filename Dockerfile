FROM openjdk:17

RUN mkdir app
WORKDIR /

COPY mhp-exec.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]