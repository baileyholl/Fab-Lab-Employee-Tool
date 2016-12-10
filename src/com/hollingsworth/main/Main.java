package com.hollingsworth.main;

import com.hollingsworth.main.utils.FileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sceneFiles/prototype.fxml"));
        primaryStage.setTitle("Fab Lab Available Employees");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        FileManager.globalFileManager = new FileManager();
        launch(args);
    }
}
