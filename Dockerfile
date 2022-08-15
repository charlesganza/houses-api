FROM gradle:7.5-jdk17-alpine

WORKDIR /

#copy everything
COPY . ./

#build the jar
RUN gradle bootJar

ENTRYPOINT ["java", "-jar", "/build/libs/app.jar"]