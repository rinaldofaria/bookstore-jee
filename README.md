# Java EE - Bookstore

This is a simple bookstore application created to prove understanding of Java EE environments and concepts. It's a project proposed by IMD0409 course in 2019.1 semester.

## Subprojects

**`Bookstore-Bean`** is a Java EE project which contains EJBs to deal with business domain (Domain classes, Data Acces Objects and EJB endpoints). It persists data using Hibernate and PostgreSQL. It's powered by Wildfly.

**`Bookstore-REST`** is a JAX-RS web project that serves a REST service to consume Bookstore-Bean endpoints. It uses JSON on data transfer layer with web.

**`Bookstore`** is a simple HTML project that uses Axios and jQuery to consume Bookstore-REST endpoints.

## Development Environment

You can use a Docker powered database (PostgreSQL), pgAdmin and container server (Wildfly) on development environment. Make sure you have docker and docker-compose. Note: that environment doesn't deploys the application.

Provided services:

- Wildfly 16
  - 8080: http services
  - 9990: HAL Management Console
- PostgreSQL
  - 5432: pgSQL port
- PGadmin
  - 8081: Admin console

### Running

To get the full pack up on your Docker instance run at the first time `docker-compose up --build`

For the followings execution use `docker-compose start` instead.

### Developing

I strongly recommend you to use VSCode as your "IDE", is insteresting to have the 
following extensions to work well with JEE environment:

- Docker (by Microsoft)
- Java Extension Pack (by Microsoft)
- [Language Support for Java](https://github.com/redhat-developer/vscode-java) (by Red Hat) you have to install this one manually

When hit "Open Folder" on VSCode pick `bookstore-jee`. After modifications, or just to try, 
you can send the code to the running instance of WildFly 16.0 by using these two tasks:

- task deploy ejb
- task deploy jsf

To run a task press `Ctrl + P` and type the name above listed, or just task to see all options.

> Note: The WildFly container is a modified image of the official one, I called it Booksfly.
It imports JDBC jar file and creates a datasource connecting to the also conteinerized PostgreSQL instance.