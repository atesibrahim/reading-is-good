FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/reading-is-good.jar
WORKDIR /opt/app
COPY target/reading-is-good-1.0.0.jar reading-is-good-docker.jar
ENTRYPOINT ["java","-jar","/reading-is-good-docker.jar"]