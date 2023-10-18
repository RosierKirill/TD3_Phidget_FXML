package com.example.td3_phidget_fxml;

import com.phidget22.PhidgetException;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Gestion {
    private EntreeLogique e0,e1,e2,e3,e4,e5,e6,e7;
    private SortieLogique s0,s1,s2,s3,s4,s5,s6,s7;
    private SortieLogique tabDout[] = new SortieLogique[8];
    private Controller controleur;

    public Gestion(Controller controlleur) throws PhidgetException {
        this.controleur=controlleur;
        e0=new EntreeLogique(this,0);
        e1=new EntreeLogique(this,1);
        e2=new EntreeLogique(this,2);
        e3=new EntreeLogique(this,3);
        e4=new EntreeLogique(this,4);
        e5=new EntreeLogique(this,5);
        e6=new EntreeLogique(this,6);
        e7=new EntreeLogique(this,7);
        s0=new SortieLogique(this,0);
        tabDout[0]=s0;
        s1=new SortieLogique(this,1);
        tabDout[1]=s1;
        s2=new SortieLogique(this,2);
        tabDout[2]=s2;
        s3=new SortieLogique(this,3);
        tabDout[3]=s3;
        s4=new SortieLogique(this,4);
        tabDout[4]=s4;
        s5=new SortieLogique(this,5);
        tabDout[5]=s5;
        s6=new SortieLogique(this,6);
        tabDout[6]=s6;
        s7=new SortieLogique(this,7);
        tabDout[7]=s7;

    }

    public void open() throws PhidgetException {
        e0.open();e1.open();e2.open();e3.open();e4.open();e5.open();e6.open();e7.open();
        s0.open();s1.open();s2.open();s3.open();s4.open();s5.open();s6.open();s7.open();

    }

    public void close() throws PhidgetException {
        e0.close();e1.close();e2.close();e3.close();e4.close();e5.close();e6.close();e7.close();
        s0.close();s1.close();s2.close();s3.close();s4.close();s5.close();s6.close();s7.close();

    }

    public void etatLogique(int index, boolean state){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (state) {
                    controleur.tabLab[index].setStyle("-fx-background-color:red");
                } else {
                    controleur.tabLab[index].setStyle("-fx-background-color:green");
                }

            }
        });
    }



    public void logiqueCmd(int index, boolean state){
        try {
            tabDout[index].dout.setState(state);
        } catch (PhidgetException e) {
            throw new RuntimeException(e);
        }
        //...
    }

    public void infoType(String info, String type){

        controleur.labelType.setText(type);
        //...
    }


}
