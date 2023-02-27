package dataAccess;

import java.util.List;

import entities.Category;

public class HibernateCategoryDao implements CategoryDao{

    @Override
    public void add(Category category, List<Category> categories) {
        System.out.println("kategori hibernate ile eklendi");
    }
    
}
