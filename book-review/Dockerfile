FROM openjdk:8u131-jre
ADD target/book-review-0.0.1-SNAPSHOT.jar book-review.jar
CMD ["java","-jar","-Dspring.profiles.active=production","book-review.jar"]