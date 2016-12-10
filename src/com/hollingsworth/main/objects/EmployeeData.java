package com.hollingsworth.main.objects;

/**
 * Created by Bailey Hollingsworth on 12/7/16.
 */
public class EmployeeData {
    private String name;
    private String description;
    private String imagePath;


    public EmployeeData(){
        this.name = "";
        this.description = "";
        this.imagePath = "";
    }

    public EmployeeData(String name, String description, String imagePath){
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
