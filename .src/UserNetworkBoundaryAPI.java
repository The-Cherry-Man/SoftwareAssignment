import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

public class UserNetworkBoundaryAPI implements UserComputeAPI1 {

        private DataStorageComputeAPI2 api2;

        private ComputeConceptualBoundaryAPI api3;

        Map<ConfigKey,Delimeter> delmeterMap =  new HashMap<>();

        Map<ConfigKey,Destinations> destinationMap =  new HashMap<>();

        Map<ConfigKey,UserNumber> usernumberMap =  new HashMap<>();

        ConfigKeyCollection collection = new ConfigKeyCollection();

        ExecutorService executor = Executors.newFixedThreadPool(7);

        public UserNetworkBoundaryAPI(DataStorageComputeAPI2 api2, ComputeConceptualBoundaryAPI api3) {

            this.api2 = api2;

            this.api3 = api3;

         }

    public UserNetworkBoundaryAPI() {

    }

    @Override
    public ConfigKey userNumberInput(UserNumber usernumber) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        usernumberMap.put(key,usernumber);

        return key;

    }

    @Override
    public ConfigKey delimeterOuput(Delimeter del) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        delmeterMap.put(key,del);

        return key;
    }

    @Override
    public ConfigKey destinationOutput(Destinations des) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        destinationMap.put(key,des);

        return key;
    }

    @Override
    public Result compute(ConfigKeyCollection c) throws IOException, ExecutionException, InterruptedException {// read --> computation --> write

        List<ConfigKey> keys = c.getListOfKeys();

        Result r = new Result();

        Destinations destination = null;

        Delimeter delimeter = null;

        UserNumber o = null;

        for (ConfigKey key : keys) {

            if (destinationMap.containsKey(key)) {

                destination = destinationMap.get(key);

            }
            if (delmeterMap.containsKey(key)) {

                delimeter = delmeterMap.get(key);

            }
            if (usernumberMap.containsKey(key)) {

                o = usernumberMap.get(key);

            }

        }

        BigInteger computationAnswer;

        List<Integer> read = api2.read(o);

        List<Future<BigInteger>> futures = new ArrayList<>();
    

        for (int i = 0; i < read.size(); ++i) {


            int computationValue =  read.get(i);

            Callable<BigInteger> compute = () -> {


                return api3.computation(computationValue);

            };

            Future<BigInteger> submit = executor.submit(compute);

            futures.add(submit);
        }

    for (int i = 0; i < futures.size(); ++i) {


        BigInteger bigInteger = futures.get(i).get();

        api2.write(bigInteger, delimeter, destination);

    }
      

  

        return r;
    }
}
