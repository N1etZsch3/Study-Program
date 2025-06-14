package com.HRMS.controller;

import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerificationCode {
    private String code;
    @Getter
    private BufferedImage image;
    private Random random = new Random();
    private static final String CHAR_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public VerificationCode(int width, int height) {
        generateCode(width, height);
    }

    private void generateCode(int width, int height) {
        // 创建图像
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 设置背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 设置字体
        g.setFont(new Font("Arial", Font.BOLD, 24));

        // 生成随机字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(CHAR_STR.length());
            sb.append(CHAR_STR.charAt(index));
        }
        code = sb.toString();

        // 绘制字符串
        for (int i = 0; i < code.length(); i++) {
            g.setColor(new Color(random.nextInt(100), random.nextInt(100), random.nextInt(100)));
            g.drawString(String.valueOf(code.charAt(i)), 5 + i * (width / 5), 28);
        }

        // 添加干扰线
        for (int i = 0; i < 10; i++) {
            g.setColor(new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200)));
            g.drawLine(random.nextInt(width), random.nextInt(height),
                    random.nextInt(width), random.nextInt(height));
        }

        g.dispose();
    }

    public boolean validate(String input) {
        return code.equalsIgnoreCase(input);
    }

}


