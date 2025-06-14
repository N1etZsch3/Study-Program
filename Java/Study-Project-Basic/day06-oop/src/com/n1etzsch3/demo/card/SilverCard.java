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