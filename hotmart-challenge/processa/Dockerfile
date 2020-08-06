FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/processa.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/processa.jar"]

EXPOSE 8084

