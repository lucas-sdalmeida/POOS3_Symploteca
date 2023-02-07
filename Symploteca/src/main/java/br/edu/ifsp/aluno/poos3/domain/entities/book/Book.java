package br.edu.ifsp.aluno.poos3.domain.entities.book;

public class Book {
    private Integer id;
    private Integer edition;
    private Integer numberOfPages;
    private String name;
    private String authors;
    private String publisher;
    private String isbn;
    private BookGenre genre;
    private BookStatus status;

    public Book(Integer id, String name, Integer edition, Integer numberOfPages,
                String authors, String publisher, String isbn,
                BookGenre genre, BookStatus status) {
        this.id = id;
        this.edition = edition;
        this.numberOfPages = numberOfPages;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
        this.genre = genre;
        this.status = status;
    }

    public Book(String name, Integer edition, Integer numberOfPages,
                String authors, String publisher, String isbn,
                BookGenre genre, BookStatus status) {
        this(null, name, edition, numberOfPages, authors, publisher, isbn, genre, status);
    }

    public Book(String name, Integer edition, Integer numberOfPages,
                String authors, String publisher, String isbn,
                BookGenre genre) {
        this(null, name, edition, numberOfPages, authors, publisher, isbn, genre, BookStatus.AVAILABLE);
    }

    public Book() {
        status = BookStatus.AVAILABLE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEdition() {
        return edition;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getName() {
        return name;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
