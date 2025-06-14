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
