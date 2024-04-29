import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Benchmark {

    public Benchmark(){

    }

    @Test
    public void computeSpeedTest() {
        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();

        UpdatedCCBAPI uccba = new UpdatedCCBAPI();

        LoggingStatistics stats = new LoggingStatistics();
        LoggingStatistics stats2 = new LoggingStatistics();

        ComputeEngineAPI3 original = TimingLoggingProxy.createProxy(new ComputeConceptualBoundaryAPI(),
                ComputeEngineAPI3.class, stats);

        ComputeEngineAPI3 updated = TimingLoggingProxy.createProxy(new UpdatedCCBAPI(),
                ComputeEngineAPI3.class, stats2);

        BigInteger slowComputation = original.computation(500);

        BigInteger fastComputation = updated.computation(500);

        stats.printStats();
        stats2.printStats();

        Assert.assertNotNull(slowComputation);
        //Assert.assertEquals(BigInteger.valueOf(2), slowComputation);
        //Assert.assertEquals(BigInteger.valueOf(2), fastComputation);

    }
}
