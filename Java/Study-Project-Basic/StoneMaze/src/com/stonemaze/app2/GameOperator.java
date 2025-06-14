package com.stonemaze.app2;

import com.stonemaze.app2.MainFrame.Direction;
import java.util.Random;

public class GameOperator {
    private int[][] imageData;

    private static final int[][] WINNING_PATTERN = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    public GameOperator(int[][] imageData) {
        this.imageData = imageData;
    }

    public void setImageData(int[][] imageData) {
        this.imageData = imageData;
    }

    public int[] findBlankPosition() {
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if (imageData[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // 空白格未找到（不应该发生）
    }

    // 统一的移动方法
    public MoveResult move(Direction direction) {
        int[] blankPos = findBlankPosition();
        if (blankPos == null) return null;

        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        int targetRow = blankRow;
        int targetCol = blankCol;

        switch (direction) {
            case UP:
                targetRow = blankRow - 1;
                break;
            case DOWN:
                targetRow = blankRow + 1;
                break;
            case LEFT:
                targetCol = blankCol - 1;
                break;
            case RIGHT:
                targetCol = blankCol + 1;
                break;
        }

        // 检查目标位置是否有效
        if (targetRow < 0 || targetRow >= imageData.length ||
                targetCol < 0 || targetCol >= imageData[0].length) {
            return null;
        }

        // 执行交换
        swap(blankRow, blankCol, targetRow, targetCol);

        // 返回移动前后的位置信息
        return new MoveResult(blankRow, blankCol, targetRow, targetCol);
    }

    private void swap(int row1, int col1, int row2, int col2) {
        int temp = imageData[row1][col1];
        imageData[row1][col1] = imageData[row2][col2];
        imageData[row2][col2] = temp;
    }

    public boolean checkWin() {
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if (imageData[i][j] != WINNING_PATTERN[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void shuffleImages() {
        Random random = new Random();
        int[] blankPos = findBlankPosition();
        if (blankPos == null) return;

        for (int move = 0; move < 300; move++) {
            // 可能的移动方向
            Direction[] directions = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
            Direction direction = directions[random.nextInt(4)];

            // 使用统一的move方法进行打乱
            MoveResult result = move(direction);
            if (result != null) {
                blankPos[0] = result.targetRow;
                blankPos[1] = result.targetCol;
            }
        }
    }

    // 用于封装移动结果的值对象
    public static class MoveResult {
        public final int blankRow;
        public final int blankCol;
        public final int targetRow;
        public final int targetCol;

        public MoveResult(int blankRow, int blankCol, int targetRow, int targetCol) {
            this.blankRow = blankRow;
            this.blankCol = blankCol;
            this.targetRow = targetRow;
            this.targetCol = targetCol;
        }
    }
}