package library_management_system.Library;

public class Book {
    private double cost;
    private String bookName;
    private String authorsName;
    //private Library userId;
    
    //Constructor
    public Book(String bookName, String authorsName, double cost){
        setBookName(bookName);
        setAuthorsName(authorsName);
        setCost(cost);
    }
    //getters
    public double getCost(){
        return this.cost;
    }
    public String getBookName(){
        return this.bookName;
    }
    public String getAuthorsName(){
        return this.authorsName;
    }
    //setters
    public void setCost(double cost){
        this.cost = cost;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public void setAuthorsName(String authorsName){
        this.authorsName = authorsName;
    }

}
