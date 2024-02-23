import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserNetworkBoundaryAPI implements UserComputeAPI1{

        private DataProcessBoundaryAPI api2;

        private ComputeConceptualBoundaryAPI api3;

        Map<ConfigKey,Delimeter> delmeterMap =  new HashMap<>();

        Map<ConfigKey,Destination> destinationMap =  new HashMap<>();

        Map<ConfigKey,Object> UsernumberMap =  new HashMap<>();

        ConfigKeyCollection collection = new ConfigKeyCollection();

        public UserNetworkBoundaryAPI() {

         }

    @Override
    public ConfigKey UserNumberInput(Object usernumber) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        UsernumberMap.put(key,usernumber);

        return key;

    }

    @Override
    public ConfigKey DelimeterOuput(Delimeter Del) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        delmeterMap.put(key,Del);

        return key;
    }

    @Override
    public ConfigKey DestinationOutput(Destination Des) {

        ConfigKey key = new ConfigKey();

        collection.addKey(key);

        destinationMap.put(key,Des);

        return key;
    }

    @Override
    public Result Compute(ConfigKeyCollection C) {// read --> computation --> write

         List<ConfigKey> Keys =  C.getListOfKeys();

            for(int i = 0; i <Keys.size(); ++i){

            Keys.contains(i);

        }

        //api2.read();
       //api3.computation();
        //tried to do but could not figure out.
    }
}
