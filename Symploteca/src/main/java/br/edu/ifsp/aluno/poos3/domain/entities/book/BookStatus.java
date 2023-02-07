package br.edu.ifsp.aluno.poos3.domain.entities.book;

public enum BookStatus {
    AVAILABLE("Disponível"),
    CHECKED_OUT("Empretado");

    private final String bookStatusAsString;

    BookStatus(String bookStatusAsString) {
        this.bookStatusAsString = bookStatusAsString;
    }

    public static BookStatus getBookStatusFromString(String maybeBookStatus) {
        if (maybeBookStatus == null)
            throw new IllegalArgumentException("Impossible to convert 'null' to a Book Status!");

        return switch (maybeBookStatus.toLowerCase()) {
            case "disponível" -> AVAILABLE;
            case "emprestado" -> CHECKED_OUT;
        };
    }

    @Override
    public String toString() {
        return bookStatusAsString;
    }
}
