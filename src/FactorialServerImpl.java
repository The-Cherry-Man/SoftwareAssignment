import io.grpc.MethodDescriptor;

import java.util.ArrayList;
import java.util.List;

public class FactorialServerImpl extends UserNetworkBoundaryServiceGrpc.UserNetworkBoundaryServiceImplBase{

  private final UserNetworkBoundaryAPI unbapi;

  public  FactorialServerImpl(UserNetworkBoundaryAPI unba) {

    unbapi = unba;

  }

  /**
   * <pre>
   * Takes in user number Data
   * </pre>
   */
  @Override
  public void userNumberInput(API1.UserNumber request, io.grpc.stub.StreamObserver<API1.ConfigKey> responseObserver) {

    //io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUserNumberInputMethod(), responseObserver);

    API1.ConfigKey  configKey = null;

    try {

      UserNumber userNumber;

      if (request.hasUserNumberInt()) {

        userNumber = new UserNumberInt(request.getUserNumberInt());

      } else if (request.getInMemoryUserNumberCount()>0) {

        List<Integer> inputData = request.getInMemoryUserNumberList();

        userNumber = new InMemoryUserNumber(inputData);

      } else if (request.hasFileUserNumber()) {

        String fileName = request.getFileUserNumber();

        userNumber = new FileUserNumber(fileName);

      } else {

        throw new IllegalArgumentException("Invalid user number input");
      }


      ConfigKey useredNumberInput = unbapi.userNumberInput(userNumber);

      configKey = API1.ConfigKey.newBuilder().setKey(useredNumberInput.getkey()).build();

    }catch (Exception e){

      configKey = API1.ConfigKey.newBuilder().setErrorMessage(e.getMessage()).build();

    }
    responseObserver.onNext(configKey);
    responseObserver.onCompleted();

  }

  /**
   * <pre>
   * Chooses the users Delimiter.
   * </pre>
   */
  @Override
  public void delimiterOutput(API1.Delimeter request, io.grpc.stub.StreamObserver<API1.ConfigKey> responseObserver) {

    //io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelimiterOutputMethod(), responseObserver);

    API1.ConfigKey configKey = null;

    try{

      ConfigKey delimeterOuput = unbapi.delimeterOuput(new Delimeter(request.getChosenDelimeter()));

      configKey = API1.ConfigKey.newBuilder().setKey(delimeterOuput.getkey()).build();

    }catch (Exception e){

      configKey = API1.ConfigKey.newBuilder().setErrorMessage(e.getMessage()).build();

    }

    responseObserver.onNext(configKey);
    responseObserver.onCompleted();

  }

  /**
   * <pre>
   * Sets the destination of the data results
   * </pre>
   */
  @Override
  public void destinationOutput(API1.Destinations request, io.grpc.stub.StreamObserver<API1.ConfigKey> responseObserver) {

    //io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDestinationOutputMethod(), responseObserver);

    API1.ConfigKey configKey = null;

    try{

      ConfigKey destinationOutput = unbapi.destinationOutput(new Destinations(request.getUserDestination()));

      configKey = API1.ConfigKey.newBuilder().setKey(destinationOutput.getkey()).build();

    }catch(Exception e){

      configKey = API1.ConfigKey.newBuilder().setErrorMessage(e.getMessage()).build();

    }

    responseObserver.onNext(configKey);
    responseObserver.onCompleted();
  }

  /**
   * <pre>
   * Compute results
   * </pre>
   */
  @Override
  public void compute(API1.ConfigKeyCollection request, io.grpc.stub.StreamObserver<API1.Result> responseObserver) {

    // io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeMethod(), responseObserver);

    API1.Result result = null;

    ConfigKeyCollection c = new ConfigKeyCollection();

    List<ConfigKey> l = new ArrayList<>();

    try {

      for(int i = 0; i < request.getListOfKeysList().size() ; ++i){

        c.addKey(new ConfigKey(request.getListOfKeys(i).getKey()));

      }

      Result compute = unbapi.compute(c);

      API1.Result.Builder builder = API1.Result.newBuilder();

      if(compute.getErrorMessageResult() != null){
        builder.setErrorMessage(compute.getErrorMessageResult());
      }
      result = builder.build();

    }catch (Exception e){

      result = API1.Result.newBuilder().setErrorMessage(e.getMessage()).build();

    }

    responseObserver.onNext(result);
    responseObserver.onCompleted();
  }

}