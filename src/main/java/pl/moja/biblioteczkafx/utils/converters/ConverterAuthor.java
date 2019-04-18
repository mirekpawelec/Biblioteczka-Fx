package pl.moja.biblioteczkafx.utils.converters;

import pl.moja.biblioteczkafx.database.models.Author;
import pl.moja.biblioteczkafx.modelfx.AuthorFx;

public class ConverterAuthor {
    public static Author convertToAuthor(AuthorFx authorFx) {
        Author author = new Author();
        author.setId(authorFx.getId());
        author.setName(authorFx.getName());
        author.setSurname(authorFx.getSurname());
        return author;
    }

    public static AuthorFx convertToAuthorFx(Author author) {
        AuthorFx authorFx = new AuthorFx();
        authorFx.setId(author.getId());
        authorFx.setName(author.getName());
        authorFx.setSurname(author.getSurname());
        return authorFx;
    }
}
