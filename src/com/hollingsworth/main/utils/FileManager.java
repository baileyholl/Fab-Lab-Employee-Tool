package com.hollingsworth.main.utils;

/**
 * Created by Bailey Hollingsworth on 12/9/16.
 */

import com.hollingsworth.main.objects.Constants;
import com.hollingsworth.main.objects.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private static String OSImagePath;
    private static String OSTextPath;

    public static void setupFolders(){
        System.out.println("Searching for resource folder");
        Constants.mainFolder = new File(getFilePath());
        Constants.imageFolder = new File(Constants.mainFolder.toString() + OSImagePath);
        Constants.textFolder = new File(Constants.mainFolder.toString()+ OSTextPath);
        if (Constants.mainFolder.exists()) {
            System.out.println("Found:" + Constants.mainFolder.listFiles().length);

        }
        else{
            Constants.mainFolder.mkdir();
            Constants.imageFolder.mkdir();
            Constants.textFolder.mkdir();
            System.out.println("Could not find folder so created it");
        }
    }


    public static void createNewEmployeeFile(String name, String description, String imagePath){
        List<String> lines = Arrays.asList(name, description, imagePath);
        Path path = Paths.get(Constants.mainFolder.toString(), name+".json");
        try {
            Files.write(path,lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(){
        String FileFolder = System.getenv("APPDATA") + "\\" + "FabLabTool";

        System.out.println("Searching for system");

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN")) {
            FileFolder = System.getenv("APPDATA") + "\\" + "FabLabTool";
            OSImagePath = ("\\images");
            OSTextPath = ("\\text");
            System.out.println("Found windows");
        }
        if (os.contains("MAC")) {
            FileFolder = System.getProperty("user.home") + "/Library/Application Support" + "/FabLabTool";
            OSImagePath = ("/images");
            OSTextPath = ("/text");
            System.out.println("Found mac");
        }
        if (os.contains("NUX")) {
            FileFolder = System.getProperty("user.dir") + ".FabLabTool";
            OSImagePath = (".images");
            OSTextPath = (".text");
            System.out.println("Found linux");
        }
        System.out.println(FileFolder);
        return FileFolder;
    }

    public static void createNewEmployeeFile(Employee newEmployee) {
        createNewEmployeeFile(newEmployee.getName(), newEmployee.getDescription(), newEmployee.getImagePath().toString());
    }
}
