import java.util.ArrayList;
import java.util.List;

public class InMemoryDestinationTest extends Destinations {

    public InMemoryDestinationTest(){
        
    }
    
    List<String> output = new ArrayList<>();
    public List getList(){
        return this.output;
    }

}
