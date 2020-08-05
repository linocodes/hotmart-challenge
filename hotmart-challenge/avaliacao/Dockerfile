FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/avaliacao.jar avaliacao.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /avaliacao.jar

