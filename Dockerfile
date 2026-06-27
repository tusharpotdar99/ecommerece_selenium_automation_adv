FROM maven:3.9.9-eclipse-temurin-24

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

COPY testng.xml .

CMD ["mvn","clean","test"]