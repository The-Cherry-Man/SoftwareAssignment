import org.junit.Assert;
import org.junit.Test;
import javax.print.attribute.standard.Destination;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ComputeEngineIntegrationTest {

    public ComputeEngineIntegrationTest(){



    }

    @Test
    public void integrationTest() throws IOException {

        InMemoryDataStoreTest imds = new InMemoryDataStoreTest();
        List<Integer> n =  imds.getInput();

        InMemoryUserNumberTest imun = new InMemoryUserNumberTest();
        imun.getInput();

        Delimeter d = new Delimeter('/');

        List<String> x = imds.getOutput();  //Should it be List<String>?
        ConfigKey c = new ConfigKey(1);

        UserNetworkBoundaryAPI unba = new UserNetworkBoundaryAPI();
        unba.userNumberInput((UserNumber) imun);
        unba.delimeterOuput(d);
        Destinations des = new Destinations();
        des.setDestination(x.get(0));
        unba.destinationOutput(des);
        //unba.configKeyCollection(c);

        ConfigKeyCollection collection = new ConfigKeyCollection();
        collection.addKey(c);

        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        dpba.read((UserNumber)imun);

        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();
        int i = 5;

        dpba.write(ccba.computation(i), d, des);

        Assert.assertNotNull(x);

    }

}
