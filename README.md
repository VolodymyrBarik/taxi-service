## Taxi-service
It's a small and simple but useful tool that can be used as a standalone app or be a part of a bigger,
more complicated application. App helps you to manage the most frequent entities or balances of any taxi-park.
If you are new, the service allows you to register as a driver in this taxi-park.

## Features
As unregistered driver you have ability to create login and password.
<img src="https://github.com/VolodymyrBarik/taxi-service/blob/9e3e3f295e0cef60ce86bbe583fe9617636c178c/Screenshot_1.png">

After that you become registered 
driver and will have access to all options. As a registered user you have the opportunity 
to create car manufacturers that are not present in db, and delete it.
You have the ability to add new cars to the database and delete it.
Every user has the ability to set a driver or drivers to a certain car and delete certain
drivers from the cars drivers list.
<img src="https://github.com/VolodymyrBarik/taxi-service/blob/9e3e3f295e0cef60ce86bbe583fe9617636c178c/Screenshot_2.png">


## Architecture
Used n-tier architecture with dao, service and controller layers.
Controllers are web-servlets which take incoming requests and responses from users via http.
Written on java, built with maven.

## Internal Middleware
| Middleware                                                                                                                               | Description                                                                         |
|------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| [controller](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/controller) | Middleware that takes data/requests from user and provides requests                 |
| [dao](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/dao)               | Classes that interacts with db, creates, reads, updates and deletes data from db    |
| [exceptions](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/exception)  | This is where the custom exceptions are placed                                      |
| [lib](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/lib)               | Classes and annotations that is responsible for internal classes initialization     |
| [model](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/model)           | Models such as driver, car, manufacturer                                            |
| [service](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/service)       | Classes responsible for business logic, connection between controllers and database |
| [util](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/util)             | Utility responsible for connection to database                                      |
| [web.filter](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/web/filter) | Filters such as Authentication filter                                               |
| [resources](https://github.com/VolodymyrBarik/taxi-service/blob/53e785fd0807e3a8a31e6c9d2d2deb4dea984d79/src/main/resources)             | Here you can find setting for the logger and quick samples to recreate tables of db |


## Usage
Make sure you have Workbench  installed to run MySql database and Tomcat to run web-server as well as 
Intellij IDEA or other tool to maintain the code.
It is recommended to use script from the resources/init_db.sql to get the actual 
parameters of the database and tables. To get connection to your newly created db
go to util/Connection util and paste there your credentials such as URL to db
and root login, password. It is recommended to use "com.mysql.cj.jdbc.Driver"
as JDBC driver. 
Script works well with Tomcat 9.0.50 server version.

## Technologies Used
* Java 11 - as main language
* JDBC - as the way to build connection to database
* MySql - as way to manage database
* Workbench - as database server
* Servlets JSP - to build communication with end user
* Apache Tomcat - as web server of the project
* Maven - as builder of the project
* Git - as version control system
