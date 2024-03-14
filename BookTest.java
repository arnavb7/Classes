import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


class BookTest {
    private Book tester;

    @BeforeEach
    public void createTesterBook() {
        tester = new Book();
    }

    @Test
    public void testLengthGetterAndSetter() {
        int length = 265;
        tester.setLength(length);
        assertEquals(length, tester.getLength());
    }

    @Test
    public void testTitleGetterAndSetter() {
        String title = "The Martian";
        tester.setTitle(title);
        assertEquals(title, tester.getTitle());
    }

    @Test
    public void testAuthorGetterAndSetter() {
        String author = "Andy Weir";
        tester.setAuthor(author);
        assertEquals(author, tester.getAuthor());
    }

    @Test
    public void testGenreGetterAndSetter() {
        Genre genre = Genre.SCIENCEFICTION;
        tester.setGenre(genre);
        assertEquals(genre, tester.getGenre());
    }

    @Test
    public void testCurrentPageGetterAndSetter() {
        int currentPage = 10;
        tester.setCurrentPage(currentPage);
        assertEquals(currentPage, tester.getCurrentPage());
    }

    @Test
    public void testIsFinished() {
        tester.setLength(265);
        tester.setCurrentPage(265);
        assertTrue(tester.isFinished());
    }

    @Test
    public void testIsFinished2() {
        tester.setLength(265);
        tester.setCurrentPage(264);
        assertFalse(tester.isFinished());
    }

    @Test
    public void testRead() {
        tester.setLength(265);
        tester.setCurrentPage(123);
        tester.read(5);
        assertEquals(128, tester.getCurrentPage());
    }
}
