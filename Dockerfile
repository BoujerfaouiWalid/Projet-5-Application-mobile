# Étape 1 : Build avec Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le reste du code source
COPY src ./src

# 💡 Ajouter cette ligne pour inclure les configs !
COPY src/main/resources/application.properties ./src/main/resources/

# Builder le projet
RUN mvn clean package -DskipTests

# Étape 2 : Image finale
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copier le .jar généré
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
