package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class WashingMachine extends AbstractDevice {
    public WashingMachine(){}

    public WashingMachine(int id, String name, boolean status){
        super(id, name,status);
    }
}
