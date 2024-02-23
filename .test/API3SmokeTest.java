import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class API3SmokeTest {

    public API3SmokeTest(){

    }

    @Test
    public void testInput(){

        int j = 5;

        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();

        BigInteger input = ccba.computation(j);

        Assert.assertNotNull(input);

    }

}
