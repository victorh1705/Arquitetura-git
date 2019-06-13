FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/project.jar project.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project.jar"]