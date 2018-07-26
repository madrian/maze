package com.example;

public class Builder {
    private Builder() {}

    private static Maze build(int length, int width) {
        Maze maze = new Maze(length, width);
        return maze;
    }
}
