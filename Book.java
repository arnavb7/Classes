import java.util.Objects;

class Book {
    private int length;
    private int currentPage;
    private String title;
    private String author;
    private Genre genre;
    private boolean checkedOut;

    public Book() { 
    }

    public Book(int length, String title, String author, Genre genre) {
        this.length = length;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(int length, String title, String author, Genre genre, boolean checkedOut) {
        this.length = length;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.checkedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isFinished() {
        return currentPage == length;
    }

    public void read(int pagesRead) {
        int newPage = Math.min(currentPage + pagesRead, length);
        this.setCurrentPage(newPage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return length == book.length &&
                currentPage == book.currentPage &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, currentPage, title, author, genre);
    }
}
