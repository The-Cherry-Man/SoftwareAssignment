import junit.framework.Assert;
import org.junit.Test;

public class API1_Smoke_Test {

    public API1_Smoke_Test(){


    }

    @Test
    public void userinputTest(){

        Usernumber n = new Usernumber();

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey userdNumberInput = unba.UserNumberInput(Usernumber);

        Assert.assertNotNull(userdNumberInput);
    }

    @Test
    public void delimterTest(){

        Delimeter d = new Delimeter('/');

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey configKey = unba.DelimeterOuput(d);

        Assert.assertNotNull(configKey);
    }

    @Test
    public void destinationTest(){

        Destination s = new Destination();

        s.setDestination("destination");

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey destinationOutput = unba.DestinationOutput(s);

        Assert.assertNotNull(destinationOutput);
    }

    @Test
    public void computeTest(){

        Collections.

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        Result compute1 = unba.Compute(c);

        Assert.assertNotNull(compute1);
    }
}

