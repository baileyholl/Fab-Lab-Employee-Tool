package com.hollingsworth.main.utils;

/**
 * Created by Bailey Hollingsworth on 12/9/16.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    public static File directory;
    public static FileManager globalFileManager;

    public FileManager(){
        String FileFolder = getOSFolder();
        System.out.println("Searching for resource folder");
        directory = new File(FileFolder);
        if (directory.exists()) {
            System.out.println("Found folder");
        }
        if (directory.exists() == false) {
            directory.mkdir();
            System.out.println("Could not find folder so created it");
        }
    }

    public void createNewEmployeeFile(String name, String description, String imagePath){
        List<String> lines = Arrays.asList(name, description, imagePath);
        Path path = Paths.get(directory.toString(), name+".json");
        try {
            Files.write(path,lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getOSFolder(){
        String FileFolder = System.getenv("APPDATA") + "\\" + "FabLabTool";

        System.out.println("Searching for system");

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN")) {
            FileFolder = System.getenv("APPDATA") + "\\" + "FabLabTool";
            System.out.println("Found windows");
        }
        if (os.contains("MAC")) {
            FileFolder = System.getProperty("user.home") + "/Library/Application Support" + "/FabLabTool";
            System.out.println("Found mac");
        }
        if (os.contains("NUX")) {
            FileFolder = System.getProperty("user.dir") + ".FabLabTool";
            System.out.println("Found linux");
        }
        System.out.print("  " + FileFolder);
        return FileFolder;
    }
}
