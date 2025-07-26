FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copier uniquement pom.xml pour pré-télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le reste du code source
COPY src ./src

# Build le projet
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

