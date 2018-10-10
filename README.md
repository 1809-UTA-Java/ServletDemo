# ServletDemo
This simple project uses Servlet 2.5/3.0.1 to provide access through JDBC to a database. It builds a war file that should be deployed to a Tomcat server or similar Java Servlet Container.
Upon successful deployment to a server, the web.xml will add these endpoints:
>http://localhost:8080/ServletDemo/hello

>http://localhost:8080/ServletDemo/forred

>http://localhost:8080/ServletDemo/animals

It will also serve static HTML pages at
>http://localhost:8080/ServletDemo/index.html

>http://localhost:8080/ServletDemo/forred.html

The above HTML pages provide simple examples for making GET and POST requests through HTTP.
