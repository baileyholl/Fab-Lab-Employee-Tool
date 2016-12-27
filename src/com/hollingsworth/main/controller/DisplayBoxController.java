package com.hollingsworth.main.controller;

import com.hollingsworth.main.data.Constants;
import com.hollingsworth.main.data.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Bailey Hollingsworth on 12/24/16.
 */
public class DisplayBoxController implements Initializable{

    @FXML
    protected Label nameLabelOne;
    @FXML
    protected ImageView imageViewOne;
    @FXML
    protected TextArea descBoxOne;
    @FXML
    protected Label nameLabelTwo;
    @FXML
    protected ImageView imageViewTwo;
    @FXML
    protected TextArea descBoxTwo;
    @FXML
    protected Label nameLabelThree;
    @FXML
    protected ImageView imageViewThree;
    @FXML
    protected TextArea descBoxThree;
    @FXML
    protected Label nameLabelFour;
    @FXML
    protected ImageView imageViewFour;
    @FXML
    protected TextArea descBoxFour;
    @FXML
    protected Label nameLabelFive;
    @FXML
    protected ImageView imageViewFive;
    @FXML
    protected TextArea descBoxFive;
    @FXML
    protected Label nameLabelSix;
    @FXML
    protected ImageView imageViewSix;
    @FXML
    protected TextArea descBoxSix;

    public static ArrayList<TextArea> areaList;
    public static ArrayList<ImageView> imageList;
    public static ArrayList<Label> labelList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        areaList = new ArrayList<>();
        imageList = new ArrayList<>();
        labelList = new ArrayList<>();
        areaList.add(descBoxOne);
        areaList.add(descBoxTwo);
        areaList.add(descBoxThree);
        areaList.add(descBoxFour);
        areaList.add(descBoxFive);
        areaList.add(descBoxSix);
        imageList.add(imageViewOne);
        imageList.add(imageViewTwo);
        imageList.add(imageViewThree);
        imageList.add(imageViewFour);
        imageList.add(imageViewFive);
        imageList.add(imageViewSix);
        labelList.add(nameLabelOne);
        labelList.add(nameLabelTwo);
        labelList.add(nameLabelThree);
        labelList.add(nameLabelFour);
        labelList.add(nameLabelFive);
        labelList.add(nameLabelSix);
    }

    public static void setEmployeeData(String EmployeeName){
        int index = findNextIndex();
        Employee employee = Constants.database.getByName(EmployeeName);
        try {
            imageList.get(index).setImage(new Image(employee.getLinkedImage().toURI().toURL().toExternalForm()));
        }catch (Exception e){
            System.out.println("Missing resource");
        }
        labelList.get(index).setText(employee.getName());
        areaList.get(index).setText(employee.getDescription());
    }
    private static int overrideCount = 0;
    private static int findNextIndex(){
        int count = 0;
        for(Label l : labelList){
            if(l.getText().isEmpty()){
                return count;
            }
            count++;
        }
        if(count > labelList.size() - 1){
            count = overrideCount;
            overrideCount ++;
            if(overrideCount > labelList.size() -1){
                overrideCount = 0;
            }
        }
        return count;
    }
}
