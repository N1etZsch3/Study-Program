package com.stonemaze.app;

import java.util.Random;

public class GameOperator {

    private int[][] imageData;

    public GameOperator(){}

    public GameOperator(int[][] imageData) {
        this.imageData = imageData;
    }

    // 还原图片数据到初始状态
    public void resetImageData() {
        // 排序
        int count = 1;
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if (count < imageData[i].length * imageData.length) {
                    imageData[i][j] = count++;
                } else {
                    imageData[i][j] = 0; // 最后一个位置为0
                }
            }
        }
    }

    public void shuffleImages() {
        Random random = new Random();
        for (int i = 0; i < imageData.length; i++){
            for (int j = 0; j < imageData[i].length; j++) {
                // 随机交换图片位置
                int randomRow = random.nextInt(imageData.length);
                int randomCol = random.nextInt(imageData[i].length);
                int temp = imageData[i][j];
                imageData[i][j] = imageData[randomRow][randomCol];
                imageData[randomRow][randomCol] = temp;
            }
        }
    }

}
