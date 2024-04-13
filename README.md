# Consuming Restful Microservices Tutorial
## Introduction
This is a simple tutorial for how one can consume restful microservices programmatically as opposed to curling or via a SwaggerUI. This tutorial is completed using the Spring Framework, Java, and Gradle for build/testing. To begin the tutorial, please clone this repository using the following command:
```bash
git clone https://github.com/saqanj/ConsumingRest.git
```
## Tutorial Steps:
### 1. Run RESTful Service via Kubernetes
For this tutorial, we will be using the Spring's Quoters Microservice observable at the following link: https://github.com/spring-guides/quoters as our source of REST resources. Kubernetes functionality is provided using the following sequentially on a terminal on your local machine:
```bash
kubectl run quoters --image=javajon/quoters:1.0.0 --port=8080
```
```bash
kubectl expose pod quoters --name=quoters
```
```bash
kubectl expose pod quoters --name=quoters
```
Be sure to run the following command and leave the terminal running to proceed with the tutorial. Once completed with the tutorial, you can run CTRL-C to terminate the command:
```bash
kubectl port-forward service/quoters 8080:8080
```
