FROM pawelkorniak/ubuntu_mvn
LABEL author="Pawel Korniak"
COPY . /app
WORKDIR /app
RUN mvn spring-boot:run
ENTRYPOINT /bin/bash
