FROM maven:latest AS build
COPY . .
WORKDIR .
RUN mvn package -D skipTests

FROM eclipse-temurin:latest
COPY --from=build ./target/app.jar ./app.jar
ENTRYPOINT ["java","-jar", "./app.jar"]