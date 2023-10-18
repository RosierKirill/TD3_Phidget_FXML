package com.example.td3_phidget_fxml;

import com.phidget22.AttachEvent;
import com.phidget22.AttachListener;
import com.phidget22.DetachEvent;
import com.phidget22.DetachListener;
import com.phidget22.DigitalOutput;
import com.phidget22.PhidgetException;

public class SortieLogique implements AttachListener,DetachListener {
    public DigitalOutput dout;
    public boolean etatConnexion;
    public int index;
    public Gestion gs;

    public SortieLogique(Gestion gs, int index)  throws PhidgetException {
        this.etatConnexion = false;
        this.gs = gs;
        this.index = index;
        this.dout = new DigitalOutput();
        this.dout.setChannel(index);
        this.dout.addAttachListener(this);
        this.dout.addDetachListener(this);
    }

    public void open() throws PhidgetException {
        this.dout.open(500);

    }

    public void close() throws PhidgetException {
        this.dout.removeAttachListener(this);
        this.dout.removeDetachListener(this);
        this.dout.close();

    }

    @Override
    public void onAttach(AttachEvent attachEvent) {
        etatConnexion=true;
    }

    @Override
    public void onDetach(DetachEvent detachEvent) {
        etatConnexion=false;

    }
}

