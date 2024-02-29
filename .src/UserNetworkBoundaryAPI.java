import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserNetworkBoundaryAPI implements UserComputeAPI1{

        private DataProcessBoundaryAPI api2;

        private ComputeConceptualBoundaryAPI api3;

        Map<ConfigKey,Delimeter> delmeterMap =  new HashMap<>();

        Map<ConfigKey,Destination> destinationMap =  new HashMap<>();

        Map<ConfigKey,UserNumber> usernumberMap =  new HashMap<>();

        ConfigKeyCollection collection = new ConfigKeyCollection();

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
    public ConfigKey destinationOutput(Destination des) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        destinationMap.put(key,des);

        return key;
    }

    @Override
    public Result compute(ConfigKeyCollection c) throws IOException {// read --> computation --> write

        List<ConfigKey> keys = c.getListOfKeys();

        Result r = new Result();

        Destination destination = null;

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

        for(int i = 0; i < read.size(); ++i){

            computationAnswer = api3.computation(read.get(i));

            api2.write(computationAnswer,delimeter,destination);
        }
        
        return r;
    }
}
