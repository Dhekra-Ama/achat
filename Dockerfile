
FROM openjdk:11
EXPOSE 8089
ADD target/achat1.jar achat1.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]
