FROM openjdk:12
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080 8000
ENTRYPOINT ["java", "-jar", "/app.jar"]