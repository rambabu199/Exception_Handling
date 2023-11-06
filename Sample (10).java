class throwdemo
{
   public static void main(String args[]) 
    {
           try
            {
           ArithmeticException  e= new ArithmeticException("Hello, Exception Occured");
                throw e;

 

              // throw  new ArithmeticException("Hello, Exception Occured");
            } 
            catch(ArithmeticException ae)
            {
                 System.out.println("The Exception is:"+ae.getMessage());
            }
     }
}