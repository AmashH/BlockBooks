FROM openjdk:11-jre-slim

WORKDIR /opt/chaincode

COPY target/chaincode.jar /opt/chaincode/chaincode.jar

ENV CHAINCODE_SERVER_ADDRESS=0.0.0.0:9999
ENV CHAINCODE_ID=dummy  

CMD ["java", "-jar", "/opt/chaincode/chaincode.jar"]
