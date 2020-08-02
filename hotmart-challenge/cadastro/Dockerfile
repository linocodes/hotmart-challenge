FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/cadastro.jar cadastro.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /cadastro.jar

