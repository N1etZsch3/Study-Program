package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class Curtain extends AbstractDevice {
    public Curtain(){}

    public Curtain(int id, String name, boolean status){
        super(id, name, status);
    }
}
