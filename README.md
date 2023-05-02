# taxi-service

**TAXI-SERVICE**
It's a small and simple but useful tool that can be used as a standalone app or be a part of a bigger,
more complicated application. App helps you to manage the most frequent entities or balances of any taxi-park.
If you are new, the service allows you to register as a driver in this taxi-park.
**FEATURES**
As a registered user you have the opportunity to create car manufacturers that are not present in db,
and delete it. You have the ability to add new cars to the database and delete it.
Every user has the ability to set a driver or drivers to a certain car and delete certain
drivers from the cars drivers list.
**ARCHITECTURE**
Used n-tier architecture with dao, service and controller layers.
Controllers are web-servlets which take incoming requests and responses from users via http.
Written on java, built with maven.
**USAGE**
To get the actual parameters of the database tables, run script from the resources/init_db.sql
file in the Workbench. As a server recommended to use Tomcat 9.0.50
