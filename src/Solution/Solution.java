package Solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution Class - Combines Book, Bookstore, and BookstoreManagement functionality.
 */
public class Solution 
{
    // Inner Book class
    static class Book 
    {
        private final String title;
        private String author;
        private String isbn;
        private double price;
        private int submissionNumber;

        public Book(String title, String author, String isbn, double price) 
        {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.price = price;
        }

        // Getters and Setters
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }
        public double getPrice() { return price; }
        public int getSubmissionNumber() { return submissionNumber; }

        public void setAuthor(String author) { this.author = author; }
        public void setIsbn(String isbn) { this.isbn = isbn; }
        public void setPrice(double price) { this.price = price; }
        public void setSubmissionNumber(int submissionNumber) { this.submissionNumber = submissionNumber; }

        public String displayInfo() 
        {
            return "Submission #" + submissionNumber + " | Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
        }
    }

    // Inner Bookstore class
    static class Bookstore 
    {
        private final Book[] books;
        private int count;
        private int submissionCounter;

        public Bookstore(int capacity) 
        {
            books = new Book[capacity];
            count = 0;
            submissionCounter = 1;
        }

        public void addBook(Book book) 
        {
            if (count < books.length) 
            {
                book.setSubmissionNumber(submissionCounter++);
                books[count++] = book;
            } 
            else 
            {
                System.out.println("Bookstore is full. Cannot add more books.");
            }
        }

        public void listBooks() 
        {
            System.out.println("Listing all books:");
            for (int i = 0; i < count; i++) 
            {
                System.out.println(books[i].displayInfo());
            }
        }

        public Book findBookByTitle(String title) 
        {
            for (int i = 0; i < count; i++) 
            {
                if (books[i].getTitle().equalsIgnoreCase(title)) 
                {
                    return books[i];
                }
            }
            return null;
        }

        public void removeBookByTitle(String title) 
        {
            for (int i = 0; i < count; i++) 
            {
                if (books[i].getTitle().equalsIgnoreCase(title)) 
                {
                    books[i] = books[count - 1];
                    books[count - 1] = null;
                    count--;
                    return;
                }
            }
            System.out.println("Book not found.");
        }

        public void updateBookDetails(String title, String newAuthor, String newIsbn, double newPrice) 
        {
            Book book = findBookByTitle(title);
            if (book != null) 
            {
                book.setAuthor(newAuthor);
                book.setIsbn(newIsbn);
                book.setPrice(newPrice);
            } 
            else 
            {
                System.out.println("Book not found.");
            }
        }

        public Book[] getBooks() 
        {
            return Arrays.copyOf(books, count);
        }

        public int getCount() 
        {
            return count;
        }
    }

    // Main method to interact with user
    public static void main(String[] args)
    {
        System.out.println("WELCOME TO THE BOOK MANAGEMENT SYSTEM");
        System.out.println("****************************************************");

        Bookstore bookstore = new Bookstore(100);
        try (Scanner scanner = new Scanner(System.in)) 
        {
            String command;
            
            do 
            {
                System.out.println("\nBookstore Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. List Books");
                System.out.println("3. Find Book by Title");
                System.out.println("4. Remove Book by Title");
                System.out.println("5. Update Book Details");
                System.out.println("6. Exit");
                System.out.print("Enter command: ");
                command = scanner.nextLine();
                
                switch (command)
                {
                    case "1" -> {
                        try 
                        {
                            System.out.print("Enter title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine(); 
                            System.out.print("Enter ISBN: ");
                            String isbn = scanner.nextLine();
                            System.out.print("Enter price: ");
                            double price = Double.parseDouble(scanner.nextLine());
                            bookstore.addBook(new Book(title, author, isbn, price));
                            System.out.println("Book added successfully.");
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Invalid price format. Please enter a valid number.");
                        }
                    }
                        
                    case "2" -> bookstore.listBooks();
                        
                    case "3" -> {
                        System.out.print("Enter title to search: ");
                        String searchTitle = scanner.nextLine();
                        Book book = bookstore.findBookByTitle(searchTitle);
                        if (book != null)
                        {
                            System.out.println("Found book: " + book.displayInfo());
                        }
                        else
                        {
                            System.out.println("Book not found.");
                        }
                    }
                        
                    case "4" -> {
                        System.out.print("Enter title to remove: ");
                        String removeTitle = scanner.nextLine();
                        bookstore.removeBookByTitle(removeTitle);
                        System.out.println("Book removed successfully (if it existed).");
                    }
                        
                    case "5" -> {
                        System.out.print("Enter title of book to update: ");
                        String updateTitle = scanner.nextLine();
                        System.out.print("Enter new author: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Enter new ISBN: ");
                        String newIsbn = scanner.nextLine();
                        double newPrice = 0;
                        boolean validPrice = false;
                        while (!validPrice)
                        {
                            System.out.print("Enter new price: ");
                            try
                            {
                                newPrice = Double.parseDouble(scanner.nextLine());
                                validPrice = true;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Invalid price format. Please enter a valid number.");
                            }
                        }
                        bookstore.updateBookDetails(updateTitle, newAuthor, newIsbn, newPrice);
                        System.out.println("Book details updated successfully.");
                    }
                        
                    case "6" -> System.out.println("Exiting...");
                        
                    default -> System.out.println("Invalid command. Please try again.");
                }
            } while (!command.equals("6"));
        }
    }
}
