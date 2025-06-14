# 项目：简易版电影信息展示系统



## 需求

+ 展示系统中的全部电影信息（id、名称、价格、导演）；
+ 允许用户根据电影编号（id）查询出某个电影的详细信息；

## 目标

+ 使用oop完成。



## 实体类

```java
package com.n1etzsch3.demo;

public class Movie {
    private int id;
    private String name;
    private double price;
    private String director;

    public Movie(){}

    public Movie(int id, String name, double price, String director)
    {
        setId(id);
        setName(name);
        setPrice(price);
        setDirector(director);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}

```



## 方法类

```java
package com.n1etzsch3.demo;

public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(){}

    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void printAllMovies(){
        System.out.println("------------------电影列表-----------------");
        for (Movie movie : this.movies) {
            System.out.println("电影ID: " + movie.getId() +
                    ", 电影名称: " + movie.getName() +
                    ", 电影价格: " + movie.getPrice() +
                    ", 导演: " + movie.getDirector());
            System.out.println();
        }
    }

    public void findMovieById(int id){
        System.out.println("-------------------"+ id +"--------------------");
        for (Movie movie : this.movies) {
            if (movie.getId() == id) {
                System.out.println("电影ID: " + movie.getId() +
                        ", 电影名称: " + movie.getName() +
                        ", 电影价格: " + movie.getPrice() +
                        ", 导演: " + movie.getDirector());
                return;
            }
        }
        System.out.println("没有找到该电影。");
    }

}

```



## 调用

```java
package com.n1etzsch3.demo;

public class Test {

    public static void main(String[] args) {
        Movie[] movies = new Movie[6];
        generateMovies(movies);
        MovieOperator mo = new MovieOperator(movies);
        mo.printAllMovies();

        mo.findMovieById(3);
    }

    public static void generateMovies(Movie[] movies) {
        movies[0] = new Movie(1, "唐顿庄园", 9.5, "罗伯·罗素");
        movies[1] = new Movie(2, "战狼2",  8.5, "王家卫");
        movies[2] = new Movie(3, "唐顿庄园2", 9.5, "罗伯·罗素");
        movies[3] = new Movie(4, "战狼3",  8.5, "王家卫");
        movies[4] = new Movie(5, "唐顿庄园3", 9.5, "罗伯·罗素");
        movies[5] = new Movie(6, "战狼4",  8.5, "王家卫");
    }

}

```

