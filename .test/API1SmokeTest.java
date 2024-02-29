import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

public class API1SmokeTest {

    public API1SmokeTest(){


    }

    @Test
    public void userInputTest(){

        FileUserNumber n = new FileUserNumber();

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey userdNumberInput = unba.userNumberInput(n);

        Assert.assertNotNull(userdNumberInput);
    }

    @Test
    public void delimeterTest(){

        Delimeter d = new Delimeter('/');

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey configKey = unba.delimeterOuput(d);

        Assert.assertNotNull(configKey);
    }

    @Test
    public void destinationTest(){

        Destination s = new Destination();

        s.setDestination("destination");

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey destinationOutput = unba.destinationOutput(s);

        Assert.assertNotNull(destinationOutput);
    }

    @Test
    public void computeTest() throws IOException {

        ConfigKeyCollection c = new ConfigKeyCollection();

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        Result compute1 = unba.compute(c);

        Assert.assertNotNull(compute1);
    }
}

