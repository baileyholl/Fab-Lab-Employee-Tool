package com.hollingsworth.main.utils;

/**
 * Created by Bailey Hollingsworth on 12/9/16.
 */
import java.io.File;
public class FileManager {
    public static File directory;
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
        System.out.println(FileFolder);
        return FileFolder;
    }


}
