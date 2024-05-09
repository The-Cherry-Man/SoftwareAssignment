import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

public class Client { // Boilerplate TODO: change to <servicename>Client
    private final UserNetworkBoundaryServiceGrpc.UserNetworkBoundaryServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public Client(Channel channel) {
        blockingStub = UserNetworkBoundaryServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public void compute(int i,String d, String a) {//create instance of each


        API1.Delimeter del = API1.Delimeter.newBuilder().setChosenDelimeter(d).build();
        API1.UserNumber usr = API1.UserNumber.newBuilder().setUserNumberInt(i).build();
        API1.Destinations des = API1.Destinations.newBuilder().setUserDestination(a).build();

        API1.ConfigKey configKey = blockingStub.delimiterOutput(del);
        API1.ConfigKey configKey2 = blockingStub.userNumberInput(usr);
        API1.ConfigKey configKey3 = blockingStub.destinationOutput(des);

        API1.ConfigKeyCollection coll = API1.ConfigKeyCollection.newBuilder().addListOfKeys(configKey).addListOfKeys(configKey2).addListOfKeys(configKey3).build();

        API1.Result result;

        result = blockingStub.compute(coll);

        if (result.hasErrorMessage()) {
            System.err.println("ther was an Error: " + result.getErrorMessage());
        } else {
            System.out.println("Order number: " + result);//need to add . to response later
        }
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50053";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

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