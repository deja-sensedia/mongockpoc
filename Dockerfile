FROM openjdk:11.0.14.1-slim-buster
WORKDIR /app
COPY target/mongockpoc.jar mongockpoc.jar
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
ENV JVM_OPT $JVM_OPT
EXPOSE 8080
EXPOSE 5005
CMD java $JVM_OPT -jar, mongockpoc.jar