import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

public class Client { // Boilerplate TODO: change to <servicename>Client
    private final DataStorageComputeServiceGrpc.DataStorageComputeServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public Client(Channel channel) {
        blockingStub = DataStorageComputeServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public void compute(int i,String d, String a) {//create instance of each



        API2.BigInteger h = API2.BigInteger.newBuilder().setValue(i).build();

        API2.WriteParameters request = API2.WriteParameters.newBuilder().setChosenDelimeter(API1.Delimeter.newBuilder().setChosenDelimeter(d))
                .setUserDestination(API1.Destinations.newBuilder().setUserDestination(a)).setInt64(h).build();

        API2.Response response;

        try {
            response = blockingStub.write(request);
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }
        if (response.hasErrorMessage()) {
            System.err.println("ther was an Error: " + response.getErrorMessage());
        } else {
            System.out.println("Order number: " + response);//need to add . to response later
        }
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50052";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        System.out.println("Succes");

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            Client client = new Client(channel); // Boilerplate TODO: update to this class name

            client.compute(Integer.parseInt(args[0]),args[1],args[2]);

        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}