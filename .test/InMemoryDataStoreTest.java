import java.util.List;

public class InMemoryDataStoreTest {

    public InMemoryDataStoreTest(){

    }
    
    public List<Integer> getInput(){
        InMemoryUserNumberTest imun = new InMemoryUserNumberTest();
        List<Integer> l = imun.getList();
        return l;
    }
    public List<String> getOutput(){
        InMemoryDestinationTest imd = new InMemoryDestinationTest();
        List<String> s = imd.getList();
        return s;
    }
}
