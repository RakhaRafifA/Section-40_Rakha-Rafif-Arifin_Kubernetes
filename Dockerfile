FROM openjdk:18-jdk-alpine

ADD target/remedial.jar remedial.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/remedial.jar"]