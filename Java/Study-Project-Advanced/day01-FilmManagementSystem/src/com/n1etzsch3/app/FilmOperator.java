package com.n1etzsch3.app;

import java.util.ArrayList;

public class FilmOperator {
    // 定义一个电影列表
    private ArrayList<Film> films = new ArrayList<>();

    // 添加电影
    public void addFilm(Film film) {
        films.add(film);
    }

    // 删除电影
    public void removeFilm(String title) {
        films.removeIf(film -> film.getTitle().equalsIgnoreCase(title));
    }

    // 修改电影信息
    public void updateFilm(String title, Film updatedFilm) {
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getTitle().equalsIgnoreCase(title)) {
                films.set(i, updatedFilm);
                return;
            }
        }
    }

    // 查找电影
    public void findFilm(String title) {
        for (Film film : films) {
            if (film.getTitle().equalsIgnoreCase(title)) {
                System.out.println(film);
                return;
            }
        }
        System.out.println("电影未找到: " + title);
    }

    // 返回所有电影
    public ArrayList<Film> getAllFilms() {
        return new ArrayList<>(films);
    }

}
