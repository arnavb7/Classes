import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

class LibraryTest {
    private Library tester;
    public boolean containsSame(ArrayList<Book> a, ArrayList<Book> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for(int i = 0; i < a.size(); i++) {
            boolean found = false;
            for(int j = 0; j < b.size(); j++) {
                if (a.get(i).equals(b.get(j))) {
                    found = true;
                    break;
                }

            }
            if (found == false) {
                return false;
            }
        }
        return true;
    }


    @BeforeEach
    public void createTesterLibrary() {
        tester = new Library();
    }

    @Test
    public void testAddNewBook() {
        Book newBook = new Book(350, "Martian", "Andy Weir", Genre.SCIENCEFICTION);
        tester.addNewBook(newBook);
        ArrayList<Book> currentBooks = tester.getAllBooks();
        assertEquals(currentBooks.size(), 1);
        assertTrue(newBook.equals(currentBooks.get(0)));
    }

    @Test
    public void testRemoveBook() {
        Book newBook = new Book(100, "Hunger Games", "Suzanne Collins", Genre.FANTASY);
        Book newBook2 = new Book(100, "Catching Fire", "Suzanne Collins", Genre.FANTASY);
        tester.addNewBook(newBook);
        tester.addNewBook(newBook2);
        ArrayList<Book> currentBooks = tester.getAllBooks();
        tester.removeBook(newBook);
        assertEquals(currentBooks.size(), 1);
        assertTrue(newBook2.equals(currentBooks.get(0)));
    }

    @Test
    public void testFilterBooksByGenre() {
        Book book1 = new Book(100, "Martian", "Andy Weir", Genre.SCIENCEFICTION);
        Book book2 = new Book(150, "Ender's Game", "Orson Scott Card", Genre.SCIENCEFICTION);
        Book book3 = new Book(200, "HitchhikerGuide", "Douglas Adams", Genre.SCIENCEFICTION);
        Book book4 = new Book(250, "MadDogs", "Robert Muchamore", Genre.THRILLER);
        Book book5 = new Book(300, "Dealer", "Robert Muchamore", Genre.THRILLER);
        tester.addNewBook(book1);
        tester.addNewBook(book2);
        tester.addNewBook(book3);
        tester.addNewBook(book4);
        tester.addNewBook(book5);
        ArrayList<Book> expected = new ArrayList<Book>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        ArrayList<Book> output = tester.filterBooksBy(Genre.SCIENCEFICTION);
        assertEquals(expected.size(), output.size());
        assertTrue(containsSame(expected, output));

    }

    @Test
    public void testFilterBooksByAuthor() {
        Book book1 = new Book(100, "Martian", "Andy Weir", Genre.SCIENCEFICTION);
        Book book2 = new Book(150, "Ender's Game", "Orson Scott Card", Genre.SCIENCEFICTION);
        Book book3 = new Book(200, "HitchhikerGuide", "Douglas Adams", Genre.SCIENCEFICTION);
        Book book4 = new Book(250, "MadDogs", "Robert Muchamore", Genre.THRILLER);
        Book book5 = new Book(300, "Dealer", "Robert Muchamore", Genre.THRILLER);
        tester.addNewBook(book1);
        tester.addNewBook(book2);
        tester.addNewBook(book3);
        tester.addNewBook(book4);
        tester.addNewBook(book5);
        ArrayList<Book> expected = new ArrayList<Book>();
        expected.add(book4);
        expected.add(book5);
        ArrayList<Book> output = tester.filterBooksBy("Robert Muchamore");
        assertEquals(expected.size(), output.size());
        assertTrue(containsSame(expected, output));
    }

    @Test
    public void testFilterBooksWithLengthLessThan() {
        Book book1 = new Book(100, "Martian", "Andy Weir", Genre.SCIENCEFICTION);
        Book book2 = new Book(150, "Ender's Game", "Orson Scott Card", Genre.SCIENCEFICTION);
        Book book3 = new Book(200, "HitchhikerGuide", "Douglas Adams", Genre.SCIENCEFICTION);
        Book book4 = new Book(250, "MadDogs", "Robert Muchamore", Genre.THRILLER);
        Book book5 = new Book(300, "Dealer", "Robert Muchamore", Genre.THRILLER);
        tester.addNewBook(book1);
        tester.addNewBook(book2);
        tester.addNewBook(book3);
        tester.addNewBook(book4);
        tester.addNewBook(book5);
        ArrayList<Book> expected = new ArrayList<Book>();
        expected.add(book1);
        expected.add(book2);
        ArrayList<Book> output = tester.filterBooksWithLengthLessThan(200);
        assertEquals(expected.size(), output.size());
        assertTrue(containsSame(expected, output));
    }

    @Test
    public void testGetBookByName() {
        Book book1 = new Book(100, "Martian", "Andy Weir", Genre.SCIENCEFICTION);
        Book book2 = new Book(150, "Ender's Game", "Orson Scott Card", Genre.SCIENCEFICTION);
        Book book3 = new Book(200, "HitchhikerGuide", "Douglas Adams", Genre.SCIENCEFICTION);
        tester.addNewBook(book1);
        tester.addNewBook(book2);
        tester.addNewBook(book3);
        assertTrue(book2.equals(tester.getBookByName("Ender's Game")));
        assertNull(tester.getBookByName("Dealer"));
    }

    @Test
    public void testCheckoutBook() {
        Book book1 = new Book(100, "Martian", "Andy Weir", Genre.SCIENCEFICTION, false);
        Book book2 = new Book(150, "Ender's Game", "Orson Scott Card", Genre.SCIENCEFICTION, false);
        Book book3 = new Book(200, "HitchhikerGuide", "Douglas Adams", Genre.SCIENCEFICTION, true);
        tester.addNewBook(book1);
        tester.addNewBook(book2);
        tester.addNewBook(book3);
        tester.checkoutBook("Martian");
        assertTrue(book1.isCheckedOut());

    }
}
