FROM openjdk:17-jdk-alpine

MAINTAINER JeckChen

RUN mkdir -p /jcindex

WORKDIR /jcindex

ENV SERVER_PORT=8080 LANG=C.UTF-8 LC_ALL=C.UTF-8

EXPOSE ${SERVER_PORT}

COPY ./target/jc-index.jar ./app.jar

ENTRYPOINT ["java", \
            "-Dserver.port=${SERVER_PORT}", \
            "-Xmx256m", \
            "-jar", "app.jar"]
