FROM openjdk:20

WORKDIR /app

COPY out/production/unime-oop /app

CMD java Main