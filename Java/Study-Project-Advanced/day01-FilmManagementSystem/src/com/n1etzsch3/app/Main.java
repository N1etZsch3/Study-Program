package com.n1etzsch3.app;

public class Main {
    public static void main(String[] args) {
        // 创建菜单实例
        Menu menu = new Menu();

        // 创建电影操作实例
        FilmOperator filmOperator = new FilmOperator();

        // 显示欢迎信息
        menu.displayWelcomeMessage();

        while (true){
            // 显示主菜单
            menu.displayMainMenu();

            // 获取用户输入的选项
            int option = menu.getUserChoice();

            // 执行相应的操作
            menu.executeOption(option, filmOperator);
        }
    }
}
