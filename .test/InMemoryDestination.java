import java.util.List;

public class InMemoryDestination {

    public InMemoryDestination(){
        
    }
    
    List<String> output = new ArrayList<>();
    public List getList(){
        return this.output;
    }

}
