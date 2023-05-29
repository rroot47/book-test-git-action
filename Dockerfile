FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} book-test.jar
#ADD target/book-test.jar book-test.jar
ENTRYPOINT ["java", "-jar", "/book-test.jar"]