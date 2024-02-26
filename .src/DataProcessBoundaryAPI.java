
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataProcessBoundaryAPI implements DataStorageComputeAPI2{

    public DataProcessBoundaryAPI(){

    }

    @Override//pass to data store
    public List<Integer> read(UserNumber n) throws FileNotFoundException {

        if (n instanceof InMemoryUserNumber) {

            return ((InMemoryUserNumber)n).getInputData();

        } else if (n instanceof FileUserNumber) {

            return loadIntegersFromFile(((FileUserNumber)n).getFileName());

        } else {
                return null;
        }
    }

    private List<Integer> loadIntegersFromFile(String fileName) throws FileNotFoundException {

        int fileLength;

        List<Integer> userlist = new ArrayList<>();

        Scanner userfile = new Scanner(new File(fileName));

        fileLength = userfile.nextInt();

        for(int i =0; i<fileLength; ++i){

            userlist.add(i,userfile.nextInt());
        }

        return userlist;
    }

    @Override
    public Response write(BigInteger n, Delimeter d, Destination e) throws IOException {

        Response r = new Response();

        FileWriter fileWriter = new FileWriter(e.getDestination());

            fileWriter.write(String.valueOf(n));

            fileWriter.write(d.getDelimeter());

            fileWriter.close();

        return r;

    }


}
