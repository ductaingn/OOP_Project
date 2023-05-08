package application;

public class Category {
    private String categoryName;
    private Category categoryChild;
    private String level = "";

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getLevel() {
        return level;
    }

    public void setCategoryChild(Category child) {
        this.categoryChild = child;
        child.level = level + "     ";
        child.setCategoryName(child.getLevel() + child.getCategoryName());
    }

    public Category getCategoryChild() {
        return categoryChild;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}