FROM openjdk:8-jre-alpine
ADD target/integration-devops.jar achat.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
