## How to build and deploy application


build project 

$ mvnw clean install -DskipTests=true

The easiest way to build and run the **server** is to use the maven:

$ mvnw spring-boot:run

The command should build war **atm-locator.war** in target folder

###War Deployment
project is already using embedded tomcat 7

$ mvnw clean install
The command will build war **atm-locator.war** in target folder

### Technology stack

* JDK 1.8
* Spring Boot 1.5.8
* Maven 3.6.3

## Security

There are two groups of users: ADMIN and USER

ADMIN:

* user:     admin
* password: admin

USER:

* user:     user
* password: password

### USAGE
visit  

http://localhost:8080/home?page=0&size=10&city=Nijmegen

http://localhost:8080/home
