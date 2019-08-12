# Review Search App

This app searches through the reviews and returns the results

## Technologies Used

Java 1.8
Spring Boot 2.1.6
Maven


## Developer Guide

Review Search Application is a standard maven project using Java 8, Spring Boot and is built, tested, and released using the standard Maven process.

### Build Application using jar

```
git clone review-search-application
cd review-search-application
mvn clean install
java -jar $path-to-jar $path-to-data-file-location
```

### Launch Application

To run the app on your local, navigate to localhost:8080/

## Docker

### Build Docker Image
```
docker build . -t littlepanda27/review-search-application-image:<GIT_SHA> -t littlepanda27/review-search-application-image:latest
```

### Push Docker Image
```
docker login
docker push littlepanda27/review-search-application-image:<GIT_SHA>
docker push littlepanda27/review-search-application-image:latest
```

### Run Docker Image
```
docker run -t -p 8080:8080 littlepanda27/review-search-application-image:latest 
```
