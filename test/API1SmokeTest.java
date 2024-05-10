import junit.framework.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class API1SmokeTest {

    public API1SmokeTest(){


    }

    @Test
    public void userInputTest(){

        FileUserNumber n = new FileUserNumber();

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI(new DataProcessBoundaryAPI(),new ComputeConceptualBoundaryAPI());

        ConfigKey userdNumberInput = unba.userNumberInput(n);

        Assert.assertNotNull(userdNumberInput);
    }

    @Test
    public void delimeterTest(){

        Delimeter d = new Delimeter('/');

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI(new DataProcessBoundaryAPI(),new ComputeConceptualBoundaryAPI());

        ConfigKey configKey = unba.delimeterOuput(d);

        Assert.assertNotNull(configKey);
    }

    @Test
    public void destinationTest(){

        Destinations s = new Destinations();

        s.setDestination("destination");

        UserNetworkBoundaryAPI unba = new  UserNetworkBoundaryAPI(new DataProcessBoundaryAPI(),new ComputeConceptualBoundaryAPI());

        ConfigKey destinationOutput = unba.destinationOutput(s);

        Assert.assertNotNull(destinationOutput);
    }

    @Test
    public void computeTest() throws IOException, ExecutionException, InterruptedException {

        
        UserNetworkBoundaryAPI unba = new UserNetworkBoundaryAPI(new DataProcessBoundaryAPI(), new ComputeConceptualBoundaryAPI());


        ConfigKeyCollection c = new ConfigKeyCollection();


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

