/*Create a class named Book with the following attributes:
title (String)
author (String)
availableCopies (int)
Create a custom exception class named OutOfCopiesException that extends Exception. This exception should be thrown when a user tries to reserve a book but there are no available copies.
Create a class named Library which contains a list of Book objects. Implement the following methods:
addBook(Book book) to add a book to the library.
reserveBook(String title) to allow a user to reserve a book. If the book is not available, throw an OutOfCopiesException.
Create a class named User with the following attributes:
name (String)
reservedBooks (List of Book)
In your Main class, demonstrate the functionality of your library reservation system by adding books to the library, allowing users to reserve books, and handling the custom exception.*/
class OutOfCopiesException extends Exception
  {
    public OutOfCopiesException(String message)
    {
      super(message);
    }
  }
class Book
  {
    String title,author;
    int avilableCopies;
    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.avilableCopies = availableCopies;
    }
    public String getTitle()
    {
      return title;
    }
    public String getAuthor()
    {
      return author;
    }
    public int getAvilableCopies()
    {
      return avilableCopies;
    }
     public void reserve(String title) throws OutOfCopiesException
    {
      if(avilableCopies<0)
      {
        throw new OutOfCopiesException("this book copy is not avilable to reserve");
      }
      else
      {
        avilableCopies=avilableCopies-1;
        
      }
      
    }
   
  }
class Library
  {
    Book list[];
    int noofbooks;
    public Library(int n)
    {
      list=new Book[n];
      noofbooks=0;
    }
    void addBook(Book b)
    {
      if(noofbooks<list.length)
      {
        list[noofbooks]=b;
      }
    }  
    public void reserveBook(String title) throws OutOfCopiesException {
        for (int i = 0; i < noofbooks; i++) {
            if (list[i].getTitle().equals(title)) {
                list[i].reserve(title);
                return;
            }
        }
        throw new OutOfCopiesException("Book not found: " + title);
    }
    
  }
class User
  {
    String name;
    Book[] reservedBooks;
    int noofreservedbooks;
    public User(String name, int maxReservedBooks) {
        this.name = name;
        reservedBooks = new Book[maxReservedBooks];
        noofreservedbooks = 0;
    }

    public void reserveBook(Book book) {
        if (noofreservedbooks < reservedBooks.length) {
            reservedBooks[noofreservedbooks++] = book;
        }
  }
    public void displayReservedBooks() {
        System.out.println(name + "'s reserved books:");
        for (int i = 0; i < noofreservedbooks; i++) {
            System.out.println(reservedBooks[i].getTitle() + " by " + reservedBooks[i].getAuthor());
        }
    }
    
  }
class CustomException1
  {
    public static void main(String args[])
    {
      Library library = new Library(5);
        library.addBook(new Book("Book1", "Author1", 2));
        library.addBook(new Book("Book2", "Author2", 1));
        library.addBook(new Book("Book3", "Author3", 0));

        User user1 = new User("User1", 2);
       // User user2 = new User("User2", 2);

        try {
            library.reserveBook("Book1");
            library.reserveBook("Book2");
            library.reserveBook("Book3"); // This should throw OutOfCopiesException

            user1.reserveBook(library.getBook("Book1"));
            user1.reserveBook(library.getBook("Book2"));

            //user2.reserveBook(library.getBook("Book1")); // This should throw OutOfCopiesException
        } catch (OutOfCopiesException e) {
            System.out.println(e.getMessage());
        }

        user1.displayReservedBooks();
        user2.displayReservedBooks();
    }
    
}
  public class AddTwoNumbers {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 7;
        int sum = num1 + num2;
        
        System.out.println("Sum: " + sum);
    }
}
public class AddTwoNumbers {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 7;
        int sum = num1 + num2;
        
        System.out.println("Sum: " + sum);
    }
}
class OutOfCopiesException extends Exception {
    public OutOfCopiesException(String message) {
        super(message);
    }
}

class Book {
    String title;
    String author;
    int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

class Library {
    Book[] books;
    int numBooks;

    public Library(int maxBooks) {
        books = new Book[maxBooks];
        numBooks = 0;
    }

    public void addBook(Book book) {
        if (numBooks < books.length) {
            books[numBooks] = book;
            numBooks++;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void reserveBook(String title) throws OutOfCopiesException {
        boolean found = false;

        for (int i = 0; i < numBooks; i++) {
            if (books[i].title.equals(title)) {
                if (books[i].availableCopies > 0) {
                    books[i].availableCopies--;
                    found = true;
                    System.out.println("Book reserved: " + title);
                } else {
                    throw new OutOfCopiesException("No available copies for the book: " + title);
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found: " + title);
        }
    }
}

class User {
    String name;
    Book[] reservedBooks;
    int numReservedBooks;

    public User(String name, int maxReservedBooks) {
        this.name = name;
        reservedBooks = new Book[maxReservedBooks];
        numReservedBooks = 0;
    }

    public void reserveBook(Book book) {
        if (numReservedBooks < reservedBooks.length) {
            reservedBooks[numReservedBooks] = book;
            numReservedBooks++;
        } else {
            System.out.println("You have reached the maximum number of reserved books.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library(10);

        Book book1 = new Book("Title 1", "Author 1", 3);
        Book book2 = new Book("Title 2", "Author 2", 1);
        Book book3 = new Book("Title 3", "Author 3", 5);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("User 1", 2);

        try {
            library.reserveBook("Title 1");
            library.reserveBook("Title 1");
            library.reserveBook("Title 2");
            library.reserveBook("Title 3");
        } catch (OutOfCopiesException e) {
            System.out.println(e.getMessage());
        }
    }
}





import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;

        System.out.println("Sum: " + sum);

        scanner.close();
    }
}
