FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/processa.jar processa.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /processa.jar

