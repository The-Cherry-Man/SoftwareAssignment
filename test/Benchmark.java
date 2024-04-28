import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Benchmark {

    @Test
    public void computeSpeedTest() {
        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();

        UpdatedCCBAPI uccba = new UpdatedCCBAPI();

        BigInteger original = ccba.computation(5);

        BigInteger updated = uccba.computation(5);

        //Assert.assertEquals(BigInteger.valueOf(), );
    }
}
