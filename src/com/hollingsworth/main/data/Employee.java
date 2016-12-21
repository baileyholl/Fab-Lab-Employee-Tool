package com.hollingsworth.main.data;

import java.io.File;

/**
 * Created by Bailey Hollingsworth on 12/7/16.
 */
public class Employee {
    private String name;
    private String description;
    private File linkedImage;

    public Employee(){
        this.name = "";
        this.description = "";
        this.linkedImage = new File("");
    }

    public Employee(String name, String description, File linkedImage){
        this.name = name;
        this.description = description;
        this.linkedImage = linkedImage;
    }

    public File getLinkedImage(){
        return linkedImage;
    }

    public void setLinkedImage(File linkedImage){
        this.linkedImage = linkedImage;
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
}
