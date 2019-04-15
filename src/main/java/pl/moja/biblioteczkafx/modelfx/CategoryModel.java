package pl.moja.biblioteczkafx.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.moja.biblioteczkafx.database.dao.CategoryDao;
import pl.moja.biblioteczkafx.database.dbutils.DbManager;
import pl.moja.biblioteczkafx.database.models.Category;

public class CategoryModel {

    // klasa serwisowa dla encji Category, łączy widok (kontrolki javafx) przez  kontroler z bazą danych (implementacja modelu MVC)

    private ObservableList<CategoryFx> categoryObservableList = FXCollections.observableArrayList();
    private ObjectProperty<CategoryFx> categoryProperty = new SimpleObjectProperty<>();

    public void init() {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        categoryObservableList.clear();
        categoryDao.queryForAll(Category.class).forEach(c -> {
            CategoryFx categoryFx = new CategoryFx();
            categoryFx.setId(c.getId());
            categoryFx.setName(c.getName());
            this.categoryObservableList.add(categoryFx);
        });
        DbManager.closeConnectionSource();
    }

    public void saveCategoryInDataBase(String name) {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        Category category = new Category();
        category.setName(name);
        categoryDao.createOrUpdate(category);
        DbManager.closeConnectionSource();

        init();
    }

    public void deleteCategoryById() {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        categoryDao.deleteById(Category.class, categoryProperty.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }

    public void updateCategoryInDataBase() {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        Category categoryToBeUpdate = categoryDao.findById(Category.class, categoryProperty.getValue().getId());
        categoryToBeUpdate.setName(getCategory().getName());
        categoryDao.createOrUpdate(categoryToBeUpdate);
        DbManager.closeConnectionSource();
        init();
    }

    public ObservableList<CategoryFx> getCategoryObservableList() {
        return categoryObservableList;
    }

    public void setCategoryObservableList(ObservableList<CategoryFx> categoryObservableList) {
        this.categoryObservableList = categoryObservableList;
    }

    public CategoryFx getCategory() {
        return categoryProperty.get();
    }

    public void setCategory(CategoryFx category) {
        this.categoryProperty.set(category);
    }

    public ObjectProperty<CategoryFx> getCategoryProperty() {
        return categoryProperty;
    }

    public void setCategoryProperty(ObjectProperty<CategoryFx> categoryProperty) {
        this.categoryProperty = categoryProperty;
    }
}
