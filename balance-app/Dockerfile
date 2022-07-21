FROM openjdk
ENV PORT 5002
EXPOSE 5002
ADD balance-app/target/balance-api-0.0.1-SNAPSHOT.jar balance-api.jar
ENTRYPOINT ["java", "-jar", "/balance-api.jar"]