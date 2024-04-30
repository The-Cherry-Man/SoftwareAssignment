public class Response {
    boolean result = true;

    String errorMessageResponse;

    public Response(){

    }
    public Response(boolean b){
        this.result = b;
    }
    public boolean getResponse(){
        return result;
    }
    public String getErrorMessage(){

        return errorMessageResponse;
    }

    public void setErrorMessage(String s){

        this.errorMessageResponse = s;
    }
    public void setResult(boolean b){
        this.result = b;

    }

}
