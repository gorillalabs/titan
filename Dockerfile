FROM maven:3.3-jdk-8-alpine
RUN mkdir -p /opt/cypp/titan
COPY . /opt/cypp/titan

# fix hostname resolving to prevent UnknownHostException
RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf

WORKDIR /opt/cypp/titan

CMD ["mvn", "clean", "install", "-e", "-X"]