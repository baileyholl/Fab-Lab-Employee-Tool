package com.hollingsworth.main.controller;

import com.hollingsworth.main.data.Constants;
import com.hollingsworth.main.utils.WebManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitController extends DisplayBoxController implements Initializable{

    @FXML
    protected MenuItem refreshMenuItem;
    @FXML
    protected MenuItem openFolderMenuItem;
    @FXML
    protected MenuItem editMenuItem;
    @FXML
    protected MenuItem addMenuItem;
    @FXML
    protected MenuItem moveMenuItem;
    @FXML
    protected MenuItem reportIssueMenuItem;
    @FXML
    protected MenuItem aboutMenuItem;
    @FXML
    protected ListView rightList;

    @FXML
    protected MenuItem deleteBoxOne;
    @FXML
    protected MenuItem deleteBoxTwo;
    @FXML
    protected MenuItem deleteBoxThree;
    @FXML
    protected MenuItem deleteBoxFour;
    @FXML
    protected MenuItem deleteBoxFive;
    @FXML
    protected MenuItem deleteBoxSix;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location,resources);
        refreshList();
        //Insert logic
        addMenuItem.setOnAction(event -> showAddNewEmployeeWindow());
        moveMenuItem.setOnAction(event -> moveEmployeeToOtherList());
        openFolderMenuItem.setOnAction(event -> openFolderExplorer());
        aboutMenuItem.setOnAction(event -> openAboutLink());
        refreshMenuItem.setOnAction(event -> refreshList());
        editMenuItem.setOnAction(event -> editEmployeeData());
        deleteBoxOne.setOnAction(event -> removeEmployeeFromDisplay(0));
        deleteBoxTwo.setOnAction(event -> removeEmployeeFromDisplay(1));
        deleteBoxThree.setOnAction(event -> removeEmployeeFromDisplay(2));
        deleteBoxFour.setOnAction(event -> removeEmployeeFromDisplay(3));
        deleteBoxFive.setOnAction(event -> removeEmployeeFromDisplay(4));
        deleteBoxSix.setOnAction(event -> removeEmployeeFromDisplay(5));
    }

    private void openAboutLink() {
        WebManager.openWebpage(Constants.ABOUT_LINK);
    }

    private void openFolderExplorer() {
        try {
            Desktop.getDesktop().open(Constants.mainFolder);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void showAddNewEmployeeWindow() {
        Constants.NewEmployeeStage.show();
    }

    private void editEmployeeData() {
        Constants.NewEmployeeStage.show();
    }

    private void refreshList() {
        rightList.setItems(FXCollections.observableArrayList (Constants.database.getEmployeeNames()));
    }

    private void removeEmployeeFromDisplay(int index){
        DisplayBoxController.removeEmployeeData(index);
    }
    private void moveEmployeeToOtherList(){
        String employeeName = rightList.getSelectionModel().getSelectedItem().toString();
        DisplayBoxController.setEmployeeData(employeeName);
    }
}
