package com.n1etzsch3.array;

// 石头迷阵游戏初始化

import java.util.Random;

public class ArrayDemo2 {
    // 程序入口
    public static void main(String[] args) {
        start();
    }
    // 游戏开始
    public static void start(){
        int order = 4;
        int[][] map = new int[order][order];
        init(map, order);
        System.out.println("----------------------------------------");
        shuffle(map);
    }

    // 初始化石板迷阵
    public static void init(int[][] map, int order){
        // 创建一个二维数组记录石板数字

        int count = 1;

        for(int i = 0; i< map.length; i++){
            for (int j = 0; j<map[i].length; j++){
                map[i][j] = count++;
            }
        }
        map[order-1][order-1] = 0;
        printMap(map);
    }



    public static void shuffle(int[][] map){
        int rows = map.length;
        if (rows == 0) return;
        int cols = map[0].length;
        int total = rows * cols;
        Random rand = new Random();

        for(int i = total - 1; i > 1; i--){

            // rand.nextInt(int bound)用于生成一个伪随机数，范围是0-bound
            int j = rand.nextInt(i+1);

            int rowI = i / cols, colI = i % cols;
            int rowJ = j / cols, colJ = j % cols;

            int temp = map[rowI][colI];
            map[rowI][colI] = map[rowJ][colJ];
            map[rowJ][colJ] = temp;

        }

        printMap(map);

    }


    public static void printMap(int[][] map){
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[i].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
