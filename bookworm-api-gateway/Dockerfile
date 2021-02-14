FROM openjdk:8u131-jre
ADD target/bookworm-api-gateway-0.0.1-SNAPSHOT.jar book-api-gateway.jar
CMD ["java","-jar","-Dspring.profiles.active=production","book-api-gateway.jar"]
