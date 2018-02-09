# spring-mongodb-jwt-starter

[![Build Status](https://travis-ci.org/m0uj/spring-mongodb-jwt-starter.svg?branch=master)](https://travis-ci.org/m0uj/spring-mongodb-jwt-starter)
[![License](https://img.shields.io/badge/License-GPL--3.0-blue.svg)](https://opensource.org/licenses/GPL-3.0)

## Installation Guidelines

### Prerequisites
The only prerequisites are a JDK and a text editor.

### Install tools
If you don't have any of these tools installed already,
you will need to:

* Download and install [git](https://git-scm.com/)
* Download and install [Java JDK 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* Download and install [MongoDB](https://docs.mongodb.com/manual/installation/)
* Download and install [Maven](https://maven.apache.org/install.html)

### Clone repository and install Maven dependencies
You will need to clone the source code of spring-mongodb-jwt-starter GitHub repository:

    git clone https://github.com/m0uj/spring-mongodb-jwt-starter.git

Go inside the repository's directory and install the Maven dependencies:

    cd spring-mongodb-jwt-starter
    mvn clean install

### Running the TESTS
To run the Tests, execute:

    mvn test
    
### Running the Web Application
To run the Web Application, go inside the starter-web directory and execute:

    cd spring-mongodb-jwt-starter-webapp
    mvn spring-boot:run

