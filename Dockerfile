FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app/barbearia-api

COPY . .

CMD ["mvn", "spring-boot:run"]

EXPOSE 8080
