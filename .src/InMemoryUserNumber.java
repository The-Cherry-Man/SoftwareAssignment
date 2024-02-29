import java.util.List;

public class InMemoryUserNumber implements UserNumber{

    int chosenNumber;

    private List<Integer> inputData;

    public InMemoryUserNumber(){


    }
    public InMemoryUserNumber(int i){
        this.chosenNumber = i;

    }

    public List<Integer> getInputData(){

        return inputData;

    }

    public void setInMemoryUserNumber(int i) {
        this.chosenNumber = i;
    }
}
