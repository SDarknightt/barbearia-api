FROM openjdk:17
ADD target/barbearia-api.jar barbearia-api.jar
ENTRYPOINT ["java", "-jar","barbearia-api.jar"]

EXPOSE 8080