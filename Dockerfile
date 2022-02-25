FROM openjdk:11

COPY ./target/simbirsoft-task-1.0-SNAPSHOT.jar /opt/simbirsoft-task/app.jar

ENTRYPOINT ["java","-jar","/opt/simbirsoft-task/app.jar"]