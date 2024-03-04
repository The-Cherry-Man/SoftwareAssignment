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

        UserNetworkBoundaryAPI unba = new UserNetworkBoundaryAPI(imds, new ComputeConceptualBoundaryAPI());
        ConfigKey configKey = unba.userNumberInput((UserNumber) imun);
        ConfigKey configKey1 = unba.delimeterOuput(d);
        InMemoryDestinationTest imd = new InMemoryDestinationTest();
        ConfigKey configKey2 = unba.destinationOutput(imd);
        //unba.configKeyCollection(c);

        ConfigKeyCollection collection = new ConfigKeyCollection();
        collection.addKey(configKey);
        collection.addKey(configKey1);
        collection.addKey(configKey2);

        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        dpba.read((UserNumber)imun);

        unba.compute(collection);

        List list = imd.getList();



        Assert.assertEquals(6, list.size());




    }
    



}
