package com.stonemaze.app2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private int[][] imageData = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 用于存储每个方块的标签
    private JLabel[][] tileLabels = new JLabel[4][4];
    // 游戏操作类实例
    private GameOperator gameOperator;
    // 图片资源路径
    private static final String imagePath = "src/com/stonemaze/resources/images/";
    // 内容面板
    private JLayeredPane contentPane;
    // 计时器相关
    private JLabel timerLabel = new JLabel("00:00");
    // 游戏计时器
    private Timer gameTimer;
    // 记录游戏开始时间
    private long startTime;
    // 背景标签
    private JLabel backgroundLabel;
    // 游戏状态
    private boolean gameWon = false;
    // 胜利标签
    private JLabel winLabel;

    // 构造器
    public MainFrame() {
        contentPane = new JLayeredPane();
        this.setContentPane(contentPane);
        contentPane.setDoubleBuffered(true); // 启用双缓冲

        gameOperator = new GameOperator(imageData);
        initFrame();
        initImage();
        initMenu();
        addKeyListener();
        createWinLabel();
    }

    // 初始化窗口
    private void initFrame() {
        contentPane.setLayout(null);
        this.setTitle("Stone-Maze V 1.0");
        this.setSize(465, 575);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 美化计时器显示
        timerLabel.setBounds(330, 0, 100, 25);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setForeground(new Color(0, 100, 0)); // 深绿色
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setOpaque(true);
        timerLabel.setBackground(new Color(255, 255, 200, 200)); // 半透明背景
        timerLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 0), 2));
        contentPane.add(timerLabel, JLayeredPane.PALETTE_LAYER);
    }

    // 创建胜利标签
    private void createWinLabel() {
        ImageIcon winIcon = loadImage("victory.png");
        if (winIcon != null) {
            winLabel = new JLabel(winIcon);
            winLabel.setBounds(75, 150, winIcon.getIconWidth(), winIcon.getIconHeight());
            winLabel.setVisible(false);
            contentPane.add(winLabel, JLayeredPane.MODAL_LAYER);
        }
    }

    // 初始化图片
    private void initImage() {
        backgroundLabel = new JLabel(loadImage("background.png"));
        backgroundLabel.setBounds(0, 0, 465, 505);
        contentPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                tileLabels[i][j] = createTileLabel(i, j);
                contentPane.add(tileLabels[i][j], JLayeredPane.PALETTE_LAYER);
            }
        }
    }

    // 创建单个方块标签
    private JLabel createTileLabel(int i, int j) {
        JLabel label = new JLabel();
        int tileValue = imageData[i][j];

        if (tileValue > 0) {
            label.setIcon(loadImage(tileValue + ".png"));
        } else {
            label.setOpaque(false);
        }

        label.setBounds(30 + j * 100, 70 + i * 100, 100, 100);
        return label;
    }

    // 加载图片资源
    private ImageIcon loadImage(String filename) {
        String resourcePath = "/com/stonemaze/resources/images/" + filename;
        java.net.URL imgURL = getClass().getResource(resourcePath);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("找不到图片资源: " + resourcePath);
            return new ImageIcon();
        }
    }

    // 添加键盘监听器
    private void addKeyListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameWon) return; // 游戏结束时不响应按键

                int keyCode = e.getKeyCode();
                Direction direction = null;

                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        moveTile(Direction.DOWN); // 按上键 → 0号图片向下移动
                        break;
                    case KeyEvent.VK_DOWN:
                        moveTile(Direction.UP);   // 按下键 → 0号图片向上移动
                        break;
                    case KeyEvent.VK_LEFT:
                        moveTile(Direction.RIGHT);// 按左键 → 0号图片向右移动
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveTile(Direction.LEFT); // 按右键 → 0号图片向左移动
                        break;
                }


                if (direction != null) {
                    moveTile(direction);
                }
            }
        });
    }

    // 移动方块
    private void moveTile(Direction direction) {
        // 使用统一的移动逻辑
        GameOperator.MoveResult moveResult = gameOperator.move(direction);

        if (moveResult != null) {
            // 更新被移动的两个方块
            updateTile(moveResult.blankRow, moveResult.blankCol);
            updateTile(moveResult.targetRow, moveResult.targetCol);

            // 检查是否获胜
            if (gameOperator.checkWin()) {
                onWin();
            }
        }
    }

    // 更新单个方块的显示
    private void updateTile(int row, int col) {
        int tileValue = imageData[row][col];
        JLabel label = tileLabels[row][col];

        if (tileValue > 0) {
            label.setIcon(loadImage(tileValue + ".png"));
        } else {
            label.setIcon(null);
            label.setOpaque(false);
        }
    }

    // 初始化菜单
    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("游戏");

        // 添加登录菜单项
        JMenuItem loginMenuItem = new JMenuItem("登录");
        loginMenuItem.addActionListener(e -> {
            // 弹出登录对话框，功能暂不提供。
            JOptionPane.showMessageDialog(this, "登录功能暂未实现。", "提示", JOptionPane.INFORMATION_MESSAGE);
        });
        gameMenu.add(loginMenuItem);

        // 添加注册菜单项
        JMenuItem registerMenuItem = new JMenuItem("注册");
        registerMenuItem.addActionListener(e -> {
            // 弹出注册对话框，功能暂不提供。
            JOptionPane.showMessageDialog(this, "注册功能暂未实现。", "提示", JOptionPane.INFORMATION_MESSAGE);
        });
        gameMenu.add(registerMenuItem);

        JMenuItem startMenuItem = new JMenuItem("开始游戏");
        startMenuItem.addActionListener(e -> startGame());
        gameMenu.add(startMenuItem);

        JMenuItem restartMenuItem = new JMenuItem("重新开始");
        restartMenuItem.addActionListener(e -> resetGame());
        gameMenu.add(restartMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("退出");
        exitMenuItem.addActionListener(e -> System.exit(0));
        gameMenu.add(exitMenuItem);

        JMenu helpMenu = new JMenu("帮助");
        JMenuItem rulesMenuItem = new JMenuItem("游戏规则");
        rulesMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "游戏规则：\n1. 使用方向键移动方块\n2. 目标是将所有图片按顺序排列\n\n" +
                        "操作说明：\n↑：空白块上移\n↓：空白块下移\n←：空白块左移\n→：空白块右移",
                "游戏规则与操作说明",
                JOptionPane.INFORMATION_MESSAGE
        ));
        helpMenu.add(rulesMenuItem);

        // 添加开发者信息菜单
        JMenuItem aboutMenuItem = new JMenuItem("开发者信息");
        aboutMenuItem.addActionListener(e -> showDeveloperInfo());
        helpMenu.add(aboutMenuItem);

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
    }

    // 显示开发者信息
    private void showDeveloperInfo() {
        JOptionPane.showMessageDialog(
                this,
                "Stone Maze Puzzle Game\n\n" +
                        "开发者: N1etZsch3\n" +
                        "版本: 1.0\n" +
                        "发布日期: 2023\n\n" +
                        "一个经典的拼图游戏，挑战你的脑力和速度!",
                "开发者信息",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // 开始游戏
    private void startGame() {
        gameWon = false;
        if (winLabel != null) winLabel.setVisible(false);

        // 重置计时器
        if (gameTimer != null) {
            gameTimer.stop();
        }
        startTime = System.currentTimeMillis();
        gameTimer = new Timer(1000, e -> updateTimer());
        gameTimer.start();
        timerLabel.setText("00:00");

        // 先重置到初始状态再打乱
        resetToInitialState();
        gameOperator.shuffleImages();
        updateAllTiles();
    }

    // 重置到初始状态
    private void resetToInitialState() {
        imageData = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        gameOperator.setImageData(imageData);
    }

    // 更新计时器显示
    private void updateTimer() {
        long elapsed = System.currentTimeMillis() - startTime;
        long seconds = elapsed / 1000;
        long minutes = seconds / 60;
        seconds %= 60;

        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    // 重置游戏
    private void resetGame() {
        gameWon = false;
        if (winLabel != null) winLabel.setVisible(false);

        // 重置游戏状态
        resetToInitialState();
        updateAllTiles();

        // 重置计时器
        if (gameTimer != null) {
            gameTimer.stop();
            timerLabel.setText("00:00");
        }
    }

    // 更新所有方块
    private void updateAllTiles() {
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                updateTile(i, j);
            }
        }
    }

    // 检查游戏是否获胜
    private void onWin() {
        gameWon = true;
        if (gameTimer != null) {
            gameTimer.stop();
        }

        if (winLabel != null) {
            winLabel.setVisible(true);
        }

        JOptionPane.showMessageDialog(
                this,
                "恭喜完成拼图！\n用时: " + timerLabel.getText(),
                "游戏胜利",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // 主方法
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
            frame.requestFocus();
        });
    }

    // 枚举方向
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}