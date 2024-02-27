import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class API1SmokeTest {

    public API1SmokeTest(){


    }

    @Test
    public void userInputTest(){

        FileUserNumber n = new FileUserNumber();

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI();

        ConfigKey userNumberInput = unba.userNumberInput(n);

        Assert.assertNotNull(userNumberInput);
    }

    @Test
    public void delimiterTest(){

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

