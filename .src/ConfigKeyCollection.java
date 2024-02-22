import java.util.ArrayList;
import java.util.List;

public class ConfigKeyCollection {

    List<ConfigKey> listOfKeys = new ArrayList<>();

    public ConfigKeyCollection(){

    }

    public ConfigKeyCollection(ConfigKey c){

        addKey(c);
    }

    public List<ConfigKey> getListOfKeys(){

        return listOfKeys;

    }
    public void addKey(ConfigKey c){

        listOfKeys.add(c);

    }

}
