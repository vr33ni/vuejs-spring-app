# Stage 1: Build stage
FROM openjdk:17-jdk-slim as build
WORKDIR /workspace/app

# Install curl, Maven, Node.js, and npm
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://deb.nodesource.com/setup_22.x -o nodesource_setup.sh && \
    bash nodesource_setup.sh && \
    apt-get install -y wget nodejs && \
    node -v && \
    mkdir -p /usr/share/maven && \
    wget -qO- https://archive.apache.org/dist/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz | tar -xz -C /usr/share/maven --strip-components=1 && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

RUN echo "Node binary location: $(node -v)"


# Copy necessary files
COPY mvnw .
COPY .mvn .mvn
COPY package.json .
COPY package-lock.json .
COPY pom.xml .
COPY src src
COPY migrations migrations 

# Cache Maven dependencies
RUN --mount=type=cache,target=/root/.m2 ./mvnw dependency:go-offline

# Cache npm dependencies
RUN --mount=type=cache,target=/root/.npm npm install

# Build the project
RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests

# Verify JAR file existence
RUN ls -l target

# Extract the JAR file using layertools if it exists
#ARG JAR_FILE=target/*.jar
ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar
RUN if [ -f ${JAR_FILE} ]; then java -Djarmode=layertools -jar ${JAR_FILE} extract --destination target/extracted; else echo "JAR file not found"; exit 1; fi

# Verify extraction by listing contents
RUN echo "Dependencies:" && ls -l target/extracted/dependencies && \
    echo "Spring Boot Loader:" && ls -l target/extracted/spring-boot-loader && \
    echo "Snapshot Dependencies:" && ls -l target/extracted/snapshot-dependencies && \
    echo "Application:" && ls -l target/extracted/application

# Stage 2: Run stage
FROM openjdk:17-jdk-slim
WORKDIR /application

RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://deb.nodesource.com/setup_22.x -o nodesource_setup.sh && \
    bash nodesource_setup.sh && \
    apt-get install -y wget nodejs && \
    node -v && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Copy the extracted files from the build stage
COPY --from=build /workspace/app/target/extracted/dependencies/ ./
COPY --from=build /workspace/app/target/extracted/spring-boot-loader/ ./
COPY --from=build /workspace/app/target/extracted/snapshot-dependencies/ ./
COPY --from=build /workspace/app/target/extracted/application/ ./

# Copy over the migration scripts and the node_modules directory
COPY --from=build /workspace/app/migrations ./migrations
COPY --from=build /workspace/app/node_modules ./node_modules


# Set the entrypoint
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]