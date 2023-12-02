# Max Integer Solver

## Descripción
Max Integer Solver es una aplicación Spring Boot desarrollada para resolver el problema de encontrar el máximo entero no negativo `k` tal que `0 ≤ k ≤ n` y `k mod x = y`. Este proyecto implementa una solución algorítmica para el problema descrito en [Codeforces - Problem 1374A](https://codeforces.com/problemset/problem/1374/A) y expone esta funcionalidad a través de una API REST.

## Características
- **Spring Boot 2.6.3**: Framework para facilitar la configuración y despliegue.
- **Java 11**: Versión del lenguaje de programación.
- **H2 Database**: Base de datos en memoria para almacenar los resultados de las operaciones.
- **Swagger UI**: Interfaz de usuario para interactuar fácilmente con la API.
- **Docker**: Soporte para contenerización y despliegue fácil.

## Metodología y Principios de Desarrollo
- **Arquitectura Hexagonal**: Utilizada para separar las preocupaciones en capas claramente definidas, facilitando la escalabilidad y mantenimiento.
- **Desarrollo Guiado por Pruebas (TDD)**: Adoptado para garantizar que el diseño y desarrollo del software estén dirigidos por pruebas automatizadas.
- **Desarrollo Guiado por el Dominio (DDD)**: Empleando un enfoque centrado en el dominio para mejorar la claridad y la lógica del negocio.
- **Principios SOLID**: Seguidos para promover un diseño de software orientado a objetos limpio y mantenible.

## Requisitos
- Java 11
- Gradle 7.4.2 (opcional, ya que se incluye un wrapper de Gradle)
- Docker (para ejecución con contenedores)

## Configuración y Ejecución
### Configuración Local
1. Clonar el repositorio.
2. Configurar las variables de entorno necesarias en el archivo `.env`.
3. Ejecutar el proyecto utilizando el comando Gradle:
   ```shell
   ./gradlew bootRun
### Ejecución con Docker
1. **Construir la imagen de Docker**:
   ```shell
   docker build -t max-integer-solver .
2. **Ejecutar el contenedor**:
   ```shell
   docker-compose up

## Uso de la API
La aplicación expone dos endpoints principales:
1. **POST /api/v1/operation**: Calcula el máximo entero **`k`** dado **`x`**, **`y`**, **`n`**.
   - **Cuerpo de la petición**: JSON con los campos x, y, n.
   - **Respuesta**: JSON con el resultado.
2. **GET /api/v1/operation**: Recupera todos los resultados de las operaciones almacenadas.

La documentación detallada de la API y los esquemas de solicitud y respuesta están disponibles a través de la interfaz de [Swagger](http://ec2-3-134-84-76.us-east-2.compute.amazonaws.com/max-integer-solver/swagger-ui/index.html?configUrl=/max-integer-solver/v3/api-docs/swagger-config).

## Pruebas
Las pruebas unitarias se pueden ejecutar mediante el comando:
1. *Ejecuón de pruebas:*
   ```shell
   ./gradlew test
./gradlew test

## Manejo de Errores
El proyecto utiliza excepciones personalizadas (`CustomException`) para manejar errores específicos que pueden surgir durante la operación de la aplicación, asegurando una respuesta coherente y estructurada.

## Documentación
La documentación generada con Java Doc está servida en una página de GitHub. Para abrir los enlaces en una nueva pestaña, haz clic con el botón central del ratón (rueda del ratón) o haz clic derecho y selecciona "Abrir enlace en una nueva pestaña".

- **Paquetes**: [Paquetes](https://jhonatanjimenezh.github.io/max-integer-solver/index.html)
- **Clases**: [Clases](https://jhonatanjimenezh.github.io/max-integer-solver/overview-tree.html)
