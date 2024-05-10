const grpc = require('grpc');
const grpcCredentials = grpc.credentials;
const timeUnit = require('timeunit'); 


const API1 = require('./API1'); 
const API2 = require('./API2'); 

class Client {
    constructor(channel) {
        this.blockingStub = new grpc.DataStorageComputeServiceGrpc.DataStorageComputeServiceBlockingStub(channel);
    }

    order() {
        const request = new API2.WriteParameters({
            chosenDelimeter: new API1.Delimeter(),
            userDestination: new API1.Destinations(),
            int64: new API2.BigInteger()
        });

        let response;
        try {
            response = this.blockingStub.write(request);
        } catch (e) {
            return;
        }
        if (response.getErrorMessage()) {
            console.error("Error: " + response.getErrorMessage());
        } else {
            console.log("Order number: " + response); 
        }
    }

    static async main() {
        const target = "localhost:50052";

        const channel = new grpc.Channel(target, grpcCredentials.createInsecure());
        try {
            const client = new Client(channel);
            client.order();
        } finally {
            await channel.shutdown().catch(console.error); 
        }
    }
}

Client.main().catch(console.error); 