FROM openjdk:8-jdk-alpine
COPY target/fssn-exchangerate-0.0.1.jar fssnrate-1.0.0.jar
ENTRYPOINT ["java","-jar","/fssnrate-1.0.0.jar"]