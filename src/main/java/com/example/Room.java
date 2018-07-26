package com.example;

public class Room {
    int x;
    int y;
    Room east;
    Room west;
    Room north;
    Room south;

    int value;
    boolean isVisited;
    boolean isBlocked;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
