import java.math.BigInteger;
import java.util.Scanner;

public class FactorialFunction {

    public static void main(String[] args) {
        // getting variables from console
        Scanner s = new Scanner(System.in);
        int m;
        int r;
        while (true) {
            System.out.print("Enter m: ");
            m = s.nextInt();
            System.out.print("Enter r: ");
            r = s.nextInt();
            if (r <= m) {
                break;
            }
            System.out.println("r must be equals or less to m");
        }

        System.out.println(getFactorial(m).divide(getFactorial(r).multiply(getFactorial(m-r))));
    }

    // Using BigInteger because for factorial more than 20, long variable is not enough
    private static BigInteger getFactorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

}
