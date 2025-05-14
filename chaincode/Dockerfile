# Dockerfile for Chaincode-as-a-Service
FROM eclipse-temurin:11-jre

WORKDIR /opt/chaincode

# Copy the chaincode JAR directly into Docker
COPY ./target/chaincode.jar /opt/chaincode/chaincode.jar

# Copy the certificates directly into the Docker image
COPY /home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/ca.crt /etc/hyperledger/fabric/tls/ca.crt
COPY /home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/server.crt /etc/hyperledger/fabric/tls/server.crt
COPY /home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/server.key /etc/hyperledger/fabric/tls/server.key

# Expose the gRPC port
EXPOSE 9999

# Command to start the chaincode
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-DCHAINCODE_SERVER_ADDRESS=0.0.0.0:9999", "-jar", "/opt/chaincode/chaincode.jar"]
