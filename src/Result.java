public class Result {

  boolean resultTrueFlase = true;

  String errorMessageResult;

  public Result(){
    
  }

  public void setResultTrueFlase(boolean b){

    this.resultTrueFlase = b;

  }
  public void setErrorMessageResult(String s){

    this.errorMessageResult = s;

  }
  public String getErrorMessageResult(){


    return errorMessageResult;
  }
  public boolean getResultTrueFlase(){

    return resultTrueFlase;

  }

}
