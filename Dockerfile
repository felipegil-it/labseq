FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY app/build/lib/* build/lib/
COPY app/build/libs/labseq-1.0.0.jar build/
WORKDIR /app/build
ENTRYPOINT java -jar labseq-1.0.0.jar
