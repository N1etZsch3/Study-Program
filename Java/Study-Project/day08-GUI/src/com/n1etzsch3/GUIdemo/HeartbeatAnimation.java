package com.n1etzsch3.GUIdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeartbeatAnimation extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 700;
    private static final int HEART_SIZE = 200;
    private static final int NUM_STARS = 100;
    private static final int MAX_OFFSET = 50;
    private static final int ANIMATION_FRAMES = 100;

    private final List<Star> stars = new ArrayList<>();
    private double pulse = 0;
    private double pulseDirection = 1;

    // 心形曲线参数
    private static final int RESOLUTION = 100;
    private final double[] heartX = new double[RESOLUTION];
    private final double[] heartY = new double[RESOLUTION];

    // 星辰颜色
    private static final Color[] STAR_COLORS = {
            new Color(255, 255, 255, 200), // 白色
            new Color(255, 255, 180, 220), // 浅黄色
            new Color(180, 180, 255, 220), // 浅蓝色
            new Color(255, 180, 180, 220)  // 浅粉色
    };

    public HeartbeatAnimation() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(15, 10, 30));

        // 生成星辰
        generateStars();

        // 预计算心形路径
        precalculateHeartPath();

        // 创建动画定时器
        Timer timer = new Timer(40, e -> {
            updateAnimation();
            repaint();
        });
        timer.start();
    }

    private void precalculateHeartPath() {
        double scale = HEART_SIZE / 20.0;

        for (int i = 0; i < RESOLUTION; i++) {
            double t = (double) i / (RESOLUTION - 1);
            double theta = 2 * Math.PI * t;

            // 标准心形曲线方程
            double x = 16 * Math.pow(Math.sin(theta), 3);
            double y = -(13 * Math.cos(theta) -
                    5 * Math.cos(2 * theta) -
                    2 * Math.cos(3 * theta) -
                    Math.cos(4 * theta));

            heartX[i] = scale * x;
            heartY[i] = scale * y;
        }
    }

    private void generateStars() {
        Random rand = new Random();

        for (int i = 0; i < NUM_STARS; i++) {
            // 在画布范围内生成点
            double x = rand.nextDouble() * WIDTH;
            double y = rand.nextDouble() * HEIGHT;
            double size = 1 + rand.nextDouble() * 4;
            int colorIndex = rand.nextInt(STAR_COLORS.length);

            stars.add(new Star(x, y, size, STAR_COLORS[colorIndex], rand));
        }
    }

    private void updateAnimation() {
        // 更新心跳效果
        pulse += 0.05 * pulseDirection;

        if (pulse > 1) {
            pulse = 1;
            pulseDirection = -1;
        } else if (pulse < -0.5) {
            pulse = -0.5;
            pulseDirection = 1;
        }

        // 更新星辰
        for (Star star : stars) {
            star.update();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 绘制星辰背景
        drawStars(g2d);

        // 绘制心跳爱心
        drawHeartbeat(g2d);

        // 绘制心跳波动效果
        drawPulseEffect(g2d);

        // 绘制爱心光芒
        drawHeartGlow(g2d);
    }

    private void drawStars(Graphics2D g2d) {
        for (Star star : stars) {
            star.draw(g2d);
        }
    }

    private void drawHeartbeat(Graphics2D g2d) {
        // 计算当前大小基于心跳脉冲
        double currentSize = HEART_SIZE * (1 + pulse * 0.2);
        double scale = currentSize / HEART_SIZE;

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2 + 50;

        // 创建心形路径
        Path2D heartPath = new Path2D.Double();

        // 起始点
        double x = centerX + heartX[0] * scale;
        double y = centerY + heartY[0] * scale;
        heartPath.moveTo(x, y);

        // 绘制心形曲线
        for (int i = 1; i < RESOLUTION; i++) {
            x = centerX + heartX[i] * scale;
            y = centerY + heartY[i] * scale;
            heartPath.lineTo(x, y);
        }

        heartPath.closePath();

        // 设置红色填充
        GradientPaint redGradient = new GradientPaint(
                centerX - (float)(HEART_SIZE * 0.5), centerY - (float)(HEART_SIZE * 0.5),
                new Color(220, 20, 60, 220),
                centerX, centerY,
                new Color(255, 100, 120, 200),
                true
        );

        g2d.setPaint(redGradient);
        g2d.fill(heartPath);

        // 绘制高光边框
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.setPaint(new Color(255, 220, 220, 200));
        g2d.draw(heartPath);
    }

    private void drawPulseEffect(Graphics2D g2d) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2 + 50;

        // 计算最大半径
        double radius = HEART_SIZE * 1.5 * (1 + pulse) + 10;

        // 创建脉动光环
        RadialGradientPaint pulseGradient = new RadialGradientPaint(
                centerX, centerY, (float)radius,
                new float[]{0.0f, 0.6f, 1.0f},
                new Color[]{new Color(255, 0, 50, (int)(100 * (1 + pulse))),
                        new Color(200, 0, 70, (int)(40 * (1 + pulse))),
                        new Color(255, 0, 50, 0)}
        );

        g2d.setPaint(pulseGradient);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        g2d.fillOval(
                (int)(centerX - radius),
                (int)(centerY - radius),
                (int)(2 * radius),
                (int)(2 * radius)
        );
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    private void drawHeartGlow(Graphics2D g2d) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2 + 50;

        // 创建更小的内部光芒
        double radius = HEART_SIZE * 0.8 * (1 + pulse);
        RadialGradientPaint glowGradient = new RadialGradientPaint(
                centerX, centerY, (float)radius,
                new float[]{0.0f, 0.5f, 1.0f},
                new Color[]{new Color(255, 150, 150, 80),
                        new Color(255, 100, 100, 40),
                        new Color(255, 100, 100, 0)}
        );

        g2d.setPaint(glowGradient);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        g2d.fillOval(
                (int)(centerX - radius),
                (int)(centerY - radius),
                (int)(2 * radius),
                (int)(2 * radius)
        );
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("心跳动画：爱心与星辰");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HeartbeatAnimation());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // 星辰点类
    private static class Star {
        double x, y;
        double size;
        Color color;
        double angle;
        double speed;
        double distance;
        double baseX, baseY;
        double time;
        Random rand;

        public Star(double x, double y, double size, Color color, Random rand) {
            this.baseX = x;
            this.baseY = y;
            this.size = size;
            this.color = color;
            this.rand = rand;
            this.angle = rand.nextDouble() * Math.PI * 2;
            this.speed = 0.1 + rand.nextDouble() * 0.4;
            this.distance = 2 + rand.nextDouble() * MAX_OFFSET;
            this.time = rand.nextDouble() * Math.PI * 2;
        }

        public void update() {
            // 星星围绕原点轻轻飘动
            time += 0.01;
            this.x = baseX + Math.sin(time * speed) * distance;
            this.y = baseY + Math.cos(time * speed * 0.7) * distance;

            // 随机闪烁
            if (rand.nextDouble() < 0.005) {
                time += Math.PI / 4; // 改变相位来产生闪烁效果
            }
        }

        public void draw(Graphics2D g2d) {
            // 绘制星星
            g2d.setColor(color);

            // 创建星光效果
            double starSize = size * (0.9 + Math.sin(time * 3) * 0.3);
            int s = (int) Math.max(starSize, 1);

            g2d.fillOval((int)x, (int)y, s, s);

            // 添加星光效果
            if (starSize > 1.5) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
                int glowSize = (int) (s * 1.4);
                g2d.fillOval((int)x - (glowSize - s)/2, (int)y - (glowSize - s)/2, glowSize, glowSize);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            }
        }
    }
}