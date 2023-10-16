FROM openjdk:8-jdk-alpine

RUN mkdir -p  /var/log/pods/test/log1
RUN chmod 777 /var/log/pods/test/log1

COPY fuse-integrator-1.0.0-SNAPSHOT.jar fuse-integrator-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","fuse-integrator-1.0.0-SNAPSHOT.jar"]