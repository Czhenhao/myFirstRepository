package com.echo.javabean;

public class Categories {
    private Integer CategoryID;
    private String CategoryName;
    private String Description;

    public Categories(){}
    public Categories(Integer categoryID, String categoryName, String description) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        Description = description;
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "CategoryID=" + CategoryID +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
