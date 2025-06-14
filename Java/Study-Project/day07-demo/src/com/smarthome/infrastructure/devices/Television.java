package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class Television extends AbstractDevice {
    public Television(){}

    public  Television(int id, String name, boolean status){
        super(id, name, status);
    }
}
