import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.standard.Destination;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ComputeEngineIntegrationTest {

    public ComputeEngineIntegrationTest(){
        
    }

    @Test
    public void integrationTest() throws IOException, ExecutionException, InterruptedException {

        InMemoryDataStoreTest imds = new InMemoryDataStoreTest();
        List<Integer> n =  imds.getInput();

        InMemoryUserNumberTest imun = new InMemoryUserNumberTest();

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
        dpba.read(imun);

        unba.compute(collection);

        List list = imd.getList();



        Assert.assertEquals(6, list.size());




    }
    



}
