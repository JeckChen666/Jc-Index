FROM ghcr.io/graalvm/jdk-community

MAINTAINER JeckChen

RUN mkdir -p /jcindex

WORKDIR /jcindex

ENV SERVER_PORT=8080 LANG=C.UTF-8 LC_ALL=C.UTF-8

EXPOSE ${SERVER_PORT}

ADD ./target/jc-index.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
            "-Xmx256m", \
            "-jar", "app.jar"]
