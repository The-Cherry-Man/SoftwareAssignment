import java.math.BigInteger;
import java.util.List;

public class DatastoreServerImpl extends DataStorageComputeServiceGrpc.DataStorageComputeServiceImplBase{

    private  final DataProcessBoundaryAPI dpbapi;

    public DatastoreServerImpl(){

        dpbapi = new DataProcessBoundaryAPI();

    }

    /**
     * <pre>
     *Takes in user's input
     * </pre>
     */
    @Override
    public void read(API1.UserNumber request,io.grpc.stub.StreamObserver<API2.IntegerList> responseObserver) {

        //io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);

        API2.IntegerList integerList = null;

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

            List<Integer> resultList =  dpbapi.read(userNumber);

            integerList = API2.IntegerList.newBuilder().addAllValues(resultList).build();

        }catch(Exception e) {

            integerList = API2.IntegerList.newBuilder().setErrorMessage(e.getMessage()).build();

        }

        responseObserver.onNext(integerList);
        responseObserver.onCompleted();

    }

    /**
     * <pre>
     *Writes to user's destination
     * </pre>
     */
    @Override
    public void write(API2.WriteParameters request, io.grpc.stub.StreamObserver<API2.Response> responseObserver) {

        //io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteMethod(), responseObserver);

        API2.Response response = null;

        try {

            Delimeter d = new Delimeter((request.getChosenDelimeter().getChosenDelimeter()));

            Destinations d2 = new Destinations(request.getUserDestination().getUserDestination());

            BigInteger bi = new BigInteger(String.valueOf(request.getInt64()));

            Response write = dpbapi.write(bi, d, d2);

            response = API2.Response.newBuilder().setErrorMessage(write.getErrorMessage()).build();

        }catch(Exception e) {

            response = API2.Response.newBuilder().setErrorMessage(e.getMessage()).build();

        }

          responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

}



