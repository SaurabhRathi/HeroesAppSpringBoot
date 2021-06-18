package com.example.demo;

public class Hero {
    private String name;
    private int id;
    private int points;

    public Hero(){}

    private Hero(String name, int id, int points) {
        this.name = name;
        this.id = id;
        this.points = points;
    }

    public static Hero of(String name, int id, int points) {
        return new Hero(name, id, points);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", points=" + points +
                '}';
    }
}
