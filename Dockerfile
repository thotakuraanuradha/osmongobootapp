FROM openjdk:11

ADD ./target/mashupcontent-0.0.1-SNAPSHOT.jar mashupcontent-0.0.1-SNAPSHOT.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","mashupcontent-0.0.1-SNAPSHOT.jar"]
