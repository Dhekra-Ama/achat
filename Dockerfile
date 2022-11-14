FROM openjdk
ONBUILD ADD target/tn/esprit/rh/achat/1.0/achat-1.0.jar achat.jar
EXPOSE 8089
CMD ["java", "-jar", "achat.jar"]
