import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.util.List;

public class API2SmokeTest {

    public API2SmokeTest(){
        
    }
    
    @Test
    public void readTest(){
        UserNumber k = 5;
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k);
        Assert.assertNotNull(read);
    }
    @Test
    public void writeTest() throws FileNotFoundException {
        Delimeter d = new Delimeter();
        UserNumberInt k = new UserNumberInt();
        ConfigKey c = new ConfigKey();
        k.setUserNumber(5);
        d.setDelimeter(':');
        c.setConfigKey(1);
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k, d, c);
        Assert.assertNotNull(read);
    }

}
