import java.util.List;


public class InMemoryUserNumber {

    public InMemoryUserNumber(){
        
    }
    
    List<Integer> input = new ArrayList<>();

    public List<Integer> getInput() {
        input.add(1);
        input.add(10);
        input.add(25);
        return input;
    }
    public List getList(){
        return this.input;
    }
}
