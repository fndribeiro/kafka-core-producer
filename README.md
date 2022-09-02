# Spring Boot Kafka

Demo project that implements producer message samples with Spring Boot and Apache Kafka.

## Features:

- Json messages
- Exception Handling using non-blocking retries and dead-letter topics
- Event sourcing and simple CQRS pattern: Producer saves employee registration event in MongoDB, consumer saves employee in postgres
- Asynchronous request/reply pattern
