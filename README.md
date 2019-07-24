# OpenTracing tutorials

Distributed tracing is a method used to profile and monitor applications, especially those built using a microservices architecture. Distributed tracing helps pinpoint where failures occur and what causes poor performance.

[OpenTracing](https://opentracing.io/) -- an open-source standard for implementing distributed tracing. OpenTracing allows developers to add instrumentation to their application code using APIs that do not lock them into any one particular product or vendor.

## Tutorials

This repository demonstrates the usage of OpenTracing to implement distributed tracing in a couple of popular scenarios:

1. Backend ([spring-boot-opentracing](spring-boot-opentracing)) instrumentation using Jaeger Tracing.
2. Frontend ([react-client](react-client)) instrumentation using OpenZipkin and connecting the traces from backend.
3. Replacing the tracing system in O(1) when using OpenTracing. The example Spring Boot project switching from Jaeger to Zipkin ([vendor-independent-spring-boot](vendor-independent-spring-boot)).

## About

We are a distributed tracing consulting house based in Copenhagen. Checkout [tracing.dk](http://tracing.dk) for more info on how you can benefit from introducing the distributed tracing into your infrastructure.

You are welcome to suggest a new technology to instrument for tutorial or fork the existing ones.
