package pl.moja.biblioteczkafx.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.moja.biblioteczkafx.database.dao.AuthorDao;
import pl.moja.biblioteczkafx.database.dbutils.DbManager;
import pl.moja.biblioteczkafx.database.models.Author;
import pl.moja.biblioteczkafx.utils.converters.ConverterAuthor;
import pl.moja.biblioteczkafx.utils.exceptions.ApplicationException;

import java.util.List;

public class AuthorModel {

    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>(new AuthorFx());
    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();

    public void init() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        List<Author> authors = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authors.forEach(a -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(a);
            this.authorFxObservableList.add(authorFx);
        });
        DbManager.closeConnectionSource();
    }

    public void saveAuthorInDataBase() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        Author author = ConverterAuthor.convertToAuthor(this.getAuthorFxObjectProperty());
        authorDao.createOrUpdate(author);
        DbManager.closeConnectionSource();
        init();
    }

    public AuthorFx getAuthorFxObjectProperty() {
        return authorFxObjectProperty.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyProperty() {
        return authorFxObjectProperty;
    }

    public void setAuthorFxObjectProperty(AuthorFx authorFxObjectProperty) {
        this.authorFxObjectProperty.set(authorFxObjectProperty);
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }
}
