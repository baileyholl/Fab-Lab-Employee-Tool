package com.hollingsworth.main.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Bailey Hollingsworth on 12/10/16.
 */
public class EmployeeDatabase {
    private LinkedHashMap<String,Employee> database;

    public EmployeeDatabase(){
        database = new LinkedHashMap<String, Employee>();
    }

    public EmployeeDatabase(File[] files){
        database = new LinkedHashMap<String, Employee>();
        getEmployeesFromResources(files);
        System.out.println("Put: " + database.size() + " elements in database.");
    }

    private void getEmployeesFromResources(File[] files){
        for (File f : files){
            if(!f.isHidden() && f.exists()){
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    String line;
                    ArrayList<String> lineList = new ArrayList<String>();
                    while ((line = br.readLine()) != null) {
                        lineList.add(line);
                    }
                    database.put(lineList.get(0), new Employee(lineList.get(0), lineList.get(1)));
                }catch (Exception e){
                    System.out.println(e.getStackTrace());
                }
            }
        }
    }

    public void put(Employee e){
        database.put(e.getName(), e);
    }

    public Employee getByName(String name){
        return database.get(name);
    }

}
