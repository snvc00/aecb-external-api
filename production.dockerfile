FROM openjdk:11.0.11-slim-buster AS build

WORKDIR /api
COPY . .

RUN ["./gradlew", "build"]

FROM openjdk:11.0.11-jre-slim-buster

COPY --from=build /api/build /api/
EXPOSE 8080

CMD ["java", "-jar", "/api/layers/application.jar"]