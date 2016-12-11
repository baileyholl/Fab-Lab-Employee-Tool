package com.hollingsworth.main.objects;

import java.io.File;

/**
 * Created by Bailey Hollingsworth on 12/7/16.
 */
public class Employee {
    private String name;
    private String description;
    private File imagePath;


    public Employee(){
        this.name = "";
        this.description = "";
        this.imagePath = new File("");
    }

    public Employee(String name, String description, File imagePath){
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

    public File getImagePath() {
        return imagePath;
    }

    public void setImagePath(File imagePath) {
        this.imagePath = imagePath;
    }
}
