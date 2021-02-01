FROM pawelkorniak/ubuntu_mvn
LABEL author="Pawel Korniak"
COPY . /app
WORKDIR /app
RUN mvn package
ENTRYPOINT ["java","-jar","target/forex-0.0.1-SNAPSHOT.jar"] 

