FROM amazoncorretto:17 AS build
WORKDIR /app

RUN yum install -y wget unzip

RUN wget https://archive.apache.org/dist/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip && \
    unzip apache-maven-3.8.6-bin.zip && \
    mv apache-maven-3.8.6 /opt/maven && \
    rm apache-maven-3.8.6-bin.zip

ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:17
WORKDIR /app

COPY --from=build /app/target/backend-sis-dis-2025-a-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
