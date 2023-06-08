# ********* ventural-backend-app **************

## Technology Stack :
- Java 17
- Spring Boot 3
- Maven 3.XX
- Swagger 3
- JUnit5 
- Docker 
- Jenkins
- GitHub

## Git :
- git clone https://github.com/julkarnain/hishab-game-app.git
- cd hishab-game-app
- git checkout develop

## Maven :
- mvn clean install 
- mvn clean package 
- ./mvnw install -DskipTests 
- ./mvnw spring-boot:run 

- mvn clean package -Pdev
- mvn clean package -Ptest

## Docker :
## Build Command :
- docker build -t hishab/hishab-game-app .

## Run Command :
- docker run -p 8000:8000 hishab/hishab-game-app

## Swagger UI :
- Select definition : players,games and all-apis
- http://localhost:8000/swagger-ui/index.html

## Test Plan :
- Import Postman collection from the application root directory

## Pros :
- Use all cutting-edge technology 
- Use some DevOps tool for automation 
- Use Java 8+(lambda,lombok,forEach,Stream etc.) and Spring Boot(FeignClient,springdoc-openapi) features
- Use Junit5 and Wiremock 
- Show how to manage Global Exception Handling and Custom Exception handling

##Cons :
- Could not manage time to provide front-end support
