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