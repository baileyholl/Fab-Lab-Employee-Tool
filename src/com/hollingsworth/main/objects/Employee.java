package com.hollingsworth.main.objects;

/**
 * Created by Bailey Hollingsworth on 12/7/16.
 */
public class Employee {
    private String name;
    private String description;


    public Employee(){
        this.name = "";
        this.description = "";
    }

    public Employee(String name, String description){
        this.name = name;
        this.description = description;
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
