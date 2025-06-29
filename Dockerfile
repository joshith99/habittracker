# Use a lightweight Java 17 runtime as base image
FROM eclipse-temurin:17-jre

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file
COPY target/habittracker-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
