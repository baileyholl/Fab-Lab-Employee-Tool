package com.hollingsworth.main.controller;

import com.hollingsworth.main.objects.Constants;
import com.hollingsworth.main.utils.WebManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        //Insert logic
        addMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Constants.NewEmployeeStage.show();
            }
        });
        closeMenuItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("clicked");
            }
        });
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WebManager.openWebpage(Constants.ABOUT_LINK);
            }
        });
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
    }
}
