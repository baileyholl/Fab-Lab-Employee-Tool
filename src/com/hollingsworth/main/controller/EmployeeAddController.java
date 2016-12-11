package com.hollingsworth.main.controller;

import com.hollingsworth.main.objects.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testAssertions();
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        chooseImageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File file = fileChooser.showOpenDialog(Constants.NewEmployeeStage);
                imagePathLabel.setText(file.toString());
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Constants.NewEmployeeStage.close();
            }
        });
    }

    private void testAssertions(){
        System.out.println("Testing Assertions for Employee Add Controller");
        assert okButton != null:"";
        assert cancelButton != null:"";
        assert chooseImageButton != null:"";
        assert imagePathLabel != null:"";
        assert nameTextField != null:"";
        assert descriptionTextArea != null:"";
    }
}
