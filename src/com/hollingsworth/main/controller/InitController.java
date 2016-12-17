package com.hollingsworth.main.controller;

import com.hollingsworth.main.data.Constants;
import com.hollingsworth.main.utils.WebManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;


public class InitController implements Initializable{

    @FXML
    protected MenuItem refreshMenuItem;
    @FXML
    protected MenuItem closeMenuItem;
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
    protected ListView leftList;
    @FXML
    protected ListView rightList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing elements into code");
        testAssertions();
        refreshList();
        //Insert logic
        addMenuItem.setOnAction(event -> Constants.NewEmployeeStage.show());
        moveMenuItem.setOnAction(event -> moveEmployeeToOtherList());
        closeMenuItem.setOnAction(event -> System.out.println("clicked"));
        aboutMenuItem.setOnAction(event -> WebManager.openWebpage(Constants.ABOUT_LINK));
        refreshMenuItem.setOnAction(event -> refreshList());
    }

    private void refreshList() {
        rightList.setItems(FXCollections.observableArrayList (Constants.database.getEmployeeNames()));
    }

    private void moveEmployeeToOtherList(){
        //System.out.println("Right list is selected");
        System.out.println(rightList.getSelectionModel().getSelectedItems().toString());
    }

    private void testAssertions(){
        System.out.println("Testing assertions");
        assert closeMenuItem != null:"fx:id=\"closeMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert leftList != null:"fx:id=\"leftList\" was not injected: check your FXML file 'prototype.fxml'.";
        assert rightList != null:"fx:id=\"rightList\" was not injected: check your FXML file 'prototype.fxml'.";
        assert editMenuItem != null:"fx:id=\"editMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert addMenuItem != null:"fx:id=\"addMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert refreshMenuItem != null:"fx:id=\"addMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert aboutMenuItem != null:"fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert reportIssueMenuItem != null:"fx:id=\"reportIssueMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert moveMenuItem != null:"fx:id=\"moveMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
    }
}
