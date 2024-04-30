const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');


const MAINPROTO_PATH = 'main.proto';
const TESTPROTO_PATH = 'test.proto';
const packageDefinition = protoLoader.loadSync(MAINPROTO_PATH);
const myService = grpc.loadPackageDefinition(packageDefinition).MyService;


const client = new myService.MyService('localhost:50051', grpc.credentials.createInsecure());


function makeGrpcRequest() {
    client.someMethod({ /* Request parameters */ }, (error, response) => {
        if (error) {
            console.error('Error:', error);
        } else {
            console.log('Response:', response);
        }
    });
}

// Call the function to make the request
makeGrpcRequest();