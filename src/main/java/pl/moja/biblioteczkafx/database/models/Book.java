package pl.moja.biblioteczkafx.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "BOOKS")
public class Book implements BaseModel {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "AUTHOR_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Author author;
    @DatabaseField(columnName = "CATEGORY_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Category category;
    @DatabaseField(columnName = "TITTLE", canBeNull = false)
    private String title;
    @DatabaseField(columnName = "DESCRIPTION")
    private String description;
    @DatabaseField(columnName = "RELASE_DATE")
    private Date releaseDate;
    @DatabaseField(columnName = "ISBN", width = 1)
    private long isbn;
    @DatabaseField(columnName = "RATING", width = 1)
    private int rating;
    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
