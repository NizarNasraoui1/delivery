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

## Running the Application

Use the Maven wrapper to start the Spring Boot application:

```bash
java -jar target/delivery-0.0.1-SNAPSHOT.jar
```

