# .gitpod.Dockerfile
FROM gitpod/workspace-full

# Install Chrome for Selenium
RUN sudo apt-get update && \
    sudo apt-get install -y wget unzip curl gnupg2 default-jdk xvfb && \
    wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    sudo apt install -y ./google-chrome-stable_current_amd64.deb && \
    rm google-chrome-stable_current_amd64.deb

ENV CHROME_BIN=/usr/bin/google-chr