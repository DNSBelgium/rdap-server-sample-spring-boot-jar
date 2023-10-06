# RDAP server library sample

The project shows how to use the RDAP server library in a Spring Boot project deployed as jar.

The project is generated using spring initializr (https://start.spring.io/) with
* project maven
* language Java
* Spring Boot version 2.7.16 (uses Spring Framework version 5.3.30 )
* including the "Spring Web" dependency
* packaging jar
* Java 17

The sample does not implement a real rdap server, the responses are hard-coded examples and incomplete.

# How to run
### Command line
Build and package the application

    mvn package

Run using Java

    java -jar ./target/spring-boot-jar-0.0.1-SNAPSHOT.jar 

Run using Spring Boot Maven plugin

    mvn spring-boot:run

### In your IDE

Import the project in your IDE and run the main method of SpringBootJarApplication


# Steps used to create the app
The project was created by following these steps:

1. Generate the project using spring initializr
2. Add a dependency on the rdap server library

       <dependency>
           <groupId>be.dnsbelgium</groupId>
           <artifactId>rdap-server</artifactId>
           <version>3.0.0</version>
       </dependency>
   
3. Configure the services to be used
   1. See ServiceConfig, that extends the DefaultServiceConfig and only creates some of services and uses the default implementations for others
      2. 
   2. In a real-world implementation you can implement all services and annotate them with @Component so that Spring will automatically find them or mix the different approaches.
5. Configure a "baseRedirectURL" 
6. Configure Spring Web MVC:
   * The sample app relies on the auto-configuration for Spring MVC provided by Spring Boot. It does not import the WebConfig from the rdap library.  
   * see WebMvcConfig
   * Add a component scan for the controllers on a configuration class
      * @ComponentScan("be.dnsbelgium.rdap.controllers")
   * Instantiate a CustomObjectMapper instance provided by the rdap library (CustomObjectMapper)
   * No need to configure a resource handler for robots.txt. Static resources are handled by Spring Boot autoconfiguration.
   * Add exception handling
     * You can import ExceptionAdviceConfig from the rdap library  
     * or implement your own as done in this example by extending ResponseEntityExceptionHandler provided by Spring.

# Example urls:

Some valid urls:

    curl http://localhost:8080/domain/test.be
    curl http://localhost:8080/domain/café.brussels
    curl http://localhost:8080/domain/xn--caf-dma.brussels
    curl http://localhost:8080/entity/1
    curl http://localhost:8080/robots.txt

Some urls returning not implemented:

    curl http://localhost:8080/help
    curl http://localhost:8080/autnum/1

Example of a invalid request (using a string instead of a number)

    curl http://localhost:8080/autnum/abc

Returning http 400 bad request (default by Spring ResponseEntityExceptionHandler)

Example of an internal server error

    curl http://localhost:8080/ip/1.2.3.4

### Note
* it would be interesting to investigate if we can further simplify the object mapper approach using spring boot 
  * eg. adding the com.fasterxml.jackson.datatype:jackson-datatype-joda dependency which is picked up by spring boot automatically (and removing the need for a custom DateTimeSerializer)
  * eg. create a jackson module that would be picked up by Spring Boot instead of a complete custom ObjectMapper
