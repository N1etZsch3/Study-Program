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
