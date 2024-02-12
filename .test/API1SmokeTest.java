import junit.framework.Assert;
import org.junit.Test;

public class API1SmokeTest {

    public API1SmokeTest(){
        
    }

    
    @Test
    public void UserinputTest(){

        UserNumber k = 13;

        UserNetworkBoundaryAPI UNBA = new  UserNetworkBoundaryAPI();

        ConfigKey useredNumberInput = UNBA.UserNumberInput(k);

        Assert.assertNotNull(useredNumberInput);
    }

    @Test
    public void DelimterTest(){

        Delimeter d = '/';

        UserNetworkBoundaryAPI UNBA = new  UserNetworkBoundaryAPI();

        ConfigKey configKey = UNBA.DelimeterOuput(d);

        Assert.assertNotNull(configKey);
    }

    @Test
    public void DestinationTest(){

        Destination s = "destination";

        UserNetworkBoundaryAPI UNBA = new  UserNetworkBoundaryAPI();

        ConfigKey destinationOutput = UNBA.DestinationOutput(s);

        Assert.assertNotNull(destinationOutput);
    }

    @Test
    public void Computetest(){

        List<Integer> list = new Arraylist<>();

        ConfigKeyCollection C = list;

        UserNetworkBoundaryAPI UNBA = new  UserNetworkBoundaryAPI();

        Result compute1 = UNBA.Compute(C);

        Assert.assertNotNull(compute1);
    }
}
