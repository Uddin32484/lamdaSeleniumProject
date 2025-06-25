FROM maven:3.9.6-eclipse-temurin-17

RUN apt-get update && \
    apt-get install -y wget unzip curl gnupg2 default-jdk xvfb && \
    wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt install -y ./google-chrome-stable_current_amd64.deb && \
    rm google-chrome-stable_current_amd64.deb

ENV CHROME_BIN=/usr/bin/google-chrome
WORKDIR /project
COPY . /project
CMD ["mvn", "clean", "test"]