import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class API2SmokeTest {
    @Test
    public void readTest(){
        UserNumber k = 5;
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k);
        Assert.assertNotNull(read);
    }
    @Test
    public void writeTest() {
        UserNumber k = 5;
        DelimeterOutput d = '/';
        ConfigKey c = 1000;
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k, d, c);
        Assert.assertNotNull(read);
    }

}
