package library_management_system.Library;
import java.util.ArrayList; 
import java.util.Random;

public class Library {
    private String fullName;
    private String libraryId;
    private boolean libraryCardOwned;
    private double totalAmountSpent;
    private int totalBooksBorrowed;
    private double totalCostOfBorrowedBooks;
    private double totalCostOfPurchasedBooks;
    private ArrayList<Book> booksPurchased = new ArrayList<>();
    private ArrayList<Book> booksBorrowed = new ArrayList<>();
    private static final char[] symbols = {
            'A', 'b', 'C', 'd', 'E', 'f',
            '1', '2', '3', '4', '5',
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
            '-', '_', '+', '=', '{', '}', '[', ']',
            ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/',
            '~', '`', '|', '\\'
            };
    private static final Random random = new Random();
    private static final double costOfLibraryCard = 19.99;


    //Constructor
    public Library(String fullName, boolean libraryCardOwned){
        setFullname(fullName);
        setLibraryCardOwned(libraryCardOwned);
        if (this.libraryCardOwned){
            this.totalAmountSpent = costOfLibraryCard;
        }
    }
    
    //getters
    public String getFullName(){
        return this.fullName;
    }
    public boolean isLibraryCardOwned(){
        return this.libraryCardOwned;
    }
    public String getLibraryId(){
        return this.libraryId;
    }
    public double getTotalAmountSpent(){
        return this.totalAmountSpent;
    }
    public int getTotalBooksBorrowed(){
        return this.totalBooksBorrowed;
    }
    public double getTotalCostOfBooksBorrowed(){
        return this.totalCostOfBorrowedBooks;
    }
    public double getTotalCostOfPurchasedBooks(){
        return this.totalCostOfPurchasedBooks;
    }

    //setters
    public void setLibraryCardOwned(boolean libraryCardOwned){
        this.libraryCardOwned = libraryCardOwned;
        if (this.libraryCardOwned) setLibraryId();
    }
    public void setLibraryId(){
        if (this.libraryCardOwned && this.libraryId == null){
            int maxSizeId = 9;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < maxSizeId; i++){
                int randInt = random.nextInt(symbols.length);
                sb.append(symbols[randInt]);
            }
            this.libraryId = sb.toString();
        } else if (!this.libraryCardOwned){
            this.libraryId = null;
        }
    }
    public void setFullname(String fullname){
        this.fullName = fullname;
    }
    public void setTotalCostOfBorrowedBooks(){
        for (Book b : this.booksBorrowed){
            this.totalCostOfBorrowedBooks += b.getCost(); 
        }
    }
    public void setTotalCostOfPurchasedBooks(){
        for (Book b : this.booksPurchased){
            this.totalCostOfPurchasedBooks += b.getCost(); 
        }
    }
    
    //method
    //true if borrowing book false if purchasing book
    public void addBook(Book b, boolean borrowingBook){
        if (borrowingBook){
            this.booksBorrowed.add(b);
            this.totalBooksBorrowed++;
            this.totalCostOfBorrowedBooks += b.getCost();
            this.totalAmountSpent += b.getCost();
        } else {
            this.booksPurchased.add(b);
            this.totalCostOfPurchasedBooks += b.getCost();
            this.totalAmountSpent += b.getCost();
        }
    }
    
    //Getter for all borrowed books
    public ArrayList<Book> getBooksBorrowed(){
        return this.booksBorrowed;
    }
    
    //Getter for all purchased books
    public ArrayList<Book> getBooksPurchased(){
        return this.booksPurchased;
    }
    
    //Remove a borrowed book and update totals
    public boolean returnBook(Book b){
        if (this.booksBorrowed.remove(b)){
            this.totalBooksBorrowed--;
            this.totalCostOfBorrowedBooks -= b.getCost();
            return true;
        }
        return false;
    }
    
    //Get summary of library user
    public String getSummary(){
        return "Library User: " + this.fullName +
               "\nLibrary ID: " + (this.libraryId != null ? this.libraryId : "No Card") +
               "\nTotal Amount Spent: $" + String.format("%.2f", this.totalAmountSpent) +
               "\nBooks Borrowed: " + this.totalBooksBorrowed +
               "\nBooks Purchased: " + this.booksPurchased.size() +
               "\nTotal Cost of Borrowed Books: $" + String.format("%.2f", this.totalCostOfBorrowedBooks) +
               "\nTotal Cost of Purchased Books: $" + String.format("%.2f", this.totalCostOfPurchasedBooks);
    }
}
