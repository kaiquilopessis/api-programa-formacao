FROM openjdk:8-jdk-alpine
ENV USERDNSDOMAIN=sccalpha.local
EXPOSE 8081
COPY target/api-programa-formacao-0.1.1.jar api-programa-formacao-0.1.1.jar
ENTRYPOINT ["java", "-jar", "api-programa-formacao-0.1.1.jar"]