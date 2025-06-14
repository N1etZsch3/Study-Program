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
