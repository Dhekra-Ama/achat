from openjdk
ADD target/achat-1.0.jar achat.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
