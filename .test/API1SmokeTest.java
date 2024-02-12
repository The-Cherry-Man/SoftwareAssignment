import junit.framework.Assert;
import org.junit.Test;

public class API1SmokeTest {

    public API1SmokeTest(){
        
    }

    
    @Test
    public void UserInputTest(){

        UserNumber k = 13;

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey useredNumberInput = unba.UserNumberInput(k);

        Assert.assertNotNull(useredNumberInput);
    }

    @Test
    public void DelimterTest(){

        Delimeter d = '/';

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey configKey = UNBA.DelimeterOuput(d);

        Assert.assertNotNull(configKey);
    }

    @Test
    public void DestinationTest(){

        Destination s = "destination";

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey destinationOutput = unba.DestinationOutput(s);

        Assert.assertNotNull(destinationOutput);
    }

    @Test
    public void Computetest(){

        List<Integer> list = new Arraylist<>();

        ConfigKeyCollection c = list;

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        Result compute1 = UNBA.Compute(c);

        Assert.assertNotNull(compute1);
    }
}
