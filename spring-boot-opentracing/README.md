# Spring Boot OpenTracing with Jaeger

This tutorial illustrates the usage of distributed tracing in a Spring Boot application. We use OpenTracing for instrumentation and Jaeger trace collecting.

The sample Spring Boot application is running a cinema theater scenario:
* *distributor* service provides available movies (`/movies`) from an in-memory h2 db.
* *cinema* provides its repertoire (`/repertoire`). Additionally, it has a circuitbreaker if *distributor* is not available and uses it's own in-house movies.

## Setup

Run Jaeger-all-in-one:
```
docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.12
```

Run the *distributor* (:8090) and *cinema* (:8080) services. Query the `/repertoire` with and without *distributor* running. Examine the resulting traces in Jaeger UI (`http://localhost:16686`).
