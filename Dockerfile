FROM openjdk:8-jdk-alpine

RUN chmod 777 /var/log

COPY target/fuse-integrator-1.0.0-SNAPSHOT fuse-integrator-1.0.0-SNAPSHOT
ENTRYPOINT ["java","-jar","/fuse-integrator-1.0.0-SNAPSHOT"]