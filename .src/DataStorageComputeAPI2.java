import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public interface DataStorageComputeAPI2 {

    //Takes in user's input
    List<Integer> read(UserNumber n) throws FileNotFoundException;



    //Writes to user's destination
    Response write(BigInteger n, Delimeter d, Destination e) throws IOException;

}
