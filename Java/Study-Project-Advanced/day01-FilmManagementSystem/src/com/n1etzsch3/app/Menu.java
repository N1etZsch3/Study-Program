package com.n1etzsch3.app;

import java.util.Scanner;

// 工具类
public class Menu {

    // 显示欢迎信息
    public void displayWelcomeMessage() {
        System.out.println("欢迎使用电影管理系统！");
        System.out.println("请按照提示进行操作。");
    }

    // 显示主菜单
    public void displayMainMenu() {
        System.out.println("\n主菜单：");
        System.out.println("=========================");
        System.out.println("1. 添加电影");
        System.out.println("2. 删除电影");
        System.out.println("3. 修改电影信息");
        System.out.println("4. 查找电影");
        System.out.println("5. 展示所有电影");
        System.out.println("6. 退出系统");
        System.out.println("=========================");
    }

    // 获取用户输入的选项
    public int getUserChoice() {
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("请输入您的选择（1-6）：");
            while (!sc.hasNextInt()) {
                System.out.println("无效输入，请输入数字1-6。");
                sc.next(); // 清除无效输入
            }
            option = sc.nextInt();
        } while (option < 1 || option > 6);
        return option; // 返回用户选项
    }

    // 执行相应的操作
    public void executeOption(int option, FilmOperator filmOperator) {
        switch (option) {
            case 1:
                addFilm(filmOperator);
                break;
            case 2:
                removeFilm(filmOperator);
                break;
            case 3:
                updateFilm(filmOperator);
                break;
            case 4:
                findFilm(filmOperator);
                break;
            case 5:
                displayAllFilms(filmOperator);
                break;
            case 6:
                exitSystem();
                break;
            default:
                System.out.println("无效选项，请重新选择。");
        }
    }

    // 1、添加电影
    public void addFilm(FilmOperator filmOperator) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入电影名称：");
        String title = sc.nextLine();
        System.out.print("请输入导演：");
        String director = sc.nextLine();
        System.out.print("请输入主演（用逗号分隔）：");
        String[] actors = sc.nextLine().split(",");
        System.out.print("请输入电影类型（用逗号分隔）：");
        String[] genre = sc.nextLine().split(",");
        System.out.print("请输入上映年份：");
        int year = sc.nextInt();
        System.out.print("请输入电影时长（分钟）：");
        int duration = sc.nextInt();

        Film film = new Film(title, director, actors, genre, year, duration);
        filmOperator.addFilm(film);
        System.out.println("电影添加成功！");
    }

    // 2、删除电影
    public void removeFilm(FilmOperator filmOperator) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要删除的电影名称：");
        String title = sc.nextLine();
        filmOperator.removeFilm(title);
        System.out.println("电影删除成功！");
    }

    // 3、修改电影信息
    public void updateFilm(FilmOperator filmOperator) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要修改的电影名称：");
        String title = sc.nextLine();

        System.out.print("请输入新的导演：");
        String director = sc.nextLine();
        System.out.print("请输入新的主演（用逗号分隔）：");
        String[] actors = sc.nextLine().split(",");
        System.out.print("请输入新的电影类型（用逗号分隔）：");
        String[] genre = sc.nextLine().split(",");
        System.out.print("请输入新的上映年份：");
        int year = sc.nextInt();
        System.out.print("请输入新的电影时长（分钟）：");
        int duration = sc.nextInt();

        Film updatedFilm = new Film(title, director, actors, genre, year, duration);
        filmOperator.updateFilm(title, updatedFilm);
        System.out.println("电影信息修改成功！");
    }

    // 4、查找电影
    public void findFilm(FilmOperator filmOperator) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要查找的电影名称：");
        String title = sc.nextLine();
        filmOperator.findFilm(title);
    }

    // 5、展示所有电影
    public void displayAllFilms(FilmOperator filmOperator) {
        System.out.println("所有电影列表：");
        for (Film film : filmOperator.getAllFilms()) {
            System.out.println("=========================");
            System.out.println(film);
            System.out.println("=========================");
        }
    }


    // 6、退出系统
    public void exitSystem() {
        System.out.println("感谢使用电影管理系统，再见！");
        System.exit(0); // 退出程序
    }
}
