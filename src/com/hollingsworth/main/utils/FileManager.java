package com.hollingsworth.main.utils;

import com.hollingsworth.main.data.Constants;
import com.hollingsworth.main.data.Employee;

import java.io.*;
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
        if (!(Constants.mainFolder.exists() && Constants.imageFolder.exists() && Constants.textFolder.exists())) {
            if(!(Constants.mainFolder.mkdir() && Constants.imageFolder.mkdir() && Constants.textFolder.mkdir())){
                System.out.println("FAILED MAKING PROPER DIRECTORIES.");
                System.exit(0);
            }
            System.out.println("Created missing files.");
        }
        Constants.imageFiles = FileManager.getAllFilesAtPath(Constants.imageFolder);
        Constants.textFiles = FileManager.getAllFilesAtPath(Constants.textFolder);
    }


    public static boolean createNewEmployeeFile(String name, String description){
        List<String> lines = Arrays.asList(name, description);
        Path path = Paths.get(Constants.textFolder.toString(), name+".txt");
        try {
            Files.write(path,lines, Charset.forName("UTF-8"));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createNewEmployeeFile(Employee newEmployee) {
        return createNewEmployeeFile(newEmployee.getName(), newEmployee.getDescription());
    }

    public static File[] getAllFilesAtPath(File path){
        File[] allFiles = path.listFiles();
        if(allFiles == null){
            allFiles = new File[0];
            System.out.println("File array returned null. Returning array of no contents.");
        }
        return allFiles;
    }

    public static boolean copyImageFileToResources(File imageFile, String employeeName){
        InputStream inStream;
        OutputStream outStream;
        try{
            inStream = new FileInputStream(imageFile);
            outStream = new FileOutputStream(new File(Constants.imageFolder.toString(),employeeName +".png"));
            byte[] buffer = new byte[1024];
            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
            System.out.println("File is copied successful!");
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
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
}
