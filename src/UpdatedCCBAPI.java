import java.math.BigInteger;
public class UpdatedCCBAPI extends Thread implements ComputeEngineAPI3{

    private Integer numberInput;
    private BigInteger result;

    public UpdatedCCBAPI() {

    }
    public void setInteger(Integer i) {
        this.numberInput = i;
    }

    public BigInteger getCompAnswer() {
        return result;
    }

    @Override
    public BigInteger computation(Integer i) {
        BigInteger factorial = factorialResult(i);
        return factorialProduct(factorial);
    }

    public BigInteger factorialResult(int input) {
        //Calculates factorial
        BigInteger number = BigInteger.ONE;
        for(int i = 2; i <= input; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        return number;
    }
    public BigInteger factorialProduct(BigInteger factorial) {
        //Finds product of digits of factorial
        BigInteger product = BigInteger.ONE;
        while(!factorial.equals(BigInteger.ZERO)) {
            BigInteger[] divideAndRemainder = factorial.divideAndRemainder(BigInteger.TEN);
            BigInteger digit = divideAndRemainder[1];
            if(!digit.equals(BigInteger.ZERO)) {
                product = product.multiply(digit);
            }
            factorial = divideAndRemainder[0];
        }
        return product;
    }
}
