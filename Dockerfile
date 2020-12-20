FROM arm64v8/openjdk:11-jre

COPY ./target/spring-raspberry-pi-1.0.0.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-raspberry-pi-1.0.0.jar"]
