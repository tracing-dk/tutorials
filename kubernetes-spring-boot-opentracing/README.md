# Kubernetes Jaeger and Spring Boot

This example shows Jaeger and sample Sample Boot applications deployment. We will use [minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/).

## Setup

It is assumed `minikube` is up and running and one can directly run `kubectl` commands directly from the command line.

First, apply [Jaeger development setup template](https://github.com/jaegertracing/jaeger-kubernetes):

* `kubectl create -f https://raw.githubusercontent.com/jaegertracing/jaeger-kubernetes/master/all-in-one/jaeger-all-in-one-template.yml`

Then apply templates to run two simple microservices `cinema` and `distributor` (these services are explained in more detail [here](../spring-boot-opentracing)):

* `kubectl create -f https://raw.githubusercontent.com/tracing-dk/tutorials/master/kubernetes-spring-boot-opentracing/deployment.yaml`

## Running the example

Minikube should automatically expose services. To get the urls to the services run `minikube service list`.

Call `cinema` microservice `/repertoire` endpoint:

* `curl $(minikube service cinema --url)/repertoire`

Get url of Jaeger Query UI

* `minikube service jaeger-query --url`

Open the url in your browser. In `Service` dropdown select `cinema` and hit "Find Traces". You should see traces of `cinema` and `distributor` microservices.
