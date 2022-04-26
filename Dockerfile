FROM openjdk:18-jdk-alpine

ADD target/miniproject-rakha.jar miniproject-rakha.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/miniproject-rakha.jar"]