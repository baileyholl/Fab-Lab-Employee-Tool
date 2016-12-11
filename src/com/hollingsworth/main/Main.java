package com.hollingsworth.main;

import com.hollingsworth.main.objects.Constants;
import com.hollingsworth.main.utils.FileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Main extends Application {
    public static Stage parentStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        parentStage = primaryStage;
        initBeforeStartup();
        setupEmployeeScene();
        Parent root = FXMLLoader.load(getClass().getResource("sceneFiles/prototype.fxml"));
        parentStage.setTitle("Fab Lab Available Employees");
        parentStage.setScene(new Scene(root));
        parentStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
    public void initBeforeStartup(){
        FileManager.globalFileManager = new FileManager();
    }

    public void setupEmployeeScene()throws Exception{
        Constants.NewEmployeeRoot = FXMLLoader.load(getClass().getResource("sceneFiles/NewEmployee.fxml"));
        Constants.NewEmployeeStage = new Stage();
        Constants.NewEmployeeStage.setScene(new Scene(Constants.NewEmployeeRoot));
        Constants.NewEmployeeStage.initModality(Modality.APPLICATION_MODAL);
        Constants.NewEmployeeStage.setTitle("Add New Employee");
    }
}
