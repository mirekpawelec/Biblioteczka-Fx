package pl.moja.biblioteczkafx.utils.converters;

import pl.moja.biblioteczkafx.database.models.Category;
import pl.moja.biblioteczkafx.modelfx.CategoryFx;

public class ConverterCategory {
    public static CategoryFx convertToCategoryFx(Category category){
        CategoryFx categoryFx = new CategoryFx();
        categoryFx.setId(category.getId());
        categoryFx.setName(category.getName());
        return categoryFx;
    }
}
