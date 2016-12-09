package com.hollingsworth.main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    MenuItem closeMenuItem;
    @FXML
    ListView leftList;
    @FXML
    ListView rightList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing elements into code! :)");
        assert closeMenuItem != null:"fx:id=\"closeMenuItem\" was not injected: check your FXML file 'prototype.fxml'.";
        assert leftList != null:"fx:id=\"leftList\" was not injected: check your FXML file 'prototype.fxml'.";
        assert rightList != null:"fx:id=\"rightList\" was not injected: check your FXML file 'prototype.fxml'.";
        //Insert logic
        ObservableList list = FXCollections.observableArrayList (
                "Bailey Hollingsworth", "Brandt", "ConfusedBrant", "Mike");
        rightList.setItems(list);

        closeMenuItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
