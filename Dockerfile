FROM amazoncorreto:19-alphine-jdk

COPY target/primerproyecto-0.0.1-SNAPSHOT.jar app.jar  

ENTRYPOINT ["java","-jar","/app.jar"]
