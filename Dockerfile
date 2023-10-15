FROM openjdk:8-jdk-alpine

RUN chmod 777 /var/log

COPY fuse-integrator-1.0.0-SNAPSHOT.jar fuse-integrator-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","fuse-integrator-1.0.0-SNAPSHOT.jar"]