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

        Destinations s = new Destinations();

        s.setDestination("destination");

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey destinationOutput = unba.destinationOutput(s);

        Assert.assertNotNull(destinationOutput);
    }

    @Test
    public void computeTest() throws IOException {

        ConfigKeyCollection c = new ConfigKeyCollection();

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey userNumberInput = unba.userNumberInput(new UserNumberInt(4));

        ConfigKey userDel = unba.delimeterOuput(new Delimeter('/'));

        ConfigKey userdestination = unba.destinationOutput(new Destinations("Test Destination"));

        c.addKey(userNumberInput);

        c.addKey(userDel);

        c.addKey(userdestination);

        Result compute = unba.compute(c);

        Assert.assertNotNull(compute);
    }
}

