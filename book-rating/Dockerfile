FROM openjdk:8u131-jre
ADD target/book-rating-0.0.1-SNAPSHOT.jar book-rating.jar
CMD ["java","-jar","-Dspring.profiles.active=production","book-rating.jar"]