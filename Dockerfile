FROM openjdk:17

# Copia el código fuente de la aplicación a la imagen
COPY target/homezbackend-0.0.1-SNAPSHOT.jar app.jar



# Ejecuta la aplicación Spring Boot cuando se inicia el contenedor
CMD ["java", "-jar", "/app.jar"]

# CMD ["startup.sh"]