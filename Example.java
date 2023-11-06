import java.util.*;
class ExceptionDemo
  {
    Scanner sc=new Scanner(System.in);
    int a,b,c;
    ExceptionDemo()
    {
      a=0;
      b=0;
      c=0;
    }
    void division()
    {
       try
       {
        System.out.println("enter a,b values");
        a=sc.nextInt();
        b=sc.nextInt();
            c=a/b;
        System.out.println("the result is: "+c);
        }
    
    catch(Exception e)
  {
    System.out.println("divide by zero exception");
    System.out.println("error is "+e);
    System.out.println("error is "+e.getMessage());
  }
finally
  {
    System.out.println("this is finally block")
;  }
    }
  }
class Example
  {
    public static void main(String args[])
    {
      ExceptionDemo ed=new ExceptionDemo();
      ed.division();
    }
  }