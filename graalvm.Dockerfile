## Building stage
#FROM openjdk:11-jdk AS builder # use OpenJDK 11 if desired
FROM openjdk:8-jdk-alpine AS builder
WORKDIR /src/

# cache gradle
COPY gradle /src/gradle
COPY gradlew /src/
# run "gradle --version" to let gradle-wrapper download gradle
RUN ./gradlew --version

# build source
COPY . /src/
RUN ./gradlew build

## GraalVM
FROM oracle/graalvm-ce:19.2.0 as graalvm
WORKDIR /src
RUN gu install native-image
COPY --from=builder /src/build/libs/*-all.jar microservice.jar
RUN ls -al
RUN native-image --no-server -cp microservice.jar -H:Name=microservice
RUN ls -al

## Final image
FROM frolvlad/alpine-glibc
WORKDIR /app
COPY --from=graalvm /src/microservice .

# set the default port to 80
ENV MICRONAUT_SERVER_PORT 80
EXPOSE 80

CMD ["./microservice"]