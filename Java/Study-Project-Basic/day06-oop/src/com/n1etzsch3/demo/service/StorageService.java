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