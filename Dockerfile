FROM openjdk:8-jre-alpine

RUN apk --no-cache upgrade

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD ./target /app

# Make port 80 and 8080 available to the world outside this container
EXPOSE 8080

COPY VERSION /

# Run app when the container launches

ENTRYPOINT ["java", "-jar", "/app/api-0.0.1-SNAPSHOT.jar"]
