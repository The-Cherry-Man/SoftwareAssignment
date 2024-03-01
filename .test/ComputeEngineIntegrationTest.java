import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.standard.Destination;
import java.io.FileNotFoundException;
import java.util.List;

public class ComputeEngineIntegrationTest {

    public ComputeEngineIntegrationTest(){
        
    }

    @Test
    public void integrationTest() throws FileNotFoundException {

        InMemoryDataStoreTest imds = new InMemoryDataStoreTest();
        InMemoryUserNumberTest n = (InMemoryUserNumberTest) imds.getInput();

        Delimeter d = new Delimeter('/');

        List<String> x = imds.getOutput();  //Should it be List<String>?
        ConfigKey c = new ConfigKey(1);

        UserNetworkBoundaryAPI unba = new UserNetworkBoundaryAPI();
        unba.userNumberInput((UserNumber) n);
        unba.delimeterOuput(d);
        unba.destinationOutput(x);
        unba.configKeyCollection(c);

        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        dpba.read((UserNumber) n);
        dpba.write(n, d, c);

        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();
        int i = 5;
        ccba.computation(i);

        Assert.assertNotNull(x);




    }
    



}
