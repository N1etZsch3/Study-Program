package com.smarthome.application;

import com.smarthome.domain.model.AbstractDevice;
import com.smarthome.domain.service.SmarthomeControlor;
import com.smarthome.infrastructure.devices.CeilingLight;
import com.smarthome.infrastructure.devices.Curtain;
import com.smarthome.infrastructure.devices.Television;
import com.smarthome.infrastructure.devices.WashingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 初始化设备
        AbstractDevice[] devices = generateDevices();

        // 显示菜单并处理用户输入
        while (true) {
            // 显示菜单
            showMenu();

            // 实例化控制器
            SmarthomeControlor sc = SmarthomeControlor.getInstance();

            // 执行操作
            executeOption(getOption(), devices);
        }
    }

    // 生成数据
    public static AbstractDevice[] generateDevices() {
        AbstractDevice[] devices = new AbstractDevice[4];
        devices[0] = new WashingMachine(1, "Washing Machine", true);
        devices[1] = new Television(2, "Television", false);
        devices[2] = new CeilingLight(3, "Ceiling Light", true);
        devices[3] = new Curtain(4, "Curtain", false);
        return devices;
    }

    // 显示菜单
    public static void showMenu(){
        System.out.println("=========欢迎使用智能家居控制系统=========");
        System.out.println("======================================");
        System.out.println("=========1. 显示所有设备状态   ==========");
        System.out.println("=========2. 切换设备状态   =============");
        System.out.println("=========3. 退出系统   ================");
        System.out.println("======================================");
    }

    // 获取用户输入
    public static int getOption() {
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // 根据用户输入执行相应操作
    public static void executeOption(int option, AbstractDevice[] devices) {
        SmarthomeControlor sc = SmarthomeControlor.getInstance();
        switch (option) {
            case 1:
                sc.showAllDevicesStatus(devices);
                break;
            case 2:
                System.out.println("请输入要切换状态的设备ID：");
                Scanner scanner = new Scanner(System.in);
                int deviceID = scanner.nextInt();
                boolean found = false;
                for (AbstractDevice device : devices) {
                    if (device.getId() == deviceID) {
                        sc.shiftDeviceStatus(device);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("未找到设备：" + deviceID);
                }
                break;
            case 3:
                System.out.println("退出系统。");
                return; // 退出程序
            default:
                System.out.println("无效的选项，请重新选择。");
        }
    }
}
