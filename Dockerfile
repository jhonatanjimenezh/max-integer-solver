# Utilizar una imagen base con Java 11
FROM openjdk:11-jdk-slim

# Copiar el JAR compilado en el contenedor
COPY max-integer-solver.jar app.jar
COPY .env .env

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
