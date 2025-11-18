FROM registry.access.redhat.com/ubi8/openjdk-17-runtime
WORKDIR /work/
COPY target/*-runner.jar /work/application.jar
EXPOSE 8080
CMD ["java", "-jar", "application.jar"]
# Trigger build