# Use the official Ubuntu base image
FROM ubuntu:latest

# Set environment variables
ENV DEBIAN_FRONTEND=noninteractive

# Update package lists and install required dependencies
RUN apt-get update && apt-get install -y wget gnupg software-properties-common \
    && wget -O- https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor -o /usr/share/keyrings/adoptium-keyring.gpg \
    && echo "deb [signed-by=/usr/share/keyrings/adoptium-keyring.gpg] https://packages.adoptium.net/artifactory/deb/ $(lsb_release -cs) main" | tee /etc/apt/sources.list.d/adoptium.list \
    && apt-get update && apt-get install -y temurin-21-jdk \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

RUN apt-get update && apt-get install -y python3 python3-pip wget bzip2 ca-certificates libglib2.0-0 libxext6 libsm6 libxrender1 sudo
RUN apt-get install -y python3-venv
RUN apt-get install -y python3-toml


WORKDIR /home/ubuntu/versions-parent
RUN mkdir versions-parent
RUN cd /home/ubuntu/versions-parent
RUN python3 -m venv phx
RUN chmod +x ./phx/bin/activate

#RUN source ./phx/bin/activate

COPY . ./

# Set JAVA_HOME environment variable
ENV RUN_DIR=/home/ubuntu/versions-parent
ENV JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-arm64
ENV PATH="$JAVA_HOME/bin:$PATH"
RUN chmod 777 script.sh
ENTRYPOINT ["./script.sh"]