# Insurance-Management-Platform

This project is developed by individual with the help of the Spring-Boot framework.It is Back-End project given by Insure My Team.
It contained all the basic CRUD operation related to different entity.

## Tech Stack and Tools
- Java
- Spring Boot Framework
- Spring Data JPA
- Hibernate
- MySQL
- Swagger
- Lombok
- Postman Rest Client (API Testing)
- Maven ORM
- Apache Tomcat Server (Embedded server in SpringBoot App)
- STS
- Git & Github


## Modules
- Client Module
- Insurance Policy Module
- Claim Module

## ER Diagram
![img](https://github.com/Kajol1106/Insurance-Management-Platform/blob/main/InsuranceManagementPlatform/redme%20file%20related/insurance%20management%20platfor%20ER%20diagram.png)

## Client Module :
- register client
- get specific client using client id
- get list of clients or clients data
- update client
- delete client

![img](https://github.com/Kajol1106/Insurance-Management-Platform/blob/main/InsuranceManagementPlatform/redme%20file%20related/client%20controller.png)
 
## Insurance Policy Module :
- create new insurance policy
- get specific insurance policy using policy id
- get list of policies
- update policy
- delete policy
 
 ![img](https://github.com/Kajol1106/Insurance-Management-Platform/blob/main/InsuranceManagementPlatform/redme%20file%20related/Insurance%20Policy%20Controller.png)
 
 ## Claim Module :
- create new claim
- get specific claim using claim id
- get list of claims
- update claim
- delete claim
 
 ![img](https://github.com/Kajol1106/Insurance-Management-Platform/blob/main/InsuranceManagementPlatform/redme%20file%20related/claim%20controller.png)
 
 
 ## Architecture 
 
 Layered Architecture
- Structure (Controller -> API Layere -> Service -> Business Logic -> Repositories -> DAO Layer (Data Access))
![img](https://github.com/Kajol1106/Blog-Application/blob/main/BlogApplicationAPI/src/main/resources/templates/layered%20Architecture.png)

User interaction layer:
- This is the layer that interacts with users through screens, forms, menus, reports, etc.
- It defines how the application looks.  

Functionality layer: 
- This is the layer that presents the functions, methods, and procedures of the system based on the business rules layer

Business rules layer:
- This layer contains rules that determine the behavior of the whole application, such as, “If an invoice is printed, then send an email to the customer, select all items sold, and decrease their stock in the stock management module.” 

Application core layer:
- This server contains the main programs, code definitions, and basic functions of the application.
- Programmers work in this layer most of the time.

Database layer:
- This layer contains the tables, indexes, and data managed by the application.
- Searches and insert/delete/update operations are executed here. 


## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
- server.port=8888
- spring.datasource.url=jdbc:mysql://localhost:3306/InsuranceManagementPlatform;
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.datasource.username=enter_username
- spring.datasource.password=enter_password

## API Root Endpoint
- https://localhost:8888/
- If you have any doubt about this application feel free to reach out kolgirkajol@gmail.com
