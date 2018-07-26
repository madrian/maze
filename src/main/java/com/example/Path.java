package com.example;

import java.util.ArrayList;
import java.util.List;

public class Path {
    List<Direction> path = new ArrayList<Direction>();
    boolean isFound;

    public Path add(Direction d) {
        path.add(d);
        return this;
    }

    public void removeLast() {
        path.remove(path.size() - 1);
    }

    public void print() {
        for(Direction d : path) {
            System.out.print(d + "->");
        }
        System.out.println("X");
    }
}
