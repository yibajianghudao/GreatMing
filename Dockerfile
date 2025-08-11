
FROM openjdk:17-oraclelinux8
RUN mkdir "greatming"
COPY target/GreatMing-1.1.0.jar /greatming/app.jar
WORKDIR /greatming
ENTRYPOINT [ "java","-jar","app.jar" ]
