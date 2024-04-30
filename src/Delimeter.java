public class Delimeter {

    char chosenDelimeter;

    String delimeterChosen;

    public Delimeter(){

    }

    public Delimeter(String s){

        this.delimeterChosen = s;
    }

    public Delimeter(char c){

        this.chosenDelimeter = c;
    }
    public String getDelimeterString(){

        return delimeterChosen;

    }

    public void setDelimeter(String h){

        this.delimeterChosen = h;

    }
    public char getDelimeter(){

        return chosenDelimeter;

    }

    public void setDelimeter(char h){

        this.chosenDelimeter = h;

    }

}
