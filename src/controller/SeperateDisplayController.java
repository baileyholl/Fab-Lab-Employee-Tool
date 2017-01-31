package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Bailey Hollingsworth on 1/31/17.
 */
public class SeperateDisplayController implements Initializable{
    public static ArrayList<Label> displayNameList;
    public static ArrayList<ImageView> displayImageList;
    public static ArrayList<Label> displayDescList;

    @FXML
    protected Label displayNameOne;
    @FXML
    protected ImageView displayImageOne;
    @FXML
    protected Label displayDescOne;
    @FXML
    protected Label displayNameTwo;
    @FXML
    protected ImageView displayImageTwo;
    @FXML
    protected Label displayDescTwo;
    @FXML
    protected Label displayNameThree;
    @FXML
    protected ImageView displayImageThree;
    @FXML
    protected Label displayDescThree;
    @FXML
    protected Label displayNameFour;
    @FXML
    protected ImageView displayImageFour;
    @FXML
    protected Label displayDescFour;
    @FXML
    protected Label displayNameFive;
    @FXML
    protected ImageView displayImageFive;
    @FXML
    protected Label displayDescFive;
    @FXML
    protected Label displayNameSix;
    @FXML
    protected ImageView displayImageSix;
    @FXML
    protected Label displayDescSix;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayNameList = new ArrayList<>();
        displayImageList = new ArrayList<>();
        displayDescList = new ArrayList<>();
        if(displayNameOne == null){
            System.out.println("WHY IS EVERYTHING NULL ? !? !? ?");
            return;
        }
        displayNameList.add(displayNameOne);
        displayDescList.add(displayDescOne);
        displayImageList.add(displayImageOne);
        displayNameList.add(displayNameTwo);
        displayDescList.add(displayDescTwo);
        displayImageList.add(displayImageTwo);
        displayNameList.add(displayNameThree);
        displayDescList.add(displayDescThree);
        displayImageList.add(displayImageThree);
        displayNameList.add(displayNameFour);
        displayDescList.add(displayDescFour);
        displayImageList.add(displayImageFour);
        displayNameList.add(displayNameFive);
        displayDescList.add(displayDescFive);
        displayImageList.add(displayImageFive);
        displayNameList.add(displayNameSix);
        displayDescList.add(displayDescSix);
        displayImageList.add(displayImageSix);
    }
}
