# taxi-service

**TAXI-SERVICE**
It's a small and simple but useful tool that can be used as a standalone app or be a part of a bigger,
more complicated application. App helps you to manage the most frequent entities or balances of any taxi-park.
If you are new, the service allows you to register as a driver in this taxi-park.

**FEATURES**
As unregistered driver you have ability to create login and password.
After that you become registered 
driver and will have access to all options. As a registered user you have the opportunity 
to create car manufacturers that are not present in db, and delete it.
You have the ability to add new cars to the database and delete it.
Every user has the ability to set a driver or drivers to a certain car and delete certain
drivers from the cars drivers list.

**ARCHITECTURE**
Used n-tier architecture with dao, service and controller layers.
Controllers are web-servlets which take incoming requests and responses from users via http.
Written on java, built with maven.

**Internal Middleware**

| Middleware | Description |
|------------|-------------|

| [controller](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/controller) | Middleware that takes data/requests from user and provides requests  |
| [dao](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/dao)               | Classes that interacts with db, creates, reads, updates and deletes data from db   |
| [exceptions](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/exception)  | This is where the custom exceptions are placed  |
| [lib](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/lib)               | Middleware and annotations that is responsible for internal classes initialization |
| [model](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/model)           | This is where the models such as driver, car etc. stored  |
| [service](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/service)       | Classes responsible for business logic, connection between controllers and database  |
| [util](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/util)             | Utility responsible for connection to database  |
| [web.filter](https://github.com/VolodymyrBarik/taxi-service/blob/35c7f69d6502d490ce9a1f21b7db00ede0d3d4e9/src/main/java/taxi/web/filter) | Filters such as Authentication filter   |


**USAGE**
To get the actual parameters of the database tables, run script from the resources/init_db.sql
file in the Workbench. As a server recommended to use Tomcat 9.0.50
