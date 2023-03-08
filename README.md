# Spring Boot TrueNorth Arithmetic Back End.
Web platform to provide a simple calculator functionality (addition, subtraction, multiplication, division, square root, and a random string generation) 
where each functionality will have a separate cost per request.

## How to Run:
This application is packaged as a jar which has Tomcat 8 embedded. 
No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

## How to Compile:
This application is a maven project, so, to buld the project run mvn clean install in your local path.

## Clone this repository:
Make sure you are using JDK 1.8 and Maven 3.x
You can build the project and run the tests by running mvn clean package

## App features

Inside the application.properties you can find the configuration for a MySQL database or H2 database (if you want to use the embended Spring Database)
To deploy the project in my cloud server I changed the credential with my AWS RDS values.

Writing a RESTful service using annotation: supports JSON request / response; simply use desired Accept header in your request
Exception mapping from application exceptions to the right HTTP response with exception details in the body
Spring Data Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
Automatic CRUD functionality against the data source using Spring Repository pattern.

The security is based on JWT token, the expiration time is configured to 24 hours. The access to the endpoints is controlled by role, in this case the roles are
USER and ADMIN (for posible new features).

The database initialize files are schema.sql (ddl) and data.sql (dml), the path: src/main/resources/
The ddl tables are: users, roles (access control), user_roles(role to user), operations, records (add new field deleted for the soft delete) 
and user_balance (to control the wallet balance).

Dml script insert into users 3 new test users: will@hotmail.com, abc@gmail.com and test@yahoo.es with the wallet balance: $100, $10 and $20 respectively.
It was also necessary to assign a cost to each operation, ADDITION $0.1, SUBTRACTION $0.2, MULTIPLICATION $0.3, DIVISION $0.4, SQUARE ROOT $0.5 and 
Random String $1.

To generate the random String the application uses the Rest Template to request the url: https://www.random.org/strings/... using the necessary parameters.


