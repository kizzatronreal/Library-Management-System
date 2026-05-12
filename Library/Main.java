package library_management_system.Library;

public class Main {
    public static void main(String[] args) {
        // Create library user with library card
        Library l1 = new Library("Kyle Bone", true);
        
        // Create some books
        Book b1 = new Book("Harry Potter", "J.K. Rowling", 32.49);
        Book b2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 28.99);
        Book b3 = new Book("1984", "George Orwell", 15.99);
        Book b4 = new Book("To Kill a Mockingbird", "Harper Lee", 18.99);
        
        // Purchase some books
        l1.addBook(b1, false);
        l1.addBook(b2, false);
        
        // Borrow some books
        l1.addBook(b3, true);
        l1.addBook(b4, true);
        
        // Display user summary
        System.out.println(l1.getSummary());
        
        System.out.println("\n--- Books Purchased ---");
        for (Book b : l1.getBooksPurchased()) {
            System.out.println(b.getBookName() + " by " + b.getAuthorsName() + " - $" + String.format("%.2f", b.getCost()));
        }
        
        System.out.println("\n--- Books Borrowed ---");
        for (Book b : l1.getBooksBorrowed()) {
            System.out.println(b.getBookName() + " by " + b.getAuthorsName() + " - $" + String.format("%.2f", b.getCost()));
        }
        
        // Return a borrowed book
        System.out.println("\n--- Returning a Book ---");
        l1.returnBook(b3);
        System.out.println("Returned: " + b3.getBookName());
        System.out.println("Books Borrowed Now: " + l1.getTotalBooksBorrowed());
        System.out.println("Total Amount Spent: $" + String.format("%.2f", l1.getTotalAmountSpent()));
    }
}
