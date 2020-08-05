FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/busca.jar busca.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /busca.jar

