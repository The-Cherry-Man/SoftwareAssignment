import junit.framework.Assert;

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

        int FileLength;

        List<Integer> userlist = new ArrayList<>();

        Scanner Userfile = new Scanner(new File(fileName));

        FileLength = Userfile.nextInt();

        for(int i =0; i<FileLength; ++i){

            userlist.add(i,Userfile.nextInt());
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
