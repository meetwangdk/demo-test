FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/template-0.0.1-SNAPSHOT.jar /app.jar
ENV APP_HOME /
WORKDIR $APP_HOME
EXPOSE  9090
ENTRYPOINT ["sh", "-c"]
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-Djava.security.egd=file:/dev/./urandom","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75.0","-jar","/app.jar"]
