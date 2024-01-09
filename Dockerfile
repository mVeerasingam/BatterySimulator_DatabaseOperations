FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/batterySimulator_DB_Operations-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
CMD ["java", "-jar", "batterySimulator_DB_Operations-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]