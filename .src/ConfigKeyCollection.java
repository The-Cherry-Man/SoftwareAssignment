import java.util.ArrayList;
import java.util.List;

public class ConfigKeyCollection {

    List<ConfigKey> ListOfKeys = new ArrayList<>();

    public ConfigKeyCollection(){

    }

    public ConfigKeyCollection(ConfigKey c){

        addKey(c);
    }

    public List<ConfigKey> getListOfKeys(){

        return ListOfKeys;

    }
    public void addKey(ConfigKey c){

        ListOfKeys.add(c);

    }

}
