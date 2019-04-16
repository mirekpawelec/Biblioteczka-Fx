package pl.moja.biblioteczkafx.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import pl.moja.biblioteczkafx.database.dao.CategoryDao;
import pl.moja.biblioteczkafx.database.dbutils.DbManager;
import pl.moja.biblioteczkafx.database.models.Category;
import pl.moja.biblioteczkafx.utils.converters.ConverterCategory;
import pl.moja.biblioteczkafx.utils.exceptions.ApplicationException;

import java.util.List;

public class CategoryModel {

    // klasa serwisowa dla encji Category, łączy widok (kontrolki javafx) przez  kontroler z bazą danych (implementacja modelu MVC)

    private ObservableList<CategoryFx> categoryObservableList = FXCollections.observableArrayList();
    private ObjectProperty<CategoryFx> categoryProperty = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        List<Category> categories = categoryDao.queryForAll(Category.class);
        initCategoryList(categories);
        initRoot(categories);
        DbManager.closeConnectionSource();
    }

    private void initRoot(List<Category> categories) {
        this.root.getChildren().clear();
        categories.forEach(c -> {
            TreeItem<String> categoryTreeItem = new TreeItem<>(c.getName());
            c.getBooks().forEach(bookTreeItem -> {
                categoryTreeItem.getChildren().add(new TreeItem(bookTreeItem.getTitle()));
            });
            this.root.getChildren().add(categoryTreeItem);
        });
    }

    private void initCategoryList(List<Category> categories) {
        categoryObservableList.clear();
        categories.forEach(c -> {
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            this.categoryObservableList.add(categoryFx);
        });
    }

    public void saveCategoryInDataBase(String name) throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        Category category = new Category();
        category.setName(name);
        categoryDao.createOrUpdate(category);
        DbManager.closeConnectionSource();

        init();
    }

    public void deleteCategoryById() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        categoryDao.deleteById(Category.class, categoryProperty.getValue().getId());
        DbManager.closeConnectionSource();
        init();
    }

    public void updateCategoryInDataBase() throws ApplicationException {
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

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
