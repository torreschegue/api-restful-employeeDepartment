# api-restful-employeeDepartment
La api emploeeDepartment muestra la creación de un proyecto con la combinaciones de varias tecnologías tales como:
JPA, Hibernate, H2, Lombook, Swagger y Faker. Estructurada en una arquitectura basadas en los estándares de Java y Spring Boot.
Con una Relación ManytoOne.

Tenemos: Entity: Clases modelos para persistencias de Datos.

Repository: Se crea la interfaz y con ayuda de JPA hacemos usos de Hibernate para crear nuestros CRUD.

Services: Interfaz modelo de métodos requeridos.

Servicios Implementados: Capa donde de implementan los métodos modelos creados en la interfaz Services.

Controller: Define las rutas y los verbos que van hacer utilizado en los servicios.

Exception: Capa para excepciones en el Rumtimer del servicio.

Con Swagger se hace la documentación de la api donde muestra información de desarrollador, controles y modelos disponibles en cada componente.
Con Faker Generamos datos aleatorios, con el objetivo de que al ejecutar el servicio este genere información y con JPA podemos hacer inserción a la tablas.
Con H2 Tenemos disponibilidad de tener una base de datos en memoria.

Versión de Java 1.8

IDE de Desarrollo STS-4.

Desarrollo trabajado con maven 3.6.3 y Spring Boot 2.4.0. Si descargas el proyecto tomar en cuanta las versiones para un optimo funcionamiento.
aplicar un mvn clean install y despues un mvn exec:java para levantar el componente.
