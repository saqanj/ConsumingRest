# Consuming Restful Microservices Tutorial
## Introduction
This is a simple tutorial for how one can consume restful microservices programmatically as opposed to curling or via a SwaggerUI. This tutorial is completed using the Spring Framework, Java, and Gradle for build/testing. To begin the tutorial, please clone this repository using the following command:
```bash
git clone https://github.com/saqanj/ConsumingRest.git
```
## Tutorial Steps:
### 1. Run RESTful Service via Kubernetes
For this tutorial, we will be using the Spring's Quoters Microservice observable at the following link: https://github.com/spring-guides/quoters as our source of REST resources. Kubernetes functionality is provided using the following commands sequentially on a terminal on your local machine:
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
You can now view the following localhost links to see the REST calls at work:
1. [Random](http://localhost:8080/api/random) This is for generating a random quote.
2. [API1](http://localhost:8080/api1) This is for accessing the first API.
3. [API2](http://localhost:8080/api2) This is for accessing the second API.
4. [API3](http://localhost:8080/api3) This is for accessing the third API.

### 2. Execute a Gradle Build.
Execute a Gradle Build on a seperate terminal in the directory containing the cloned github repository using the following command:
```bash
./gradlew build
```
This will generate a new/updated JAR file and compile the code. You can now access the REST calls from the previous links programmatically using the following command in the same directory as before:
```bash
java -jar CallingTutorial-0.0.1-SNAPSHOT.jar
```
To terminate this command, simply hold CTRL-C. 
### 3. Run the Communication Service on a Container on K8's!
Follow these commands sequentially in the same directory from Step 2:
```bash
docker image build -t name/consumingrest .
```
```bash
docker push -t name/consumingrest
```
```bash
kubectl run consumingrest --image=name/consumingrest --env="quoters_base_url=http://quoters:8080"
```
```bash
kubectl logs consumingrest
```
Be sure to replace name with your DockerHub name!
