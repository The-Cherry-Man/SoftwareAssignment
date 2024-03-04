import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class InMemoryDataStoreTest implements DataStorageComputeAPI2{

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

    @Override
    public List<Integer> read(UserNumber n) throws FileNotFoundException {
        List<Integer> l= ((InMemoryUserNumberTest) n).getInput();
        return l;
    }

    @Override
    public Response write(BigInteger n, Delimeter d, Destinations e) throws IOException {
        List<String> s = ((InMemoryDestinationTest)e).getList();
        s.add(n.toString());
        s.add(d.toString());
        return new Response(true);
    }
}
