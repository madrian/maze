package com.example;

public class Maze {
    int length;
    int width;
    Room start;
    Room end;
    Room[][] map;

    public Maze(int length, int width) {
        this.length = length;
        this.width = width;
        map = new Room[length][width];
        buildRooms();
        start = map[0][0];
        end = map[length - 1][width - 1];
    }

    private void buildRooms() {
        for(int x = 0; x < length; x++) {
            for(int y = 0; y < width; y++) {
                map[x][y] = new Room(x, y);
            }
        }
        for(int x = 0; x < length; x++) {
            for(int y = 0; y < width; y++) {
                Room r = map[x][y];
                r.east = getEast(x, y);
                r.west = getWest(x, y);
                r.north = getNorth(x, y);
                r.south = getSouth(x, y);
            }
        }
    }

    private Room getEast(int x, int y) {
        if(x + 1 < length) return map[x + 1][y];
        return null;
    }
    private Room getWest(int x, int y) {
        if(x - 1 >= 0) return map[x - 1][y];
        return null;
    }
    private Room getNorth(int x, int y) {
        if(y - 1 >= 0) return map[x][y - 1];
        return null;
    }
    private Room getSouth(int x, int y) {
        if(y + 1 < width) return map[x][y + 1];
        return null;
    }
}
