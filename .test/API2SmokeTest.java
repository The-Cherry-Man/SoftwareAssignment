import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.util.List;

public class API2SmokeTest {

    public API2SmokeTest(){
        
    }
    
    @Test
    public void readTest() throws FileNotFoundException {
        UserNumber k = 5;
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k);
        Assert.assertNotNull(read);
    }
    @Test
    public void writeTest() throws FileNotFoundException {
        UserNumber k = 5;
        DelimeterOutput d = '/';
        ConfigKey c = 1000;
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k);
        Assert.assertNotNull(read);
    }

}
