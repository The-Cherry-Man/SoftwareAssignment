import junit.framework.Assert;
import org.junit.Test;

public class API3SmokeTest {

    @Test
    public void testInput(){

        int j = 5;

        ComputeConceptualBoundaryAPI ccba = new ComputeConceptualBoundaryAPI();

        Integer input = ccba.input(j);

        Assert.assertNotNull(input);

    }

}
