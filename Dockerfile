FROM openjdk:8u121-jre-alpine

RUN apk add --no-cache curl jq

WORKDIR /usr/share/udemy

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD src/main/resources/testng.xml testng.xml
ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh

