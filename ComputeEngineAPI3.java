import java.math.BigInteger;
public interface ComputeEngineAPI3 {


  public BigInteger computation(Integer i){
    BigInteger firstResult = factorialResult(i);

    BigInteger secondResult = factorialProduct(firstResult);

    return secondResult;
  }
  static BigInteger factorialResult(int input) {
      //Calculates factorial
      BigInteger number = new BigInteger("1");
      for(int i = 1; i <= input; i++) {
          number = number.multiply(BigInteger.valueOf(i));
      }
      return number;
  }
  static BigInteger factorialProduct(BigInteger factorial) {
      //Finds product of digits of factorial
      BigInteger product = BigInteger.ONE;
      for (int i = 0; i < factorial.toString().length(); i++) {
          int digit = factorial.toString().charAt(i) - '0';
          if(digit == 0){
            continue;
          }
          else{
              product = product.multiply(BigInteger.valueOf(digit));
          }
      }
      return product;
  }

}
