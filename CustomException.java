class MyException extends Exception
  {
    public MyException(String message)
    {
      super(message);
    }
  }
class Bank
  {
    double bal;
    public Bank(double amount)
    {
      this.bal=amount;
    }
    public void withdraw(double amount) throws MyException
    {
      if(amount>bal)
      {
        throw new MyException("Insufficient Balance in your account to with draw");
      }
      bal=bal-amount;
      System.out.println("withdrawls successfully: current balance: "+bal);
    }
  }
class CustomException
  {
    public static void main(String args[])
    {
      Bank b=new Bank(1000.00);
      try{
        b.withdraw(1500);
      }
      catch(MyException m)
        {
          System.out.println("error :"+m.getMessage());
        }
    }
  }