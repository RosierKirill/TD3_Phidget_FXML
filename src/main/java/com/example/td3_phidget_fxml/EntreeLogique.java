package com.example.td3_phidget_fxml;


import com.phidget22.*;

public class EntreeLogique implements AttachListener, DetachListener, DigitalInputStateChangeListener {
    public DigitalInput di;
    public int index;
    public boolean etatConnexion;
    public Gestion refGestion;
    private boolean etatLogique;

    public EntreeLogique(Gestion gestion, int i) {
        try {

            this.refGestion=refGestion;
            di = new DigitalInput();
            di.setChannel(i);
            this.di.addAttachListener(this);
            this.di.addDetachListener(this);
            this.di.addStateChangeListener(this);

        } catch (PhidgetException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onAttach(AttachEvent attachEvent) {
        etatConnexion = true;
        System.out.println("attachement entree fait");
        try {
            refGestion.infoType("Attaché " , di.getDeviceName());
        } catch (PhidgetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDetach(DetachEvent detachEvent) {
        etatConnexion = false;
        System.out.println("détachement entree fait");
        refGestion.infoType("Detaché", "");
    }

    @Override
    public void onStateChange(DigitalInputStateChangeEvent digitalInputStateChangeEvent) {
        etatLogique= digitalInputStateChangeEvent.getState();
        System.out.println("Entree " + index + " " + etatLogique);
        refGestion.etatLogique(index,etatLogique);
    }

    public void open() {
        try {
            this.di.open(500);
        } catch (PhidgetException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws PhidgetException {
        this.di.close();
        this.di.removeAttachListener(this);
        this.di.removeDetachListener(this);
        this.di.removeStateChangeListener(this);
    }

//...
}
