# Use the official Ubuntu base image
FROM localhost:5001/python

WORKDIR /home/ubuntu
RUN mkdir versions-parent
RUN cd /home/ubuntu/versions-parent
WORKDIR /home/ubuntu/versions-parent
COPY . ./
# Set JAVA_HOME environment variable
ENV RUN_DIR=/home/ubuntu/versions-parent
RUN chmod 777 script.sh
RUN apt-get install -y vim
ENTRYPOINT ["./script.sh"]