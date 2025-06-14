package com.smarthome.domain.service;

import com.smarthome.domain.model.AbstractDevice;

public class SmarthomeControlor {

    // 单例类
    private static SmarthomeControlor instance;
    private SmarthomeControlor() {
        // 私有构造函数，防止外部实例化
    }
    public static SmarthomeControlor getInstance() {
        if (instance == null) {
            instance = new SmarthomeControlor();
        }
        return instance;
    }

    public void showAllDevicesStatus(AbstractDevice[] devices) {
        // 获取所有设备状态
        for (AbstractDevice device : devices) {
            System.out.println(device.getId() + "、" + "设备名称: " + device.getName() + ", 状态: " + (device.isStatus() ? "开" : "关"));
        }
    }

    // 切换设备状态
    public void shiftDeviceStatus(AbstractDevice device) {
        device.turn();
        System.out.println("设备 " + device.getName() + " 状态已切换为: " + (device.isStatus() ? "开" : "关"));
    }

}
