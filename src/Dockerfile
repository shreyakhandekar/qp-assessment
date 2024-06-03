FROM adoptopenjdk/openjdk17:alpine-jre


WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/*.jar app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
