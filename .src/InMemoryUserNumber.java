import java.util.List;

public class InMemoryUserNumber implements UserNumber{

    private List<Integer> inputData;

    public InMemoryUserNumber(){


    }

    public List<Integer> getInputData(){

        return inputData;

    }
}
