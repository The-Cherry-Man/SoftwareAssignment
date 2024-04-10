import java.util.ArrayList;
import java.util.List;

public class InMemoryUserNumber implements UserNumber{

    private List<Integer> inputData;

    public InMemoryUserNumber(){

        inputData = new ArrayList<>();
    }
    
    public InMemoryUserNumber(int i){
        
        this.inputData.add(i);
        
    }

    public List<Integer> getInputData(){

        return inputData;

    }

    public void setInMemoryUserNumber(int i) {
        
        this.inputData.add(i);
        
    }
}
