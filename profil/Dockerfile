FROM openjdk:8-jre-alpine

EXPOSE 8080

RUN mkdir /app
WORKDIR /app
ADD target/profil-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar