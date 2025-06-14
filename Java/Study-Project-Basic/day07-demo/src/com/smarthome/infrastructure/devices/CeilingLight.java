package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class CeilingLight extends AbstractDevice {
    public CeilingLight(){}

    public CeilingLight(int id, String name, boolean status){
        super(id, name, status);
    }
}
