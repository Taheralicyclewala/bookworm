FROM openjdk:8u131-jre
ADD target/book-info-0.0.1-SNAPSHOT.jar book-info.jar
CMD ["java","-jar","-Dspring.profiles.active=production","book-info.jar"]