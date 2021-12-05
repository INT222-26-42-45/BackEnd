FROM maven:3.8.1-jdk-11 AS BUILD
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package

FROM openjdk:11
WORKDIR /app
COPY --from=BUILD /build/target/skor-backend.jar /app
COPY public/images public/images
EXPOSE 9000

ENTRYPOINT ["java", "-jar","skor-backend.jar"]
