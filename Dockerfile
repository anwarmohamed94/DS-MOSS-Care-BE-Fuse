FROM openjdk:8-jdk-alpine

RUN mkdir /var/log/pods
RUN chmod 777 /var/log/pods

COPY fuse-integrator-1.0.0-SNAPSHOT.jar fuse-integrator-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","fuse-integrator-1.0.0-SNAPSHOT.jar"]