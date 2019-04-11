package pl.moja.biblioteczkafx.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AUTHORS")
public class Author implements BaseModel {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String NameAndSurname;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Book> books;

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAndSurname() {
        return NameAndSurname;
    }

    public void setNameAndSurname(String NameAndSurname) {
        this.NameAndSurname = NameAndSurname;
    }

    public ForeignCollection<Book> getBooks() {
        return books;
    }

    public void setBooks(ForeignCollection<Book> books) {
        this.books = books;
    }
}
