# Spring Boot OpenTracing with Jaeger

This tutorial illustrates the usage of distributed tracing in a Spring Boot application. We use OpenTracing for instrumentation and Jaeger trace collecting.

The sample Spring Boot application is running a cinema theater scenario:
* *distributor* service provides available movies (`/movies`) from an in-memory h2 db.
* *cinema* provides its repertoire (`/repertoire`). Additionally, it has a circuitbreaker if *distributor* is not available and uses it's own in-house movies.

## Running the example

Build with Maven:

* `mvn install`

Run the whole setup with Docker Compose:

* `docker-compose up`

Query `cinema` microservice several times:

* `curl localhost:8080/repertoire`

Inspect the results in Jaeger UI [http://localhost:16686]

Stop `distributor` service:

* `docker-compose stop distributor`

Again query `cinema` microservice several times:

* `curl localhost:8080/repertoire`

And inspect the results in Jaeger UI [http://localhost:16686]
