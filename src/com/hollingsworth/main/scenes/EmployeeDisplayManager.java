package com.hollingsworth.main.scenes;

import java.io.File;

/**
 * Created by Bailey Hollingsworth on 12/23/16.
 */
public class EmployeeDisplayManager{
    private String name, description;
    private File imageToDisplay;

    public EmployeeDisplayManager(String name, String description, File imageToDisplay){
        this.name = name;
        this.description = description;
        this.imageToDisplay = imageToDisplay;
    }
}
