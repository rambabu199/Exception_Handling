

/*[16:07] Karunakar Eeede

You are tasked with developing a Reservation System program in Java for a theater. The program will allow users to make reservations for seats. The theater has a fixed number of rows and columns of seats, and each seat can be either available or reserved.

Your program should perform the following tasks using custom exceptions:

Create a grid representing the theater with available and reserved seats.
Implement a custom exception called SeatUnavailableException which is thrown when a user tries to reserve an already reserved seat.
Allow users to input the row and column numbers of the seat they want to reserve.
If the seat is unavailable, throw the SeatUnavailableException.
Display the updated theater grid after each reservation.

Write a Java program that implements the above scenario using custom exceptions, arrays, and user input.*/
import java.util.Scanner;
class SeatUnavailableException extends Exception {
  public SeatUnavailableException(String msg) {
    super(msg);
  }
}

class Theater {
  int col, row;
  int arr[][];
 

  Theater(int row, int col) {

    this.row = row;
    this.col = col;
    arr= new int[row][col];
  }

  public void data() {
    Scanner sc = new Scanner(System.in);

    System.out.println("enter data for theater(0/1)");
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
  }

  public void reserve() throws SeatUnavailableException {
    Scanner sc = new Scanner(System.in);
    System.out.println("select the row number and seat number to reserve");
    int r = sc.nextInt();
    int c = sc.nextInt();
    if (arr[r][c] == 0) {
      throw new SeatUnavailableException("seat not avilable Exception ");
    } else {
      System.out.println("seat reserved successfully");
      arr[r][c] = 0;
    }
  }
}

class Movie {
  public static void main(String args[]) {
    char ch;
   Scanner sc = new Scanner(System.in);
    
      
      System.out.println("enter row size of the theater");
      int row = sc.nextInt();
      System.out.println("enter column size of the theater");
      int col = sc.nextInt();
      // int arr[][] = new int[row][col];
      Theater t = new Theater(row,col);
     t.data();
       do{
         try {
     
      t.reserve();
    } catch (SeatUnavailableException s) {
      System.out.println("Error is: " + s.getMessage());
    }
      System.out.println("do you want to book anothor seat");
      ch=sc.next().charAt(0);
    }while(ch!='n');
  }
}