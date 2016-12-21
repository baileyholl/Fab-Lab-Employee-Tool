package com.hollingsworth.main.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 * Created by Bailey Hollingsworth on 12/10/16.
 */
public class EmployeeDatabase {
    private LinkedHashMap<String,Employee> database;

    public EmployeeDatabase(){
        database = new LinkedHashMap<String, Employee>();
    }

    public EmployeeDatabase(File[] textFiles, File[] imageFiles){
        database = new LinkedHashMap<String, Employee>();
        putEmployeesFromResources(textFiles, imageFiles);
        System.out.println("Put: " + database.size() + " elements in database.");
    }

    private void putEmployeesFromResources(File[] files, File[] imageFiles){
        for (File f : files){
            if(!f.isHidden() && f.exists()){
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    String line;
                    ArrayList<String> lineList = new ArrayList<String>();
                    while ((line = br.readLine()) != null) {
                        lineList.add(line);
                    }
                    database.put(lineList.get(0), new Employee(lineList.get(0), lineList.get(1),
                            getLinkedImageFile(lineList.get(0), imageFiles)));
                }catch (Exception e){
                    System.out.println(e.getStackTrace());
                }
            }
        }
    }

    public Set<String> getEmployeeNames(){
        return database.keySet();
    }

    public void put(Employee e){
        database.put(e.getName(), e);
    }

    public Employee getByName(String name){
        return database.get(name);
    }

    //Can return null
    private File getLinkedImageFile(String name, File[] imageFiles) {
        for(File f : imageFiles){
            if(!f.isHidden() && f.exists()){
                if(f.getName().equals(name+".png")){
                    return f;
                }
            }
        }
        System.out.println("Could not find image file for " + name + ". Returning null.");
        return null;
    }
}
