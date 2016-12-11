package com.hollingsworth.main.objects;

import java.util.LinkedHashMap;

/**
 * Created by Bailey Hollingsworth on 12/10/16.
 */
public class EmployeeDatabase {
    private LinkedHashMap<String,Employee> database;

    public EmployeeDatabase(){
        database = new LinkedHashMap<String, Employee>();
    }

    public void add(Employee e){
        database.put(e.getName(), e);
    }

    public Employee getByName(String name){
        return database.get(name);
    }
}
