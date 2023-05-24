![Design First Approach in Microservices Development](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*-kjmu0V2ZzZ8Rwq86DkQng.png)

# Design-First Approach in Microservices Development with Spring Boot, Maven, and Swagger
A design first approach, demonstrated via OpenApi (Swagger Maven Plugin) on SpringBoot application.
The demo application creates are REST API for getting currency exchange, it uses an external service in order to calculate the currency exchange.

## REST API
There is a single REST API exposed in this Microservice
![OpenApi REST Request](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*jcknNSOPlRpvLyoHWXBqRA.png)
In order to see the Open API rendered in the broeser navigate to: 
`http://localhost:8044/swagger-ui/index.html#/`

## How to Build the Microservice?
Just run the following Maven command
`mvn clean install`

## How to Run the Microservice?
`curl http://localhost:8044/v2/rate/USD/EUR`

## Notes
-This API is using an external service that is meant for development purposes only
-For detailed information look at my [Medium Article](https://medium.com/@eyalzoref_26637/swagger-design-first-approach-in-microservices-development-with-spring-boot-maven-and-swagger-eb8525cb55f2)
