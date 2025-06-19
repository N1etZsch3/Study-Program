package com.n1etzsch3.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    // 电影名称
    private String title;
    // 导演
    private String director;
    // 主演
    private String[] actors;
    // 电影类型
    private String[] genre;
    // 上映年份
    private int year;
    // 电影时长（分钟）
    private int duration;

    @Override
    public String toString() {
        return "电影名称: " + title + "\n" +
               "导演: " + director + "\n" +
               "主演: " + String.join(", ", actors) + "\n" +
               "类型: " + String.join(", ", genre) + "\n" +
               "上映年份: " + year + "\n" +
               "时长: " + duration + " 分钟";
    }

}
