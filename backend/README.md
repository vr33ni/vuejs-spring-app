# Spring Boot Application with MongoDB

## Overview

This project is a basic web application built with Spring Boot and Java, using MongoDB as the database. The application provides basic CRUD operations for an `Item` model.

## Prerequisites

To run this application locally, you need to have the following software installed:

- Java Development Kit (JDK) 17 or later
- Apache Maven 3.6.3 or later
- MongoDB Community Server
- Git (optional, for cloning the repository)

To run this applicaton using Docker, you need to have Docker Desktop installed or use Docker in a Linux environment. (not been tested yet)

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

## Run locally without Docker

Follow these steps to set up and run the application locally:

### 1. Configure MongoDB

Ensure MongoDB is running on localhost:27017. No additional configuration is necessary if MongoDB is running with the default settings.

### 2. Build the Project

Navigate to the project directory and build the project using Maven:

```sh
mvn clean install
```

### 3. Run the Application

Start the Spring Boot application:

```sh
./mvnw spring-boot:run
```

The Maven Wrapper ensures that the same version of Maven is used by everyone working on the project, which helps avoid issues that can arise from different Maven versions.
If you prefer to rely on a pre-installed Maven and use your global environment, you can also run:

 ```sh
 mvn spring-boot:run relies
 ```

## Run locally with Docker (on Mac)

Follow these steps to set up and run the application locally:

### 1. Build the Docker image

```sh
cd vuejs-spring-app/backend
docker build --build-arg JAR_FILE=target/\*.jar --platform=linux/amd64  -t vr33ni/backend .
```

### 2. Run the Docker container

```sh
docker run --platform=linux/amd64 -p 8080:8080 vr33ni/backend                              
```

## Access the Application

Once the application is running, you can access it using a web browser or API client (like Postman) at:

```sh
http://localhost:8080/items
```

## Endpoints

- GET /items/: Retrieve all items
- GET /items/{id}: Retrieve an item by ID
- POST /items/: Create a new item
- DELETE /items/{id}: Delete an item by ID

## Initializing the Database

The application includes a DatabaseInitializer that creates an initial item in the MongoDB database when the application starts if the database is empty.
Additional Information

- Database Configuration: The database connection settings can be found and modified in the application.properties file.
- Dependencies: The project dependencies are managed using Maven and listed in the pom.xml file.

## Troubleshooting

If you encounter any issues, ensure that:

- All prerequisites are installed and configured correctly.
- MongoDB is running and accessible at localhost:27017.

Feel free to create an issue or contact the project maintainers for further assistance.
