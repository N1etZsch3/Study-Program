# 加油支付模块



## 需求

+ 某加油站为了吸引更多的车主，推出如下活动，车主可办理金卡和银卡。
+ 卡片信息包括：车牌号码、车主姓名、电话号码、卡片余额。
+ 金卡办理时存入金额必须大于等于5000元，银卡办理时预存金额必须大于等于2000元。
+ 金卡支付时享受8折优惠，银卡支付时享受9折优惠。
+ 金卡消费满200元可以提供打印免费洗车票的服务。



## 要求

​	用oop完成加油支付机的存款和消费程序。



## 代码实现



### 项目结构：

```cmd
demo
├── MainApp.java	// 主程序入口
├── card
│   ├── Card.java		// 卡片父类
│   ├── GoldCard.java		// 金卡子类
│   └── SilverCard.java		// 银卡子类
└── service
    ├── PaymentService.java	// 支付模块
    └── StorageService.java	// 存储模块

```



### `Card.java`

```java
package com.n1etzsch3.demo.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // @Data注解可以自动生成getter setter方法 无参构造器 toString方法等
@NoArgsConstructor  // @NoArgsConstructor 可以自动生成无参构造器
@AllArgsConstructor // @AllArgsConstructor 可以自动生成有参构造器


public abstract class Card {
    // 原有getter/setter保持不变
    private String carNumber;
    private String ownerName;
    private String ownerPhoneNumber;
    private double cardBalance;

    public abstract void pay(double amount);

    protected void updateBalance(double amount) {
        this.cardBalance -= amount;
    }

    public void recharge(double amount) {
        if(amount <= 0) {
            System.out.println("充值金额必须大于0");
            return;
        }
        this.cardBalance += amount;
    }

}

```



### `GoldCard.java`

```java
package com.n1etzsch3.demo.card;

public class GoldCard extends Card {
    private static final double DISCOUNT = 0.8;

    public GoldCard() {}

    public GoldCard(String carNumber, String owner, String phone, double balance) {
        super(carNumber, owner, phone, balance);
    }

    @Override
    public void pay(double amount) {
        double payment = amount * DISCOUNT;
        if(getCardBalance() >= payment) {
            updateBalance(payment);
            System.out.printf("金卡支付成功，实际支付: %.2f 元，余额: %.2f%n", payment, getCardBalance());
            if(payment >= 200) {
                System.out.println("获得免费洗车券");
            }
        } else {
            System.out.println("金卡余额不足");
        }
    }
}
```



### `SilverCard.java`

```java
package com.n1etzsch3.demo.card;

public class SilverCard extends Card {
    private static final double DISCOUNT = 0.9;

    public SilverCard() {}

    public SilverCard(String carNumber, String owner, String phone, double balance) {
        super(carNumber, owner, phone, balance);
    }

    @Override
    public void pay(double amount) {
        double payment = amount * DISCOUNT;
        if(getCardBalance() >= payment) {
            updateBalance(payment);
            System.out.printf("银卡支付成功，实际支付: %.2f 元，余额: %.2f%n", payment, getCardBalance());
        } else {
            System.out.println("银卡余额不足");
        }
    }
}
```



### `PaymentService.java`

```java
package com.n1etzsch3.demo.service;

import com.n1etzsch3.demo.card.Card;

public class PaymentService {

    private PaymentService(){}

    public static void processPayment(Card card, double amount) {
        if(amount <= 0) {
            System.out.println("支付金额必须大于0");
            return;
        }
        card.pay(amount);
    }
}
```



### `StorageService.java`

```java
package com.n1etzsch3.demo.service;

import com.n1etzsch3.demo.card.Card;
import com.n1etzsch3.demo.card.GoldCard;
import com.n1etzsch3.demo.card.SilverCard;

public class StorageService {

    private StorageService(){}

    public static Card createCard(String carNum, String name, String phone, double deposit) {
        if(deposit >= 5000) {
            return new GoldCard(carNum, name, phone, deposit);
        } else if(deposit >= 2000) {
            return new SilverCard(carNum, name, phone, deposit);
        } else {
            throw new IllegalArgumentException("存款金额不足，金卡需5000元以上，银卡需2000元以上");
        }
    }

    public static void recharge(Card card, double amount) {
        if(amount <= 0) {
            System.out.println("充值金额必须大于0");
            return;
        }
        card.recharge(amount);
        System.out.printf("充值成功，当前余额: %.2f%n", card.getCardBalance());
    }
}
```



### `MainApp.java`

```java
package com.n1etzsch3.demo;

import com.n1etzsch3.demo.card.Card;
import com.n1etzsch3.demo.card.GoldCard;
import com.n1etzsch3.demo.service.PaymentService;
import com.n1etzsch3.demo.service.StorageService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Card currentCard = null;

        while(true) {
            System.out.println("\n请选择操作：1、办卡 2、充值 3、消费 4、退出");
            int option = sc.nextInt();

            switch(option) {
                case 1:
                    currentCard = handleCreateCard(sc);
                    break;
                case 2:
                    handleRecharge(sc, currentCard);
                    break;
                case 3:
                    handlePayment(sc, currentCard);
                    break;
                case 4:
                    System.out.println("感谢使用，再见！");
                    return;
                default:
                    System.out.println("无效选项");
            }
        }
    }

    private static Card handleCreateCard(Scanner sc) {
        System.out.println("请输入车牌号、姓名、电话、初始金额（用空格分隔）：");
        String carNum = sc.next();
        String name = sc.next();
        String phone = sc.next();
        double deposit = sc.nextDouble();

        try {
            Card card = StorageService.createCard(carNum, name, phone, deposit);
            System.out.println("办卡成功！卡片类型：" +
                    (card instanceof GoldCard ? "金卡" : "银卡"));
            return card;
        } catch (IllegalArgumentException e) {
            System.out.println("办卡失败：" + e.getMessage());
            return null;
        }
    }

    private static void handleRecharge(Scanner sc, Card card) {
        if(card == null) {
            System.out.println("请先办理会员卡");
            return;
        }
        System.out.print("请输入充值金额：");
        double amount = sc.nextDouble();
        StorageService.recharge(card, amount);
    }

    private static void handlePayment(Scanner sc, Card card) {
        if(card == null) {
            System.out.println("请先办理会员卡");
            return;
        }
        System.out.print("请输入消费金额：");
        double amount = sc.nextDouble();
        PaymentService.processPayment(card, amount);
    }
}
```

