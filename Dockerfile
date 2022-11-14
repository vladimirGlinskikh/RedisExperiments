FROM adoptopenjdk/openjdk11:alpine-jre
COPY /target/RedisExperiment-0.0.1-SNAPSHOT.jar RedisExperiment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","RedisExperiment-0.0.1-SNAPSHOT.jar"]