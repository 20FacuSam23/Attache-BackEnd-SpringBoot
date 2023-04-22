FROM amazoncorretto:8

MAINTAINER FacuSam

COPY target/primerproyecto-0.0.1-SNAPSHOT.jar primerproyecto-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/primerproyecto-0.0.1-SNAPSHOT.jar"]
