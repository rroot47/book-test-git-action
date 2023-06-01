FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-book.jar
#ADD target/spring-book.jar spring-book.jar
ENTRYPOINT ["java", "-jar", "/spring-book.jar"]