FROM openjdk:8-jdk
COPY ./target/Phase3Project-0.0.1-SNAPSHOT.jar Phase3Project-0.0.1-SNAPSHOT.jar
CMD ["java" ,"-jar","Phase3Project-0.0.1-SNAPSHOT.jar"]
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers