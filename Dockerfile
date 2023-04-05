# We take the base container
# For maximum compatibility I have selected openjdk 8 on alpine (linux)
FROM openjdk:11

# Add a volume pointing to /tmp
VOLUME /tmp

# Exposing port 8080 of the container
EXPOSE 8080

# Set the jar file variable
ARG JAR_FILE=target/spring-boot-starter-project-0.0.1-SNAPSHOT.jar

# copy jar file to the container
ADD ${JAR_FILE} spring-dockerizing.jar

# mention the entrypoint for the container
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-dockerizing.jar"]


#   To create the package:
#   mvn clean
#   mvn package


#   Command to build the docker image
#   docker image build --tag sg-spring .

#   Command to run the container
#   docker container run --publish 9000:8080 --env APP_KEY=ABCD1234 --env RETRY_COUNT=23 --name sg-spring-container sg-spring

#   In the browser, go to: http://localhost:9000/api/v1/persons