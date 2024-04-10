public class FileUserNumber implements UserNumber{

    private String filename;

    public FileUserNumber(){


    }

    public FileUserNumber(String s){

        this.filename = s;
    }

    public String getFileName(){

        return filename;

    }

    public void setFileName(String s){

        this.filename = s;
    }
}
