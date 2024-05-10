import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class API2SmokeTest {

    public API2SmokeTest(){
        
    }
    
    @Test
    public void readTest() throws FileNotFoundException {
        InMemoryUserNumber k = new InMemoryUserNumber();
        k.setInMemoryUserNumber(5);
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        List read = dpba.read(k);
        Assert.assertNotNull(read);
    }
    @Test
    public void writeTest() throws IOException {
        Delimeter d = new Delimeter();
        BigInteger k = new BigInteger(String.valueOf(5));
        Destinations c = new Destinations("text");
        d.setDelimeter(':');
        DataProcessBoundaryAPI dpba = new DataProcessBoundaryAPI();
        Response write = dpba.write(k, d, c);
        Assert.assertNotNull(write);
    }

}
