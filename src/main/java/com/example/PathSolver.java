package com.example;

public class PathSolver {

    public Path solve(Maze maze) {
        Path path = new Path();
        move(maze.start, maze.end, path);
        return path;
    }

    private boolean move(Room a, Room b, Path path) {
        if(path.isFound) {
            path.removeLast();
            return true;
        }
        if(a == null || b == null || a.isBlocked || a.isVisited) {
            path.removeLast();
            return false;
        }
        a.isVisited = true;
        if(a == b) {
            path.isFound = true;
            return true;
        }
        return !move(a.east, b, path.add(Direction.EAST))
                 && !move(a.south, b, path.add(Direction.SOUTH))
                 && !move(a.west, b, path.add(Direction.WEST))
                 && !move(a.north, b, path.add(Direction.NORTH));
    }
}
