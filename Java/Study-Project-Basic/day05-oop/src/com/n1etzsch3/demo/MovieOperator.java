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
