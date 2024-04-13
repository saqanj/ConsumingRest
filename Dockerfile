# Use an official OpenJDK runtime as a base image
FROM openjdk:23-slim-bullseye

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/CallingTutorial-0.0.1-SNAPSHOT.jar .

# Exposing Port 3000
EXPOSE 3000

# Specify the command to run on container start
CMD ["java", "-jar", "CallingTutorial-0.0.1-SNAPSHOT.jar"]