package com.example.td3_phidget_fxml;

import com.phidget22.PhidgetException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label labelConnexion;
    public Label labelType;
    public Label labelE0;
    public Label labelE1;
    public Label labelE2;
    public Label labelE3;
    public Label labelE4;
    public Label labelE5;
    public Label labelE6;
    public Label labelE7;
    public Label[] tabLab;
    public Gestion kit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            kit = new Gestion(this);
            kit.open();
        } catch (PhidgetException e) {
            throw new RuntimeException(e);
        }

        tabLab = new Label[]{labelE0,labelE1,labelE2,labelE3,labelE4,labelE5,labelE6,labelE7};
        //...
    }
}