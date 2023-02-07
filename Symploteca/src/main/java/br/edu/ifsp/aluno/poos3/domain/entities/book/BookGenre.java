package br.edu.ifsp.aluno.poos3.domain.entities.book;

public enum BookGenre {
    ACTION("Ação"),
    DRAMA("Drama"),
    HISTORY("História"),
    HORROR("Terror"),
    SCIENCE("Ciência"),
    TECHNICAL("Técnico");

    private final String genreAsString;

    BookGenre(String genreAsString) {
        this.genreAsString = genreAsString;
    }

    public static BookGenre getGenreFromString(String maybeGenre) {
        if (maybeGenre == null)
            throw new IllegalArgumentException("Impossible to convert 'null' to a BookGenre!");

        return switch (maybeGenre.toLowerCase()) {
            case "ação" -> ACTION;
            case "drama" -> DRAMA;
            case "história" -> HISTORY;
            case "terror" -> HORROR;
            case "ciência" -> SCIENCE;
            case "técnico" -> TECHNICAL;
        };
    }

    @Override
    public String toString() {
        return genreAsString;
    }
}
