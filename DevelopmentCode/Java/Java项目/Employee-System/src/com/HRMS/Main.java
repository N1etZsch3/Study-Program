package com.HRMS;

import com.HRMS.controller.FileUtil;

import static javax.swing.SwingUtilities.invokeLater;

public class Main {
    public static void main(String[] args) {
        // 初始化必要文件
        FileUtil.initializeFiles();

        invokeLater(() -> {
            new com.HRMS.view.MainFrame().setVisible(true);
        });
    }
}