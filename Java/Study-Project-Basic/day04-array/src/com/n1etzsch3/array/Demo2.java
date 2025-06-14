package com.n1etzsch3.array;

public class Demo2 {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        String[] poker = new String[54];
        stack(poker);
        System.out.println("\nShuffling----------------------------------------------------------");
        shuffle(poker);
    }

    public static void stack(String[] poker){
        int n = 0;
        char[] suit = {'♠', '♥','♦','♣'};
        String[] cardFace = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // 假如相同花色的放一起：
        for(int i = 0; i < suit.length; i++){
            for(int j = 0; j < cardFace.length; j++){
                 poker[n++] = suit[i] + cardFace[j];
            }
        }

        poker[52] = "小王";
        poker[53] = "大王";

        // 输出牌面，每13个一组，大小王单独输出
        for(int i = 0; i < poker.length; i++){
            if(i % 13 == 0){
                System.out.println();
            }
            System.out.print(poker[i] + "\t");
        }
        System.out.println();
    }

    public static void shuffle(String[] poker){
        for(int i = poker.length - 1; i > 0; i--){
            int j = (int)(Math.random() * (i + 1));
            // 交换 poker[i] 和 poker[j]
            String temp = poker[i];
            poker[i] = poker[j];
            poker[j] = temp;
        }

        // 输出洗牌后的结果，每13个一行
        for(int i = 0; i < poker.length; i++){
            if(i % 13 == 0) System.out.println();
            System.out.print(poker[i] + "\t");
        }
        System.out.println();
    }

}
