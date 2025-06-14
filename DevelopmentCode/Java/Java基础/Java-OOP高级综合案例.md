# 智能家居控制系统



## 需求

+ 某智能家居系统，可以让用户选择要控制的家用设备（吊灯、电视机、洗衣机、窗帘），并可以对它们进行打开或者关闭操作。



## 项目结构

```java
smarthome
├── application		// 程序入口
│   └── Main.java
├── command
├── domain		// 模型接口和服务
│   ├── model
│   │   ├── AbstractDevice.java	 // 抽象设备类
│   │   └── Device.java		// 设备操作接口
│   └── service		// 服务
│       ├── CommandHistory.java		// 命令历史记录
│       └── SmarthomeControlor.java		// 控制器
├── exception		// 异常处理
├── infrastructure	// 基础设施
│   ├── devices		// 基础设备
│   │   ├── CeilingLight.java	// 吊灯
│   │   ├── Curtain.java		// 窗帘
│   │   ├── Television.java		// 电视机
│   │   └── WashingMachine.java		// 洗衣机
│   └── repository		// 设备存储
└── ui	// 可视化界面
    ├── api
    ├── console
    └── web

```

> 目前仅完成基础的开关操作，和简单的实现。



## 代码实现



### 设备操作接口：`Device.java`

```java
package com.smarthome.domain.model;

public interface Device {
    // 控制开关
    void turn();
}

```



### 抽象设备类`AbstractDevice.java`

```java
package com.smarthome.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDevice implements Device{
    private int id;
    private String name;
    private boolean status;

    @Override
    public void turn() {
        status = !status; // 切换状态
    }
}

```



### 控制器`SmarthomeControlor.java`

```java
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

```



### 基础设施

```java
// =====================CeilingLight.java=======================
package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class CeilingLight extends AbstractDevice {
    public CeilingLight(){}

    public CeilingLight(int id, String name, boolean status){
        super(id, name, status);
    }
}

package com.smarthome.infrastructure.devices;


// =====================Curtain.java=======================
import com.smarthome.domain.model.AbstractDevice;

public class Curtain extends AbstractDevice {
    public Curtain(){}

    public Curtain(int id, String name, boolean status){
        super(id, name, status);
    }
}


// =====================Television.java=======================
package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class Television extends AbstractDevice {
    public Television(){}

    public  Television(int id, String name, boolean status){
        super(id, name, status);
    }
}


// =====================WashingMachine.java=======================
package com.smarthome.infrastructure.devices;

import com.smarthome.domain.model.AbstractDevice;

public class WashingMachine extends AbstractDevice {
    public WashingMachine(){}

    public WashingMachine(int id, String name, boolean status){
        super(id, name,status);
    }
}

```



### 程序入口`Main.java`

```java
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

```


