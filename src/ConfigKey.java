import java.util.Objects;

public class ConfigKey {

    private static int ConfigKey = 1;

    private int key;

    public ConfigKey(int i){

        key = i;

    }

    public  ConfigKey(){

        this.key = ConfigKey;

        ConfigKey++;

    }
    public int getkey(){

        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){

            return true;
        }

        if (o == null || getClass() != o.getClass()){

            return false;
        }
        ConfigKey configKey = (ConfigKey) o;
        return key == configKey.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}