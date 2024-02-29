public class ConfigKey {

    private static int ConfigKey = 1;

    private int key;
    public ConfigKey(int i){

    }

    public  ConfigKey(){

        this.key = ConfigKey;

        ConfigKey++;

    }
    public int getkey(){

        return key;
    }

}
