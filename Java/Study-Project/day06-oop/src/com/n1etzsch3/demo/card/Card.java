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
