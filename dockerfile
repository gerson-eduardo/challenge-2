FROM openjdk:17-jdk-alpine

RUN mkdir /app

COPY ms-auth-and-auto/target/ms-auth-and-auto-0.0.1-SNAPSHOT.jar /app/ms-auth-and-auto.jar
COPY ms-a/target/a-0.0.1-SNAPSHOT.jar /app/a.jar
COPY ms-b/target/b-0.0.1-SNAPSHOT.jar /app/b.jar
COPY ms-c/target/c-0.0.1-SNAPSHOT.jar /app/c.jar
COPY d/target/d-0.0.1-SNAPSHOT.jar /app/d.jar
COPY e/target/e-0.0.1-SNAPSHOT.jar /app/e.jar
COPY start.sh /app/start.sh

WORKDIR /app

EXPOSE 8080 8081 8082 8083 8084 8085

CMD ["sh", "start.sh"]
