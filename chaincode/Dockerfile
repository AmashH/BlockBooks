FROM openjdk:11-jre-slim

WORKDIR /opt/chaincode

COPY target/chaincode.jar /opt/chaincode/chaincode.jar

# Environment Variables
ENV CHAINCODE_SERVER_ADDRESS=0.0.0.0:9999
ENV CHAINCODE_ID=dummy

# Expose the gRPC server port
EXPOSE 9999

# Run the chaincode
CMD ["java", "-DCHAINCODE_SERVER_ADDRESS=0.0.0.0:9999", "-jar", "/opt/chaincode/chaincode.jar"]
