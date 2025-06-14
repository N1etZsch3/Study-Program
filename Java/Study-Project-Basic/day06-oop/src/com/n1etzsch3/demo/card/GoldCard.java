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