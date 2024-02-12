import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.standard.Destination;

public class ComputeEngineIntegrationTest {

    public ComputeEngineIntegrationTest(){
        
    }
    
    @Test
    public void integrationTest() {

        InMemoryDataStore imds = new InMemoryDataStore();
        UserNumber n = imds.getInput();
        DelimeterOutput d = '/';
        Destination x = imds.getOutput();  //Should it be List<String>?
        ConfigKey c = 1000;

        UserNetworkBoundaryAPI unba = new UserNetworkBoundaryAPI();
        unba.UserNumberInput(n);
        unba.DelimeterOutput(d);
        unba.DestinationOutput(x);
        unba.ConfigKeyCollection(c);

        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        dpba.read(n);
        dpba.write(n, d, c);

        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();
        int i = 5;
        ccba.input(i);

        Assert.assertNotNull(x);




    }


}
