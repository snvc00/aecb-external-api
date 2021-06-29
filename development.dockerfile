FROM openjdk:11.0.11-slim-buster

WORKDIR /api
COPY . .
EXPOSE 8080

CMD ["./gradlew", "run"]