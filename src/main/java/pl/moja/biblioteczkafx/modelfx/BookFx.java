package pl.moja.biblioteczkafx.modelfx;

import javafx.beans.property.*;

public class BookFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<AuthorFx> author = new SimpleObjectProperty<>();
    private ObjectProperty<CategoryFx> category = new SimpleObjectProperty<>();
    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private StringProperty releaseDate = new SimpleStringProperty();
    private LongProperty isbn = new SimpleLongProperty();
    private IntegerProperty rating = new SimpleIntegerProperty();
    private StringProperty addedDate = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public AuthorFx getAuthor() {
        return author.get();
    }

    public ObjectProperty<AuthorFx> authorProperty() {
        return author;
    }

    public void setAuthor(AuthorFx author) {
        this.author.set(author);
    }

    public CategoryFx getCategory() {
        return category.get();
    }

    public ObjectProperty<CategoryFx> categoryProperty() {
        return category;
    }

    public void setCategory(CategoryFx category) {
        this.category.set(category);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public StringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }

    public long getIsbn() {
        return isbn.get();
    }

    public LongProperty isbnProperty() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn.set(isbn);
    }

    public int getRating() {
        return rating.get();
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public String getAddedDate() {
        return addedDate.get();
    }

    public StringProperty addedDateProperty() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate.set(addedDate);
    }
}
