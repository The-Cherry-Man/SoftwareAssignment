import java.util.List;

public class InMemoryDataStore {

    public InMemoryDataStore(){

    }
    
    public List<Integer> getInput(){
        InMemoryUserNumber imun = new InMemoryUserNumber();
        List<Integer> l = imun.getList();
        return l;
    }
    public List<String> getOutput(){
        InMemoryDestination imd = new InMemoryDestination();
        List<String> s = imd.getList();
        return s;
    }
}
