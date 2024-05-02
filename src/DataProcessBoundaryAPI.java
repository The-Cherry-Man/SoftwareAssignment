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

        } else if (n instanceof UserNumberInt){
            
            List<Integer> l = new ArrayList<>();

            l.add(((UserNumberInt) n).getUsernumber());

            return l;

        } else{

            return null;
        }
    }

    private List<Integer> loadIntegersFromFile(String fileName) throws FileNotFoundException {

        List<Integer> userlist = new ArrayList<>();

        Scanner userfile = new Scanner(new File(fileName)).useDelimiter(",\\s*");
        
        ArrayList<Integer> a = new ArrayList<>();

        while (userfile.hasNextInt()) {
            
            int number = userfile.nextInt();

            userlist.add(number);
        }
        
        return userlist;
    }

    @Override
    public Response write(BigInteger n, Delimeter d, Destinations e) throws IOException {

        Response r = new Response();

        try {
            FileWriter fileWriter = new FileWriter(e.getDestination());

            fileWriter.write(String.valueOf(n));

            fileWriter.write(d.getDelimeter());

            fileWriter.close();
        }
        catch (Exception a){

            if(a.getMessage().isEmpty()){

                r.setErrorMessage(a.getClass().getName());
                r.setResult(true);

            }else{

                r.setErrorMessage(a.getMessage());
                r.setResult(false);

            }
        }
        return r;

    }


}
