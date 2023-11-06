import java.util.*;

class PrimeNotFoundException extends Exception {
  public PrimeNotFoundException(String message) {
    super(message);
  }
}
class Demo
  {
    void isPrime(int n) throws PrimeNotFoundException
    {
      int count = 0;
      for (int i = 1; i <= n; i++) {
        if (n % i == 0)
          count++;
      }

      if (count == 2) {
        System.out.println(n + " is prime number");
      } else {
        throw new PrimeNotFoundException("prime number not found exception");
      }
    }
  }

class PrimeNotFounExceptionMain {
  public static void main(String args[]) {
    try {
      Scanner sc = new Scanner(System.in);
      System.out.println("enter a number");
      int n = sc.nextInt();
      Demo d=new Demo();
      d.isPrime(n);
      
    } catch (PrimeNotFoundException p) {
      System.out.println("error is: " + p.getMessage());
    }
  }
}