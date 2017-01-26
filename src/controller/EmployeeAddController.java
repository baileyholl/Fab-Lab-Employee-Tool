package controller;

import data.Constants;
import data.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import utils.FileManager;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Bailey Hollingsworth on 12/10/16.
 */
public class EmployeeAddController implements Initializable{
    @FXML
    Button okButton;
    @FXML
    Button cancelButton;
    @FXML
    Button chooseImageButton;
    @FXML
    Label imagePathLabel;
    @FXML
    TextField nameTextField;
    @FXML
    TextArea descriptionTextArea;

    private File imageFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        okButton.setOnAction(event -> {attemptAddEmployee();});
        chooseImageButton.setOnAction(event -> {openImageSelector();});
        cancelButton.setOnAction(event -> {
            Constants.NewEmployeeStage.close();
            clearFields();
        });
    }

    private void openImageSelector() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Employee Image");
        File file = fileChooser.showOpenDialog(Constants.NewEmployeeStage);
        imagePathLabel.setText(file.toString());
        imageFile = file;
    }

    public void setupFieldsForEdit(Employee employee){
        nameTextField.setText(employee.getName());
        descriptionTextArea.setText(employee.getDescription());
        imagePathLabel.setText("");
    }


    private void clearFields(){
        imagePathLabel.setText("");
        imageFile = new File("");
        nameTextField.setText("");
        descriptionTextArea.setText("");
    }
    public void attemptAddEmployee(){
        if(imageFile != null && imageFile.exists() && !imageFile.toString().isEmpty()&& !nameTextField.getText().isEmpty() &&
                !descriptionTextArea.getText().isEmpty()){
            //Add employee to database and list
            Employee newEmployee = new Employee(nameTextField.getText(), descriptionTextArea.getText(), imageFile);
            FileManager.createNewEmployeeFile(newEmployee);
            if(FileManager.copyImageFileToResources(imageFile, nameTextField.getText()) && FileManager.createNewEmployeeFile(newEmployee)){
                clearFields();
                Constants.database.put(newEmployee);
                Constants.NewEmployeeStage.close();
            }
        }else{
            System.out.println("Criteria not met");
        }
    }
}
