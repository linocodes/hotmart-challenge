FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/venda.jar venda.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /venda.jar

