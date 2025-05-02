FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/crazy-harbor-bff-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-Dspring.profiles.active=live"
ENTRYPOINT ["java","-jar", "/app.jar"]
