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
    private ObjectProperty<AuthorFx> authorFxObjectPropertyEdit = new SimpleObjectProperty<>(new AuthorFx());
    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();

    public void init() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        List<Author> authors = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authors.forEach(a -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(a);
            this.authorFxObservableList.add(authorFx);
        });
    }

    public void saveAuthorInDataBase() throws ApplicationException {
        saveOrUpdateAuthorFx(this.getAuthorFxObjectProperty());
    }

    public void saveAuthorInDataBaseEdit() throws ApplicationException {
        saveOrUpdateAuthorFx(this.getAuthorFxObjectPropertyEdit());
    }

    public void saveOrUpdateAuthorFx(AuthorFx authorFx) throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        Author author = ConverterAuthor.convertToAuthor(authorFx);
        authorDao.createOrUpdate(author);
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

    public AuthorFx getAuthorFxObjectPropertyEdit() {
        return authorFxObjectPropertyEdit.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyEditProperty() {
        return authorFxObjectPropertyEdit;
    }

    public void setAuthorFxObjectPropertyEdit(AuthorFx authorFxObjectPropertyEdit) {
        this.authorFxObjectPropertyEdit.set(authorFxObjectPropertyEdit);
    }
}
