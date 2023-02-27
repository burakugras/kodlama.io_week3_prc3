package dataAccess;

import java.util.List;

import entities.Category;

public class JdbcCategoryDao implements CategoryDao{

    @Override
    public void add(Category category, List<Category> categories) {
        System.out.println("kategori jdbc ile eklendi");
    }
    
}
