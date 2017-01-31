import data.Constants;
import data.EmployeeDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.FileManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Constants.parentStage = primaryStage;
        initBeforeStartup();
        setupEmployeeScene();
        //setupDisplayScene();
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/MainScene.fxml"));
        Constants.parentStage.setTitle("Fab Lab Available Employees");
        Constants.parentStage.setScene(new Scene(root));
        Constants.parentStage.show();

        FXMLLoader anotherLoader = new FXMLLoader(getClass().getResource("/scenes/DisplayView.fxml")) ; // FXML for second stage
        Constants.DisplayRoot = anotherLoader.load();
        Scene anotherScene = new Scene(Constants.DisplayRoot);
        Constants.DisplayStage = new Stage();
        Constants.DisplayStage.setScene(anotherScene);
        Constants.DisplayStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }

    public void initBeforeStartup(){
        FileManager.setupFolders();
        Constants.database = new EmployeeDatabase(Constants.textFiles, Constants.imageFiles);
    }

    public void setupEmployeeScene()throws Exception{
        Constants.NewEmployeeRoot = FXMLLoader.load(getClass().getResource("/scenes/NewEmployee.fxml"));
        Constants.NewEmployeeStage = new Stage();
        Constants.NewEmployeeStage.setScene(new Scene(Constants.NewEmployeeRoot));
        Constants.NewEmployeeStage.initModality(Modality.APPLICATION_MODAL);
        Constants.NewEmployeeStage.setTitle("Add New Employee");
    }
    public void setupDisplayScene() throws Exception{
        Constants.DisplayRoot = FXMLLoader.load(getClass().getResource("/scenes/DisplayView.fxml"));
        Constants.DisplayStage = new Stage();
        Constants.DisplayStage.setScene(new Scene(Constants.DisplayRoot));
        Constants.DisplayStage.initModality(Modality.NONE);
    }
}
