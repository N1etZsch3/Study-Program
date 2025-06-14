package com.stonemaze.app;

import javax.swing.*;

public class MainFrame extends JFrame {

    private static final int[][] imageData = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 图片路径
    private static final String imagePath = "StoneMaze/src/com/stonemaze/resources/images/";

    private final GameOperator gameOperator;
    private JLabel backgroundLabel;

    public MainFrame() {

        gameOperator = new GameOperator(imageData);

        // 1、初始化窗口
        initFrame();
        // 2、初始化游戏面板
        initImage();
        // 3、初始化系统菜单
        initMenu();

    }

    private void initFrame() {

        // 注意禁用布局管理器，否则会出现渲染位置不正确和图层混乱问题。
        this.setLayout(null);

        // 设置窗口标题
        this.setTitle("Stone-Maze V 1.0");
        // 设置窗口大小
        this.setSize(465, 575);
        // 设置窗口位置
        this.setLocationRelativeTo(null);
        // 设置默认关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initImage() {

        if (backgroundLabel != null) {
            this.remove(backgroundLabel);
        }

        // 展示一个行列矩阵，使图片铺满窗口
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                // 创建一个标签来显示图片
                JLabel label = new JLabel();
                // 设置图片
                label.setIcon(new ImageIcon(imagePath + imageData[i][j] + ".png"));
                // 设置标签位置和大小
                label.setBounds(30 + j * 100, 70 + i * 100, 100, 100);
                // 添加标签到窗口
                this.add(label);
            }
        }

        // 设置背景图片
        backgroundLabel = new JLabel(new ImageIcon(imagePath + "background.png"));
        backgroundLabel.setBounds(0, 0, 465, 505);
        this.add(backgroundLabel);
    }

    private void initMenu() {
        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 创建“游戏”菜单
        JMenu gameMenu = new JMenu("游戏");

        // 创建“开始游戏”菜单项
        JMenuItem startMenuItem = new JMenuItem("开始游戏");
        startMenuItem.addActionListener(e -> {
            // 开始游戏逻辑
            startGame();
        });
        gameMenu.add(startMenuItem);

        // 创建重置游戏菜单项
        JMenuItem restartMenuItem = new JMenuItem("重置游戏");
        restartMenuItem.addActionListener(e -> {
            // 重置游戏逻辑
            restartGame();
        });
        gameMenu.add(restartMenuItem);

        // 创建退出菜单项
        JMenuItem exitMenuItem = new JMenuItem("退出");
        exitMenuItem.addActionListener(e -> System.exit(0));
        gameMenu.add(exitMenuItem);

        // 创建“帮助”菜单
        JMenu helpMenu = new JMenu("帮助");
        // 创建游戏规则菜单项
        JMenuItem rulesMenuItem = new JMenuItem("游戏规则");
        rulesMenuItem.addActionListener(e -> {
            // 显示游戏规则
            JOptionPane.showMessageDialog(this, "游戏规则：\n1. 点击图片进行移动。\n2. 目标是将所有图片按顺序排列。", "游戏规则", JOptionPane.INFORMATION_MESSAGE);
        });
        helpMenu.add(rulesMenuItem);

        // 添加到菜单条中。
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);

    }

    private void updateImage() {
        // 清除之前的图片
        this.getContentPane().removeAll();
        // 重新初始化图片
        initImage();
        // 刷新窗口
        this.revalidate();
        this.repaint();
    }

    private void startGame() {
        // 随机打乱图片位置
        gameOperator.shuffleImages();
        // 重新初始化图片
        updateImage();
    }

    private void restartGame() {
        // 重新开始游戏逻辑
        gameOperator.resetImageData();
        updateImage();
    }
}
