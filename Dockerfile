FROM openjdk:18-jdk-alpine

ADD target/miniproject-rakharafifa.jar miniproject-rakharafifa.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/miniproject-rakharafifa.jar"]