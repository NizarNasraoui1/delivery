# Delivery Service

This project provides a basic delivery microservice built with Spring Boot.

## Prerequisites

- Docker and Docker Compose
- Java 21

## Running Dependencies

The project includes a `docker-compose.yaml` file with Kafka and Zookeeper services. Start them with:

```bash
docker-compose up -d
```

This will launch Kafka on port `9092` and Zookeeper on port `2181`.

## Running the Application

Use the Maven wrapper to start the Spring Boot application:

```bash
./mvnw spring-boot:run
```

Alternatively, build a jar and run it manually:

```bash
./mvnw clean package
java -jar target/delivery-0.0.1-SNAPSHOT.jar
```

The application starts on port `8080` by default.

