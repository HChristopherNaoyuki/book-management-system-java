package Solution;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest 
{
    @Test
    public void testAddAndFindBook() 
    {
        Solution.Bookstore store = new Solution.Bookstore(10);
        Solution.Book book = new Solution.Book("Test Book", "Author A", "12345", 19.99);
        store.addBook(book);

        Solution.Book found = store.findBookByTitle("Test Book");
        assertNotNull(found);
        assertEquals("Author A", found.getAuthor());
    }

    @Test
    public void testUpdateBookDetails() 
    {
        Solution.Bookstore store = new Solution.Bookstore(10);
        store.addBook(new Solution.Book("Test Book", "Author A", "12345", 19.99));
        store.updateBookDetails("Test Book", "Author B", "67890", 25.99);

        Solution.Book updated = store.findBookByTitle("Test Book");
        assertEquals("Author B", updated.getAuthor());
        assertEquals("67890", updated.getIsbn());
        assertEquals(25.99, updated.getPrice(), 0.001);
    }

    @Test
    public void testRemoveBook() 
    {
        Solution.Bookstore store = new Solution.Bookstore(10);
        store.addBook(new Solution.Book("Book A", "Author A", "111", 10.0));
        store.removeBookByTitle("Book A");

        Solution.Book removed = store.findBookByTitle("Book A");
        assertNull(removed);
    }

    @Test
    public void testSubmissionNumberIncrement() 
    {
        Solution.Bookstore store = new Solution.Bookstore(10);
        store.addBook(new Solution.Book("Book 1", "A", "1", 10.0));
        store.addBook(new Solution.Book("Book 2", "B", "2", 20.0));

        Solution.Book book1 = store.findBookByTitle("Book 1");
        Solution.Book book2 = store.findBookByTitle("Book 2");

        assertEquals(1, book1.getSubmissionNumber());
        assertEquals(2, book2.getSubmissionNumber());
    }
}
