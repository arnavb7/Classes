import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Library() {
        this.books = new ArrayList<Book>();

    }

    public void addNewBook(Book book) {
        this.books.add(book);
    }

    public void removeBook (Book book) {
        this.books.remove(book);
    }

    public Book getBookByName(String name) {
        for (int i = 0; i < books.size(); i++) {
            if ((books.get(i)).getTitle() == name) {
                return books.get(i);
            }
        }
        return null;
    }

    public boolean checkoutBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (((books.get(i)).getTitle() == name) && ((books.get(i)).isCheckedOut() == false)) {
                (books.get(i)).setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> filterBooksBy(Genre genre) {
        ArrayList<Book> filteredBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (((books.get(i)).getGenre()) == genre) {
                filteredBooks.add(books.get(i));
            }
        }
        return filteredBooks;
    }

    public ArrayList<Book> filterBooksBy(String author) {
        ArrayList<Book> filteredBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (((books.get(i)).getAuthor()) == author) {
                filteredBooks.add(books.get(i));
            }
        }
        return filteredBooks;
    }

    public ArrayList<Book> filterBooksWithLengthLessThan(int length) {
        ArrayList<Book> filteredBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (((books.get(i)).getLength()) < length) {
                filteredBooks.add(books.get(i));
            }
        }
        return filteredBooks;
    }
}