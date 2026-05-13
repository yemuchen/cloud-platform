FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/cjlgb-design-gateway.jar app.jar
EXPOSE 10001
ENTRYPOINT ["java", "-jar", "app.jar"]