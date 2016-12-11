package com.hollingsworth.main.utils;

/**
 * Created by Bailey Hollingsworth on 12/9/16.
 */

import com.hollingsworth.main.objects.Constants;
import com.hollingsworth.main.objects.Employee;

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
        Path path = Paths.get(Constants.textFolder.toString(), name+".txt");
        try {
            Files.write(path,lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewEmployeeFile(Employee newEmployee) {
        createNewEmployeeFile(newEmployee.getName(), newEmployee.getDescription(), newEmployee.getImagePath().toString());
    }

    public static void copyImageFileToResources(File imageFile, String employeeName){
        InputStream inStream;
        OutputStream outStream;
        try{

            File afile = imageFile;
            File bfile =new File(Constants.imageFolder.toString(),employeeName +".png");

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

            //delete the original file
            //afile.delete();

            System.out.println("File is copied successful!");

        }catch(IOException e){
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
}
