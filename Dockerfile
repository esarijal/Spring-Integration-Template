FROM openjdk:11-jre-slim
MAINTAINER Esa Rijal <esarijal_mustaqbal@mitrais.com>

ARG JAR_FILE
COPY $JAR_FILE /app.jar
CMD ["java","-jar","/app.jar"]