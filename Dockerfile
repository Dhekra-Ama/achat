FROM openjdk
ADD target/tn/esprit/rh/achat/1.0/achat-1.0.jar achat.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
