FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/noticia.jar noticia.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /noticia.jar

