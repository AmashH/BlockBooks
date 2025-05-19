# Use Eclipse Temurin for Java 11
FROM eclipse-temurin:11-jre

# Set environment variables
ENV CORE_CHAINCODE_ID_NAME=ebooklicense_v15:1.0
ENV CORE_PEER_TLS_ENABLED=true
ENV CORE_PEER_ADDRESS=peer0.org1.example.com:7051
ENV CORE_PEER_LOCALMSPID=Org1MSP
ENV CORE_PEER_TLS_ROOTCERT_FILE=/etc/hyperledger/fabric/tls/ca.crt
ENV CORE_TLS_CLIENT_KEY_PATH=/etc/hyperledger/fabric/tls/server.key
ENV CORE_TLS_CLIENT_CERT_PATH=/etc/hyperledger/fabric/tls/server.crt

# Copy required certificates and chaincode
COPY fyp/BlockBooks/chaincode/target/chaincode.jar /opt/chaincode/chaincode.jar
#COPY fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls /etc/hyperledger/fabric/tls

#  Set permissions 
#RUN chmod 644 /etc/hyperledger/fabric/tls/ca.crt && \
#   chmod 644 /etc/hyperledger/fabric/tls/server.crt && \
#  chmod 644 /etc/hyperledger/fabric/tls/server.key


EXPOSE 9999

# Start the chaincode server
CMD ["java", "-Djava.net.preferIPv4Stack=true", "-DCHAINCODE_SERVER_ADDRESS=0.0.0.0:9999", "-jar", "/opt/chaincode/chaincode.jar"]




#    cd ~/fyp/BlockBooks/chaincode
#   docker build -t ebookcode_v15_ccaas -f Dockerfile /home/amash


