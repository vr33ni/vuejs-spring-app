# Spring Boot Application with MongoDB

## Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
    - [To run without Docker](#to-run-without-docker)
    - [To run with Docker](#to-run-with-docker)
3. [Installation](#installation)
    - [1. Java Development Kit (JDK)](#1-java-development-kit-jdk)
    - [2. Apache Maven](#2-apache-maven)
    - [3. MongoDB Community Server](#3-mongodb-community-server)
    - [4. Git (Optional)](#4-git-optional)
4. [Running the Application](#running-the-application)
    - [Run locally without Docker](#run-locally-without-docker)
    - [Run with Docker](#run-with-docker)
5. [Access the Application](#access-the-application)
6. [Endpoints](#endpoints)
7. [Initializing the Database](#initializing-the-database)
8. [Additional Information](#additional-information)
9. [Troubleshooting](#troubleshooting)

## Overview

This project is a basic web application built with Spring Boot and Java, using MongoDB as the database. The application provides basic CRUD operations for an `Item` model.

[Back to top](#table-of-contents)

## Prerequisites

This application can be run with or without Docker.

### To run without Docker

- Java Development Kit (JDK) 17 or later
- Apache Maven 3.6.3 or later
- MongoDB Community Server
- Git (optional, for cloning the repository)

### To run with Docker

- Docker Desktop installed or Docker in a Linux environment (not tested yet)

[Back to top](#table-of-contents)

## Installation

### 1. Java Development Kit (JDK)

Ensure you have JDK 17 or later installed. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or use an open-source version like OpenJDK.

To verify the installation, run:

```sh
java -version
```

### 2. Apache Maven

Download and install Maven from the official website.

To verify the installation, run:

```sh
mvn -version
```

### 3. MongoDB Community Server

Download and install MongoDB Community Server from the MongoDB website.

To start MongoDB, run:

```sh
brew services start mongodb-community@7.0
```

To verify MongoDB is running, use:

```sh
mongosh
```

### 4. Git (Optional)

To clone the repository, install Git from the official website.

To verify the installation, run:

```sh
git --version
```

```sh
git clone https://github.com/vr33ni/vuejs-spring-app.git
cd vuejs-spring-app/backend
```

[Back to top](#table-of-contents)

## Running the application

### Run locally without Docker

Follow these steps to set up and run the application locally:

#### 1. Configure MongoDB

Ensure MongoDB is running on localhost:27017. No additional configuration is necessary if MongoDB is running with the default settings.

#### 2. Build the Project

Navigate to the project directory and build the project using Maven:

```sh
mvn clean install
```

#### 3. Run the Application

Start the Spring Boot application:

```sh
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

The Maven Wrapper ensures that the same version of Maven is used by everyone working on the project, which helps avoid issues that can arise from different Maven versions.
If you prefer to rely on a pre-installed Maven and use your global environment, you can also run:

 ```sh
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

[Back to top](#table-of-contents)

## Run locally with Docker (on Mac)

Follow these steps to set up and run the application locally:

Navigate to parent folder to start all the services required at once.

```sh
cd ..
```

### 1. Build the Docker images

```sh
docker-compose --build
```

### 2. Run the Docker containers

```sh
docker-compose up                           
```

[Back to top](#table-of-contents)

## Access the Application

Once the application is running, you can access it using a web browser or API client (like Postman) at:

```sh
http://localhost:8080/items
```

[Back to top](#table-of-contents)

## Endpoints

- **GET /api/items**: Retrieve all items
- **GET /api/items/{id}**: Retrieve an item by ID
- **POST /api/items/**: Create a new item
- **DELETE /api/items/{id}**: Delete an item by ID
- **GET /api/items/brand/{brand}**: Retrieve items by brand
- **GET /api/items/type/{type}**: Retrieve items by type
- **GET /api/items/search?name={name}**: Retrieve items by name containing a substring (case-insensitive)

[Back to top](#table-of-contents)

## Initializing the Database

The application includes a DatabaseSeeder that creates an initial list of items in the MongoDB database when the application starts if the database is empty.

Additional Information

- Database Configuration: The database connection settings can be found and modified in the application.properties (local or prod) file(s).
- Dependencies: The project dependencies are managed using Maven and listed in the pom.xml file.

[Back to top](#table-of-contents)

## Troubleshooting

If you encounter any issues, ensure that:

- All prerequisites are installed and configured correctly.
- MongoDB is running and accessible at localhost:27017.

Feel free to create an issue or contact the project maintainers for further assistance.

[Back to top](#table-of-contents)