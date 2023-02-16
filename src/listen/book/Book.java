package listen.book;

import listen.book.Printable;

public class Book implements Printable{
  
    String name;
    String author;
    int yearEdition;
  
    public Book(String name, String author, int yearEdition){
        
        this.name = name;
        this.author = author;
        this.yearEdition = yearEdition;
    }
      
    public void print() {
        System.out.printf("%s (%s), yearEdition %d \n", name, author, yearEdition);
        //Print.f("%s (%s), yearEdition %d \n", new Object[]{name, author, yearEdition});
    }
}