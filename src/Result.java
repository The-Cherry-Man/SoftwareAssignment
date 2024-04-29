public class Result {

  boolean ResultTrueFlase = true;

  String errorMessageResult;

  public Result(){
    
  }

  public void setResultTrueFlase(boolean b){

    this.ResultTrueFlase = b;

  }
  public void setErrorMessageResult(String s){

    this.errorMessageResult = s;

  }
  public String getErrorMessageResult(){


    return errorMessageResult;
  }
  public boolean getResultTrueFlase(){

    return ResultTrueFlase;

  }

}
