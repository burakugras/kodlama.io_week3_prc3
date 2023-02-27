package business;

import java.util.List;

import core.logging.Logger;
import dataAccess.CategoryDao;
import entities.Category;

public class CategoryManager {
    private CategoryDao categoryDao;
    private List<Logger> loggers;

    public CategoryManager(CategoryDao categoryDao, List<Logger> loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }

    public void add(Category category,List<Category> categories) throws Exception{
        for (Category categoryElement : categories) {
            if(category.getCategoryName().equals(categoryElement.getCategoryName())){
                throw new Exception("bu isimde bir kategori mevcut");
            }    
        }

        categoryDao.add(category, categories);
        categories.add(category);
        
        for (Logger logger : loggers) {
            logger.log(category.getCategoryName()+" kategorisi loglandı");
        }

    }
    
}
