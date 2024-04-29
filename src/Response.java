public class Response {
    boolean result = true;

    String ErrorMessage;

    public Response(){

    }
    public void setErrorMessage(String s){

        this.ErrorMessage = s;

    }
    public Response(boolean b){

        this.result = b;

    }
    public boolean getResponse(){

        return result;

    }
    public void setResult(boolean result){

        this.result = result;
    }
    public String getErrorMessage(){

        return ErrorMessage;
    }

}
